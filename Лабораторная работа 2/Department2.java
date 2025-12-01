import java.util.ArrayList;
import java.util.List;

public class Department2 {
    private String name;
    private Employee2 chief;
    private List<Employee2> employees = new ArrayList<>();

    public Department2(String name) {
        this.name = name;
    }

    public void setChief(Employee2 chief) {
        this.chief = chief;
    }

    public Employee2 getChief() {
        return chief;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee2 e) {
        employees.add(e);
    }

    public List<Employee2> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return name;
    }
}
