import java.util.List;

public class Employee2 {
    private String name;
    private Department2 department;

    public Employee2(String name, Department2 department) {
        this.name = name;
        this.department = department;
        department.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    public Department2 getDepartment() {
        return department;
    }

    public List<Employee2> getColleagues() {
        return department.getEmployees();
    }

    @Override
    public String toString() {
        Employee2 chief = department.getChief();

        if (chief == this)
            return name + " начальник отдела " + department.getName();

        return name + " работает в отделе " + department.getName() +
                ", начальник которого " + chief.getName();
    }
}
