public class Staff {
    private String name;
    private String id;
    private int salary;
    private String job;

    public Staff(String name, String id, int salary, String job) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}