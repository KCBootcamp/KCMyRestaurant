package model;


import android.content.res.Resources;

import java.io.Serializable;

import es.bhavishchandnani.myrestaurant.R;

public class Table implements Serializable{
    private int id;
    private int people;
    private TableState state;

    public Table(int id, int people, TableState state) {
        this.id = id;
        this.people = people;
        this.state = state;
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

    public String getName() {
        return String.format(Resources.getSystem().getString(R.string.table_name_format), id);
    }

    public int getIcon() {
        return getState().getIconId();
    }

}
