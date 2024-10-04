import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private Hotel hotel;
    private ArrayList<Staff> staff;
    Scanner sc = new Scanner(System.in);

    public Admin(Hotel hotel) {
        this.hotel = hotel;
        this.staff = new ArrayList<>();
    }

    public void addStaff(Staff staff) {
        this.staff.add(staff);
    }

    public void removeStaff(String id) {
        for (Staff staff : staff) {
            if (staff.getId().equals(id)) {
                this.staff.remove(staff);
                System.out.println("\nStaff removed successfully.");
                return;
            }
        }
        System.out.println("\nStaff not found.");
    }

    public void searchStaff(String id) {
        for (Staff staff : staff) {
            if (staff.getId().equals(id)) {
                System.out.println("Name: " + staff.getName() + ", ID: " + staff.getId() + ", Salary: " + staff.getSalary()+ ", Job: "+staff.getJob());
                return;
            }
        }
        System.out.println("\nStaff not found.");
    }

    public void updateStaff(String id) {
        for (Staff staff : staff) {
            if (staff.getId().equals(id)) {
                while (true) {
                    System.out.print("\nUPDATE STAFF\n\n1.Name\n2.Salary\n3.Job\n4.Job\n0.Return\nSelect an Option: ");
                    int updmenu =sc.nextInt();
                    sc.nextLine();
                    switch (updmenu){
                        case 1 -> {
                            System.out.printf("\nCurrent Staff Name: %s \nEnter New Name: ", staff.getName());
                            String name = sc.nextLine();
                            staff.setName(name);
                            System.out.printf("\nStaff name now set to %s", name);
                        }
                        case 2 -> {
                            System.out.printf("\nCurrent Staff Salary: %d \nEnter New Salary: ", staff.getSalary());
                            int salary = sc.nextInt();
                            sc.nextLine();
                            staff.setSalary(salary);
                            System.out.printf("\nStaff salary now set to %d", salary);
                        }
                        case 3 -> {
                            System.out.printf("\nCurrent Staff Job: %s \nEnter New Job: ", staff.getJob());
                            String job = sc.nextLine();
                            staff.setJob(job);
                            System.out.printf("\nStaff job now set to %s", job);
                        }
                        default -> {
                            if (updmenu != 0){
                                System.out.println("\nInvalid");
                            }
                        }
                    }
                    if (updmenu == 0){
                        System.out.println("\nReturning");
                        break;
                    }
                }
                return;
            }
        }
        System.out.println("\nStaff not found.");
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void displayRooms() {
        for (Room room : hotel.getRooms()) {
            System.out.println("\nRoom Number: " + room.getRoomNumber() + ", Room Type: " + room.getRoomType() +", Room Price per Night: "+ room.getRoomPrice() +", Booked: " + room.isBooked());
        }
    }

    public void addRoom(Room room) {
        hotel.addRoom(room);
    }
    public void removeRoom(){
        System.out.print("\nEnter Room Number to Remove: ");
        int roomNumber = sc.nextInt();
        hotel.removeRoom(roomNumber);
    }

    public void viewAllStaff() {
        for (Staff staff : staff) {
            System.out.println("\nName: " + staff.getName() + ", ID: " + staff.getId() + ", Salary: " + staff.getSalary()+", Job: "+staff.getJob());
        }
    }

    public void addNewCustomer(Customer customer) {
        hotel.addCustomer(customer);
    }

    public void viewBookedCustomers() {
        for (Customer customer : hotel.getCustomers()) {
            if (customer.getRoom() != null) {
                System.out.println("\nCustomer ID: " + customer.getId() + ", Name: " + customer.getName() + ", Room Number: " + customer.getRoom().getRoomNumber());
            }
        }
    }

    public void viewCustomerInfo(Customer customer) {
        System.out.println("\nCustomer ID: " + customer.getId() + ", Name: " + customer.getName() + ", Email: " + customer.getEmail() + ", Phone: " + customer.getPhone() + ", Address: " + customer.getAddress());
    }

    public void viewCheckInLogs() {
        ArrayList<String> checkInLogs = hotel.getCheckInLogs();
        for (String log : checkInLogs) {
            System.out.println(log);
        }
    }

    public void viewCheckOutLogs() {
       ArrayList<String> checkOutLogs = hotel.getCheckOutLogs();
       for (String log : checkOutLogs) {
           System.out.println(log);
       }
    }
}