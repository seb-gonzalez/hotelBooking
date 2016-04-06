package markit.hotelBooking;

import java.sql.Date;
import java.util.HashMap;

public class Room {
	private Integer room; // Room identifier

	/*
	 * HashMap variable bookings will a list of bookings in the room: - date:
	 * Date - Guest: String
	 */
	private HashMap<Date, String> bookings;

	public Room(Integer room) {
		this.room = room;
		this.bookings = new HashMap<Date, String>();
	}

	public Integer getRoom() {
		return room;
	}

	/*
	 * It will tell us whether the room is empty or not.
	 * 
	 * @param none
	 * 
	 * @return True if the room has been book at any time, False otherwise
	 */
	public boolean isEmpty() {
		return bookings.isEmpty();
	}

	/*
	 * isBooked will tell us whether the actual object/room has been booked on
	 * the date passed on parameters or not.
	 * 
	 * @param Date date in which the room is being booked, or not
	 * 
	 * @return False if there is no booking, otherwise True.
	 */
	public boolean isBooked(Date date) {
		if( bookings.containsKey(date) ) return true;
		else return false;
	}

	public void setBooking(Date date, String guest) {
		this.bookings.put(date, guest);
	}
}
