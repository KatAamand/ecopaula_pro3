package dto;

import entity.Origin;

import java.io.Serializable;
import java.util.Date;

public class AnimalDTO implements Serializable {
    private int id;
    private double weight;
    private Date registrationDate;
    private Origin origin;

    public AnimalDTO() {
    }

    public AnimalDTO(int i, double v, Date date, Origin origin) {
        id = i;
        weight = v;
        registrationDate = date;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "AnimalDTO{id=" + id;
    }
}
