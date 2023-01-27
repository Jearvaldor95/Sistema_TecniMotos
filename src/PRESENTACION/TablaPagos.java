package PRESENTACION;

import LOGICANEGOCIO.PagosNegocio;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class TablaPagos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;

    public TablaPagos() {
        initComponents();
        mostrar("");
        BuscarPorNombre("");
    }

    void mostrar(String valor) {
        try {
            DefaultTableModel modelo;
            PagosNegocio pn = new PagosNegocio();
            modelo = pn.MostrarTabla(valor);
            this.TablaPago.setModel(modelo);
            
            TablaPago.setModel(modelo);
            TablaPago.getColumnModel().getColumn(0).setPreferredWidth(20);
            TablaPago.getColumnModel().getColumn(1).setPreferredWidth(150);
            TablaPago.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaPago.getColumnModel().getColumn(3).setPreferredWidth(50);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);;
        }
    }
    
    void BuscarPorNombre(String valor) {
        try {
            DefaultTableModel modelo;
            PagosNegocio pn = new PagosNegocio();
            modelo = pn.FiltrarPorNombre(valor);
            this.TablaPago.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPago = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campofiltrarpornombre = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTA ABONOS CLIENTES");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TablaPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TablaPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PAGO", "CLIENTE", "FECHA ABONO", "VALOR ABONADO"
            }
        ));
        jScrollPane1.setViewportView(TablaPago);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opcion de Consulta"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("BUSCAR CLIENTE:");

        campofiltrarpornombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campofiltrarpornombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campofiltrarpornombreActionPerformed(evt);
            }
        });
        campofiltrarpornombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campofiltrarpornombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campofiltrarpornombreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campofiltrarpornombre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campofiltrarpornombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void campofiltrarpornombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campofiltrarpornombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campofiltrarpornombreActionPerformed

    private void campofiltrarpornombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campofiltrarpornombreKeyReleased
        // TODO add your handling code here:
        BuscarPorNombre(campofiltrarpornombre.getText());
    }//GEN-LAST:event_campofiltrarpornombreKeyReleased

    private void campofiltrarpornombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campofiltrarpornombreKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_campofiltrarpornombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaPago;
    private javax.swing.JTextField campofiltrarpornombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
