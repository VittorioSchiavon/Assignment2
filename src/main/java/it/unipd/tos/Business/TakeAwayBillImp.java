////////////////////////////////////////////////////////////////////
// [VITTORIO] [SCHIAVON] [1187243]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import java.time.LocalTime;
import java.util.Random;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillImp implements TakeAwayBill {

  static int numFreeOrders=10;
  static Random seed= new Random(1000);

  double modificaTot(double numeroGelati,double prezzoMinimo,
  double gelatiEBudini,double tot){

    if(numeroGelati>5) {
      tot=tot-(prezzoMinimo/2);
    }

    if(gelatiEBudini>50){
      tot=tot-(tot*0.1);
    }

    if(tot<10 && tot>0){
      tot+=0.5;
    }
    return tot;
  }

  boolean freeOrder(LocalTime orderTime, User user) {

    if (orderTime.isAfter(LocalTime.of(17, 59, 59)) &&
            orderTime.isBefore(LocalTime.of(19, 00, 01))) {
        if (user.getAge()<18) {
            if (numFreeOrders > 0) {
                int x = seed.nextInt() & Integer.MAX_VALUE;
                if (x % 100 < 50) {
                    numFreeOrders=numFreeOrders-1;
                    return true;
                }
            }
        }
    } else {
        numFreeOrders = 10;
    }
    return false;
}

  public double getOrderPrice(List<MenuItem> itemsOrdered, User user,
  LocalTime orderTime)
  throws RestaurantBillException {

    if(itemsOrdered.size()>30) {
      throw new RestaurantBillException
      ("Numero massimo elementi superato");
    }

    int numeroGelati=0;
    double tot=0;
    double prezzoMinimo=0;
    double gelatiEBudini=0;

    for (int i = 0; i < itemsOrdered.size(); i++) {

      tot+=itemsOrdered.get(i).getPrice();

      if(itemsOrdered.get(i).getItemType()==ItemType.Gelati) {
        gelatiEBudini+=itemsOrdered.get(i).getPrice();
        numeroGelati++;
        if( prezzoMinimo==0 || itemsOrdered.get(i).getPrice()<prezzoMinimo){
          prezzoMinimo=itemsOrdered.get(i).getPrice();

        }
      }else if(  itemsOrdered.get(i).getItemType()==ItemType.Budini){
        gelatiEBudini+=itemsOrdered.get(i).getPrice();
      }
    }

            if (freeOrder(orderTime, user)) {
                return 0;
            }

    return modificaTot(numeroGelati ,prezzoMinimo,gelatiEBudini,tot);
  }
}
