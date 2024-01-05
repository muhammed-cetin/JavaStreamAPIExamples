package employeeexample;

public class Employee {

    private int employeeId;
    private String employeeName;
    private int employeeAge;
    private String employeeGender;
    private String employeeDept;
    private int employeeDoj;
    private double employeeSalary;

    public Employee(int employeeId, String employeeName, int employeeAge, String employeeGender, String employeeDept, int employeeDoj, double employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeGender = employeeGender;
        this.employeeDept = employeeDept;
        this.employeeDoj = employeeDoj;
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept;
    }

    public int getEmployeeDoj() {
        return employeeDoj;
    }

    public void setEmployeeDoj(int employeeDoj) {
        this.employeeDoj = employeeDoj;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
