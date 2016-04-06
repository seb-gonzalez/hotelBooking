package markit.hotelBooking;

import java.sql.Date;

public interface BookingManager {

	/*
	 * Return true if there is no booking for the given room on the date,
	 * Otherwise false
	 */
	public boolean isRoomAvailable(Integer room, Date date);

	/*
	 * Add a booking for the given guest in the given room on the given date.
	 */
	public void addBooking(String guest, Integer room, Date date);
	
	/*Return a list of all the available room numbers for the given date
	 * */
	public Iterable<Integer> getAvailableRooms(Date date);
	
	

}
