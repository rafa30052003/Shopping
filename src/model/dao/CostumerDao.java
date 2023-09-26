package model.dao;


import model.dto.Customer;
import model.dto.Order;
import utils.Utils;

import java.util.ArrayList;

public class CostumerDao {
    private ArrayList <Customer> clientes = new ArrayList<Customer>();


    public boolean addOrder(Customer c) {
        boolean valid = false;
        if(!clientes.contains(c)){
            clientes.add(c);
            valid=true;
        }
        return valid;
    }


    public Customer findCustomer(String dni) {
		Customer u=null;
		for(Customer c: clientes) {
			if(c.getDni().equals(dni)) {
					u=c;
					break;
			}else {
				Utils.print("No se encuentra el elemento introducido");
			}
		}
		return u;
	}

    public boolean deleteCustomer(Customer c) {
        boolean valid = false;
        if(clientes.contains(c)) {
            clientes.remove(c);
            valid = true;
        }else {

        }
        return valid;
    }

    public String showAllCustomer() {
        String result="";
        for(Customer p: clientes) {
            if(p!=null) {
                result+=p+"\n";
            }
        }
        return result;
    }
}
