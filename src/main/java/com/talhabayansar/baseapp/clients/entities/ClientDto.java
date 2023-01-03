package com.talhabayansar.baseapp.clients.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientDto {
    private String firstName;
    private String lastName;
    private String birthday;
    private String city;
    private String email;
    private String zip;
    private List<Integer> productIds;

    public ClientDto(String firstName, String lastName, String birthday, String city, String email, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.city = city;
        this.email = email;
        this.zip = zip;
    }

    public Client toClient() {
        return new Client(null, getFirstName(), getLastName(), getBirthday(), getCity(), getEmail(), getZip(), null);
    }
}
