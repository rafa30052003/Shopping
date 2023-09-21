package model.dao;

import java.util.ArrayList;


import model.dto.*;
import utils.Utils;

public class OrderDao {
	
	private ArrayList <Order> pedidos = new ArrayList <Order>();
	
	public boolean addOrder(Order order) {
		boolean valid = false;
		if(!pedidos.contains(order) && findOrder(order.getCod())==null) {
			pedidos.add(order);
			valid=true;
		}
		return valid;
	}
	
	public Order findOrder(int cod) {
		Order p=null;
		for(Order pedido: pedidos) {
			if(pedido.getCod()==cod) {
					p=pedido;
			}
		}
		return p;
	}
	
	
	public boolean deleteOrder(Order pedido) {
			
			boolean valid=false;
			if(pedidos.contains(pedido)) {
				pedidos.remove(pedido);
				valid=true;
				Utils.print("Eliminado correctamente.");
			}else {
				Utils.print("No se ha eliminado.");
			}
			return valid;
		}
	
	/**
	 * Función que muestra todos los Elementos del ArrayList
	 */
	
	public String showAllOrders() {
		String result="";
		for(Order p: pedidos) {
			if(p!=null) {
				result+=p+"\n";
			}
		}
		return result;
	}
	
}
