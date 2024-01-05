package employeeexample;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeStreamExample {
    public static void main(String[] args) {

    }

    private static void howManyMaleAndFemaleInTheOrganization(List<Employee> employeeList){
        Map<String,Long> noOfFemaleAndMaleEmployees = employeeList.stream()
                .collect(
                    Collectors.groupingBy(Employee::getEmployeeGender,Collectors.counting())
                );
    }
}
