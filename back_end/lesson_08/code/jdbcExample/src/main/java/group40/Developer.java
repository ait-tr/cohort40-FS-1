package group40;

public class Developer {
    private int id;
    private String name;
    private String specialty;
    private int salary;

    public Developer(int id, String name, String specialty, int salary) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", salary=" + salary +
                '}';
    }
}
