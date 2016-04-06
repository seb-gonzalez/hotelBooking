package markit.hotelBooking;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Hotel implements BookingManager {

	private HashMap<Integer, Room> rooms;

	private Random rng;
	private Set<Integer> numberList;

	/*
	 * This method will create an array of rooms in a random and non-sequential
	 * way. The list will be stored as a SET on 'numberList'.
	 * 
	 * @param number of rooms to be created, minimum range, maximum range
	 * 
	 */
	private void createRoomNumberList(int n, int min, int max) {

		this.rng = new Random();

		while (numberList.size() <= n) {
			this.numberList.add(rng.nextInt(max - min + 1) + min);
		}

	}

	public Hotel(int nRooms, String mode) {

		this.rooms = new HashMap<Integer, Room>();
		this.numberList = new LinkedHashSet<Integer>();

		if (mode.equals("dinamic")) {
			/*
			 * By default for this test I will create 10 rooms ranging from
			 * number 100 till 200, both included. Just to stick to the
			 * requirements of the exercise. It will be passed by parameter.
			 */
			this.createRoomNumberList(nRooms, 100, 200);

			for (Integer roomNumber : numberList) {
				this.rooms.put(roomNumber, new Room(roomNumber));

			}
		} else {
			this.numberList.add(101);
			this.numberList.add(102);
			this.numberList.add(201);
			this.numberList.add(203);

			for (Integer roomNumber : numberList) {
				this.rooms.put(roomNumber, new Room(roomNumber));
			}
		}

		//System.out.println("List of rooms in the Hotel: ");
		//System.out.println(numberList.toString());

	}

	// This method must be threadsafe; multiple users may be consulting at the
	// same time
	public synchronized boolean isRoomAvailable(Integer room, Date date) {

		// There is no room with the identifier passed as parameter
		if (!this.rooms.containsKey(room))
			return false;
		else {

			/*
			 * We consult to the room object whether there is a book at that
			 * date or not. It will retrieve True or False.
			 * 
			 * If the room is BOOKED, we return FALSE If the room is NOT BOOKED,
			 * we return TRUE
			 */
			return !this.rooms.get(room).isBooked(date);
		}

	}

	// This method must be threadsafe; multiple users may be consulting at the
	// same time
	public synchronized void addBooking(String guest, Integer room, Date date) {
		// It is assumed by the exercise that is not needed to check
		// whether the room exists or not.

		this.rooms.get(room).setBooking(date, guest);
	}

	// This method must be threadsafe; multiple users may be consulting at the
	// same time
	public synchronized Iterable<Integer> getAvailableRooms(Date date) {

		ArrayList<Integer> availableRooms = new ArrayList<Integer>();
		Integer aux_room = null;

		for (Map.Entry<Integer, Room> entry : rooms.entrySet()) {

			aux_room = entry.getKey();
			if (isRoomAvailable(aux_room, date)) {
				availableRooms.add(aux_room);
			}

		}

		return availableRooms;
	}

}
