package PRESENTACION;

import LOGICANEGOCIO.ComprasNegocio;
import LOGICANEGOCIO.DetallesComprasNegocio;
import static PRESENTACION.MenuPrincipal.PanelEscritorio;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Compra extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    DefaultTableModel Modelo = new DefaultTableModel();
    ComprasNegocio cn = new ComprasNegocio();
    DetallesComprasNegocio dcd = new DetallesComprasNegocio();

    public Compra() {
        initComponents();
        String[] data = {"CODIGO", "NOMBRE PRODUCTO", "CANTIDAD", "VALOR UNITARIO", "DESCUENTO", "PRECIO NETO", "VALOR ENTRADA", "VALOR TOTAL"};
        Modelo = new DefaultTableModel(null, data);
        this.TablaCompra.setModel(Modelo);
        TablaCompra.getColumnModel().getColumn(0).setPreferredWidth(50);
        TablaCompra.getColumnModel().getColumn(1).setPreferredWidth(200);
        TablaCompra.getColumnModel().getColumn(2).setPreferredWidth(15);
        TablaCompra.getColumnModel().getColumn(3).setPreferredWidth(50);
        TablaCompra.getColumnModel().getColumn(4).setPreferredWidth(50);

        campofechacompra.setEnabled(false);
        campofechacompra.setDisabledTextColor(Color.blue);
        campofechacompra.setText(fechaactual());

        campostockactual.setEditable(false);
        campoprecioactual.setEditable(false);
        campocodigoproducto.setEditable(false);
        campodescuento.setEditable(false);
        campoprecioneto.setEditable(false);
        campovalortotal.setEditable(false);
        campoidcompra.setEditable(false);
        campovalortotalcompra.setEditable(false);
        NumerosCompras();
    }

    public static String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);

    }

    public void SumarColumnaTotalDeTabla() {

        int fila = 0;
        int Total = 0;
        for (int i = 0; i < TablaCompra.getRowCount(); i++) {
            fila = Integer.parseInt(TablaCompra.getValueAt(i, 7).toString());
            Total += fila;
        }
        campovalortotalcompra.setText(String.valueOf(Total));
    }

    public void NumerosCompras() {
        cn.CodigoIdCompras(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabProvedores = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmergenteProvedores = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        camponombre = new javax.swing.JTextField();
        SALIRDETABLAEMERGENTE = new javax.swing.JButton();
        TablaProductos = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaEmergenteProductos = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        campobuscarproducto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        SalirTablaEmergenteProductos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        camponombreproducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campostockactual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoprecioactual = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campocodigoproducto = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        campocantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campovalortotal = new javax.swing.JTextField();
        AnadirProducto = new javax.swing.JButton();
        QuitarProducto = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        campopreciocompra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        campopreciounitario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        campodescuento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        campoprecioneto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaCompra = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        campovalortotalcompra = new javax.swing.JTextField();
        campoidcompra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        campofechacompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        NUEVO = new javax.swing.JButton();
        GUARDARCOMPRA = new javax.swing.JButton();
        CANCELAR = new javax.swing.JButton();

        TabProvedores.setTitle("PROVEEDORES");

        TablaEmergenteProvedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TablaEmergenteProvedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "DIRECCION", "TELEFONO"
            }
        ));
        jScrollPane1.setViewportView(TablaEmergenteProvedores);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("OPCION DE CONSULTA"));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("NOMBRE:");

        camponombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        camponombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camponombreKeyTyped(evt);
            }
        });

        SALIRDETABLAEMERGENTE.setText("SALIR");
        SALIRDETABLAEMERGENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIRDETABLAEMERGENTEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(SALIRDETABLAEMERGENTE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SALIRDETABLAEMERGENTE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TabProvedoresLayout = new javax.swing.GroupLayout(TabProvedores.getContentPane());
        TabProvedores.getContentPane().setLayout(TabProvedoresLayout);
        TabProvedoresLayout.setHorizontalGroup(
            TabProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabProvedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        TabProvedoresLayout.setVerticalGroup(
            TabProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabProvedoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        TablaProductos.setTitle("TABLA PRODUCTOS");

        TablaEmergenteProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TablaEmergenteProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(TablaEmergenteProductos);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("OPCION DE CONSULTA"));

        campobuscarproducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campobuscarproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campobuscarproductoKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("CONSULTAR POR NOMBRE O CATEGORIA");

        SalirTablaEmergenteProductos.setText("SALIR");
        SalirTablaEmergenteProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirTablaEmergenteProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(campobuscarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(SalirTablaEmergenteProductos)
                        .addGap(109, 109, 109))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campobuscarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalirTablaEmergenteProductos))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TablaProductosLayout = new javax.swing.GroupLayout(TablaProductos.getContentPane());
        TablaProductos.getContentPane().setLayout(TablaProductosLayout);
        TablaProductosLayout.setHorizontalGroup(
            TablaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablaProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TablaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TablaProductosLayout.setVerticalGroup(
            TablaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TablaProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("COMPRAS");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setPreferredSize(new java.awt.Dimension(892, 645));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Producto"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("NOMBRE:");

        camponombreproducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        camponombreproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camponombreproductoActionPerformed(evt);
            }
        });
        camponombreproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camponombreproductoKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("STOCK ACTUAL:");

        campostockactual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("COSTO ACTUAL:");

        campoprecioactual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CODIGO PRODUCTO");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(camponombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(campoprecioactual, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campostockactual))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campocodigoproducto))))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(camponombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoprecioactual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campostockactual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campocodigoproducto, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("CANTIDAD:");

        campocantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campocantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campocantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campocantidadKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("VALOR TOTAL:");

        campovalortotal.setBackground(new java.awt.Color(102, 255, 102));
        campovalortotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        AnadirProducto.setText("Anadir");
        AnadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnadirProductoActionPerformed(evt);
            }
        });

        QuitarProducto.setText("Quitar");
        QuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarProductoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("PRECIO DE COMPRA:");

        campopreciocompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campopreciocompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campopreciocompraKeyTyped(evt);
            }
        });

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("PRECIO UNITARIO");

        campopreciounitario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campopreciounitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campopreciounitarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campopreciounitarioKeyTyped(evt);
            }
        });

        jLabel17.setText("DESCUENTO");

        campodescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campodescuentoActionPerformed(evt);
            }
        });

        jLabel1.setText("PRECIO NETO");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campocantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campovalortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(campopreciocompra)
                                .addGap(50, 50, 50))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(85, 85, 85)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(campopreciounitario, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(campodescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnadirProducto, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoprecioneto, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(QuitarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campodescuento)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(campoprecioneto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(campopreciounitario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campopreciocompra))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campocantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campovalortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnadirProducto)
                    .addComponent(QuitarProducto)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        TablaCompra.setForeground(new java.awt.Color(153, 255, 255));
        TablaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "PRODUCTO", "Title 3", "VALOR UNITARIO", "DESCUENTO", "PRECIO NETO", "VALOR ENTRADA", "VALOR TOTAL"
            }
        ));
        jScrollPane2.setViewportView(TablaCompra);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("TOTAL COMPRA:");

        campovalortotalcompra.setBackground(new java.awt.Color(0, 0, 0));
        campovalortotalcompra.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        campovalortotalcompra.setForeground(new java.awt.Color(102, 255, 102));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campovalortotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campovalortotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("N° DE COMPRA");

        campofechacompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campofechacompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campofechacompraActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("FECHA:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campofechacompra, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(campoidcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campofechacompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoidcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Mantenimiento"));

        NUEVO.setText("NUEVO");
        NUEVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUEVOActionPerformed(evt);
            }
        });

        GUARDARCOMPRA.setText("GUARDAR ");
        GUARDARCOMPRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUARDARCOMPRAActionPerformed(evt);
            }
        });

        CANCELAR.setText("CANCELAR");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CANCELAR)
                    .addComponent(GUARDARCOMPRA)
                    .addComponent(NUEVO))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NUEVO)
                .addGap(28, 28, 28)
                .addComponent(GUARDARCOMPRA)
                .addGap(96, 96, 96)
                .addComponent(CANCELAR)
                .addContainerGap(325, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void camponombreproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camponombreproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camponombreproductoActionPerformed

    private void campofechacompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campofechacompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campofechacompraActionPerformed

    private void GUARDARCOMPRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUARDARCOMPRAActionPerformed
        // TODO add your handling code here:
        cn.RegistrarCompra(this);
        dcd.RegistrarDetallesCompras(this);
    }//GEN-LAST:event_GUARDARCOMPRAActionPerformed

    private void camponombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_camponombreKeyTyped

    private void SALIRDETABLAEMERGENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIRDETABLAEMERGENTEActionPerformed

    }//GEN-LAST:event_SALIRDETABLAEMERGENTEActionPerformed

    private void campobuscarproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campobuscarproductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campobuscarproductoKeyReleased

    private void SalirTablaEmergenteProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirTablaEmergenteProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirTablaEmergenteProductosActionPerformed

    private void AnadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnadirProductoActionPerformed
        // TODO add your handling code here:
        Object Datos[] = new Object[8];

        Datos[0] = campocodigoproducto.getText();

        Datos[1] = camponombreproducto.getText();

        Datos[2] = campocantidad.getText();

        Datos[3] = campopreciounitario.getText();

        Datos[4] = campodescuento.getText();

        Datos[5] = campoprecioneto.getText();

        Datos[6] = campopreciocompra.getText();

        Datos[7] = campovalortotal.getText();

        Modelo.addRow(Datos);
        TablaCompra.setModel(Modelo);
        SumarColumnaTotalDeTabla();
        AnadirProducto.setVisible(false);
    }//GEN-LAST:event_AnadirProductoActionPerformed

    private void camponombreproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreproductoKeyReleased
        // TODO add your handling code here:
        cn.BuscarProductoPorNombre(this);
    }//GEN-LAST:event_camponombreproductoKeyReleased

    private void campocantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campocantidadKeyReleased
        // TODO add your handling code here:
        int Cantidad = Integer.parseInt(campocantidad.getText());
        int PrecioProducto = Integer.parseInt(campopreciounitario.getText());
        int Total = Cantidad * PrecioProducto;
        campovalortotal.setText(String.valueOf(Total));
    }//GEN-LAST:event_campocantidadKeyReleased

    private void QuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitarProductoActionPerformed
        // TODO add your handling code here:
        int fila = TablaCompra.getSelectedRow();
        if (fila >= 0) {
            Modelo.removeRow(fila);
            SumarColumnaTotalDeTabla();

        } else {
            JOptionPane.showMessageDialog(null, "No Selecciono ninguna fila Se leccione el Producto a quitar");
        }
    }//GEN-LAST:event_QuitarProductoActionPerformed

    private void campodescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campodescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campodescuentoActionPerformed

    private void campopreciounitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campopreciounitarioKeyReleased
        // TODO add your handling code here:
        int valorunitario = Integer.parseInt(campopreciounitario.getText());
        float descuento = (float) (valorunitario * (3.5 / 100));
        campodescuento.setText(String.valueOf(descuento));

        double precioneto = (valorunitario - descuento);
        campoprecioneto.setText(String.valueOf(precioneto));
    }//GEN-LAST:event_campopreciounitarioKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void campopreciocompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campopreciocompraKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_campopreciocompraKeyTyped

    private void campopreciounitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campopreciounitarioKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_campopreciounitarioKeyTyped

    private void campocantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campocantidadKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_campocantidadKeyTyped

    private void NUEVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUEVOActionPerformed
        // TODO add your handling code here:
        dispose();
        Compra c = new Compra();
        PanelEscritorio.add(c);
        c.setLocation(165, 0);
        c.show();
        c.GUARDARCOMPRA.setVisible(true);
    }//GEN-LAST:event_NUEVOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnadirProducto;
    private javax.swing.JButton CANCELAR;
    public javax.swing.JButton GUARDARCOMPRA;
    private javax.swing.JButton NUEVO;
    private javax.swing.JButton QuitarProducto;
    private javax.swing.JButton SALIRDETABLAEMERGENTE;
    private javax.swing.JButton SalirTablaEmergenteProductos;
    private javax.swing.JDialog TabProvedores;
    public javax.swing.JTable TablaCompra;
    private javax.swing.JTable TablaEmergenteProductos;
    private javax.swing.JTable TablaEmergenteProvedores;
    private javax.swing.JDialog TablaProductos;
    private javax.swing.JTextField campobuscarproducto;
    public javax.swing.JTextField campocantidad;
    public javax.swing.JTextField campocodigoproducto;
    public javax.swing.JTextField campodescuento;
    public javax.swing.JTextField campofechacompra;
    public javax.swing.JTextField campoidcompra;
    private javax.swing.JTextField camponombre;
    public javax.swing.JTextField camponombreproducto;
    public javax.swing.JTextField campoprecioactual;
    public javax.swing.JTextField campopreciocompra;
    public javax.swing.JTextField campoprecioneto;
    public javax.swing.JTextField campopreciounitario;
    public javax.swing.JTextField campostockactual;
    public javax.swing.JTextField campovalortotal;
    public javax.swing.JTextField campovalortotalcompra;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
