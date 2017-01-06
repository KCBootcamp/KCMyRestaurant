package es.bhavishchandnani.myrestaurant.model;


import java.io.Serializable;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class Dish implements Serializable {
    private String name;
    private DishType type;
    private String photoUrl;
    private List<Allergens> allergens;
    private double price;
    private Currency currency;
    private String description;

    public Dish(String name, DishType type,  String photoUrl, List<Allergens> allergens, double price, Currency currency, String description) {
        this.name = name;
        this.type =  type;
        this.photoUrl = photoUrl;
        this.allergens = allergens;
        this.price = price;
        this.currency = currency;
        this.description = description;
    }

    public Dish(String name, DishType type, List<Allergens> allergens, double price) {
        this(name, type, null, allergens, price, Currency.getInstance(Locale.FRANCE), null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Allergens> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<Allergens> allergens) {
        this.allergens = allergens;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

}

