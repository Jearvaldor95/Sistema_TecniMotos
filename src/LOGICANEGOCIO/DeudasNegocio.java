package LOGICANEGOCIO;

import DATOS.ConexionSingleton;
import DATOS.DeudasDatos;
import PRESENTACION.Deudas;
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
public class DeudasNegocio {

    Connection cn = ConexionSingleton.getConnection();
    DeudasDatos dd = new DeudasDatos();
    private DefaultTableModel modelo;

    public DefaultTableModel MostrarTabla(String Valor) {
        String col[] = {"ID", "CLIENTE", "FECHA DEUDA", "VALOR DEUDA"};
        String[] data = new String[4];
        String sql = "SELECT * FROM deudas,clientes WHERE deudas.ID_CLIENTE=clientes.ID_CLIENTE &&  CONCAT (NOMBRES) LIKE '%" + Valor + "%'";
        modelo = new DefaultTableModel(null, col);

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("ID_DEUDA");
                data[1] = r.getString("NOMBRES");
                data[2] = r.getString("FECHA_DEUDA");
                data[3] = r.getString("VALOR_DEUDA");
                modelo.addRow(data);
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;

    }

    public boolean AgregarDeuda(Deudas d) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        dd.IdCliente = Integer.parseInt(d.campoicliente.getText());
        String consultarp = "SELECT * FROM creditos,clientes WHERE creditos.ID_CLIENTE='" + dd.IdCliente + "'";
        try {
            pst = cn.prepareStatement(consultarp);
            rs = pst.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "PORFAVOR GENERAR CREDITO AL CLIENTE");
            } else {

                dd.IdCliente = Integer.parseInt(d.campoicliente.getText());
                dd.FechaDeuda = d.campofechadeuda.getText();
                dd.ValorDeuda = Double.parseDouble(d.campototalrestante.getText());
                String sql;

                sql = "INSERT INTO DEUDAS(ID_CLIENTE,FECHA_DEUDA,VALOR_DEUDA) VALUES (?,?,?)";

                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setInt(1, dd.getIdCliente());
                psd.setString(2, dd.getFechaDeuda());
                psd.setDouble(3, dd.getValorDeuda());
                psd.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deuda Registrada");
                d.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Deudas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se Pudo Registar");
        }
        return true;

    }

}
