
package DATOS;

/**
 *
 * @author USUARIO
 */
public class PagosDatos {
    
    public int IdPago;
    public int IdCliente;
    public String FechaPago;
    public double ValorPago;

    public PagosDatos() {
    }

    public int getIdPago() {
        return IdPago;
    }

    public void setIdPago(int IdPago) {
        this.IdPago = IdPago;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(String FechaPago) {
        this.FechaPago = FechaPago;
    }

    public double getValorPago() {
        return ValorPago;
    }

    public void setValorPago(double ValorPago) {
        this.ValorPago = ValorPago;
    }
    
    
}
