package org.Lambdas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("elis",LocalDate.of(1991, 1, 21),34546);
        Person p2 = new Person("carlos ",LocalDate.of(1995, 2, 11),64546);
        Person p3 = new Person("albert ",LocalDate.of(2000, 1, 06),78453);

        Employee e1 = new Employee("alfed",23,34546);
        Employee e2 = new Employee("dino ",27,64546);
        Employee e3 = new Employee("andres ",88,78453);



        List<Person> persons = Arrays.asList(p1,p2,p3);
        List<Employee> employees = Arrays.asList(e1,e2,e3);

        // Filter foreach
       // persons.forEach(System.out::print);

        List<Person> collect = persons.stream()
                .filter(sa -> getAge(sa.getBirthDate()) >= 28)
                .collect(Collectors.toList());


        ListMapper(collect);



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
    public  static void ListMapper(List<?> Ls){
        Ls.forEach(System.out::print);

    }

    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }


}