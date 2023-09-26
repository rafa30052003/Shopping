package model.dto;

import java.util.Objects;

public class Order {
    private int cod;
    private String nombre;
    private String proveedor;
    private Customer cliente;

    public Order() {
    }

    public Order(int cod, String nombre, String proveedor, Customer cliente) {
        this.cod = cod;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.cliente = cliente;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Customer getCliente() {
        return cliente;
    }

    public void setCliente(Customer cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return cod == order.cod && Objects.equals(nombre, order.nombre) && Objects.equals(proveedor, order.proveedor);
    }

    @Override
    public String toString() {
        return "Order{" +
                "cod=" + cod +
                ", nombre='" + nombre + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
