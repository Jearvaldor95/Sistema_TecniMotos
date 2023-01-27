package PRESENTACION;

import LOGICANEGOCIO.DetallesVentasNegocio;
import LOGICANEGOCIO.VentasNegocio;
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
public class Ventas extends javax.swing.JInternalFrame {

    VentasNegocio vn = new VentasNegocio();
    DetallesVentasNegocio dvn = new DetallesVentasNegocio();
    private DefaultTableModel modelo;
    DefaultTableModel Modelo = new DefaultTableModel();

    public Ventas() {
        initComponents();

        String[] data = {"CODIGO", "NOMBRE PRODUCTO", "CANTIDAD", "PRECIO UNITARIO", "TOTAL"};
        Modelo = new DefaultTableModel(null, data);
        this.TablaVenta.setModel(Modelo);
        TablaVenta.getColumnModel().getColumn(0).setPreferredWidth(50);
        TablaVenta.getColumnModel().getColumn(1).setPreferredWidth(200);
        TablaVenta.getColumnModel().getColumn(2).setPreferredWidth(15);
        TablaVenta.getColumnModel().getColumn(3).setPreferredWidth(50);
        TablaVenta.getColumnModel().getColumn(4).setPreferredWidth(50);
        camponombrecliente.setText("PUBLICO GENERAL");
        campofechaventa.setEnabled(false);
        campofechaventa.setDisabledTextColor(Color.blue);
        campofechaventa.setText(fechaactual());

        campostock.setEditable(false);
        campoprecioventa.setEditable(false);
        campototal.setEditable(false);
        campocodigoproducto.setEditable(false);
        campocambio.setEditable(false);
        campototalventa.setEditable(false);
        campototalventa.setText("0.0");
        campocambio.setText("0.0");
        campoidcliente.setVisible(false);
        campoimportepago.setText("0.0");
        campoidcliente.setText("1");
        NumerosVentas();
        campoidventa.setEditable(false);

    }

