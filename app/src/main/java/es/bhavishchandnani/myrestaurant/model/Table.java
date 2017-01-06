package es.bhavishchandnani.myrestaurant.model;


import android.content.Context;

import java.io.Serializable;
import java.util.List;

import es.bhavishchandnani.myrestaurant.R;

public class Table implements Serializable{
    private int id;
    private int people;
    private TableState state;
    private List<Dish> dishList;

    public Table(int id, int people, TableState state, List<Dish> dishList) {
        this.id = id;
        this.people = people;
        this.state = state;
        this.dishList = dishList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public TableState getState() {
        return state;
    }

    public void setState(TableState state) {
        this.state = state;
    }

    public String getName(Context ctx) {
        return String.format(ctx.getString(R.string.table_name_format), id);
    }

    public int getIconId() {
        return getState().getIconId();
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
}
