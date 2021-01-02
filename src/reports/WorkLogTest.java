package reports;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WorkLogTest {
	WorkLog log = new WorkLog("Agustin A", "Clock In/Out", "", "", "7:30 AM", "9:05 PM", "4/1/2019", "4/1/2019");

	@Test
	void testGetEmployeeName() {
		assertEquals("Agustin A", log.getEmployeeName());
	}

	@Test
	void testGetClientName() {
		assertEquals("", log.getClientName());
	}

	@Test
	void testGetInfo() {
		assertEquals("Clock In/Out", log.getInfo());
	}

	@Test
	void testGetService() {
		assertEquals("", log.getService());
	}

	@Test
	void testGetStartDatetime() {
		assertEquals("2019-04-01 07:30", log.getStartDatetime());
	}

	@Test
	void testGetEndDatetime() {
		assertEquals("2019-04-01 21:05", log.getEndDatetime());
	}

	@Test
	void testGetTimeDifference() {
		assertEquals(48900000, log.getTimeDifference());
	}

	@Test
	void testCompareTo() {
		WorkLog other = new WorkLog("Augustin A", "Clock In/Out", "", "", "7:30 AM", "9:05 PM", "4/1/2019", "4/1/2019");

		assertTrue(log.compareTo(other) < 0);
		assertTrue(other.compareTo(log) > 0);
		assertTrue(log.compareTo(log) == 0);
	}

	@Test
	void testToString() {
		assertEquals("Log for: Agustin A", log.toString());
	}

}
