import java.util.Random;

public class Customer {
    private String id;
    private String name;
    private String email;
    private int phone;
    private String address;
    private Room room;

    public Customer(String name, String email, int phone, String address) {
        this.id = generateId();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.room = null;
    }

    private String generateId() {
        Random rand = new Random();
        int rid = rand.nextInt(1000);
        return "C" + rid;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}