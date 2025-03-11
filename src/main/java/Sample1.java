import java.util.*;
import java.util.stream.Collectors;

public class Sample1 {

    public static void main(String[] args) {
        String value = "We stay at gunjur near gunjur bus stop";
        List<Integer> intList = List.of(2,13,37,45,36,93);

//        List<Employee> employees = List.of(
//                new Employee("Sumit", 400, "IT"),
//                new Employee("Divya", 700, "Marketing"),
//                new Employee("Swaroop", 900, "Analytics"),
//                new Employee("Sheetal", 600, "Operations"));
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Sumit", 400, "IT"));
        employees.add(new Employee("Divya", 700, "Marketing"));
        employees.add(new Employee("Swaroop", 900, "Analytics"));
        employees.add(new Employee("Sheetal", 600, "Operations"));
//        findDuplicateString(value);
//        removeDuplicateFromString(value);
//        findLongestString(value);
//        findUniqueItems(value);
//        findFirstNonRepeatElement(value);
//        findSecondHighestNumber(intList);
        findSecondHighestSalary(employees);
    }

    private static void findSecondHighestSalary(List<Employee> employees) {
        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get().getSalary());
    }

    private static void findSecondHighestNumber(List<Integer> intList) {
        System.out.println(intList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
    }

    private static void findFirstNonRepeatElement(String value) {
        System.out.println(Arrays.stream(value.split(" "))
                .collect(Collectors.groupingBy(x->x, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().get());
    }

    private static void findUniqueItems(String value) {
        System.out.println(Arrays.stream(value.split(" ")).distinct().collect(Collectors.toList()));
    }

    private static void findLongestString(String value) {
        Map<Object, Integer> map =
                Arrays.stream(value.split(" ")).distinct().collect(Collectors.toMap(x->x, String::length));
        System.out.println(map);
        System.out.println("longest string:: " +map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());

        System.out.println("longest string:: " +Arrays.stream(value.split(" ")).distinct().max(Comparator.comparingInt(String::length)).get());
    }

    private static void removeDuplicateFromString(String value) {
        String str = Arrays.stream(value.split(" ")).distinct().collect(Collectors.joining(" "));
        System.out.println("String after removing duplicate:: " +str);
    }

    private static void findDuplicateString(String value) {

        Map<Object, Long> occurance =
                Arrays.stream(value.split(" ")).collect(Collectors.groupingBy(Objects::toString, Collectors.counting()));
        System.out.println(occurance);
        System.out.println("Highest number of duplicates :: " +occurance.values().stream().max(Comparator.naturalOrder()).get());
        System.out.println("Highest number of duplicates for string :: "+occurance.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());
    }
}

