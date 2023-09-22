package model.dao;

import model.dto.Customer;
import model.dto.Order;

import java.util.ArrayList;

public class CostumerDao {
    private ArrayList <Customer> cliente = new ArrayList<Customer>();


    public boolean addOrder(Customer c) {
        boolean valid = false;
        if(!cliente.contains(c)){
            cliente.add(c);
            valid=true;
        }
        return valid;
    }


    public Customer searchCustomer(String dni) {
        Customer c = null;
        if(!cliente.isEmpty()) {
            for(Customer customer : cliente) {
                if(customer.getDni().equals(dni)) {
                    c=customer;
                }
            }
        }else {

        }

        return c;
    }

    public boolean deleteCustomer(Customer c) {
        boolean valid = false;
        if(cliente.contains(c)) {
            cliente.remove(c);
            valid = true;
        }else {

        }
        return valid;
    }

    public String showAllOrders() {
        String result="";
        for(Customer p: cliente) {
            if(p!=null) {
                result+=p+"\n";
            }
        }
        return result;
    }
}
