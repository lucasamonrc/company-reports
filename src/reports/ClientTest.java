package reports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class ClientTest {

	@Test
	void testClient() {
		Client c = new Client("client", null);
		assertEquals("client", c.getName());
	}

	@Test
	void testGetEmployees() {
		HashSet<String> employees = new HashSet<>();
		employees.add("a");
		employees.add("b");
		employees.add("c");
		employees.add("d");

		Client client = new Client("client", employees);

		assertTrue(client.getEmployees().contains("a"));
		assertTrue(client.getEmployees().contains("b"));
		assertTrue(client.getEmployees().contains("c"));
		assertTrue(client.getEmployees().contains("d"));
		assertFalse(client.getEmployees().contains("e"));
	}

}
