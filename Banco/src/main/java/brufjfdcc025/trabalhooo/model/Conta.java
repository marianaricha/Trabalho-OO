package brufjfdcc025.trabalhooo.model;
import java.util.Scanner;
import java.util.*;

public class Conta {
    Scanner teclado = new Scanner(System.in);
    
    private List <Extrato> extrato;
    private String numero;
    private float saldo;
    private static String digito = "-025";

    public Conta() {
        saldo=0;
        extrato = new ArrayList<>();
        
        if(this.numero == null){
            //digito do Banco é 025
            int a = (int) (Math.random() * 10);
            int b = (int) (Math.random() * 10);
            int c = (int) (Math.random() * 10);
            int d = (int) (Math.random() * 10);
            int e = (int) (Math.random() * 10);
            this.numero = Integer.toString(a) + Integer.toString(b) +Integer.toString(c) +
                    Integer.toString(d) +Integer.toString(e) + digito;
        }
    }

    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero){
        this.numero=numero;
    }


    public float getSaldo() {
        return saldo;
    }
    
    public void setSaldo(float val){
        this.saldo = val;
    }

    public List<Extrato> getExtrato() {
        return extrato;
    }
    
    public void addExtrato(String tipo, float valor, Date data){ //usar sempre esse ao inves do set
        extrato.add(new Extrato(tipo,valor,data));
        this.saldo+=valor; //ja adiciona o valor ao saldo
    }
    
    @Override
    public String toString() {
        return this.getNumero() + ";" + saldo;
    }    
}
