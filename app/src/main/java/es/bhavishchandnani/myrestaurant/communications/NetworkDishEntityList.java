package es.bhavishchandnani.myrestaurant.communications;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NetworkDishEntityList {
    @SerializedName("dishes") List<NetworkDishEntity> dishList;

    public List<NetworkDishEntity> getDishList() {
        return dishList;
    }
}
