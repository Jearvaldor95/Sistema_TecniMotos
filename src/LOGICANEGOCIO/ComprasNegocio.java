package LOGICANEGOCIO;

import DATOS.ComprasDatos;
import DATOS.ConexionSingleton;
import DATOS.GenerarCodigos;
import PRESENTACION.Compra;
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
public class ComprasNegocio {
    private DefaultTableModel modelo;
    ComprasDatos cd = new ComprasDatos();
    Connection cn = ConexionSingleton.getConnection();
    
    public DefaultTableModel MostrarTabla(String Valor) {
        String col[] = {"ID COMPRAS", "FECHA DE COMPRA", "VALOR DE COMPRA"};
        String[] data = new String[4];
        String sql = "SELECT * FROM compras";
        modelo = new DefaultTableModel(null, col);

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("ID_COMPRA");
                data[1] = r.getString("FECHA_COMPRA");
                data[2] = r.getString("VALOR_COMPRA");
                modelo.addRow(data);
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;

    }
    
    public boolean RegistrarCompra(Compra c){
        cd.IdCompras = Integer.parseInt(c.campoidcompra.getText());
        cd.FechaCompra = c.campofechacompra.getText();
        cd.ValorCompra = Double.parseDouble(c.campovalortotalcompra.getText());
        
        String sql;
        sql = "INSERT INTO COMPRAS(ID_COMPRA,FECHA_COMPRA,VALOR_COMPRA) VALUES(?,?,?)";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setInt(1, cd.getIdCompras());
            psd.setString(2, cd.getFechaCompra());
            psd.setDouble(3, cd.getValorCompra());
            psd.executeUpdate();
            JOptionPane.showMessageDialog(null, "COMPRA REGISTRADA");
            c.GUARDARCOMPRA.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Realizo La Compra");
        }
        
        return true;
        
    }
    
    
    public boolean BuscarProductoPorNombre(Compra c){
        String sql;
        sql = "SELECT * FROM productos WHERE DESCRIPCION_P=?";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, c.camponombreproducto.getText());
            ResultSet r = psd.executeQuery();
            if (r.next()) {
                c.campocodigoproducto.setText(r.getString("CODIGO"));
                c.campostockactual.setText(r.getString("CANTIDAD"));
                c.campoprecioactual.setText(r.getString("PRECIO_VENTA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return true;
        
    }
    public boolean CodigoIdCompras(Compra cp){
        int j;
        int cont = 1;
        int num = 0;
        int c = 0;
        String sql = "SELECT MAX(ID_COMPRA) FROM compras";
        
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            if (rs.next()) {
                c = rs.getInt(1);
            }

            if (c == 0) {
                cp.campoidcompra.setText(String.valueOf(1));
            } else {

                j = Integer.parseInt(String.valueOf(c));
                GenerarCodigos gen = new GenerarCodigos();
                gen.generar(j);
                cp.campoidcompra.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        
    }
    
}
