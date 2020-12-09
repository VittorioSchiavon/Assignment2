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
      assertEquals(0, test.getOrderPrice( BlankList , new User("12345","Vittorio","Schiavon",LocalDate.of(1999,12,21))),0);
    } catch (RestaurantBillException exce) {
      // TODO Auto-generated catch block
      fail("errore");

    }

  }

  @Test
  public void testSconto() {
    List<MenuItem> ordine = new ArrayList<MenuItem>();
    ordine.add(new MenuItem(ItemType.Gelati,"Vaniglia",4));
    ordine.add(new MenuItem(ItemType.Gelati,"Cioccolato",5));
    ordine.add(new MenuItem(ItemType.Gelati,"Pistacchio",6));
    ordine.add(new MenuItem(ItemType.Gelati,"Banana",7));
    ordine.add(new MenuItem(ItemType.Gelati,"Mirtillo",8));
    ordine.add(new MenuItem(ItemType.Gelati,"Cassata",9));

    try {
      assertEquals(37, test.getOrderPrice(ordine, new User("12345","Vittorio","Schiavon",LocalDate.of(1999,12,21))),0);
    } catch (RestaurantBillException exce) {
      // TODO Auto-generated catch block
      fail("errore");

    }


  }

  @Test
  public void testNonSconto() {
    List<MenuItem> ordine = new ArrayList<MenuItem>();
    ordine.add(new MenuItem(ItemType.Gelati,"Vaniglia",4));
    ordine.add(new MenuItem(ItemType.Gelati,"Cioccolato",5));
    ordine.add(new MenuItem(ItemType.Gelati,"Pistacchio",6));
    ordine.add(new MenuItem(ItemType.Gelati,"Banana",7));
    ordine.add(new MenuItem(ItemType.Gelati,"Mirtillo",8));

    try {
      assertEquals(30, test.getOrderPrice(ordine, new User("12345","Vittorio","Schiavon",LocalDate.of(1999,12,21))),0);
    } catch (RestaurantBillException exce) {
      // TODO Auto-generated catch block
      fail("errore");

    }

  }

  @Test
  public void testSconto50() {
    List<MenuItem> ordine = new ArrayList<MenuItem>();
    ordine.add(new MenuItem(ItemType.Gelati,"Vaniglia",10));
    ordine.add(new MenuItem(ItemType.Gelati,"Cioccolato",10));
    ordine.add(new MenuItem(ItemType.Gelati,"Pistacchio",10));
    ordine.add(new MenuItem(ItemType.Gelati,"Banana",10));
    ordine.add(new MenuItem(ItemType.Gelati,"Mirtillo",10));
    ordine.add(new MenuItem(ItemType.Gelati,"Cassata",10));
    ordine.add(new MenuItem(ItemType.Budini,"Cassata",10));
    ordine.add(new MenuItem(ItemType.Bevande,"Coca",10));

    try {
      assertEquals(67.5, test.getOrderPrice(ordine, new User("12345","Vittorio","Schiavon",LocalDate.of(1999,12,21))),0);
    } catch (RestaurantBillException exce) {
      // TODO Auto-generated catch block
      fail("errore");

    }
  }

  @Test
  public void testNonSconto50() {
    List<MenuItem> ordine = new ArrayList<MenuItem>();
    ordine.add(new MenuItem(ItemType.Gelati,"Vaniglia",10));
    ordine.add(new MenuItem(ItemType.Budini,"Cassata",10));
    ordine.add(new MenuItem(ItemType.Bevande,"Coca",10));

    try {
      assertEquals(30, test.getOrderPrice(ordine, new User("12345","Vittorio","Schiavon",LocalDate.of(1999,12,21))),0);
    } catch (RestaurantBillException exce) {
      // TODO Auto-generated catch block
      fail("errore");

    }
  }

  @Test(expected = RestaurantBillException.class)
  public void testPiuDi30elementi() throws RestaurantBillException{
    List<MenuItem> list = new ArrayList<MenuItem>();
    for(int i = 0; i < 35; i++) {
      list.add(new MenuItem(ItemType.Budini, "Vaniglia", 5));
    }
    test.getOrderPrice(list,new User("12345","Vittorio","Schiavon",LocalDate.of(1999,12,21)));
  }


  @Test
  public void testCommissione() {
    List<MenuItem> ordine = new ArrayList<MenuItem>();
    ordine.add(new MenuItem(ItemType.Gelati,"Vaniglia",1));
    ordine.add(new MenuItem(ItemType.Gelati,"Cola",2));
    ordine.add(new MenuItem(ItemType.Budini,"CoppaBudino",5));

    try {
      assertEquals(8.5, test.getOrderPrice(ordine, new User("12345","Vittorio","Schiavon",LocalDate.of(1999,12,21))),0);
    } catch (RestaurantBillException exce) {
      // TODO Auto-generated catch block
      fail("Errore");

    }

  }

  @Test
  public void testNoCommissione() {
    List<MenuItem> ordine = new ArrayList<MenuItem>();
    ordine.add(new MenuItem(ItemType.Gelati,"Vaniglia",1));
    ordine.add(new MenuItem(ItemType.Gelati,"Cola",2));
    ordine.add(new MenuItem(ItemType.Budini,"CoppaBudino",5));
    ordine.add(new MenuItem(ItemType.Budini,"CoppaBudino",5));

    try {
      assertEquals(13, test.getOrderPrice(ordine, new User("12345","Vittorio","Schiavon",LocalDate.of(1999,12,21))),0);
    } catch (RestaurantBillException exce) {
      // TODO Auto-generated catch block
      fail("Errore");

    }

  }
}
