package LOGICANEGOCIO;

import DATOS.ConexionSingleton;
import DATOS.CreditosDatos;
import DATOS.GenerarCodigos;
import PRESENTACION.Creditos;
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
public class CreditosNegocio {

    private DefaultTableModel modelo;
    Connection cn = ConexionSingleton.getConnection();

    CreditosDatos cd = new CreditosDatos();

    public DefaultTableModel MostrarTablaCreditos(String valor) {
        String col[] = {"ID CUENTA", "NOMBRE CLIENTE      ", "VALOR DEUDA"};
        String[] data = new String[4];
        String sql = "SELECT * FROM creditos,clientes WHERE creditos.ID_CLIENTE=clientes.ID_CLIENTE &&  CONCAT (NOMBRES) LIKE '%" + valor + "%'";
        modelo = new DefaultTableModel(null, col);

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("ID_CREDITO");
                data[1] = r.getString("NOMBRES");
                data[2] = r.getString("TOTAL_CUENTA");

                modelo.addRow(data);

            }
            return modelo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;

    }

    public boolean GenerarCreditos(Creditos c) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        cd.IdCliente = Integer.parseInt(c.campoidcliente.getText());
        String consultarp = "SELECT * FROM creditos,clientes WHERE creditos.ID_CLIENTE='" + cd.IdCliente + "'";
        try {
            pst = cn.prepareStatement(consultarp);
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "EL CLIENTE YA TIENE CREDITOS");
            } else {

                cd.IdCredito = Integer.parseInt(c.campoid.getText());
                cd.IdCliente = Integer.parseInt(c.campoidcliente.getText());
                String sql;
                sql = "INSERT INTO creditos (ID_CREDITO,ID_CLIENTE,TOTAL_CUENTA) VALUES (?,?,?)";

                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setInt(1, cd.getIdCredito());
                psd.setInt(2, cd.getIdCliente());
                psd.setDouble(3, cd.getTotalCuenta());
                psd.executeUpdate();
                JOptionPane.showMessageDialog(null, "CREDITO CONCEDIDO");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Creditos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;

    }

    public boolean BuscarClientePorDocumento(Creditos c) {
        String sql;
        //sql = "SELECT * FROM cuentasporcobrar,clientes WHERE cuentasporcobrar.ID_CLIENTE=clientes.ID_CLIENTE &&  CONCAT (NOMBRES=?)";
        sql = "SELECT * FROM clientes WHERE clientes.ID_CLIENTE &&  CONCAT (NUM_CEDULA=?)";

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, c.camponumerodocumento.getText());
            ResultSet r = psd.executeQuery();
            if (r.next()) {
                //campo3.setText(r.getString("ID_CUENTA_C"));

                c.campoidcliente.setText(r.getString("ID_CLIENTE"));
                c.camponombrecliente.setText(r.getString("NOMBRES"));
                //JOptionPane.showMessageDialog(null, "EL cliente al que quiere generar creditos es: " + r.getString("NOMBRES"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Creditos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;

    }
    
    public boolean CodigoIdCreditos(Creditos cr){
        int j;
        int cont = 1;
        int num = 0;
        int c = 0;
        String sql = "SELECT MAX(ID_CREDITO) FROM creditos";
        
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            if (rs.next()) {
                c = rs.getInt(1);
            }

            if (c == 0) {
                cr.campoid.setText(String.valueOf(1));
            } else {

                j = Integer.parseInt(String.valueOf(c));
                GenerarCodigos gen = new GenerarCodigos();
                gen.generar(j);
                cr.campoid.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(Creditos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        
    }

}
