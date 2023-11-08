package brufjfdcc025.trabalhooo.model;

import java.util.Date;

public class Extrato {
    private String tipo;
    private float val;
    private Date data;
    
    public Extrato(String tipo, float valor, Date data){
        this.tipo=tipo;
        this.val=valor;
        this.data=data;
    }

    public String getTipo() {
        return tipo;
    }

    public float getVal() {
        return val;
    }

    public Date getData() {
        return data;
    }
    
    
    
    @Override
    public String toString() {
        return ("Tipo: "+tipo+ " Valor: R$"+ val +"  " + data);
    }
    
    
    
}
