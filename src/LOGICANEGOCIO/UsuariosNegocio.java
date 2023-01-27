package LOGICANEGOCIO;

import DATOS.ConexionSingleton;
import DATOS.GenerarCodigos;
import DATOS.UsuarioDatos;
import static PRESENTACION.MenuPrincipal.PanelEscritorio;
import PRESENTACION.ModificarUsuario;
import PRESENTACION.TablaUsuarios;
import PRESENTACION.Usuario;
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
public class UsuariosNegocio {

    private DefaultTableModel modelo;
    Connection cn = ConexionSingleton.getConnection();
    UsuarioDatos ud = new UsuarioDatos();

    public DefaultTableModel MostrarTabla(String valor) {

        String col[] = {"ID USUARIO", "NOMBRES      ", "USUARIO      ", "ROL"};
        String[] data = new String[6];
        String sql = "SELECT * FROM usuario WHERE  CONCAT (NOMBRES,'',ROL) LIKE '%" + valor + "%'";
        modelo = new DefaultTableModel(null, col);

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet r = psd.executeQuery();
            while (r.next()) {
                data[0] = r.getString("ID_USUARIO");
                data[1] = r.getString("NOMBRES");
                data[2] = r.getString("USUARIO");
                data[3] = r.getString("ROL");

                modelo.addRow(data);
            }

            return modelo;
        } catch (SQLException e) {

            //JOptionPane.showMessageDialog(null, "Cliente Modificado Con Exito");
            return null;
        }

    }

    public boolean AgregarUsuario(Usuario u) {

        ud.IdUsuario = Integer.parseInt(u.campoidusuario.getText());
        ud.Nombres = (u.camponombreusuario.getText());
        ud.Usuario = (u.campousuario.getText());
        ud.Contraseña = (u.campopasword.getText());
        ud.Rol = (String) u.jcomborol.getSelectedItem();
        //String encript=DigestUtils.sha256Hex(ud.Contraseña);
        String sql;

        sql = "INSERT INTO usuario(ID_USUARIO,NOMBRES,USUARIO,CONTRASEÑA,ROL) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setInt(1, ud.getIdUsuario());
            psd.setString(2, ud.getNombres());
            psd.setString(3, ud.getUsuario());
            psd.setString(4, ud.getContraseña());
            psd.setString(5, ud.getRol());
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Usuario Guardado Con Exito");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);

        }
        return true;

    }

    public boolean ModificarUsuario(ModificarUsuario mu) {
        ud.IdUsuario = Integer.parseInt(mu.campoidusuario.getText());
        ud.Nombres = (mu.camponombresusuario.getText());
        ud.Usuario = (mu.campousuario.getText());
        ud.Contraseña = (mu.password.getText());

        String sql;

        sql = "UPDATE  usuario SET ID_USUARIO=?,NOMBRES=?,USUARIO=?,CONTRASEÑA=? WHERE ID_USUARIO=?";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setInt(1, ud.getIdUsuario());
            psd.setString(2, ud.getNombres());
            psd.setString(3, ud.getUsuario());
            psd.setString(4, ud.getContraseña());
            psd.setInt(5, ud.getIdUsuario());
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Usuario Modificado Con Exito");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);

        }

        return true;

    }

    public boolean EliminarUsuario(TablaUsuarios tb) {

        ud.IdUsuario = Integer.parseInt(tb.campoidusuario.getText());
        String sql;
        sql = "DELETE FROM usuario WHERE ID_USUARIO=?";

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setInt(1, ud.getIdUsuario());

            psd.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario Eliminado Con Exito");
            tb.dispose();
            TablaUsuarios u = new TablaUsuarios();
            PanelEscritorio.add(u);
            u.setLocation(165, 0);
            u.show();
        } catch (SQLException ex) {
            Logger.getLogger(TablaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Puede Eliminar Intente Nuevamente");
        }

        return true;

    }

    public boolean BuscarUsuario(ModificarUsuario mu) {
        String sql;
        sql = "SELECT * FROM usuario WHERE USUARIO=? && CONTRASEÑA=?";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, mu.campobuscarusuario.getText());
            psd.setString(2, mu.buscarpassword.getText());
            ResultSet r = psd.executeQuery();
            if (r.next()) {
                mu.campoidusuario.setText(r.getString("ID_USUARIO"));
                mu.camponombresusuario.setText(r.getString("NOMBRES"));
                mu.campousuario.setText(r.getString("USUARIO"));
                mu.password.setText(r.getString("CONTRASEÑA"));
            } else {
                JOptionPane.showMessageDialog(null, "El Usuario No Existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);

        }

        return true;

    }

    public boolean CodigoIdUsuarios(Usuario u) {
        int j;
        int cont = 1;
        int num = 0;
        int c = 0;
        String sql = "SELECT MAX(ID_USUARIO) FROM usuario";

        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            if (rs.next()) {
                c = rs.getInt(1);
            }

            if (c == 0) {
                //campo1.setText("1");
                u.campoidusuario.setText(String.valueOf(1));
            } else {

                j = Integer.parseInt(String.valueOf(c));
                GenerarCodigos gen = new GenerarCodigos();
                gen.generar(j);
                u.campoidusuario.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }
}
