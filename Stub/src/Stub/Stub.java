/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stub;

import java.rmi.Remote;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Ivan Luis Jimenez
 */
public interface Stub extends Remote{
    public String addContacto(List<String> cont)
             throws java.rmi.RemoteException;
    public String ModificarContacto(List<String> cont)
             throws java.rmi.RemoteException;
    public String BuscarCont(String text)
             throws java.rmi.RemoteException;
    public List<List<String>> getContactoPAtron(String text)
             throws java.rmi.RemoteException;
    public boolean EliminarContacto(String text)
             throws java.rmi.RemoteException;
}
