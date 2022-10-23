package com.facundo.javaDocker.dto;

import com.facundo.javaDocker.models.Client;

public class ClientDTO {
    private long id;
    private String name, lastName,email,password;
    private long dni;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.email= client.getEmail();
        this.password= client.getPassword();
        this.dni = client.getDni();
    }

    /*GETTERS*/
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public long getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
