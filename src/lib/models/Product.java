//Java imports
package lib.models;

import java.sql.Date;

public class Product {
    private int id;
    private String user;
    private int nit;
    private String brand;
    private String productType;
    private int quantity;
    private String storingMethod;
    private String storingPlace;
    private Date expirationDate;
    private String name;
    private String description;
    private String icon;

    public Product(int id, String user, int nit, String brand, String productType, 
            int quantity, String storingMethod, String storingPlace, Date expirationDate, 
            String name, String description, String icon) {
        this.id = id;
        this.user = user;
        this.nit = nit;
        this.brand = brand;
        this.productType = productType;
        this.quantity = quantity;
        this.storingMethod = storingMethod;
        this.storingPlace = storingPlace;
        this.expirationDate = expirationDate;
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStoringMethod() {
        return storingMethod;
    }

    public void setStoringMethod(String storingMethod) {
        this.storingMethod = storingMethod;
    }

    public String getStoringPlace() {
        return storingPlace;
    }

    public void setStoringPlace(String storingPlace) {
        this.storingPlace = storingPlace;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
}
