package employeeexample;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamExample {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeLoadData.loadEmployee();
        howManyMaleAndFemaleInTheOrganization(employeeList);
        averageAgeOfAllMaleAndFemaleInTheOrganization(employeeList);
        averageSalaryOfEachDepartment(employeeList);
        getDetailsOfYoungestMaleInEachDepartment(employeeList);
        getMaximumSalaryOfEmployeeFromEachDepartment(employeeList);

    }

    private static void getMaximumSalaryOfEmployeeFromEachDepartment(List<Employee> employeeList) {
        Map<String, Optional<Employee>> departmentWiseMaxSalary = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getEmployeeDept,
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getEmployeeSalary))
                        )
                );
        System.out.println("Example 5 : maximum salary of an employee from each department: " + departmentWiseMaxSalary);

        /*
            Collectors.groupingBy(Employee::getEmployeeDept, Collectors.maxBy(Comparator.comparingDouble(Employee::getEmployeeSalary))):
            Burada, groupingBy fonksiyonu kullanılarak departman (Employee::getEmployeeDept) özelliklerine göre gruplama yapılır. Her bir grup
            içindeki elemanlar, maaş değerine (Employee::getEmployeeSalary) göre maksimum değere sahip olan çalışanı bulmak için maxBy fonksiyonu
            kullanılarak gruplanır. Ancak, bu işlem sonucu Optional<Employee> türünde bir değer döndürecektir, çünkü bir departmanda hiç çalışan olmayabilir.
         */
    }

    private static void getDetailsOfYoungestMaleInEachDepartment(List<Employee> employeeList) {
        Map<String, Optional<Employee>> youngestEmployeesInEachDept = employeeList.stream()
                .filter(employee -> employee.getEmployeeGender() == "Male")
                .collect(
                        Collectors.groupingBy(Employee::getEmployeeDept,
                                Collectors.maxBy(Comparator.comparingInt(Employee::getEmployeeDoj)))
                );
        System.out.println("Example 4 : Youngest employee in each department: " + youngestEmployeesInEachDept);

        /*
            filter(employee -> employee.getEmployeeGender() == "Male"): Stream içinde sadece erkek çalışanları filtreler.
            Bu, cinsiyeti "Male" olan çalışanları içeren bir alt küme oluşturur.

            Collectors.groupingBy(Employee::getEmployeeDept, Collectors.maxBy(Comparator.comparingInt(Employee::getEmployeeDoj))):
            Burada, groupingBy fonksiyonu kullanılarak departman (Employee::getEmployeeDept) özelliklerine göre gruplama yapılır.
            Her bir grup içindeki elemanlar, işe başlama tarihine (Employee::getEmployeeDoj) göre maksimum değere sahip olan çalışanı bulmak için
            maxBy fonksiyonu kullanılarak gruplanır. Ancak, bu işlem sonucu Optional<Employee> türünde bir değer döndürecektir, çünkü bir departmanda
            hiç erkek çalışan olmayabilir.
         */
    }

    private static void averageSalaryOfEachDepartment(List<Employee> employeeList) {
        Map<String, Double> avgSalaryOfEachDepartment = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getEmployeeDept, Collectors.averagingDouble(Employee::getEmployeeSalary)
                        )
                );
        System.out.println("Example 3 : Average salary of each department: " + avgSalaryOfEachDepartment);
        /*
            Collectors.groupingBy(Employee::getEmployeeDept, Collectors.averagingDouble(Employee::getEmployeeSalary)): Burada, groupingBy
            fonksiyonu kullanılarak departman (Employee::getEmployeeDept) özelliklerine göre gruplama yapılır. Gruplar oluşturulurken, averagingDouble
            fonksiyonu kullanılarak her bir grup içindeki çalışan maaşlarının ortalaması alınır.
         */
    }

    private static void averageAgeOfAllMaleAndFemaleInTheOrganization(List<Employee> employeeList) {
        Map<String, Double> avgAgeOfFemaleAndMaleEmployees = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getEmployeeGender, Collectors.averagingInt(Employee::getEmployeeAge)
                        )
                );
        System.out.println("Example 2 : Average age of male and female employees: " + avgAgeOfFemaleAndMaleEmployees);

        /*
            Collectors.groupingBy(Employee::getEmployeeGender, Collectors.averagingInt(Employee::getEmployeeAge)): Burada, groupingBy
            fonksiyonu kullanılarak cinsiyet (Employee::getEmployeeGender) özelliklerine göre gruplama yapılır. Ancak, bu sefer averagingInt
            fonksiyonu kullanılarak yaş değerlerinin ortalaması alınır. Yani her cinsiyet için bir grup oluşturulur ve bu grupların içindeki
            yaş değerlerinin ortalaması alınarak bir Double değer elde edilir.
         */
    }

    private static void howManyMaleAndFemaleInTheOrganization(List<Employee> employeeList) {
        Map<String, Long> noOfFemaleAndMaleEmployees = employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getEmployeeGender, Collectors.counting())
                );

        System.out.println("Example 1 : No.of Females and Males: " + noOfFemaleAndMaleEmployees);

        /*
            Collectors.counting()): Burada, groupingBy fonksiyonu kullanılarak cinsiyet (Employee::getEmployeeGender) özelliklerine
            göre gruplama yapılır. Bu, bir Map döndürecektir. Her bir grup, cinsiyet değerine göre olacak ve bu gruplardaki eleman
            sayıları counting fonksiyonu ile sayılır. Sonuç olarak, her cinsiyet için bir anahtar ve o cinsiyetteki çalışan sayısıyla
            eşleşen bir değer içeren bir Map elde edilir.
         */
    }
}