    public static String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);

    }

    public void NumerosVentas() {

        vn.GenerarCodigoVenta(this);
    }
    //para sumar la columna total  de cada producto y me muestre el total a pagar

    public void SumarColumnaTotalDeTabla() {

        int fila = 0;
        int Total = 0;
        for (int i = 0; i < TablaVenta.getRowCount(); i++) {
            fila = Integer.parseInt(TablaVenta.getValueAt(i, 4).toString());
            Total += fila;
        }
        campototalventa.setText(String.valueOf(Total));
    }

    //metodo para bloquer cajas y botones
    public void Bloquer() {
        camponombrecliente.setEditable(false);
        camponombreproducto.setEditable(false);
        campocantidadvendida.setEditable(false);
        campoimportepago.setEditable(false);
        QuitarProducto.setEnabled(false);
        NuevoProducto.setEnabled(false);

    }

    // metodo para desbloquer las cajas y botones
    public void Desbloquer() {
        camponombrecliente.setEditable(true);
        camponombreproducto.setEditable(true);
        campocantidadvendida.setEditable(true);
        campoimportepago.setEditable(true);
        AñadirProducto.setVisible(true);
        QuitarProducto.setEnabled(true);
        NuevoProducto.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        camponombrecliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcombotipoventa = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        campofechaventa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        NUEVO = new javax.swing.JButton();
        GENERARVENTA = new javax.swing.JButton();
        CANCELAR = new javax.swing.JButton();
        SALIR = new javax.swing.JButton();
        campoidcliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        campocodigoproducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        camponombreproducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campostock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoprecioventa = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        campocantidadvendida = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campototal = new javax.swing.JTextField();
        AñadirProducto = new javax.swing.JButton();
        QuitarProducto = new javax.swing.JButton();
        NuevoProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVenta = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        campoimportepago = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        campocambio = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        campototalventa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        campoidventa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("VENTAS");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Venta"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("CLIENTE:");

        camponombrecliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        camponombrecliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camponombreclienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camponombreclienteKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("TIPO DE VENTA:");

        jcombotipoventa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "Efectivo", "Abono", "Credito" }));
        jcombotipoventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombotipoventaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("FECHA:");

        campofechaventa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(camponombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcombotipoventa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campofechaventa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campofechaventa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcombotipoventa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1))
                        .addComponent(camponombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Mantenimiento"));

        NUEVO.setText("NUEVO");
        NUEVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUEVOActionPerformed(evt);
            }
        });

        GENERARVENTA.setText("GENERAR");
        GENERARVENTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GENERARVENTAActionPerformed(evt);
            }
        });

        CANCELAR.setText("CANCELAR");
        CANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELARActionPerformed(evt);
            }
        });

        SALIR.setText("SALIR");

        campoidcliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NUEVO)
                    .addComponent(GENERARVENTA)
                    .addComponent(CANCELAR)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(campoidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SALIR))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NUEVO)
                .addGap(42, 42, 42)
                .addComponent(GENERARVENTA)
                .addGap(44, 44, 44)
                .addComponent(CANCELAR)
                .addGap(47, 47, 47)
                .addComponent(SALIR)
                .addGap(163, 163, 163)
                .addComponent(campoidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Producto"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("CODIGO:");

        campocodigoproducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("NOMBRE:");

        camponombreproducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        camponombreproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camponombreproductoKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("STOCK:");

        campostock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("PRECIO:");

        campoprecioventa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campocodigoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campostock, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoprecioventa, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(camponombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(campocodigoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(campostock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(campoprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(camponombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("CANTIDAD:");

        campocantidadvendida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campocantidadvendida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campocantidadvendidaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campocantidadvendidaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("TOTAL:");

        campototal.setBackground(new java.awt.Color(102, 255, 102));
        campototal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        AñadirProducto.setText("Añadir");
        AñadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirProductoActionPerformed(evt);
            }
        });

        QuitarProducto.setText("Quitar");
        QuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarProductoActionPerformed(evt);
            }
        });

        NuevoProducto.setText("Nuevo");
        NuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campocantidadvendida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campototal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(AñadirProducto)
                .addGap(18, 18, 18)
                .addComponent(QuitarProducto)
                .addGap(43, 43, 43)
                .addComponent(NuevoProducto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campocantidadvendida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(campototal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AñadirProducto)
                    .addComponent(QuitarProducto)
                    .addComponent(NuevoProducto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE DEL  PRODUCTO", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(TablaVenta);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("IMPORTE:");

        campoimportepago.setBackground(new java.awt.Color(0, 0, 0));
        campoimportepago.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        campoimportepago.setForeground(new java.awt.Color(153, 255, 153));
        campoimportepago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoimportepagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoimportepagoKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("CAMBIO:");

        campocambio.setBackground(new java.awt.Color(0, 0, 0));
        campocambio.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        campocambio.setForeground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoimportepago, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campocambio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoimportepago)
                            .addComponent(campocambio))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        campototalventa.setBackground(new java.awt.Color(0, 0, 0));
        campototalventa.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        campototalventa.setForeground(new java.awt.Color(153, 255, 153));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("TOTAL PAGAR:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campototalventa, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(campototalventa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(30, 30, 30))
        );

        campoidventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoidventaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("N° DE VENTAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoidventa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel13))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoidventa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoidventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoidventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoidventaActionPerformed

    private void GENERARVENTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GENERARVENTAActionPerformed
        // TODO add your handling code here:      
        vn.GeneralVenta(this);
        dvn.InsertarDetallesVenta(this);
        GENERARVENTA.setVisible(false);
        
    }//GEN-LAST:event_GENERARVENTAActionPerformed

    private void AñadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirProductoActionPerformed
        // TODO add your handling code here:
        Object Datos[] = new Object[5];

        Datos[0] = campocodigoproducto.getText();

        Datos[1] = camponombreproducto.getText();

        Datos[2] = campocantidadvendida.getText();

        Datos[3] = campoprecioventa.getText();

        Datos[4] = campototal.getText();

        Modelo.addRow(Datos);
        TablaVenta.setModel(Modelo);
        SumarColumnaTotalDeTabla();
        AñadirProducto.setVisible(false);
    }//GEN-LAST:event_AñadirProductoActionPerformed

    private void QuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitarProductoActionPerformed
        // TODO add your handling code here:
        int fila = TablaVenta.getSelectedRow();
        if (fila >= 0) {
            Modelo.removeRow(fila);
            SumarColumnaTotalDeTabla();

        } else {
            JOptionPane.showMessageDialog(null, "No Selecciono ninguna fila Se leccione el Producto a quitar");
        }
    }//GEN-LAST:event_QuitarProductoActionPerformed

    private void campocantidadvendidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campocantidadvendidaKeyReleased
        // TODO add your handling code here:
        int Cantidad = Integer.parseInt(campocantidadvendida.getText());
        int PrecioProducto = Integer.parseInt(campoprecioventa.getText());
        int Total = Cantidad * PrecioProducto;
        campototal.setText(String.valueOf(Total));
    }//GEN-LAST:event_campocantidadvendidaKeyReleased

    private void NUEVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUEVOActionPerformed
        // TODO add your handling code here:
        dispose();
        Ventas v = new Ventas();
        PanelEscritorio.add(v);
        v.setLocation(165, 0);
        v.show();
    }//GEN-LAST:event_NUEVOActionPerformed

    private void CANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELARActionPerformed
        // TODO add your handling code here:
        camponombrecliente.setText("");
        campocodigoproducto.setText("");
        camponombreproducto.setText("");
        campostock.setText("");
        campoprecioventa.setText("");
        campocantidadvendida.setText("");
        campototal.setText("");
        campoimportepago.setText("");
        campocambio.setText("");
        campototalventa.setText("");
        campoidcliente.setText("");
        jcombotipoventa.setSelectedIndex(0);
    }//GEN-LAST:event_CANCELARActionPerformed

    private void NuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoProductoActionPerformed
        // TODO add your handling code here:
        campocodigoproducto.setText("");
        camponombreproducto.setText("");
        campostock.setText("");
        campoprecioventa.setText("");
        campocantidadvendida.setText("");
        campototal.setText("");
        AñadirProducto.setVisible(true);
    }//GEN-LAST:event_NuevoProductoActionPerformed

    private void camponombreproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreproductoKeyReleased
        // TODO add your handling code here:
        vn.BuscarProductoPorNombre(this);
    }//GEN-LAST:event_camponombreproductoKeyReleased

    private void campoimportepagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoimportepagoKeyReleased
        // TODO add your handling code here:
        double Importedepago = Double.parseDouble(campoimportepago.getText());
        double TotalPagar = Double.parseDouble(campototalventa.getText());
        double Cambio = Importedepago - TotalPagar;
        campocambio.setText(String.valueOf(Cambio));
    }//GEN-LAST:event_campoimportepagoKeyReleased

    private void jcombotipoventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombotipoventaActionPerformed

    }//GEN-LAST:event_jcombotipoventaActionPerformed

    private void camponombreclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreclienteKeyReleased
        vn.BuscarClientePorNombre(this);
    }//GEN-LAST:event_camponombreclienteKeyReleased

    private void campocantidadvendidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campocantidadvendidaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_campocantidadvendidaKeyTyped

    private void campoimportepagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoimportepagoKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_campoimportepagoKeyTyped

    private void camponombreclienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreclienteKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_camponombreclienteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AñadirProducto;
    private javax.swing.JButton CANCELAR;
    public javax.swing.JButton GENERARVENTA;
    private javax.swing.JButton NUEVO;
    private javax.swing.JButton NuevoProducto;
    private javax.swing.JButton QuitarProducto;
    private javax.swing.JButton SALIR;
    public javax.swing.JTable TablaVenta;
    public javax.swing.JTextField campocambio;
    public javax.swing.JTextField campocantidadvendida;
    public javax.swing.JTextField campocodigoproducto;
    public javax.swing.JTextField campofechaventa;
    public javax.swing.JTextField campoidcliente;
    public javax.swing.JTextField campoidventa;
    public javax.swing.JTextField campoimportepago;
    public javax.swing.JTextField camponombrecliente;
    public javax.swing.JTextField camponombreproducto;
    public javax.swing.JTextField campoprecioventa;
    public javax.swing.JTextField campostock;
    public javax.swing.JTextField campototal;
    public javax.swing.JTextField campototalventa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JComboBox<String> jcombotipoventa;
    // End of variables declaration//GEN-END:variables
}
