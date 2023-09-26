package controller;

import model.dao.CostumerDao;
import model.dto.Customer;
import utils.Utils;
import view.PrincipalView;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private CostumerDao customerDao;
    private Scanner scanner;

    public CustomerController() {
        this.customerDao = new CostumerDao();
        this.scanner = new Scanner(System.in);
    }
    PrincipalView pv = new PrincipalView();
    public void controlCustomerMenu() {
        int option;
        boolean valid = false;
        do {
           pv.menuClient();
            option = Utils.leeEntero("Enter the option you want to choose: ");
            switch (option) {
                case 0:
                    valid = true;
                    Utils.print("You have exited successfully.");
                    break;
                case 1:
                    controlAddCustomer();
                    break;
                case 2:
                    controlSearchCustomer();
                    break;
                case 3:
                    controlaEditCustomer();
                    break;
                case 4:
                    controlDeleteCustomer();

                    break;
                default:
                    Utils.print("Incorrect option.");
                    break;
            }
        } while (!valid);
    }

    public void controlAddCustomer() {
        Utils.print("Add a new customer:");
        String dni = Utils.devuelveDNI("Enter the DNI: ");
        String name = Utils.leeString("Enter the name: ");
        String address = Utils.leeString("Enter the address: ");
        String phone = Utils.leeString("Enter the phone: ");

        Customer customer = new Customer(dni, name, address, phone);
        boolean added = customerDao.addOrder(customer);

        if (added) {
            Utils.print("The customer has been added successfully.");
        } else {
            Utils.print("Error adding the customer. Something went wrong.");
        }
    }

    public void controlSearchCustomer() {
        Utils.print("Search for a customer by DNI:");
        String dni = Utils.devuelveDNI("Enter the DNI to search for: ");
        Customer customer = customerDao.searchCustomer(dni);

        if (customer != null) {
            Utils.printObject("Customer found:\n" + customer.toString());
        } else {
            Utils.print("Customer not found.");
        }
    }

    public void controlDeleteCustomer() {
        Utils.print("Delete a customer:");
        String dni = Utils.devuelveDNI("Enter the customer's DNI to delete: ");
        Customer customer = customerDao.searchCustomer(dni);

        if (customer != null) {
            customerDao.deleteCustomer(customer);
            Utils.print("The customer has been deleted successfully.");
        } else {
            Utils.print("Customer not found. Could not be deleted.");
        }
    }

    public void showAllCustomers() {
        CostumerDao c = new CostumerDao();
        Utils.print("List of all customers:");
       String customer = c.showAllCustomer();

       Utils.printObject(customer);
    }

    public void controlaEditCustomer() {
        pv.editClient();
        Customer u = null;
        CostumerDao cd = new CostumerDao();
        u = cd.searchCustomer(Utils.devuelveDNI("Introduce el DNI de el Cliente a modificar: "));

        String nombre = Utils.leeString("Introduce el nombre: ");
        String tlf = Utils.leeString("Introduce el telefono: ");
        String adress = Utils.leeString("Introduce la direccion: ");
        u.setNombre(nombre);
        u.setTlf(tlf);
        u.setDireccion(adress);


    }

}
