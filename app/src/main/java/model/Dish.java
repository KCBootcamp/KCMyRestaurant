package model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class Dish implements Serializable {
    private String name;
    private String photoUrl;
    private List<String> allergens;
    private BigDecimal price;
    private Currency currency;
    private String description;

    public Dish(String name, String photoUrl, List<String> allergens, BigDecimal price, Currency currency, String description) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.allergens = allergens;
        this.price = price;
        this.currency = currency;
        this.description = description;
    }

    public Dish(String name, List<String> allergens, BigDecimal price) {
        this(name, null, allergens, price, Currency.getInstance(Locale.FRANCE), "");
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

    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
}
