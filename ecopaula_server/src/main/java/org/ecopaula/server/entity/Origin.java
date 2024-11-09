package org.ecopaula.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name_of_farm;

    public Origin(int id, String name_of_farm) {
        this.id = id;
        this.name_of_farm = name_of_farm;
    }

    public Origin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_of_farm() {
        return name_of_farm;
    }

    public void setName_of_farm(String farmName) {
        this.name_of_farm = farmName;
    }
}
