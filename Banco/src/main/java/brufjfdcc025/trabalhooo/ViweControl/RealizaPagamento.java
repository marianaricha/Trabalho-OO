package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import brufjfdcc025.trabalhooo.model.PessoaJuridica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RealizaPagamento implements ActionListener {

    private final Menu tela;
    private final JTextField cpf;
    private final JTextField numConta;
    private final JTextField nomeConta;
    private final Cliente cliente;
    private final float val;

    public RealizaPagamento(Menu tela, JTextField cpf, JTextField numConta, JTextField nomeConta, float val, Cliente cliente) {
        this.tela = tela;
        this.cpf = cpf;
        this.numConta = numConta;
        this.nomeConta = nomeConta;
        this.cliente = cliente;
        this.val = val;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            boolean pag = false;
            for (Cliente c : tela.getClientes()) {
                if (c.getTipo().equals("J")) {
                    PessoaJuridica p = (PessoaJuridica) c;
                    if (p.getCnpj().equals(cpf.getText()) && p.getConta().getNumero().equals(numConta.getText()) && p.getNome().equals(nomeConta.getText())) {
                        c.getConta().addExtrato("Pagamento", val, Calendar.getInstance().getTime());
                        cliente.getConta().addExtrato("Pagamento", -val, Calendar.getInstance().getTime());
                        pag = true;
                        break;
                    }
                }
            }

            if (pag == true) {
                JOptionPane.showMessageDialog(tela, "Pagamento realizado com sucesso!");
                tela.painelPagamento.setVisible(false);
                tela.repaint();
                tela.menuOpcoes(cliente);

            } else {
                JOptionPane.showMessageDialog(tela, "Destinatário não encontrado!");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(tela, "Digite apenas números para a conta e para o CNPJ.");
        }

    }

}
