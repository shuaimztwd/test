package test.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

public class LambdaTest {

	public static void main(String[] args) {
		String str = null;

		Function<Long, String> fun1 = String::valueOf;
		str = fun1.apply(10L);

		Consumer<String> con1 = System.out::println;
		con1.accept(str);

		Supplier<String> sup1 = str::toUpperCase;
		str = sup1.get();

		Predicate<String> pre1 = str::equals;
		System.out.println(pre1.test("10"));

		List<Person> all = new ArrayList<>();
		all.add(new Person("张三", 30));
		all.add(new Person("李四", 31));
		all.add(new Person("李大嘴", 20));
		all.add(new Person("李大胆", 30));
		all.add(new Person("李晓鸡", 20));

		Map<Integer, List<Person>> map = all.stream().collect(
				Collectors.groupingBy(Person::getAge));
		Iterator<Entry<Integer, List<Person>>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, List<Person>> entry = it.next();
			List<Person> personList = entry.getValue();
			System.out.println(entry.getKey());
			personList.stream().forEach(System.out::println);
		}
		// System.out.println(all.stream().mapToDouble(Person::getAge)
		// .summaryStatistics().getSum());
	}
}
