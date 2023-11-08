package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposito implements ActionListener {

    private final Menu tela;
    private Cliente cliente;

    public Deposito(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente=cliente;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            JTextField deposito = new JTextField();
            JOptionPane.showMessageDialog(tela, deposito, "Digite o valor a ser depositado:", JOptionPane.INFORMATION_MESSAGE);
            float valDeposito = Float.parseFloat(deposito.getText());
            if (valDeposito < 10) {
                int x = 100 / 0; 
            } else {
                cliente.getConta().addExtrato("Depósito", valDeposito, Calendar.getInstance().getTime());
                JOptionPane.showMessageDialog(tela, "Depósito efetuado com sucesso!");
            }
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(tela, "Não foi possível efetuar o depósito! \nSó é válido depósitos acima de R$10,00");

        } catch (NumberFormatException e2) {
            JOptionPane.showMessageDialog(tela, "Você não digitou o valor a ser depositado\nou digitou um valor inválido. ");
        }

    }

}
