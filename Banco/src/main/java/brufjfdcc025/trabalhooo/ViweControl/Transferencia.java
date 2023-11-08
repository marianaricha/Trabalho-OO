package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Transferencia implements ActionListener {

    private final Menu tela;
    Cliente cliente;
    List<Cliente> clientes;

    public Transferencia(Menu tela, Cliente cliente, List<Cliente> clientes) {
        this.tela = tela;
        this.cliente = cliente;
        this.clientes = clientes;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            JTextField transferencia = new JTextField();
            JOptionPane.showMessageDialog(tela, transferencia, "Digite o valor da transferência:", JOptionPane.INFORMATION_MESSAGE);
            float valTransferencia = Float.parseFloat(transferencia.getText());
            
            if (valTransferencia >= cliente.getConta().getSaldo()) {
                int x = 100 / 0;
            } else {
                tela.jpMenuOpcoes.setVisible(false);
                tela.painelTransferencia = new JPanel();
                tela.painelTransferencia.setVisible(true);
                tela.painelTransferencia.setLayout(new GridLayout(10, 1, 10, 10));
                JLabel nome = new JLabel("Nome:");
                JLabel numConta = new JLabel("Número da conta:");
                JLabel cpfJLabel = new JLabel("CPF: ");
                JLabel aviso = new JLabel("OBS.: Transferência só pode ser feita para pessoas físicas.");

                JTextField nomeDestinatario = new JTextField(15);
                JTextField numeroConta = new JTextField(15);
                JTextField cpf = new JTextField(15);
                tela.painelTransferencia.add(nome);
                tela.painelTransferencia.add(nomeDestinatario);
                tela.painelTransferencia.add(numConta);
                tela.painelTransferencia.add(numeroConta);
                tela.painelTransferencia.add(cpfJLabel);
                tela.painelTransferencia.add(cpf);
                tela.painelTransferencia.add(aviso);

                JButton btntransferir = new JButton("Transferir");
                btntransferir.addActionListener(new RealizaTransferencia(tela, cpf, numeroConta, nomeDestinatario, valTransferencia, cliente));

                tela.painelTransferencia.add(btntransferir);

                tela.btnVoltar.addActionListener(new VoltarTransferencia(tela, cliente));
                tela.painelTransferencia.add(tela.btnVoltar, BorderLayout.SOUTH);//BOTAO VOLTAR 
                tela.add(tela.painelTransferencia, BorderLayout.CENTER);

            }

        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(tela, "Saldo Insuficiente!");
        } catch (NumberFormatException e2) {
            JOptionPane.showMessageDialog(tela, "Digite o valor da transferência usando apenas números.");
        } 
//        
        }
    }
