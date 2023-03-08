/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoClientes;
/**
 *
 * @author visitante
 */
public class clsClientes {
    private int idClientes;
    private String Nombre;
    private String Nit;

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    public clsClientes(int idClientes, String Nombre, String Nit) {
        this.idClientes = idClientes;
        this.Nombre = Nombre;
        this.Nit = Nit;
    }

    public clsClientes(String Nombre, String Nit) {
        this.Nombre = Nombre;
        this.Nit = Nit;
    }

    public clsClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public clsClientes() {
    }

    

  
    @Override
    public String toString() {
        return "clsClientes{" + "idClientes=" + idClientes + ", Nombre=" + Nombre + ", Nit=" + Nit + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsClientes getBuscarInformacionClientePorNombre(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.consultaClientesPorNombre(cliente);
    }
    public clsClientes getBuscarInformacionClientePorId(clsClientes cliente )
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.consultaClientesPorId(cliente);
    }    
    public List<clsClientes> getListadoClientes()
    {
        daoClientes daocliente = new daoClientes();
        List<clsClientes> listadoClientes= daocliente.consultaClientes();
        return listadoClientes;
    }
    public int setBorrarClientes(clsClientes cliente)
    {
        daoClientes daoclientes = new daoClientes();
        return daoclientes.borrarClientes(cliente);
    }          
    public int setIngresarCliente(clsClientes cliente)
    {
        daoClientes daoclientes = new daoClientes();
        return daoclientes.ingresaClientes(cliente);
    }              
    public int setModificarCliente(clsClientes cliente)
    {
        daoClientes daoclientes = new daoClientes();
        return daoclientes.actualizaClientes(cliente);
    }              

    public void add(clsClientes cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
