package model;


import es.bhavishchandnani.myrestaurant.R;

public enum TableState {
    ORDERPENDING(R.mipmap.ic_table_pending),
    ORDERTAKEN(R.mipmap.ic_table_taken),
    ORDERSERVED(R.mipmap.ic_table_served),
    ORDERPAID(R.mipmap.ic_table_paid);

    private int iconId;

    TableState(int iconId) {
        this.iconId = iconId;
    }

    public int getIconId() {
        return iconId;
    }
}
