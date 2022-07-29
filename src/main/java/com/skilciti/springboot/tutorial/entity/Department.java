package com.skilciti.springboot.tutorial.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Provide department name")
    @NotNull
    /*
   @Length(max = 30, min = 2)
    @Email //Validating email
    @Positive //Validating values
    @Negative //Validating values
    @PositiveOrZero //Validating values
    @NegativeOrZero //Validating values
    @Future //Validating date
    @FutureOrPresent //Validating date
    @Past //Validating date
    @PastOrPresent //Validating date
    */
    private String name;
    private String address;
    private String code;

}
