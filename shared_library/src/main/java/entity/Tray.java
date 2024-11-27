package entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tray", schema = "ecopaula_production")
public class Tray {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "max_weight")
    private Double maxWeight;

    @ManyToOne
    @JoinColumn(name = "part_type", nullable = false)
    private PartType partType;

    @OneToMany(mappedBy = "tray")
    private Set<Cut> cuts;

    @ManyToMany
    @JoinTable(
            name = "trays_in_product",
            joinColumns = @JoinColumn(name = "tray_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;


    public Tray() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public PartType getPartType() {
        return partType;
    }

    public void setPartType(PartType partType) {
        this.partType = partType;
    }

    public Set<Cut> getCuts() {
        return cuts;
    }

    public void setCuts(Set<Cut> cuts) {
        this.cuts = cuts;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
