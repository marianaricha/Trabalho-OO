package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Saque implements ActionListener {

    private final Menu tela;
    private Cliente cliente;

    public Saque(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente = cliente;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            JTextField saque = new JTextField();
            JOptionPane.showMessageDialog(tela,saque, "Digite o valor a ser sacado:",JOptionPane.INFORMATION_MESSAGE);
            float valSaque = Float.parseFloat(saque.getText());
            
            if(cliente.getConta().getSaldo()>=valSaque){
                cliente.getConta().addExtrato("Saque", -valSaque, Calendar.getInstance().getTime());
                JOptionPane.showMessageDialog(tela, "Saque efetuado com sucesso!");
            }
            else{
                JOptionPane.showMessageDialog(tela, "Saldo insuficiente!");
            }
        }
        catch(NumberFormatException e2){
            JOptionPane.showMessageDialog(tela, "Voce não digitou o valor a ser sacado\nou digitou um valor inválido!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

}
