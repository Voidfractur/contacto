/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Stub.Stub;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author spart
 */
public class VentanaBuscar extends javax.swing.JFrame {

    /**
     * Creates new form VentanaBuscar
     */
    private List<List<String>> lista;
    private DefaultTableModel modeloTabla;
    private DefaultListModel jLModelo;
    private Stub cliente2;
    public VentanaBuscar(Stub stub) {
        initComponents();
        cliente2 = stub;
        jLModelo = new DefaultListModel();
        updateTable("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cajaPatron = new javax.swing.JTextField();
        jTContactos = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cajaPatron.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cajaPatron.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                cajaPatronCaretUpdate(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTContactos.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTContactos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(cajaPatron, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cajaPatron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jTContactos, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cajaPatronCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_cajaPatronCaretUpdate

   updateTable(cajaPatron.getText());

        // TODO add your handling code here:
    }//GEN-LAST:event_cajaPatronCaretUpdate
 public void updateTable(String text){
    modeloTabla = new DefaultTableModel();
      jTable1.setModel(modeloTabla);
    modeloTabla.addColumn("Nombre");
     modeloTabla.addColumn("Apellido");
      modeloTabla.addColumn("Numero");
       modeloTabla.addColumn("email");
       
       jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
       jTable1.getTableHeader().setReorderingAllowed(false);
        try {
            List<List<String>> lista = cliente2.getContactoPAtron(text);
            
            for (int i = 0; i < lista.get(0).size(); i++) {
                List<Object> miniLista = new ArrayList<Object>();
                miniLista.add(lista.get(0).get(i));
                 miniLista.add(lista.get(1).get(i));
                  miniLista.add(lista.get(2).get(i));
                   miniLista.add(lista.get(3).get(i));                 
                modeloTabla.addRow((Object[]) miniLista.toArray());
            }
 
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
 }
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
            java.util.logging.Logger.getLogger(VentanaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new VentanaBuscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cajaPatron;
    private javax.swing.JScrollPane jTContactos;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
