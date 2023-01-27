package LOGICANEGOCIO;

import DATOS.ConexionSingleton;
import DATOS.PagosDatos;
import PRESENTACION.Pagos;
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
public class PagosNegocio {

    Connection cn = ConexionSingleton.getConnection();
    private DefaultTableModel modelo;

    public DefaultTableModel MostrarTabla(String valor) {

        String col[] = {"ID PAGOS", "NOMBRES CLIENTE     ", "FECHA PAGO      ", "VALOR PAGO"};
        String[] data = new String[4];
        String sql = "SELECT * FROM pagos,clientes WHERE  pagos.ID_CLIENTE=clientes.ID_CLIENTE";
        modelo = new DefaultTableModel(null, col);

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("ID_PAGOS");
                data[1] = r.getString("NOMBRES");
                data[2] = r.getString("FECHA_PAGO");
                data[3] = r.getString("VALOR_PAGO");

                modelo.addRow(data);
            }

            return modelo;
        } catch (SQLException e) {
            return null;
        }

    }

    public DefaultTableModel FiltrarPorNombre(String valor) {

        String col[] = {"ID PAGOS", "NOMBRES CLIENTE     ", "FECHA PAGO      ", "VALOR PAGO"};
        String[] data = new String[4];
        String sql = "SELECT * FROM pagos,clientes WHERE  pagos.ID_CLIENTE=clientes.ID_CLIENTE &&  CONCAT (NOMBRES) LIKE '%" + valor + "%'";
        modelo = new DefaultTableModel(null, col);

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("ID_PAGOS");
                data[1] = r.getString("NOMBRES");
                data[2] = r.getString("FECHA_PAGO");
                data[3] = r.getString("VALOR_PAGO");

                modelo.addRow(data);
            }

            return modelo;
        } catch (SQLException e) {

            //JOptionPane.showMessageDialog(null, "Cliente Modificado Con Exito");
            return null;
        }

    }

    public boolean RegistrarPagos(Pagos p) {
        PagosDatos pd = new PagosDatos();
        pd.IdCliente = Integer.parseInt(p.campoidcliente.getText());
        pd.FechaPago = p.campofechapago.getText();
        pd.ValorPago = Double.parseDouble(p.camponuevopago.getText());
        double TotalRestante = Double.parseDouble(p.campototalrestante.getText());
        if (TotalRestante == 0) {
            String sql;
            sql = "INSERT INTO PAGOS (ID_CLIENTE,FECHA_PAGO,VALOR_PAGO) VALUES (?,?,?)";

            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setInt(1, pd.getIdCliente());
                psd.setString(2, pd.getFechaPago());
                psd.setDouble(3, pd.getValorPago());
                psd.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cuenta Cancelada");
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "No se Pudo Hacer El Pago");
            }
        } else {
            String sql;

            sql = "INSERT INTO PAGOS (ID_CLIENTE,FECHA_PAGO,VALOR_PAGO) VALUES (?,?,?)";
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setInt(1, pd.getIdCliente());
                psd.setString(2, pd.getFechaPago());
                psd.setDouble(3, pd.getValorPago());
                psd.executeUpdate();
                JOptionPane.showMessageDialog(null, "Abono Realizado");
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "No se Pudo Hacer El Pago");
            }

        }

        return true;

    }

    public boolean CalculoPagos(Pagos p) {
        int NuevoPago, ValorCuenta, TotalRestante;
        NuevoPago = (int) Double.parseDouble(p.camponuevopago.getText());
        //ValorAbonado = Double.parseDouble(campo4.getText());
        ValorCuenta = (int) Double.parseDouble(p.campototaldeuda.getText());
        //ValorAbonado = ValorAbonado + NuevoPago;

        TotalRestante = ValorCuenta - NuevoPago;
        //ValorCuenta = ValorCuenta - NuevoPago;
        //campo4.setText(String.valueOf(ValorAbonado));
        p.campototalrestante.setText(String.valueOf(TotalRestante));

        return true;

    }

    public boolean BuscarClientePorNombre(Pagos p) {
        String sql;

        sql = "SELECT * FROM creditos,clientes WHERE creditos.ID_CLIENTE=clientes.ID_CLIENTE &&  CONCAT (NOMBRES=?)";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, p.camponombrecliente.getText());
            ResultSet r = psd.executeQuery();
            if (r.next()) {
                p.campoidcliente.setText(r.getString("ID_CLIENTE"));
                p.campototaldeuda.setText(r.getString("TOTAL_CUENTA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;

    }

}
