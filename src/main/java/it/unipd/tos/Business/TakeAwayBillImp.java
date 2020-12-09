////////////////////////////////////////////////////////////////////
// [VITTORIO] [SCHIAVON] [1187243]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillImp implements TakeAwayBill {
  public double getOrderPrice(List<MenuItem> itemsOrdered, User user)
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

    if(numeroGelati>5) {
      tot=tot-(prezzoMinimo/2);
    }

    if(gelatiEBudini>50){
      tot=tot-(tot*0.1);
    }

    return tot;
  }
}
