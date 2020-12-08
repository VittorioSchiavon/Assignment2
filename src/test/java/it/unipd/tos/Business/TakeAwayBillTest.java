////////////////////////////////////////////////////////////////////
// [VITTORIO] [SCHIAVON] [1187243]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillTest {

    private TakeAwayBillImp test;


    @Before
    public void BeforeClass() {
        test = new TakeAwayBillImp();
    }

    @Test
    public void testGetOrderPriceStandard() {
        List<MenuItem> list = new ArrayList<MenuItem>();
        list.add(new MenuItem(ItemType.Gelati,"Pinguino",5));
        list.add(new MenuItem(ItemType.Bevande,"Cola",3));
        list.add(new MenuItem(ItemType.Budini,"Coppa Nafta",4));

        try {
            assertEquals(12, test.getOrderPrice(list, new User("12345","Vittorio","Schiavon",LocalDate.of(1999,12,21))),0);
        } catch (RestaurantBillException exce) {
            // TODO Auto-generated catch block
            fail("errore");

        }

    }

    @Test
    public void testGetOrderPriceVuoto() {
        List<MenuItem> BlankList = new ArrayList<MenuItem>();

        try {
            assertEquals(0, test.getOrderPrice(BlankList, new User("12345","Vittorio","Schiavon",LocalDate.of(1999,12,21))),0);
        } catch (RestaurantBillException exce) {
            // TODO Auto-generated catch block
            fail("errore");

        }

    }


}