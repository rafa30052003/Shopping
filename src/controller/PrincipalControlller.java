package controller;

import utils.Utils;
import view.PrincipalView;

public class PrincipalControlller {

    PrincipalView pv = new PrincipalView();
    CustomerController cc = new CustomerController();
    OrderController oc = new OrderController();

    public void controlaMenuPrincipal(){
        int opcion;
        boolean valid = false;
        do{
        pv.Menu();
        opcion = Utils.leeEntero("Introduce la opcion a elegir: ");
        switch (opcion){
            case 0:
                valid = true;
                Utils.print("has salido de la aplicacion.");
                break;
            case 1:
                cc.controlCustomerMenu();
                break;
            case 2:
                //co.controlOrderMenu();
                break;

            default:
                Utils.print("Opcion incorrecta");
        }
        }while(!valid);
    }
}
