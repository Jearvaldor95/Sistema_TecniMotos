
package DATOS;

/**
 *
 * @author USUARIO
 */
public class DetallesComprasDatos {
    
    public int IdCompra;
    public String Codigo;
    public int Cantidad;
    public Double ValorUnitario;
    public float Descuento;
    public float PrecioNeto;
    public Double ValorEntrada;
    public double Valor_Total;

    public DetallesComprasDatos() {
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    public float getDescuento() {
        return Descuento;
    }

    public void setDescuento(float Descuento) {
        this.Descuento = Descuento;
    }

    public float getPrecioNeto() {
        return PrecioNeto;
    }

    public void setPrecioNeto(float PrecioNeto) {
        this.PrecioNeto = PrecioNeto;
    }

    public Double getValorEntrada() {
        return ValorEntrada;
    }

    public void setValorEntrada(Double ValorEntrada) {
        this.ValorEntrada = ValorEntrada;
    }

    public double getValor_Total() {
        return Valor_Total;
    }

    public void setValor_Total(double Valor_Total) {
        this.Valor_Total = Valor_Total;
    }
    
    
}
