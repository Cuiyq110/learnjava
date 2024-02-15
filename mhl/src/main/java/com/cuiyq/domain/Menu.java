package com.cuiyq.domain;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
public class Menu {
    private Integer id;
    private String name;
    private Double price;
    private String type;

    public Menu() {
    }
    public Menu(Integer id, String name, Double price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return id + "\t\t\t" + name + "\t\t" + type + "\t\t" + price;
    }

}
