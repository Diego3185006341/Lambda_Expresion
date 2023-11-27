package org.Lambdas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("elis",LocalDate.of(1991, 1, 21),34546);
        Person p2 = new Person("carlos ",LocalDate.of(1995, 2, 11),64546);
        Person p3 = new Person("albert ",LocalDate.of(2000, 1, 06),78453);

        Employee e1 = new Employee("alfed",LocalDate.of(1990, 1, 7),34546);
        Employee e2 = new Employee("dino ",LocalDate.of(1980, 2, 7),64546);
        Employee e3 = new Employee("andres ",LocalDate.of(1993, 3, 7),78453);

        Products pr1 = new Products(1, "Ceviche", 15.0);
        Products pr2 = new Products(2, "Chilaquiles", 25.50);
        Products pr3 = new Products(3, "Bandeja Paisa", 35.50);
        Products pr4 = new Products(4, "Ceviche", 15.0);


        List<Person> persons = Arrays.asList(p1,p2,p3);
        List<Employee> employees = Arrays.asList(e1,e2,e3);
        List<Products> products = Arrays.asList(pr1, pr2, pr3, pr4);

        // Filter foreach
       // persons.forEach(System.out::print);

        //filter

       /* List<Person> collect = persons.stream()
                .filter(sa -> getAge(sa.getBirthDate()) >= 28)
                .collect(Collectors.toList());


        ListMapper(collect);*/
        //Mapper
        /*
        List<Integer> collect = persons.stream()
                .map(person -> getAge(person.getBirthDate()))
                .collect(Collectors.toList());
        ListMapper(collect);*/

        //Mapper Function
        /*
        Function<String,String> CoderFuncion = name -> " Coder " + name;
        List<String> collect = persons.stream()
                .map(Person::getName )
                .map(CoderFuncion)
                .collect(Collectors.toList());
        ListMapper(collect);*/

        //Maper Person to  Employee

        /*List<Employee> collect = persons.stream()
                .map(asd -> employeeMapper(asd))
                .collect(Collectors.toList());

        ListMapper(collect);*/

        //sorted

        Comparator<Person> byNameAsc = Comparator.comparing(Person::getName);
        List<Person> personList = persons.stream()
                .sorted(byNameAsc).collect(Collectors.toList());
        ListMapper(personList);

        Comparator<Person> byNameDesc = Comparator.comparing(Person::getName, Comparator.reverseOrder());
        List<Person> personLista = persons.stream()
                .sorted(byNameDesc)
                .collect(Collectors.toList());
        ListMapper(personLista);

        //filter
        /*

        List<Person> LsPersons1 = persons.stream()
                .filter(person -> person.getName().contains("t"))
                .collect(Collectors.toList());

        Main.ListMapper(LsPersons1);*/

        // match any,none, all
        /*List<Integer> collectemAge = employees.stream()
                .map(Employee::getAge).collect(Collectors.toList());

        List<Integer> compare = collectemAge.stream()
                .filter(ageemployees  ->  persons.
                        stream().noneMatch(person -> ageemployees.equals(person.getEdad()))).collect(Collectors.toList());

        ListMapper(compare);*/

        //filter employee by name

        /*
        List<Employee> c = employees.stream().filter(as -> as.getName().contains("d"))
                .collect(Collectors.toList());
        ListMapper(c);*/
    }

    private static Employee employeeMapper(Person asd) {

        return Employee.builder()
                .name(asd.getName())
                .birthDate(asd.getBirthDate())
                .salary(asd.getSalary())
                .build();
    }

    public  static void ListMapper(List<?> Ls){
        Ls.forEach(System.out::print);

    }

    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }


}