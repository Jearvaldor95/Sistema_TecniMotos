package LOGICANEGOCIO;

import DATOS.ConexionSingleton;
import PRESENTACION.Login;
import PRESENTACION.MenuAuxiliar;
import PRESENTACION.MenuPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class AccesoNegocio {
    
    Connection cn = ConexionSingleton.getConnection();
    ResultSet r = null;
    PreparedStatement psd = null;
    
    public boolean AccederSistema(Login a) {
        
        String sql = "select * from usuario Where (usuario=? and contraseña =? and rol=?)";
        
        try {
            
            psd = cn.prepareStatement(sql);
            psd.setString(1, a.campousuario.getText());
            psd.setString(2, a.campocontraseña.getText());
            psd.setString(3, a.jcomborol.getSelectedItem().toString());
            
            r = psd.executeQuery();
            
            if (r.next()) {
                
                
                String TipoUsuario;
                TipoUsuario = String.valueOf(a.jcomborol.getSelectedItem()).intern();
                if (TipoUsuario == "Auxiliar") {
                    MenuAuxiliar m = new MenuAuxiliar();
                    m.campousuarioconectado.setText(r.getString("ROL") + ": " + r.getString("NOMBRES"));
                    m.setVisible(true);
                    a.dispose();
                    
                } else {
                    MenuPrincipal m = new MenuPrincipal();
                    m.setVisible(true);
                    a.dispose();
                    m.jMenuItem18.setEnabled(false);
                    m.campousuarioconectado.setText(r.getString("ROL") + ": " + r.getString("NOMBRES"));
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "!Datos Incorrectos! Vuelva A intentar");
            }
            
        } catch (SQLException e) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
           
        }
        
        return true;
        
    }
    
    public boolean ControlSesionAdministrador(MenuPrincipal m ) {
        m.BotobProductos.setEnabled(false);
        m.BotonClientes.setEnabled(false);
        m.BotonCreditos.setEnabled(false);
        m.BotonPagos.setEnabled(false);
        m.BotonUsuarios.setEnabled(false);
        m.BotonVentas.setEnabled(false);
        m.campousuarioconectado.setText("");
        m.jMenu1.setEnabled(false);
        m.jMenu2.setEnabled(false);
        m.jMenu3.setEnabled(false);
        m.jMenu5.setEnabled(false);
        m.jMenuItem16.setEnabled(false);
        m.jMenuItem18.setEnabled(true);
        return true;
        
    }
    
    public boolean ControlSesionAuxiliar(MenuAuxiliar m ) {
        m.BotobProductos.setEnabled(false);
        m.BotonClientes.setEnabled(false);
        m.BotonVentas.setEnabled(false);
        m.campousuarioconectado.setText("");
        m.jMenu1.setEnabled(false);
        m.jMenu2.setEnabled(false);
        m.jMenu3.setEnabled(false);
        m.jMenuItem16.setEnabled(false);
        m.jMenuItem18.setEnabled(true);
        return true;
        
    }
}
