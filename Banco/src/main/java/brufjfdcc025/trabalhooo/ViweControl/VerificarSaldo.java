
package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class VerificarSaldo implements ActionListener{

    private final Menu tela;
    private Cliente cliente;

    public VerificarSaldo(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente=cliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(tela, "O seu saldo é de R$"+cliente.getConta().getSaldo(), "Saldo", JOptionPane.INFORMATION_MESSAGE);
    }
}
