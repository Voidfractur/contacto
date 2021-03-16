/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servera;

import bd_datos.conexion;
import java.rmi.server.UnicastRemoteObject;
import Stub.Stub;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Ivan Luis Jimenez
 */
public class ServerObject_RMI extends UnicastRemoteObject implements Stub {
    /*
     *Parametros para la conexion y consultas a la base de datos
     */

    conexion C = new conexion();
    Connection CC = C.conex();
    PreparedStatement us;

    /*
     *Vectores para almacenar los resultados
     */
    Vector<Vector<String>> Dcoo = new Vector<Vector<String>>();
    Vector<String> Dcua = new Vector<String>();
    Vector<Vector<String>> vv = new Vector<Vector<String>>();

    /*
     *Vectores para método E
     */
    Vector<String> hora = new Vector<String>();
    Vector<String> calle1 = new Vector<String>();
    Vector<String> calle2 = new Vector<String>();
    Vector<String> delegacion = new Vector<String>();
    Vector<String> delito = new Vector<String>();

    /*
     *Vectores para método D    
     */
    Vector<String> fecha = new Vector<String>();
    Vector<String> colonia = new Vector<String>();
    Vector<String> tipo = new Vector<String>();

    public ServerObject_RMI() throws java.rmi.RemoteException {
        super();
    }

    
    public void limpiar_D(){
        fecha.clear();
        colonia.clear();
        tipo.clear();
    }

    @Override
    public String addContacto(List<String> arg0) throws RemoteException {
         try {
            String consulta = "INSERT INTO `contactos`.`cont` (`nombre_cont`, `apellido_cont`, `numero`, `email`) "
                    + "VALUES ('"+arg0.get(0)+"', '"+arg0.get(1)+"', '"+arg0.get(2)+"', '"+arg0.get(3)+"');";
            Statement st = CC.createStatement();
            st.execute(consulta);
        } catch (Exception e) {
            ServerA.Write("Error [RMI] método D:"+e.getMessage());
            return "Error al crear Contacto";
        }
        ServerA.Write("[RMI] Cliente ejecutó método D");
        return "Contacto añadido";
    }


    @Override
    public String ModificarContacto(List<String> arg0) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String BuscarCont(String arg0) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
