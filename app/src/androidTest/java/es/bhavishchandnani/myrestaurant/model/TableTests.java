package es.bhavishchandnani.myrestaurant.model;


import android.test.AndroidTestCase;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Table;
import es.bhavishchandnani.myrestaurant.model.TableState;


public class TableTests extends AndroidTestCase {
    public static final int id = 1;
    public static final int PEOPLE = 4;
    public static final TableState STATE = TableState.ORDERPENDING;

    public void testCreateTable(){
        Table sut = new Table(id, PEOPLE, STATE);
        assertNotNull(sut);
    }

    public void testTableStoresData(){
        Table sut = new Table(id, PEOPLE, STATE);
        assertEquals(id,sut.getId());
        assertEquals(PEOPLE,sut.getPeople());
        assertEquals(STATE,sut.getState());
    }

    public void testTableProperties(){
        Table sut = new Table(id, PEOPLE, STATE);

        assertEquals(id,sut.getId());
        assertEquals(PEOPLE,sut.getPeople());
        assertEquals(STATE,sut.getState());

        assertEquals(String.format(getContext().getString(es.bhavishchandnani.myrestaurant.R.string.table_name_format), id), sut.getName(getContext()));
        assertEquals(R.mipmap.ic_table_pending,sut.getIconId());
    }

}
