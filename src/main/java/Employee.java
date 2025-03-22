import lombok.*;

//@Data
//@AllArgsConstructor
public class Employee {
    private String name;
    private int salary;
    private String Department;

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        Department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", Department='" + Department + '\'' +
                '}';
    }
}
