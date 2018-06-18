package com.nagham.model;

import javax.persistence.*;
import java.util.Set;


/**
 * @author Ahmed El-Deeb
 *
 */
@Entity
@Table(name = "package")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "package_id")
    private int id;
    @Column(name = "package_name")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    @JoinTable(name = "package_deals", joinColumns = @JoinColumn(name = "package_id"), inverseJoinColumns = @JoinColumn(name = "deal_id"))
    private Set<Deal> deals;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Deal> getDeals() { return deals; }

    public void setDeals(Set<Deal> deals) {
        this.deals = deals;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deals=" + deals +
                '}';
    }
}
