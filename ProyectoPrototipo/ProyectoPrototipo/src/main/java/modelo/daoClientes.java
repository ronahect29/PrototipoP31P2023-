/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsClientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoClientes {

    private static final String SQL_SELECT = "SELECT  idClientes, Nombre,Nit FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes(Nombre, Nit) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET Nombre=?, Nit=? WHERE idClientes= ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE idClientes=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT idClientes, Nombre, Nit FROM Clientes WHERE Nombre = ?";
    private static final String SQL_SELECT_ID = "SELECT idClientes, Nombre, Nit FROM Clientes WHERE idClientes= ?";    

    public List<clsClientes> consultaClientes() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsClientes> Cliente = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idClientes");
                String nombre = rs.getString("Nombre");
                String contrasena = rs.getString("Nit");
                clsClientes cliente = new clsClientes();
                cliente.setIdClientes(id);
                cliente.setNombre(nombre);
                cliente.setNit(contrasena);
                cliente.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return Cliente;
    }

    public int ingresaClientes(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getNit());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaClientes(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getNit());
            stmt.setInt(3, cliente.getIdClientes());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarClientes(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,cliente.getIdClientes());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsClientes consultaClientesPorNombre(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cliente);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, cliente.getNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idClientes");
                String nombre = rs.getString("Nombre");
                String contrasena = rs.getString("Nit");

                //usuario = new clsUsuario();
                cliente.setIdClientes(id);
                cliente.setNombre(nombre);
                cliente.setNit(contrasena);
                System.out.println(" registro consultado: " + cliente);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return cliente;
    }
    public clsClientes consultaClientesPorId(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cliente);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, cliente.getIdClientes());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idClientes");
                String nombre = rs.getString("Nombre");
                String contrasena = rs.getString("Nit");

                //usuario = new clsUsuario();
                cliente.setIdClientes(id);
                cliente.setNombre(nombre);
                cliente.setNit(contrasena);
                System.out.println(" registro consultado: " + cliente);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return cliente;
    }    
}
