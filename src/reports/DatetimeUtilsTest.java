package reports;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class DatetimeUtilsTest {

	@Test
	void testMsToHoursAndMinutes() {
		assertEquals("06:30", DatetimeUtils.msToHoursAndMinutes(23450140));
		assertNotEquals("12:45", DatetimeUtils.msToHoursAndMinutes(23450140));
	}

	@Test
	void testTimeDifferenceInMili() {
		assertEquals(18900000, DatetimeUtils.timeDifferenceInMili("2020-12-14 12:30", "2020-12-14 17:45"));
		assertNotEquals(315000, DatetimeUtils.timeDifferenceInMili("2020-12-14 12:30", "2020-12-14 17:45"));
	}

	@Test
	void testToISOString() {
		assertEquals("1997-08-12 21:45", DatetimeUtils.toISOString("08/12/1997", "09:45 PM"));
	}

}
