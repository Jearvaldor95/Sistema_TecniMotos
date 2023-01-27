package LOGICANEGOCIO;

import DATOS.ConexionSingleton;
import DATOS.GenerarNumero;
import DATOS.VentasDatos;
import PRESENTACION.Deudas;
import PRESENTACION.MenuPrincipal;
import PRESENTACION.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class VentasNegocio {

    private DefaultTableModel modelo;
    VentasDatos vd = new VentasDatos();
    Connection cn = ConexionSingleton.getConnection();

    public DefaultTableModel MostrarTabla(String Valor) {
        String col[] = {"ID VENTAS", " CLIENTE", "FECHA DE VENTA", "VALOR DE VENTA", "TIPO DE VENTA"};
        String[] data = new String[5];
        String sql = "SELECT * FROM ventas,clientes WHERE ventas.ID_CLIENTE=clientes.ID_CLIENTE";
        modelo = new DefaultTableModel(null, col);

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("ID_VENTA");
                data[1] = r.getString("NOMBRES");
                data[2] = r.getString("FECHA_VENTA");
                data[3] = r.getString("VALOR_VENTA");
                data[4] = r.getString("TIPO_VENTA");
                modelo.addRow(data);
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;

    }

    /*creamos 4 atributos publicos estaticos de tipo String,double, para enviar 
    la informacion que en ellos se guarden a la otra ventana deudas */
    public  static String nombrecliente;

    public  static double importedepago = 0;
    public  static double totalpagar = 0;
    public  static double totalrestante = 0;
    public  static int idcliente = 0;

    public boolean GeneralVenta(Ventas v) {
        vd.IdVenta = v.campoidventa.getText();
        vd.IdCliente = Integer.parseInt(v.campoidcliente.getText());
        vd.FechaVenta = v.campofechaventa.getText();
        vd.ValorVenta = Double.parseDouble(v.campototalventa.getText());
        vd.TipoVenta = (String) v.jcombotipoventa.getSelectedItem();     
        
        String sql;
        sql = "INSERT INTO ventas(ID_VENTA,ID_CLIENTE,FECHA_VENTA,VALOR_VENTA,TIPO_VENTA) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, vd.getIdVenta());
            psd.setInt(2, vd.getIdCliente());
            psd.setString(3, vd.getFechaVenta());
            psd.setDouble(4, vd.getValorVenta());
            psd.setString(5, vd.getTipoVenta());
            psd.executeUpdate();
            JOptionPane.showMessageDialog(null, "VENTA EXITOSA");
            v.GENERARVENTA.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Realizo La Venta");
        }
        String formapago = String.valueOf(v.jcombotipoventa.getSelectedItem()).intern();
        if (formapago == "Abono" || formapago == "Credito") {
            nombrecliente = v.camponombrecliente.getText();
            importedepago = Double.parseDouble(v.campoimportepago.getText());
            totalpagar = Double.parseDouble(v.campototalventa.getText());
            totalrestante = totalpagar - importedepago;
            idcliente = Integer.parseInt(v.campoidcliente.getText());
            Deudas t = new Deudas();

            MenuPrincipal.PanelEscritorio.add(t);
            t.toFront();
            t.setLocation(165, 0);
            t.setVisible(true);
        }

        return true;

    }

    
    public boolean BuscarProductoPorNombre(Ventas v){
        String sql;
        sql = "SELECT * FROM productos WHERE DESCRIPCION_P=?";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, v.camponombreproducto.getText());
            ResultSet r = psd.executeQuery();
            if (r.next()) {
                v.campocodigoproducto.setText(r.getString("CODIGO"));
                v.campostock.setText(r.getString("CANTIDAD"));
                v.campoprecioventa.setText(r.getString("PRECIO_VENTA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return true;
        
    }
    
    public boolean BuscarClientePorNombre(Ventas v){
        String sql;
        sql = "SELECT * FROM clientes WHERE NOMBRES=?";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, v.camponombrecliente.getText());
            ResultSet r = psd.executeQuery();
            if (r.next()) {
                v.campoidcliente.setText(r.getString("ID_CLIENTE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);

        }
        return true;
        
    }
    
    public boolean GenerarCodigoVenta(Ventas v){
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(ID_VENTA) FROM ventas";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                v.campoidventa.setText("N°0001");
            } else {
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);
                char r3 = c.charAt(4);
                char r4 = c.charAt(5);
                String r = "";
                r = "" + r1 + r2 + r3 + r4;
                j = Integer.parseInt(r);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                v.campoidventa.setText("N°" + gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
        
    }
}
