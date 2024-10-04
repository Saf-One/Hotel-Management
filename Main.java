import java.util.Scanner;

public class Main {
    private static final String adminpass = "admin123";

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Admin admin = new Admin(hotel);
        Scanner sc = new Scanner(System.in);
        boolean Preset = false;
        while (true) {
            System.out.print("\n\nWELCOME\n\n1.Admin\n2.Customer\n3.Add Preset Entries for Testing\n0.Exit\n\nSelect an Option: ");
            int welcmenu = sc.nextInt();
            switch (welcmenu) {
                case 1 -> {
                    System.out.print("Enter Admin Password: ");
                    String admpass = sc.next();
                    if (admpass.equals(adminpass)) {
                        while (true) {
                            System.out.print("\n\nWelcome Admin\n\n1.Room Status\n2.Manage Staff\n3.Customer Status\n4.Logs\n0.Return\n\nSelect an Option: ");
                            int admmenu = sc.nextInt();
                            switch (admmenu) {
                                case 1 -> {
                                    while (true) {
                                        System.out.print("\n\nROOM STATUS\n\n1.View All Room Information\n2.Add Rooms\n0.Return\n\nSelect an Option: ");
                                        int roommenu = sc.nextInt();
                                        switch (roommenu) {
                                            case 1 -> {
                                                admin.displayRooms();
                                            }
                                            case 2 -> {
                                                System.out.print("Enter Room Number: ");
                                                int roomNumber = sc.nextInt();
                                                System.out.print("Enter Room Type: ");
                                                sc.nextLine();
                                                String roomType = sc.nextLine();
                                                System.out.print("Enter Room Price");
                                                int roomPrice = sc.nextInt();
                                                Room room = new Room(roomNumber, roomType, roomPrice);
                                                admin.addRoom(room);
                                            }
                                            default -> {
                                                if (roommenu != 0) {
                                                    System.out.println("\n\nInvalid");
                                                }
                                            }
                                        }
                                        if (roommenu == 0) {
                                            System.out.println("\nReturning");
                                            break;
                                        }
                                    }
                                }
                                case 2 -> {
                                    while (true) {
                                        System.out.print("\nSTAFF DATA\n\n1.View All Staff\n2.Add Staff\n3.Remove Staff\n4.Search Staff\n5.Update Staff\n0.Return\n\nSelect an Option: ");
                                        int staffmenu = sc.nextInt();
                                        sc.nextLine();
                                        switch (staffmenu) {
                                            case 1 -> {
                                                admin.viewAllStaff();
                                            }
                                            case 2 -> {
                                                System.out.print("Enter Staff Name: ");
                                                String name = sc.nextLine();
                                                System.out.print("Enter Staff ID: ");
                                                String id = sc.next();
                                                System.out.print("Enter Staff Salary: ");
                                                int salary = sc.nextInt();
                                                sc.nextLine();
                                                System.out.print("Enter Staff Job: ");
                                                String job = sc.next();
                                                Staff staff = new Staff(name, id, salary, job);
                                                admin.addStaff(staff);
                                            }
                                            case 3 -> {
                                                System.out.print("Enter Staff ID to remove: ");
                                                String removeId = sc.next();
                                                admin.removeStaff(removeId);
                                            }
                                            case 4 -> {
                                                System.out.print("Enter Staff ID to search: ");
                                                String searchId = sc.next();
                                                admin.searchStaff(searchId);
                                            }
                                            case 5 -> {
                                                System.out.print("Enter Staff ID to update: ");
                                                String updateId = sc.next();
                                                admin.updateStaff(updateId);
                                            }
                                            default -> {
                                                if (staffmenu != 0) {
                                                    System.out.println("\nInvalid");
                                                }
                                            }
                                        }
                                        if (staffmenu == 0) {
                                            System.out.println("\nReturning");
                                            break;
                                        }
                                    }
                                }
                                case 3 -> {
                                    while (true) {
                                        System.out.print("\nCUSTOMER INFO\n1.View All Booked Customers\n2.Add New Customer\n3.View Customer Info\n0.Return\nSelect an Option: ");
                                        int custmenu = sc.nextInt();
                                        sc.nextLine();
                                        switch (custmenu) {
                                            case 1 -> {
                                                admin.viewBookedCustomers();
                                            }
                                            case 2 -> {
                                                System.out.print("Enter Customer Name: ");
                                                String name = sc.nextLine();
                                                System.out.print("Enter Customer Email: ");
                                                String email = sc.next();
                                                System.out.print("Enter Customer Phone: ");
                                                int phone = sc.nextInt();
                                                sc.nextLine();
                                                System.out.print("Enter Customer Address: ");
                                                String address = sc.nextLine();
                                                Customer customer = new Customer(name, email, phone, address);
                                                admin.addNewCustomer(customer);
                                            }
                                            case 3 -> {
                                                System.out.print("Enter Customer ID: ");
                                                String id = sc.next();
                                                for (Customer customer : hotel.getCustomers()) {
                                                    if (customer.getId().equals(id)) {
                                                        admin.viewCustomerInfo(customer);
                                                        break;
                                                    }
                                                }
                                            }
                                            default -> {
                                                if (custmenu != 0) {
                                                    System.out.println("\nInvalid");
                                                }
                                            }
                                        }
                                        if (custmenu == 0) {
                                            System.out.println("\nReturning");
                                            break;
                                        }
                                    }
                                }
                                case 4 -> {
                                    while (true) {
                                        System.out.print("\n\nLOGS\n1. View Check Ins\n2.View Check Outs\n0. Return\n\nSelect an Option: ");
                                        int logmenu = sc.nextInt();
                                        switch (logmenu) {
                                            case 1 -> {
                                                admin.viewCheckInLogs();
                                            }
                                            case 2 -> {
                                                admin.viewCheckOutLogs();
                                            }
                                            default -> {
                                                if (logmenu != 0) {
                                                    System.out.println("\nInvalid.");
                                                }
                                            }
                                        }
                                        if (logmenu == 0) {
                                            System.out.println("\nReturning");
                                            break;
                                        }
                                    }
                                }
                                default -> {
                                    if (admmenu != 0) {
                                        System.out.println("\nInvalid");
                                    }
                                }
                            }
                            if (admmenu == 0) {
                                System.out.println("\nReturning");
                                break;
                            }
                        }
                    } else {
                        System.out.println("\nInvalid Password");
                    }
                }
                case 2 -> {
                    while (true) {
                        System.out.print("\n1.Check In\n2.Check Out\n3.Show Available Rooms\n0.Return\n\nSelect an Option: ");
                        int customermenu = sc.nextInt();
                        sc.nextLine();
                        switch (customermenu) {
                            case 1 -> {
                                hotel.checkInCustomer();
                            }
                            case 2 -> {
                                System.out.print("Enter Customer ID: ");
                                String id = sc.next();
                                for (Customer customer : hotel.getCustomers()) {
                                    if (customer.getId().equals(id)) {
                                        hotel.checkOut(customer);
                                        break;
                                    }
                                }
                            }
                            case 3 -> {
                                for (Room room : hotel.getRooms()) {
                                    if (!room.isBooked()) {
                                        System.out.println("Room Number: " + room.getRoomNumber() + ", Room Type: " + room.getRoomType());
                                    }
                                }
                            }
                            default -> {
                                if (customermenu != 0) {
                                    System.out.println("\nInvalid");
                                }
                            }
                        }
                        if (customermenu == 0) {
                            System.out.println("\nReturning");
                            break;
                        }
                    }
                }
                case 3 -> {
                    if (Preset == false) {
                        Preset = true;
                        admin.addStaff(new Staff("Rohan Sharma", "P001", 50000, "Manager"));
                        admin.addStaff(new Staff("Aisha Khan", "P002", 40000, "Receptionist"));
                        admin.addStaff(new Staff("Kunal Mehta", "P003", 60000, "Chef"));
                        admin.addStaff(new Staff("Nalini Rao", "P004", 45000, "Housekeeper"));
                        admin.addStaff(new Staff("Vikram Singh", "P005", 55000, "Maintenance"));
                        admin.addStaff(new Staff("Riya Jain", "P006", 40000, "Receptionist"));
                        admin.addStaff(new Staff("Siddharth Gupta", "P007", 50000, "Bartender"));
                        admin.addStaff(new Staff("Priya Patel", "P008", 45000, "Waitress"));
                        admin.addStaff(new Staff("Rajesh Kumar", "P009", 60000, "Accountant"));
                        admin.addStaff(new Staff("Sonia Chopra", "P010", 50000, "Marketing Manager"));

                        admin.addRoom(new Room(101, "Deluxe Single Bed", 1000));
                        admin.addRoom(new Room(102, "Executive Double Bed", 3000));
                        admin.addRoom(new Room(103, "Luxury King Bed", 1800));
                        admin.addRoom(new Room(104, "Standard Single Bed", 500));
                        admin.addRoom(new Room(105, "Premium Double Bed", 1100));
                        admin.addRoom(new Room(106, "Suite King Bed", 1000));
                        admin.addRoom(new Room(107, "Twin Bed", 800));
                        admin.addRoom(new Room(108, "Family Room", 1500));
                        admin.addRoom(new Room(109, "Accessible Room", 500));
                        admin.addRoom(new Room(110, "Presidential Suite", 5000));
                        System.out.println("\nAdded 10 Rooms and 10 Staff.");
                    }
                    else {
                        System.out.print("\nPresets already added.");
                    }
                }
                default -> {
                    if (welcmenu != 0) {
                        System.out.println("\nInvalid");
                    }
                }
            }
            if (welcmenu == 0) {
                System.out.println("\n\nExiting\nPress any Key to Close Program");
                sc.next();
                System.exit(0);
            }
        }
    }
}