import java.util.*;

class Room {
    String cat;
    int roomNum;
    boolean isAvail;

    Room(String cat, int roomNum) {
        this.cat = cat;
        this.roomNum = roomNum;
        this.isAvail = true;
    }
}

class Booking {
    String guestName;
    Room room;
    int days;
    double amount;

    Booking(String guestName, Room room, int days, double amount) {
        this.guestName = guestName;
        this.room = room;
        this.days = days;
        this.amount = amount;
    }
}

public class HotelReservationSystem {
    static List<Room> rooms = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Adding rooms
        rooms.add(new Room("Single", 101));
        rooms.add(new Room("Single", 102));
        rooms.add(new Room("Double", 201));
        rooms.add(new Room("Double", 202));
        rooms.add(new Room("Suite", 301));
        rooms.add(new Room("Suite", 302));

        while (true) {
            System.out.println("1. Search Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 4) {
                break;
            }

            switch (ch) {
                case 1:
                    searchRooms();
                    break;
                case 2:
                    makeReservation(sc);
                    break;
                case 3:
                    viewBookings();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }

    static void searchRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvail) {
                System.out.println("Room " + room.roomNum + " (" + room.cat + ")");
            }
        }
    }

    static void makeReservation(Scanner sc) {
        System.out.print("Enter your name: ");
        String guestName = sc.next();
        System.out.print("Enter room number: ");
        int roomNum = sc.nextInt();
        Room room = null;
        for (Room r : rooms) {
            if (r.roomNum == roomNum && r.isAvail) {
                room = r;
                break;
            }
        }
        if (room == null) {
            System.out.println("Room not available");
            return;
        }
        System.out.print("Enter number of days: ");
        int days = sc.nextInt();
        double amount = days * 100.0; // Simplified pricing

        room.isAvail = false;
        bookings.add(new Booking(guestName, room, days, amount));
        System.out.println("Reservation successful. Amount: $" + amount);
    }

    static void viewBookings() {
        System.out.println("Bookings:");
        for (Booking booking : bookings) {
            System.out.println("Guest: " + booking.guestName + ", Room: " + booking.room.roomNum + " (" + booking.room.cat + "), Days: " + booking.days + ", Amount: $" + booking.amount);
        }
    }
}