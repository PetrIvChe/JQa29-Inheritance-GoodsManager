package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String model;
    private String manufacturer;

    public Smartphone(String model, String manufacturer) {
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public Smartphone(int id, String name, int price, String model, String manufacturer) {
        super(id, name, price);
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public Smartphone() {

        super();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone smartphone = (Smartphone) o;
        return Objects.equals(model, smartphone.model) &&
                Objects.equals(manufacturer, smartphone.manufacturer);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "model='" + model + '\'' +
                ", Manufacturer='" + manufacturer + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model, manufacturer);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
