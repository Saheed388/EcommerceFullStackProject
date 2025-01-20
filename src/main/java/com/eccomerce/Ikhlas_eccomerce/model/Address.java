package com.eccomerce.Ikhlas_eccomerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "Street name must be atleast five character")
    private String street;

    @NotBlank
    @Size(min = 5, message = "buildingName name must be atleast five character")
    private String buildingName;

    @NotBlank
    @Size(min = 5, message = "buildingName name must be atleast five character")
    private String city;

    @NotBlank
    @Size(min = 2, message = "state name must be atleast two character")
    private String state;

    @NotBlank
    @Size(min = 5, message = "country name must be atleast five character")
    private String country;

    @NotBlank
    @Size(min = 5, message = "pincode name must be atleast five character")
    private String pincode;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(Long addressId, String street, String buildingName, String city, String state, String country, String pincode) {
        this.addressId = addressId;
        this.street = street;
        this.buildingName = buildingName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }
}
