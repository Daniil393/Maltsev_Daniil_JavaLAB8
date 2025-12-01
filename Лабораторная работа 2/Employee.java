public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        Department dep = department;
        Employee chief = dep.getChief();

        // Если сотрудник сам начальник отдела
        if (chief == this) {
            return name + " начальник отдела " + dep.getName();
        }

        // Обычный сотрудник
        return name + " работает в отделе " + dep.getName()
                + ", начальник которого " + chief.getName();
    }
}
