package masters;

// Base UEmployee class
class UEmployee {
    private String name;
    private double salary;

    public UEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

// Faculty class inheriting from UEmployee
class Faculty extends UEmployee {
    private String department;

    public Faculty(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

// Staff class inheriting from UEmployee
class Staff extends UEmployee {
    private String jobTitle;

    public Staff(String name, double salary, String jobTitle) {
        super(name, salary);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}

// Main class for testing
public class Employee {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("Dr. Smith", 80000, "Computer Science");
        Staff staff = new Staff("John Doe", 40000, "Administrator");

        System.out.println("Faculty: " + faculty.getName() + ", Salary: " + faculty.getSalary() + ", Department: " + faculty.getDepartment());
        System.out.println("Staff: " + staff.getName() + ", Salary: " + staff.getSalary() + ", Job Title: " + staff.getJobTitle());
    }
}

