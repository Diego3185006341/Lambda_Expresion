package org.Lambdas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class Person {
    String name;
    private LocalDate birthDate;
    double salary;
}
