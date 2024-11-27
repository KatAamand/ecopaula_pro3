package entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "animal", schema = "ecopaula_production")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double weight;

    @Column(name = "registration_date")
    private Date registration_date;

    @ManyToOne
    @JoinColumn(name = "origin", nullable = false)
    private Origin origin;

    @OneToMany(mappedBy = "animal")
    private Set<Cut> cuts;


    public Animal(int id, double weight, Date registrationDate, Origin origin) {
        this.id = id;
        this.weight = weight;
        this.registration_date = registrationDate;
        this.origin = origin;
    }

    public Animal() {}

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
        return registration_date;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registration_date = registrationDate;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }
}
