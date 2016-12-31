package es.bhavishchandnani.myrestaurant.model;


import java.util.LinkedList;
import java.util.List;

public class Dishes {

    private static Dishes instance;
    private List<Dish> dishes;

    private Dishes(){}

    public static Dishes getInstance() {
        if (instance == null){
            instance = new Dishes();
        }
        return instance;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Dish getDish(int position){
        return dishes.get(position);
    }

    public List<Dish> getDishesWithType(DishType type){
        List<Dish> filteredDishes = new LinkedList<>();
        for (Dish dish : dishes) {
            if (dish.getType().equals(type)){
                filteredDishes.add(dish);
            }
        }
        return filteredDishes;
    }

    public int getCount() {
        return dishes.size();
    }
}
