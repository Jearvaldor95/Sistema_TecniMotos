package DATOS;
import java.sql.*;

/**
 *
 * @author USUARIO
 */
public class ConexionSingleton {

    private static Connection cn = null;
    private String Driver;
    private String user;
    private String password;
    private String url;

    public ConexionSingleton() {
        String url = "jdbc:mysql://localhost:3306/TECNIMOTOS";
        String Driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "";
        try {
            Class.forName(Driver);
            cn = DriverManager.getConnection(url, user, password);
            /*if(cn!=null){
                System.out.println("conexion establecida");
            }*/
            System.out.println("conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            //System.out.println("error al conectar"+e);
            System.out.println("error al conectar" + e);
        }
    }

    public static Connection getConnection() {
        if (cn == null) {
            new ConexionSingleton();
            //System.out.println("conexion establecida");
        }
        return cn;
    }

}
