package es.bhavishchandnani.myrestaurant.model;


import android.test.AndroidTestCase;

import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import static es.bhavishchandnani.myrestaurant.model.DishTests.getAllergensList;

public class DishesTest extends AndroidTestCase {
    public static final String DISH = "Dish";
    public static final String DESCRIPTION = "description";
    public static final String PHOTOURL = "photo";
    public static final LinkedList<Allergens> ALLERGENS = getAllergensList();
    public static final double PRICE = 12.0;
    public static final Currency CURRENCY = Currency.getInstance(Locale.FRANCE);


    public void testCreateDishesNoReturnsNull(){
        List<Dish> data = getDishes();
        Dishes sut = new Dishes(data);
        assertNotNull(sut);
        assertNotNull(sut.getCount());
        assertEquals(sut.getDishes(), data);
        assertTrue(sut.getCount() > 0);
        assertEquals(sut.getCount(), data.size());
    }
    
    private List<Dish> getDishes() {
        List<Dish> data = new LinkedList<>();
        data.add(getDish(1));
        data.add(getDish(2));
        data.add(getDish(3));
        return data;
    }

    public Dish getDish(int number){
        Dish dish = new Dish(DISH + " "+ number, DishType.FIRST_PLATE, ALLERGENS, PRICE + number);
        dish.setCurrency(CURRENCY);
        dish.setDescription(DESCRIPTION + " " + number);
        dish.setPhotoUrl(PHOTOURL + " " + number);

        return dish;
    }

}
