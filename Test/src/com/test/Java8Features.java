package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Features {

	public static void main(String[] args) {
		List<Employee> employeeList = getEmployeeList();
		// Employee count --use of count
		System.out.println("Employee's count in list(count)::" + employeeList.stream().count());

		// Employee count --counting
		System.out
				.println("Employee's count in list(counting)::" + employeeList.stream().collect(Collectors.counting()));

		// filter employee having salary > 10K and limit to first 2
		List<Employee> employeeSalaryList = employeeList.stream().filter(x -> x.getSalary() > 10000)
				.collect(Collectors.toList());
		System.out.println("Employee having salary > 10::" + employeeSalaryList);

		// filter employee having max salary
		Employee empMax = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("Employee having max salary::" + empMax);

		// filter employee having max salary -- using maxBy
		Employee empMaxCollector = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
		System.out.println("Employee having max salary-- using maxBy::" + empMaxCollector);

		// filter employee having min salary
		Employee empMin = employeeList.stream().min(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("Employee having min salary::" + empMin);

		// filter employee having findFirstEmp salary
		Employee findFirstEmp = employeeList.parallelStream().filter(x -> x.getDept().equalsIgnoreCase("IT"))
				.findFirst().get();
		System.out.println("findFirstEmp who is in IT::" + findFirstEmp);

		// filter employee having findFirstEmp salary
		Employee findAnyEmp = employeeList.stream().filter(x -> x.getDept().equalsIgnoreCase("IT")).findAny().get();
		System.out.println("findAnyEmp who is in IT::" + findAnyEmp);

		// Sum of employee salary -- using reduce
		Integer salarySum = employeeList.stream().map(x -> x.getSalary()).reduce((a, b) -> a + b).get();
		System.out.println("Employees salary sum using reduce::" + salarySum);

		// Sum of employee salary -- using sum()
		salarySum = employeeList.stream().mapToInt(x -> x.getSalary()).sum();
		System.out.println("Employees salary sum using sum()::" + salarySum);

		// Average of employee's salary
		Double salaryAvg = employeeList.stream().mapToInt(x -> x.getSalary()).average().getAsDouble();
		System.out.println("Employees salary average::" + salaryAvg);

		// Distinct emp names
		List<String> employeeDistinct = employeeList.stream().map(x -> x.getName()).distinct()
				.collect(Collectors.toList());
		System.out.println("Distinct employee's name::" + employeeDistinct);

		// sort by name
		List<Employee> employeeSortByName = employeeList.stream().sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		System.out.println("Employee's list sorted by name Asc::" + employeeSortByName);

		// sort by name reversed
		List<Employee> employeeSortByNameRev = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		System.out.println("Employee's list sorted by name Desc::" + employeeSortByNameRev);

		// allMatch-- salary greater than 30K
		System.out.println(
				"Does all employee's have salary >30K::" + employeeList.stream().allMatch(x -> x.getSalary() > 30000));

		// anyMatch-- salary greater than 30K
		System.out.println(
				"Does any employee has salary >30K::" + employeeList.stream().anyMatch(x -> x.getSalary() > 30000));

		// noneMatch-- salary greater than 3L
		System.out.println(
				"Does any employee has salary >30K::" + employeeList.stream().noneMatch(x -> x.getSalary() > 300000));

		// joining
		System.out.println("Employee ID's concat::"
				+ employeeList.stream().map(x -> x.getEmpId()).collect(Collectors.joining("/", "(", ")")));

		// Sum of employee salary -- using summingInt()
		salarySum = employeeList.stream().collect(Collectors.summingInt(Employee::getSalary));
		System.out.println("Employees salary sum using summingInt()::" + salarySum);

		// group employee's by gender
		Map<String, List<Employee>> genderMap = employeeList.stream()
				.collect(Collectors.groupingBy(x -> String.valueOf(x.getGender()).equals("F") ? "Female" : "Male"));
		System.out.println("Employees grouped by gender::" + genderMap);

		// group employee's by gender and their count
		Map<String, Long> genderMapwithCount = employeeList.stream().collect(Collectors
				.groupingBy(x -> String.valueOf(x.getGender()).equals("F") ? "Female" : "Male", Collectors.counting()));
		System.out.println("Employees grouped by gender and count of employee::" + genderMapwithCount);

		// group employee's by gender and max salary in each gender
		Map<String, Optional<Employee>> genderWithMaxsalary = employeeList.stream()
				.collect(Collectors.groupingBy(x -> String.valueOf(x.getGender()).equals("F") ? "Female" : "Male",
						Collectors.maxBy(Comparator.comparing(x -> x.getSalary()))));
		System.out.println("Employees grouped by gender and max salary of employee::" + genderWithMaxsalary);

		String str = "abc";
		String newString = IntStream.range(0, str.length())
				.mapToObj(x -> x == 0 ? String.valueOf(str.charAt(x)).toUpperCase() : String.valueOf(str.charAt(x)))
				.collect(Collectors.joining());
		System.out.println("Changed first character to Upper" + newString);

		// Distinct emp names -- mapping by
		Set<String> distinctEmpNames = employeeList.stream()
				.collect(Collectors.mapping(Employee::getName, Collectors.toSet()));
		System.out.println(distinctEmpNames);
		
		Optional<Integer> op=Optional.ofNullable(null);
		System.out.println(op.isPresent());
	}

	public static List<Employee> getEmployeeList() {
		Employee E1 = new Employee("Rohan", "R123", 20000, "IT", 'M');
		Employee E2 = new Employee("Amit", "A123", 30000, "Finance", 'M');
		Employee E3 = new Employee("Marie", "M456", 40000, "IT", 'F');
		Employee E4 = new Employee("Molly", "J123", 100000, "CEO", 'F');

		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(E1);
		employeeList.add(E2);
		employeeList.add(E3);
		employeeList.add(E4);

		return employeeList;
	}
}
