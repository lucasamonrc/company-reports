package reports;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
	void testEmployee() {
		Employee e = new Employee("name", "");
		assertEquals("name", e.getName());
	}

	@Test
	void testGetTimeWorked() {
		Employee e = new Employee("name", "120:30");
		assertEquals("120:30", e.getTimeWorked());
	}

}
