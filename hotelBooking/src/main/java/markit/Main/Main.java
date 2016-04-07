package markit.Main;

import java.sql.Date;

import markit.hotelBooking.BookingManager;
import markit.hotelBooking.Hotel;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hotel Booking exercise - Sebastian Gonzalez: ");
		System.out.println("Creation of a static hotel with the default rooms [101, 102, 201, 203]: ");

		BookingManager bm = new Hotel(10, "static");
		Date today = java.sql.Date.valueOf("2016-04-06");

		System.out.println(bm.isRoomAvailable(101, today)); // outputs true

		bm.addBooking("Smith", 101, today);

		System.out.println(bm.isRoomAvailable(101, today)); // outputs false

		System.out.println("List of available rooms: " + bm.getAvailableRooms(today));

		/*
		 * Let´s suppose the creation of a Hotel with Random rooms
		 * 
		 */

		BookingManager bm2 = new Hotel(10, "dinamic"); // It will be created 10
														// Rooms
		System.out.println("\n\nList of available rooms: " + bm2.getAvailableRooms(today));

	}
}
