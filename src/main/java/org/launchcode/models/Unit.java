package org.launchcode.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Unit {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String type;

    private String category;

    private int price;

    private int productionTime;

    private int quantity;

    public int getId() {
        return id;
    }

    public Unit(String name, String type, String category, int price, int productionTime, int quantity) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.price = price;
        this.productionTime = productionTime;
        this.quantity = quantity;
    }

    public Unit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
