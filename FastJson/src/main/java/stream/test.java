package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author ricky
 * @create 2023-03-29 20:18
 */
public class test {

	static public List<Employee> filterEmployee(List<Employee> emps, Predicate<Employee> mp){
		List<Employee> list = new ArrayList<>();

		for (Employee employee : emps) {
			if(mp.test(employee)){
				list.add(employee);
			}
		}

		return list;
	}

	public static void main(String[] args) {

		List<Employee> emps = new ArrayList<>();
		Employee employee = new Employee("aa",10);
		emps.add(employee);

		List<Employee> list = filterEmployee(emps, (e) -> e.getAge() <= 35);
		list.forEach(System.out::println);


	}
}
