package LOGICANEGOCIO;

import DATOS.ConexionSingleton;
import DATOS.DetallesVentasDatos;
import PRESENTACION.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class DetallesVentasNegocio {
    
    Connection cn = ConexionSingleton.getConnection();
    public boolean InsertarDetallesVenta(Ventas v) {
        DetallesVentasDatos dvd = new DetallesVentasDatos();
        for (int i = 0; i < v.TablaVenta.getRowCount(); i++) {

            String sql;

            sql = "INSERT INTO detalles_ventas(ID_VENTA,CODIGO,CANTIDAD,PRECIO_UNITARIO,TOTAL)VALUES(?,?,?,?,?)";
            dvd.IdVenta = v.campoidventa.getText();
            dvd.Codigo = v.TablaVenta.getValueAt(i, 0).toString();
            dvd.Cantidad = Integer.parseInt(v.TablaVenta.getValueAt(i, 2).toString());
            dvd.PrecioUnitario = Double.parseDouble(v.TablaVenta.getValueAt(i, 3).toString());
            dvd.Total = Double.parseDouble(v.TablaVenta.getValueAt(i, 4).toString());
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1, dvd.getIdVenta());
                psd.setString(2, dvd.getCodigo());
                psd.setInt(3, dvd.getCantidad());
                psd.setDouble(4, dvd.getPrecioUnitario());
                psd.setDouble(5, dvd.getTotal());
                psd.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return true;
    }
    
}
