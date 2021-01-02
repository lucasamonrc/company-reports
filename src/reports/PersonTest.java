package reports;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testCompareTo() {
		Client a = new Client("Lucas C.", null);
		Client b = new Client("Sara H.", null);

		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
		assertTrue(a.compareTo(a) == 0);
	}

	@Test
	void testToString() {
		Client client = new Client("New Client", null);

		assertEquals("New Client", client.toString());
	}

}
