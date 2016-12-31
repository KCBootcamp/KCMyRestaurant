package es.bhavishchandnani.myrestaurant.mappers;


import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

import es.bhavishchandnani.myrestaurant.communications.NetworkDishEntity;
import es.bhavishchandnani.myrestaurant.communications.NetworkDishEntityList;
import es.bhavishchandnani.myrestaurant.model.Allergens;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.model.DishType;

public class DishMapper {
    public static List<Dish> mapDishList(String dishesString){
        List<Dish> dishList = new LinkedList<>();
        try {
            Reader reader = new StringReader(dishesString);
            Gson gson = new GsonBuilder().create();

            NetworkDishEntityList networkDishEntityList = gson.fromJson(reader, NetworkDishEntityList.class);
            dishList = mapNetworkDishEntityListToDishList(networkDishEntityList);

        }catch (Exception e){
            e.printStackTrace();
        }
        return dishList;
    }

    private static List<Dish> mapNetworkDishEntityListToDishList(NetworkDishEntityList networkDishEntityList) {
        List<Dish> dishList = new LinkedList<>() ;
        for (NetworkDishEntity networkDishEntity : networkDishEntityList.getDishList()) {
            Dish dish = mapNetworkDishEntityToDish(networkDishEntity);
            dishList.add(dish);
        }
        return dishList;
    }

    private static Dish mapNetworkDishEntityToDish(NetworkDishEntity networkDishEntity) {
        Currency currency = mapCurrency(networkDishEntity.getCurrency());
        List<Allergens> allergens = getAllergenses(networkDishEntity.getAllergens());
        DishType dishType = getDishType(networkDishEntity.getType());

        Dish dish = new Dish(
                networkDishEntity.getName(),
                dishType,
                networkDishEntity.getPhotoURL(),
                allergens,
                networkDishEntity.getPrice(),
                currency,
                networkDishEntity.getDescriptionEs());
        return dish;
    }

    @NonNull
    private static DishType getDishType(String type) {
       try{
           return DishType.valueOf(type);
        }catch (Exception e){
           System.out.println("ERROR PARSING DISHTYPE");
           return null;
        }

    }

    @NonNull
    private static List<Allergens> getAllergenses(String[] allergenArray) {
        List<Allergens> allergens = new LinkedList<>();
        for (String allergen : allergenArray) {
            try{
                allergens.add(Allergens.valueOf(allergen));
            }catch (Exception e){
                System.out.println("ERROR PARSING ALLERGEN");
            }
        }
        return allergens;
    }

    private static Currency mapCurrency(String currencyString) {
        try {
            return Currency.getInstance(currencyString);
        }catch (Exception e){
            System.out.println("ERROR PARSING CURRENCY");
            return null;
        }

    }
}
