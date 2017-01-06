package es.bhavishchandnani.myrestaurant.model;


import es.bhavishchandnani.myrestaurant.R;

public enum DishType {
    STARTER(R.string.starter),
    FIRST_COURSE(R.string.first_course),
    SECOND_COURSE(R.string.second_course),
    DESSERT(R.string.dessert),
    DRINK(R.string.drink);

    private int dishTypeNameId;

    DishType(int dishTypeNameId) {
        this.dishTypeNameId = dishTypeNameId;
    }

    public int getDishTypeNameId() {
        return dishTypeNameId;
    }
}
