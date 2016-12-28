package es.bhavishchandnani.myrestaurant;


import android.test.AndroidTestCase;

import java.util.LinkedList;
import java.util.List;

import model.Table;
import model.TableState;
import model.Tables;

public class TablesTests extends AndroidTestCase {
    public void testCreateDishesNoReturnsNull(){
        List<Table> data = getTables();
        Tables sut = new Tables(data);
        assertNotNull(sut);
        assertNotNull(sut.getCount());
        assertEquals(sut.getTables(), data);
        assertTrue(sut.getCount() > 0);
        assertEquals(sut.getCount(), data.size());
    }

    private List<Table> getTables() {
        List<Table> data = new LinkedList<>();
        data.add(getTable(1));
        data.add(getTable(2));
        data.add(getTable(3));
        return data;
    }

    public Table getTable(int number){
        Table table = new Table(number, 4, TableState.ORDERPENDING);
        return table;
    }
}
