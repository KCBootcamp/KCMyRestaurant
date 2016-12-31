package es.bhavishchandnani.myrestaurant.model;


import android.test.AndroidTestCase;

import java.util.Currency;
import java.util.LinkedList;
import java.util.Locale;



public class DishTests extends AndroidTestCase {
    public static final String DISH = "Dish";
    public static final String DESCRIPTION = "description";
    public static final String PHOTOURL = "photo";
    public static final LinkedList<Allergens> ALLERGENS = getAllergensList();
    public static final double PRICE = 12.0;
    public static final Currency CURRENCY = Currency.getInstance(Locale.FRANCE);

    public void testCreateADish(){
        Dish sut = new Dish(DISH, DishType.FIRST_COURSE, ALLERGENS, PRICE);
        assertNotNull(sut);
    }

    public void testDishStoresData(){
        Dish sut = new Dish(DISH, DishType.DESSERT, ALLERGENS, PRICE);
        assertEquals(DISH,sut.getName());
        assertEquals(ALLERGENS,sut.getAllergens());
        assertEquals(PRICE,sut.getPrice());
    }

    public void testDishStoresProperties(){
        Dish sut = new Dish(DISH, DishType.FIRST_COURSE, ALLERGENS, PRICE);
        sut.setCurrency(CURRENCY);
        sut.setDescription(DESCRIPTION);
        sut.setPhotoUrl(PHOTOURL);

        assertEquals(DISH,sut.getName());
        assertEquals(ALLERGENS,sut.getAllergens());
        assertEquals(PRICE,sut.getPrice());
        assertEquals(sut.getDescription(), DESCRIPTION);
        assertEquals(sut.getPhotoUrl(), PHOTOURL);
        assertEquals(sut.getCurrency(), CURRENCY);
    }

    public static LinkedList<Allergens> getAllergensList() {
        LinkedList<Allergens> allergensList =  new LinkedList<>();
        allergensList.add(Allergens.CELERY);
        allergensList.add(Allergens.CRUSTACEAN);
        return allergensList;
    }
}
