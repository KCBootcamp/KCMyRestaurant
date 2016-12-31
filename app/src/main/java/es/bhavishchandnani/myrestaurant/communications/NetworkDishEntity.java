package es.bhavishchandnani.myrestaurant.communications;


import com.google.gson.annotations.SerializedName;

public class NetworkDishEntity {

    @SerializedName("name") private String name;
    @SerializedName("type") private String type;
    @SerializedName("photoUrl") private String photoURL;
    @SerializedName("allergens") private String[] allergens;
    @SerializedName("price") private double price;
    @SerializedName("currency") private String currency;
    @SerializedName("description_es") private String descriptionEs;

    public String getName() {
        return name;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public String getType() {
        return type;
    }

    public String[] getAllergens() {
        return allergens;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescriptionEs() {
        return descriptionEs;
    }
}
