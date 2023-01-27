package LOGICANEGOCIO;

import DATOS.ClientesDatos;
import DATOS.ConexionSingleton;
import DATOS.GenerarCodigos;
import PRESENTACION.Clientes;
import static PRESENTACION.MenuPrincipal.PanelEscritorio;
import PRESENTACION.TablaClientes;
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
public class ClientesNegocio {

    private DefaultTableModel modelo;
    ClientesDatos c = new ClientesDatos();

    Connection cn = ConexionSingleton.getConnection();

    public DefaultTableModel MostrarTabla(String valor) {

        String col[] = {"ID CLIENTE", "NOMBRES      ", "N° CEDULA      ", "TELEFONO", "DIRECCION"};
        String[] data = new String[5];
        String sql = "SELECT * FROM clientes WHERE  CONCAT (NOMBRES,'',NUM_CEDULA) LIKE '%" + valor + "%'";
        modelo = new DefaultTableModel(null, col);

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("ID_CLIENTE");
                data[1] = r.getString("NOMBRES");
                data[2] = r.getString("NUM_CEDULA");
                data[3] = r.getString("TELEFONO");
                data[4] = r.getString("DIRECCION");

                modelo.addRow(data);
            }

            return modelo;
        } catch (SQLException e) {

            //JOptionPane.showMessageDialog(null, "Cliente Modificado Con Exito");
            return null;
        }

    }

    public DefaultTableModel Filtrarpornombres(String valor) {

        String col[] = {"ID CLIENTE", "NOMBRES      ", "N° CEDULA      ", "TELEFONO", "DIRECCION"};
        String[] data = new String[6];
        String sql = "SELECT * FROM clientes WHERE  NOMBRES LIKE '%" + valor + "%'";
        modelo = new DefaultTableModel(null, col);

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("ID_CLIENTE");
                data[1] = r.getString("NOMBRES");
                data[2] = r.getString("NUM_CEDULA");
                data[3] = r.getString("TELEFONO");
                data[4] = r.getString("DIRECCION");

                modelo.addRow(data);
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }

    }

    public DefaultTableModel Filtrarporcedula(String valor) {

        String col[] = {"ID CLIENTE", "NOMBRES      ", "N° CEDULA      ", "TELEFONO", "DIRECCION"};
        String[] data = new String[6];
        String sql = "SELECT * FROM clientes WHERE  NUM_CEDULA LIKE '%" + valor + "%'";
        modelo = new DefaultTableModel(null, col);
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("ID_CLIENTE");
                data[1] = r.getString("NOMBRES");
                data[2] = r.getString("NUM_CEDULA");
                data[4] = r.getString("TELEFONO");
                data[5] = r.getString("DIRECCION");

                modelo.addRow(data);
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }

    }

    public boolean AgregarCliente(Clientes cf) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        c.NumeroDocumento = Long.parseLong(cf.campodocumento.getText());
        String consultarp = "SELECT * FROM clientes WHERE NUM_CEDULA='" + c.NumeroDocumento + "'";
        try {
            pst = cn.prepareStatement(consultarp);
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "EL Cliente ya se encuentra resgistrado");
            } else {

                c.IdCliente = Integer.parseInt(cf.campoid.getText());
                c.NombreCompleto = (cf.camponombres.getText());
                c.NumeroDocumento = Long.parseLong(cf.campodocumento.getText());
                c.Telefono = Long.parseLong(cf.campotelefono.getText());
                c.Direccion = (cf.campodireccion.getText());
                String sql;

                sql = "INSERT INTO clientes(ID_CLIENTE,NOMBRES,NUM_CEDULA,TELEFONO,DIRECCION) VALUES(?,?,?,?,?)";

                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setInt(1, c.getIdCliente());
                psd.setString(2, c.getNombreCompleto());
                psd.setLong(3, c.getNumeroDocumento());
                psd.setLong(4, c.getTelefono());
                psd.setString(5, c.getDireccion());
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente Guardado Con Exito");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);

            //Guardar.setEnabled(false);
        }
        return true;

    }

    public boolean ConsultarCliente(Clientes cf) {

        return false;

    }

    public boolean ModificarCliente(Clientes cf) {

        c.IdCliente = Integer.parseInt(cf.campoid.getText());
        c.NombreCompleto = (cf.camponombres.getText());
        c.NumeroDocumento = Long.parseLong(cf.campodocumento.getText());
        c.Telefono = Long.parseLong(cf.campotelefono.getText());
        c.Direccion = (cf.campodireccion.getText());
        String sql;

        sql = "UPDATE  clientes SET ID_CLIENTE=?,NOMBRES=?,NUM_CEDULA=?,TELEFONO=?,DIRECCION=? WHERE ID_CLIENTE=?";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setInt(1, c.getIdCliente());
            psd.setString(2, c.getNombreCompleto());
            psd.setLong(3, c.getNumeroDocumento());
            psd.setLong(4, c.getTelefono());
            psd.setString(5, c.getDireccion());
            psd.setInt(6, c.getIdCliente());
            psd.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Modificado Con Exito");
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);

        }

        return true;

    }

    public boolean EliminaeCliente(TablaClientes tb) {

        c.IdCliente = Integer.parseInt(tb.campoidcliente.getText());
        String sql;
        sql = "DELETE FROM clientes WHERE ID_CLIENTE=?";

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setInt(1, c.getIdCliente());

            psd.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente Eliminado Con Exito");
            tb.dispose();
            TablaClientes c = new TablaClientes();
            PanelEscritorio.add(c);
            c.setLocation(165, 0);
            c.show();
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Puede Eliminar Intente Nuevamente");
        }
        return true;

    }

    public boolean CodigoIdCliente(Clientes cl) {
        int j;
        int cont = 1;
        int num = 0;
        int c = 0;
        String sql = "SELECT MAX(ID_CLIENTE) FROM clientes";

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            if (rs.next()) {
                c = rs.getInt(1);
            }

            if (c == 0) {
                //campo1.setText("1");
                cl.campoid.setText(String.valueOf(1));
            } else {

                j = Integer.parseInt(String.valueOf(c));
                GenerarCodigos gen = new GenerarCodigos();
                gen.generar(j);
                cl.campoid.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

}
