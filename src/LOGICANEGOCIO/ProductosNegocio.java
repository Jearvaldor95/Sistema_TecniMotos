package LOGICANEGOCIO;

import DATOS.ConexionSingleton;
import DATOS.GenerarNumero;
import DATOS.ProductosDatos;
import static PRESENTACION.MenuPrincipal.PanelEscritorio;
import PRESENTACION.Productos;
import PRESENTACION.TablaProductos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ProductosNegocio {

    private DefaultTableModel modelo;
    Connection cn = ConexionSingleton.getConnection();

    ProductosDatos pd = new ProductosDatos();

    public DefaultTableModel MostrarTabla(String valor) {

        String col[] = {"CODIGO PRODUCTO", "NOMBRE PRODUCTO", "PRECIO VENTA", "CANTIDAD"};
        String[] data = new String[7];
        String sql = "SELECT * FROM productos WHERE  CONCAT (  DESCRIPCION_P,'' ,PRECIO_VENTA)  LIKE '%" + valor + "%'";

        modelo = new DefaultTableModel(null, col);
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("CODIGO");
                data[1] = r.getString("DESCRIPCION_P");
                data[2] = r.getString("PRECIO_VENTA");
                data[3] = r.getString("CANTIDAD");

                modelo.addRow(data);

            }
            /*TablaProductos tb = new TablaProductos();
            tb.TablaProducto.setModel(modelo);
            tb.TablaProducto.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb.TablaProducto.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb.TablaProducto.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb.TablaProducto.getColumnModel().getColumn(3).setPreferredWidth(100);*/

            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

    public DefaultTableModel FiltrarPorNombres(String valor) {

        String col[] = {"CODIGO PRODUCTO", "NOMBRE PRODUCTO", "PRECIO VENTA", "CANTIDAD"};
        String[] data = new String[7];
        String sql = "SELECT * FROM productos WHERE   DESCRIPCION_P  LIKE '%" + valor + "%'";

        modelo = new DefaultTableModel(null, col);
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("CODIGO");
                data[1] = r.getString("DESCRIPCION_P");
                data[2] = r.getString("PRECIO_VENTA");
                data[3] = r.getString("CANTIDAD");

                modelo.addRow(data);

            }
            return modelo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

    public boolean AgregarProducto(Productos p) {
        pd.Codigo = p.campocodigoproducto.getText();
        pd.Nombre = p.camponombreproducto.getText();
        pd.PrecioVenta = Double.parseDouble(p.campoprecioventa.getText());
        pd.Cantidad = Integer.parseInt(p.campocantidad.getText());

        String sql;
        sql = "INSERT INTO productos(CODIGO,DESCRIPCION_P,PRECIO_VENTA,CANTIDAD) VALUES (?,?,?,?)";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, pd.getCodigo());
            psd.setString(2, pd.getNombre());
            psd.setDouble(3, pd.getPrecioVenta());
            psd.setInt(4, pd.getCantidad());
            psd.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Guardado Con Exito");
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Pudo Guardar");
        }

        return true;

    }

    public boolean ModificarProducto(Productos p) {

        pd.Codigo = p.campocodigoproducto.getText();
        pd.Nombre = p.camponombreproducto.getText();
        pd.PrecioVenta = Double.parseDouble(p.campoprecioventa.getText());
        pd.Cantidad = Integer.parseInt(p.campocantidad.getText());

        String sql;
        sql = "UPDATE productos SET CODIGO=?,DESCRIPCION_P=?,PRECIO_VENTA=?,CANTIDAD=? WHERE CODIGO=?";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, pd.Codigo);
            psd.setString(2, pd.getNombre());
            psd.setDouble(3, pd.getPrecioVenta());
            psd.setInt(4, pd.getCantidad());
            psd.setString(5, pd.Codigo);
            psd.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Modificado Con Exito");
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Pudo Modificar");
        }

        return true;

    }

    public boolean EliminarProducto(TablaProductos tb) {

        String sql;

        pd.Codigo = tb.campocodigoproducto.getText();

        sql = "DELETE FROM productos WHERE CODIGO=?";

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, pd.getCodigo());

            psd.executeUpdate();
            tb.dispose();
            TablaProductos p = new TablaProductos();
            PanelEscritorio.add(p);
            p.setLocation(165, 0);
            p.show();
            JOptionPane.showMessageDialog(null, "Producto Eliminado Con Exito");

        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Puede Eliminar Intente Nuevamente");
        }

        return true;

    }

    public boolean CodigoProductos(Productos p) {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(CODIGO) FROM productos";

        try {
            PreparedStatement psd = cn.prepareStatement(SQL);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                p.campocodigoproducto.setText("T0001");
            } else {
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);
                char r3 = c.charAt(4);
                String r = "";
                r = "" + r1 + r2 + r3;
                j = Integer.parseInt(r);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                p.campocodigoproducto.setText("T" + gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

}
