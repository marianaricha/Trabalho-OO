package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pagamento implements ActionListener {

    private final Menu tela;
    private Cliente cliente;

    public Pagamento(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente = cliente;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
try {
            JTextField pagamento = new JTextField();
            JOptionPane.showMessageDialog(tela, pagamento, "Digite o valor do pagamento:", JOptionPane.INFORMATION_MESSAGE);
            float valPagamento = Float.parseFloat(pagamento.getText());

            if (valPagamento >= cliente.getConta().getSaldo()) {
                int x = 100 / 0;
            } else {
                tela.jpMenuOpcoes.setVisible(false);
                tela.painelPagamento = new JPanel();
                tela.painelPagamento.setVisible(true);
                tela.painelPagamento.setLayout(new GridLayout(10, 1, 10, 10));
                JLabel nome = new JLabel("Nome:");
                JLabel numConta = new JLabel("Número da conta:");
                JLabel cnpjLabel = new JLabel("CNPJ: ");
                JLabel aviso = new JLabel("OBS.: Pagamento só pode ser feito para pessoas jurídicas.");

                JTextField nomeDestinatario = new JTextField(15);
                JTextField numeroConta = new JTextField(15);
                JTextField cnpj = new JTextField(15);
                tela.painelPagamento.add(nome);
                tela.painelPagamento.add(nomeDestinatario);
                tela.painelPagamento.add(numConta);
                tela.painelPagamento.add(numeroConta);
                tela.painelPagamento.add(cnpjLabel);
                tela.painelPagamento.add(cnpj);
                tela.painelPagamento.add(aviso);


                JButton btnpagar = new JButton("Pagar");
                btnpagar.addActionListener(new RealizaPagamento(tela, cnpj, numeroConta, nomeDestinatario, valPagamento, cliente));

                tela.painelPagamento.add(btnpagar);

                tela.btnVoltar.addActionListener(new VoltarPagamento(tela, cliente));
                tela.painelPagamento.add(tela.btnVoltar, BorderLayout.SOUTH);//BOTAO VOLTAR 
                tela.add(tela.painelPagamento, BorderLayout.CENTER);

            }

        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(tela, "Saldo Insuficiente!");
        } catch (NumberFormatException e2) {
            JOptionPane.showMessageDialog(tela, "Digite o valor do pagamento usando apenas números.");
        }

    }

}