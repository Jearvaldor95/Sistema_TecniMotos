
package DATOS;

/**
 *
 * @author USUARIO
 */
public class ClientesDatos {
    
    public int IdCliente;
    public String NombreCompleto;
    public long NumeroDocumento;
    public long Telefono;
    public String Direccion;

    public ClientesDatos() {
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public long getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(long NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    
    
}
