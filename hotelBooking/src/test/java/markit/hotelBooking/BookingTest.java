package markit.hotelBooking;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class BookingTest {
	BookingManager bm;
	Date today;

	@Before
	public void setUp() throws Exception {

		bm = new Hotel(10, "static");
		today = java.sql.Date.valueOf("2016-04-06");

	}

	@Test
	public void testBookingAvailability() throws Exception {
		assertEquals(true, bm.isRoomAvailable(101, today));
	}

	@Test
	public void testBookingAdding() throws Exception {
		bm.addBooking("Gonzalez", 101, today);
		assertEquals(false, bm.isRoomAvailable(101, today));
	}
	
	@Test
	public void testBookingAvailable() throws Exception {
		bm.addBooking("Aspess", 102, today);
		bm.addBooking("Gonzalez", 101, today);
		assertEquals(false, bm.isRoomAvailable(102, today));		
		
		assertEquals(bm.getAvailableRooms(today).toString().equals("[201, 203]"), true);
		
	}
}
