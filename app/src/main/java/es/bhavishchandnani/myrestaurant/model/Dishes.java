package es.bhavishchandnani.myrestaurant.model;


import java.util.List;

public class Dishes {

    private List<Dish> dishes;

    public Dishes(List<Dish> dishes) {
        this.dishes = dishes;
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

    public int getCount() {
        return dishes.size();
    }
}
