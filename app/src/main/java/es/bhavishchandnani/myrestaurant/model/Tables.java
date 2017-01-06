package es.bhavishchandnani.myrestaurant.model;


import java.util.List;

public class Tables {

    private static Tables instance;
    private List<Table> tables;


    private Tables() {}

    public static Tables getInstance() {
        if (instance == null){
            instance = new Tables();
        }
        return instance;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public Table getTable(int position){
        return tables.get(position);
    }

    public void setTable(int position, Table table){
        tables.set(position, table);
    }

    public int getCount() {
        return tables.size();
    }
}
