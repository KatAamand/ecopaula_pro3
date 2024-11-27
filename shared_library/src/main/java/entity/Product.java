package entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product", schema = "ecopaula_production")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "trays_in_product",
            schema = "ecopaula_production",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tray_id")
    )
    private Set<Tray> trays;

    public Product(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Product() {};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Tray> getTrays() {
        return trays;
    }

    public void setTrays(Set<Tray> trays) {
        this.trays = trays;
    }
}
