package controller;

import model.dao.CostumerDao;
import model.dao.OrderDao;
import model.dto.Customer;
import model.dto.Order;
import utils.Utils;
import view.PrincipalView;

import java.util.Scanner;

public class OrderController {
	private OrderDao orderDao;
    private Scanner scanner;
    CostumerDao cd = new CostumerDao();
    public OrderController() {
        this.orderDao = new OrderDao();
        this.scanner = new Scanner(System.in);
    }
    
    PrincipalView pv = new PrincipalView();
    public void controlOrderMenu() {
        int option;
        boolean valid = false;
        do {
            pv.menuOrders();
            option = Utils.leeEntero("Enter the option you want to choose: ");
            switch (option) {
                case 0:
                    valid = true;
                    Utils.print("You have exited successfully.");
                    break;
                case 1:
                    controlAddOrder();
                    break;
                case 2:
                    controlSearchOrder();
                    break;
                case 3:
                	controlEditOrder();
                    break;
                case 4:
                    controlDeleteOrder();
                    break;
                default:
                    Utils.print("Incorrect option.");
                    break;
            }
        } while (!valid);
    }
    public void controlAddOrder() {
        Utils.print("Add a new Order:");
        int cod = Utils.leeEntero("Enter the Code: ");
        String nombre = Utils.leeString("Enter the name: ");
        String proveedor = Utils.leeString("Enter the supplier: ");
        Customer c= null;
        c  = (Customer)cd.findCustomer(Utils.devuelveDNI("Enter the customers DNI: "));


        Order order = new Order(cod, nombre, proveedor, c);
        boolean added = orderDao.addOrder(order);

        if (added) {
            Utils.print("The order has been added successfully.");
        } else {
            Utils.print("Error adding the order. Something went wrong.");
        }

    }
    public void controlSearchOrder() {
        Utils.print("Search for a customer by code:");
        int cod = Utils.leeEntero("Enter the code to search for: ");
        Order order =orderDao.findOrder(cod);

        if (order != null) {
            Utils.printObject("Order found:\n" + order.toString());
        } else {
            Utils.print("Order not found.");
        }
    }
    public void controlDeleteOrder() {
        Utils.print("Delete a order:");
        int cod = Utils.leeEntero("Enter the order's code to delete: ");
        Order order = orderDao.findOrder(cod);

        if (order != null) {
            orderDao.deleteOrder(order);
            Utils.print("The order has been deleted successfully.");
        } else {
            Utils.print("Order not found. Could not be deleted.");
        }
    }
    public void controlEditOrder() {
        pv.EditOrder();
        Order u = null;
        u = orderDao.findOrder(Utils.leeEntero("Enter the code of the Order to modify: "));

        String nombre = Utils.leeString("Enter the name: ");
        String proveedor = Utils.leeString("Enter the supplier: ");
        u.setNombre(nombre);
        u.setProveedor(proveedor);


    }
}
