package com.study.basics.sample;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample1 {

    public static void main(String[] args) {
        String value = "We stay at gunjur near gunjur bus stop";
        List<Integer> intList = List.of(2,13,37,45,36,93);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Sumit", 400, "IT"));
        employees.add(new Employee("Divya", 700, "Marketing"));
        employees.add(new Employee("Swaroop", 900, "Analytics"));
        employees.add(new Employee("Sheetal", 600, "Operations"));

        Map<String, String> demoMap = new HashMap<String, String>();
        demoMap.put("1", "sumit");
        demoMap.put("2", "anil");
        demoMap.put("3", "sunil");
        demoMap.put("4", "prakash");

//        findDuplicateString(value);
//        removeDuplicateFromString(value);
//        findLongestString(value);
//        findUniqueItems(value);
        findFirstNonRepeatElement(value);
//        findSecondHighestNumber(intList);
//        findSecondHighestSalary(employees);
//        sortBasedOnSalaryThenName(employees);
//        sortByKeyOrValues(demoMap);
    }

    private static void sortByKeyOrValues(Map<String, String> demoMap) {
        System.out.println("By Value:: ");
        demoMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        System.out.println("By Key:: ");
        demoMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    }

    private static void sortBasedOnSalaryThenName(List<Employee> employees) {
        employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName)).forEach(System.out::println);
    }

    private static void findSecondHighestSalary(List<Employee> employees) {
        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get().getSalary());
    }

    private static void findSecondHighestNumber(List<Integer> intList) {
        System.out.println(intList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
    }

    private static void findFirstNonRepeatElement(String value) {
        System.out.println(Arrays.stream(value.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().get());

        String val = String.valueOf("cactus".chars().mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(x->x, HashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue()==1)
                .findFirst()
                .map(Map.Entry::getKey).get());
        System.out.println(val);
    }

    private static void findUniqueItems(String value) {
        System.out.println(Arrays.stream(value.split(" ")).distinct().collect(Collectors.toList()));
    }

    private static void findLongestString(String value) {
        Map<Object, Long> map =
//                Arrays.stream(value.split(" ")).distinct().collect(Collectors.toMap(x->x, String::length));
                Arrays.stream(value.split(" ")).distinct().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        System.out.println("longest string:: " +map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());

        System.out.println("longest string:: " +Arrays.stream(value.split(" ")).distinct().max(Comparator.comparingLong(String::length)).get());
    }

    private static void removeDuplicateFromString(String value) {
        String str = Arrays.stream(value.split(" ")).distinct().collect(Collectors.joining(" "));
        System.out.println("String after removing duplicate:: " +str);
    }

    private static void findDuplicateString(String value) {

        Map<Object, Long> occurance =
                Arrays.stream(value.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(occurance);
        System.out.println("Highest number of duplicates :: " +occurance.values().stream().max(Comparator.naturalOrder()).get());
        System.out.println("Highest number of duplicates for string :: "+occurance.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());
    }
}

