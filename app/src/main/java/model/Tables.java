package model;


import java.util.List;

public class Tables {

    private List<Table> tables;

    public Tables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public Table getDish(int position){
        return tables.get(position);
    }

    public int getCount() {
        return tables.size();
    }
}
