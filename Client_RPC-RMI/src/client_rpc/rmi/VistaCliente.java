/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_rpc.rmi;

import Frame.VentanaAddCont;
import Stub.Stub;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcClient;

/**
 *
 * @author spart
 */
public class VistaCliente extends javax.swing.JFrame {  
    private VentanaAddCont ventanaAdd;
    private Stub cliente2;
    public VistaCliente() {
        initComponents();
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAddContacto = new javax.swing.JButton();
        btnBuscarContacto = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Contactos");

        btnAddContacto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddContacto.setText("Agregar Contacto");
        btnAddContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddContactoActionPerformed(evt);
            }
        });

        btnBuscarContacto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscarContacto.setText("Buscar Contacto");

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(153, 102, 255));

        jButton1.setText("Conectar con servidor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarContacto)
                    .addComponent(btnAddContacto)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28))
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnAddContacto)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarContacto)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddContactoActionPerformed
ventanaAdd = new VentanaAddCont(cliente2);
 ventanaAdd.setVisible(true);        
    }//GEN-LAST:event_btnAddContactoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        lblEstado.setText("Contectando...");
        int estado = conectar_A();
        if (estado == 3) {
             lblEstado.setText("Finalizó correctamente");
        } else {
            if(estado == 2){
                int estado2 = conectar_B();
                if(estado2 == 3){
                    lblEstado.setText("Finalizó correctamente");
                }else{
                    
                }
            }          
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddContacto;
    private javax.swing.JButton btnBuscarContacto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEstado;
    // End of variables declaration//GEN-END:variables

    public int conectar_A() {
        int estado = 0;
        String ruta_RPC = "http://localhost:81/";
        String ruta_RMI = "rmi://localhost:1099/ServerRMI";
        try {
            XmlRpcClient cliente = new XmlRpcClient(ruta_RPC);
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            cliente2 = (Stub) Naming.lookup(ruta_RMI);
            estado = 5;
            lblEstado.setText("Conectado a servidor A");
        } catch (Exception e) {
           
            lblEstado.setText("No se pudo conectar al servidor A");
            lblEstado.setText("Conectando al servidor B");
            estado = 2;
        }

        return estado;
    }
    
    
    public int conectar_B() {
        int estado = 0;
        String ruta_RPC = "http://192.168.43.156:81/";
        String ruta_RMI = "rmi://192.168.43.156:1099/ServerRMI";
        try {
            XmlRpcClient cliente = new XmlRpcClient(ruta_RPC);            
            Registry reg = LocateRegistry.getRegistry("192.168.43.156", 1099);
            cliente2 = (Stub) Naming.lookup(ruta_RMI);
            estado =5;
            lblEstado.setText("Conectado a servidor B");
        } catch (Exception e) {
            lblEstado.setText("No se pudo conectar al servidor B");
            estado = 2;
        }
        return estado;
    }
}
