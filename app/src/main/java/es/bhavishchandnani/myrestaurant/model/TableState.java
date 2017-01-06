package es.bhavishchandnani.myrestaurant.model;


import java.util.Arrays;
import java.util.LinkedList;

import es.bhavishchandnani.myrestaurant.R;

public enum TableState {
    EMPTY(R.drawable.ic_table_empty, R.string.state_table_empty),
    ORDERPENDING(R.drawable.ic_table_pending, R.string.state_table_pending),
    ORDERTAKEN(R.drawable.ic_table_taken, R.string.state_table_taken),
    ORDERSERVED(R.drawable.ic_table_served, R.string.state_table_served),
    ORDERPAID(R.drawable.ic_table_paid, R.string.state_table_paid);

    private int iconId;
    private int stateStringId;

    TableState(int iconId, int stateStringId) {
        this.iconId = iconId;
        this.stateStringId = stateStringId;
    }

    public int getIconId() {
        return iconId;
    }

    public int getStateStringId() {
        return stateStringId;
    }

    public static LinkedList<TableState> getTableStates(){
        LinkedList<TableState> tableStatesList = new LinkedList<>(Arrays.asList(TableState.values()));
        return tableStatesList;
    }
}
