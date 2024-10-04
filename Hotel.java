import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Customer> customers;
    private ArrayList<String> checkInLogs = new ArrayList<>();
    private ArrayList<String> checkOutLogs = new ArrayList<>();

    public Hotel(ArrayList<Room> rooms, ArrayList<Customer> customers, ArrayList<String> checkInLogs, ArrayList<String> checkOutLogs) {
        this.rooms = rooms;
        this.customers = customers;
        this.checkInLogs = checkInLogs;
        this.checkOutLogs = checkOutLogs;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<String> getCheckInLogs() {
        return checkInLogs;
    }

    public void setCheckInLogs(ArrayList<String> checkInLogs) {
        this.checkInLogs = checkInLogs;
    }

    public ArrayList<String> getCheckOutLogs() {
        return checkOutLogs;
    }

    public void setCheckOutLogs(ArrayList<String> checkOutLogs) {
        this.checkOutLogs = checkOutLogs;
    }



    public Hotel() {
        this.rooms = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
    public void removeRoom(int roomNumber) {
        for (Room room: rooms){
            if (room.getRoomNumber()==roomNumber){
                rooms.remove(room);
            }
        }
    }

    public void addCheckInLog(String log) {
        checkInLogs.add(log);
    }

    public void addCheckOutLog(String log) {
        checkOutLogs.add(log);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void checkIn(Customer customer, Room room) {
        customer.setRoom(room);
        room.setBooked(true);
        String log = "Customer ID: " + customer.getId() + ", Room Number: " + room.getRoomNumber() + ", Price: "+room.getRoomPrice();
        addCheckInLog(log);
    }

    public void checkOut(Customer customer) {
        int roomNumber = customer.getRoom().getRoomNumber();
        customer.setRoom(null);
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.setBooked(false);
                break;
            }
        }
        String log = "Customer ID: " + customer.getId() + ", Room Number: " + customer.getRoom().getRoomNumber() + ", Price: "+customer.getRoom().getRoomPrice();
        addCheckOutLog(log);
    }

    public boolean isRoomAvailable(Room room) {
        return !room.isBooked();
    }

    public void checkInCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Customer Phone: ");
        int phone = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Customer Address: ");
        String address = sc.nextLine();
        Customer customer = new Customer(name, email, phone, address);
        System.out.println("Available Rooms:");
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : this.getRooms()) {
            if (!room.isBooked()) {
                System.out.println("Room Number: " + room.getRoomNumber() + ", Room Type: " + room.getRoomType()+", Room Price per Night: "+room.getRoomPrice());
                availableRooms.add(room);
            }
        }
        while (true) {
            System.out.print("\nEnter Room Number: ");
            int roomNumber = sc.nextInt();
            for (Room room : availableRooms) {
                if (room.getRoomNumber() == roomNumber) {
                    this.checkIn(customer, room);
                    System.out.println("Your Customer ID is: " + customer.getId());
                    return;
                }
            }
            System.out.println("\nRoom not available. Please choose another room.");
        }
    }
}

