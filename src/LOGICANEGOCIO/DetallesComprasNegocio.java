
package LOGICANEGOCIO;

import DATOS.ConexionSingleton;
import DATOS.DetallesComprasDatos;
import PRESENTACION.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class DetallesComprasNegocio {
    
    Connection cn = ConexionSingleton.getConnection();
    public boolean RegistrarDetallesCompras(Compra c){
        DetallesComprasDatos dcd = new DetallesComprasDatos();
        for (int i = 0; i < c.TablaCompra.getRowCount(); i++) {

            dcd.IdCompra = Integer.parseInt(c.campoidcompra.getText());
            dcd.Codigo = c.TablaCompra.getValueAt(i, 0).toString();
            dcd.Cantidad = Integer.parseInt(c.TablaCompra.getValueAt(i, 2).toString());
            dcd.ValorUnitario = Double.parseDouble(c.TablaCompra.getValueAt(i, 3).toString());
            dcd.Descuento = Float.parseFloat(c.TablaCompra.getValueAt(i, 4).toString());
            dcd.PrecioNeto = Float.parseFloat(c.TablaCompra.getValueAt(i, 5).toString());
            dcd.ValorEntrada = Double.parseDouble(c.TablaCompra.getValueAt(i, 6).toString());
            dcd.Valor_Total = Double.parseDouble(c.TablaCompra.getValueAt(i, 7).toString());
            String sql;
            sql = "INSERT INTO detalles_compras(ID_COMPRA,CODIGO,CANTIDAD,VALOR_UNITARIO,DESCUENTO,PRECIO_NETO,VALOR_ENTRADA,VALOR_TOTAL)VALUES(?,?,?,?,?,?,?,?)";
            
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setInt(1, dcd.getIdCompra());
                psd.setString(2, dcd.getCodigo());
                psd.setInt(3, dcd.getCantidad());
                psd.setDouble(4, dcd.getValorUnitario());
                psd.setFloat(5, dcd.getDescuento());
                psd.setFloat(6, dcd.getPrecioNeto());
                psd.setDouble(7, dcd.getValorEntrada());
                psd.setDouble(8, dcd.getValor_Total());
                psd.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return true;
        
    }
    
}
