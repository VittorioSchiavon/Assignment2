////////////////////////////////////////////////////////////////////
// [VITTORIO] [SCHIAVON] [1187243]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {
    private MenuItem test;

    @Before
    public void beforeTest() {
        test= new MenuItem(ItemType.Bevande,"Acqua",2);
    }

    @Test
    public void itemTypeTest() {
        assertEquals(ItemType.Bevande,test.getItemType());
    }

    @Test
    public void nameTest() {
        assertEquals("Acqua",test.getName());
    }

    @Test
    public void priceTest() {
        assertEquals(2,test.getPrice(),0);
    }
}
