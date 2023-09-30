package com.example.lab7gtics.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "technician")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID", nullable = false)
    private Integer id;

    @Column(name = "FirstName", nullable = false, length = 100)
    @Size(max = 100, min = 3,message = "Solo se soportan entre 3 a 100 caractéres")
    @NotBlank
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 100)
    @Size(max = 100, min = 3,message = "Solo se soportan entre 3 a 100 caractéres")
    @NotBlank
    private String lastName;

    @Column(name = "Dni", nullable = false, length = 8)
    @Digits(integer = 8,fraction = 0, message = "Debe ingresar 8 dígitos")
    private String dni;

    @Column(name = "Phone", nullable = false, length = 9)
    @Digits(integer = 9,fraction = 0, message = "Debe ingresar 9 dígitos")

    private String phone;

    @Column(name = "Age", nullable = false)
    @Digits(integer = 2,fraction = 0, message = "")
    @Min(value = 18, message = "Evite ingresar valores negativos")
    @Max(value = 60,message = "La edad debe ser entre 18 - 60 años")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}