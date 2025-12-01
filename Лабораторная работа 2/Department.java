public class Department {
    private String name;
    private Employee chief;

    public Department(String name) {
        this.name = name;
    }

    public void setChief(Employee chief) {
        this.chief = chief;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee getChief() {
        return chief;
    }

    @Override
    public String toString() {
        return name;
    }
}
