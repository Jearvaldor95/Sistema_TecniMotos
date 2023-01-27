package PRESENTACION;

import LOGICANEGOCIO.ClientesNegocio;
import static PRESENTACION.MenuPrincipal.PanelEscritorio;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class TablaClientes extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    ClientesNegocio tb = new ClientesNegocio();

    public TablaClientes() {
        initComponents();
        mostrar("");
        BuscarPorCedula("");
        BuscarPorNombre("");
        campoidcliente.setVisible(true);
    }

    void mostrar(String valor) {
        try {
            DefaultTableModel modelo;
            ClientesNegocio tb = new ClientesNegocio();
            modelo = tb.MostrarTabla(valor);
            this.TablaCliente.setModel(modelo);

            TablaCliente.setModel(modelo);
            TablaCliente.getColumnModel().getColumn(0).setPreferredWidth(20);
            TablaCliente.getColumnModel().getColumn(1).setPreferredWidth(150);
            TablaCliente.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaCliente.getColumnModel().getColumn(3).setPreferredWidth(50);
            TablaCliente.getColumnModel().getColumn(4).setPreferredWidth(200);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void BuscarPorNombre(String valor) {
        try {
            DefaultTableModel modelo;
            ClientesNegocio tb = new ClientesNegocio();
            modelo = tb.Filtrarpornombres(valor);
            this.TablaCliente.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);;
        }
    }

    void BuscarPorCedula(String valor) {
        try {
            DefaultTableModel modelo;
            ClientesNegocio tb = new ClientesNegocio();
            modelo = tb.Filtrarporcedula(valor);
            this.TablaCliente.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        radiobuton1 = new javax.swing.JRadioButton();
        radiobuton2 = new javax.swing.JRadioButton();
        campobuscarpornombre = new javax.swing.JTextField();
        campobuscarpordocumento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        NUEVO = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        campoidcliente = new javax.swing.JTextField();

        setBorder(new javax.swing.border.MatteBorder(null));
        setClosable(true);
        setIconifiable(true);
        setTitle("TABLA CLIENTES");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de Consultas"));

        radiobuton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radiobuton1.setText("Buscar Clientes Por Nombres");
        radiobuton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobuton1ActionPerformed(evt);
            }
        });

        radiobuton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radiobuton2.setText("Buscar Clientes por N° Cedula");
        radiobuton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobuton2ActionPerformed(evt);
            }
        });

        campobuscarpornombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campobuscarpornombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campobuscarpornombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campobuscarpornombreKeyTyped(evt);
            }
        });

        campobuscarpordocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campobuscarpordocumentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campobuscarpordocumentoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(radiobuton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campobuscarpornombre))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(radiobuton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campobuscarpordocumento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiobuton1)
                    .addComponent(radiobuton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campobuscarpornombre, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(campobuscarpordocumento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID CLIENTE", "NOMBRE CLIENTE", "N° CEDULA", "TELEFONO", "DIRECCION"
            }
        ));
        jScrollPane1.setViewportView(TablaCliente);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Mantenimiento"));

        NUEVO.setText("NUEVO");
        NUEVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUEVOActionPerformed(evt);
            }
        });

        ELIMINAR.setText("ELIMINAR");
        ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARActionPerformed(evt);
            }
        });

        Modificar.setText("MODIFICAR");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Modificar)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ELIMINAR)
                        .addComponent(NUEVO)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(NUEVO)
                .addGap(38, 38, 38)
                .addComponent(ELIMINAR)
                .addGap(43, 43, 43)
                .addComponent(Modificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("INFORMACION DE LOS CLIENTES");

        campoidcliente.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(321, 321, 321)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(364, 364, 364)
                                .addComponent(campoidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(campoidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NUEVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUEVOActionPerformed
        // TODO add your handling code here:
        Clientes c = new Clientes();
        PanelEscritorio.add(c);
        c.setLocation(165, 0);
        this.dispose();
        c.show();
    }//GEN-LAST:event_NUEVOActionPerformed

    private void ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELIMINARActionPerformed
        // TODO add your handling code here:
        int fila = TablaCliente.getSelectedRow();
        if (fila >= 0) {
            campoidcliente.setText(TablaCliente.getValueAt(fila, 0).toString());

            int valor = JOptionPane.showConfirmDialog(this, "¿Estas Seguro Que Quieres Eliminar el Cliente?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (valor == JOptionPane.YES_NO_OPTION) {
                tb.EliminaeCliente(this);
            }
        } else {
            JOptionPane.showMessageDialog(null, " Seleccione el Cliente a eliminar Por Favor");
        }


    }//GEN-LAST:event_ELIMINARActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
        Clientes c = new Clientes();
        MenuPrincipal.PanelEscritorio.add(c);

        int fila = TablaCliente.getSelectedRow();
        if (fila >= 0) {

            c.campoid.setText(TablaCliente.getValueAt(fila, 0).toString());
            c.camponombres.setText(TablaCliente.getValueAt(fila, 1).toString());
            c.campodocumento.setText(TablaCliente.getValueAt(fila, 2).toString());
            c.campotelefono.setText(TablaCliente.getValueAt(fila, 3).toString());
            c.campodireccion.setText(TablaCliente.getValueAt(fila, 4).toString());
            c.Guardar.setEnabled(false);
            c.show();
            c.toFront();
            c.setLocation(165, 0);
            c.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, " Seleccione el Cliente a eliminar Por Favor");
        }

    }//GEN-LAST:event_ModificarActionPerformed

    private void radiobuton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobuton1ActionPerformed
        // TODO add your handling code here:

        if (radiobuton1.isSelected() == true) {
            campobuscarpordocumento.setEnabled(false);
            campobuscarpornombre.requestFocus();
            campobuscarpornombre.setEnabled(true);
            radiobuton2.setSelected(false);
        }
    }//GEN-LAST:event_radiobuton1ActionPerformed

    private void radiobuton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobuton2ActionPerformed
        // TODO add your handling code here:
        if (radiobuton2.isSelected() == true) {
            campobuscarpordocumento.setEnabled(true);
            campobuscarpordocumento.requestFocus();
            campobuscarpornombre.setEnabled(false);
            radiobuton1.setSelected(false);
        }
    }//GEN-LAST:event_radiobuton2ActionPerformed

    private void campobuscarpornombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campobuscarpornombreKeyReleased
        // TODO add your handling code here:
        BuscarPorCedula("");
        BuscarPorNombre(campobuscarpornombre.getText());
    }//GEN-LAST:event_campobuscarpornombreKeyReleased

    private void campobuscarpordocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campobuscarpordocumentoKeyReleased
        // TODO add your handling code here:
        BuscarPorCedula(campobuscarpordocumento.getText());
    }//GEN-LAST:event_campobuscarpordocumentoKeyReleased

    private void campobuscarpornombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campobuscarpornombreKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_campobuscarpornombreKeyTyped

    private void campobuscarpordocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campobuscarpordocumentoKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if (campobuscarpordocumento.getText().length() >= 10) {
            evt.consume();
        }
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_campobuscarpordocumentoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ELIMINAR;
    public javax.swing.JButton Modificar;
    public javax.swing.JButton NUEVO;
    public javax.swing.JTable TablaCliente;
    public javax.swing.JTextField campobuscarpordocumento;
    public javax.swing.JTextField campobuscarpornombre;
    public javax.swing.JTextField campoidcliente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JRadioButton radiobuton1;
    public javax.swing.JRadioButton radiobuton2;
    // End of variables declaration//GEN-END:variables
}
