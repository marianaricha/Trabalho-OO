package brufjfdcc025.trabalhooo.ViweControl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import brufjfdcc025.trabalhooo.model.Cliente;

public class Pix implements ActionListener {

    private final Menu tela;
    private Cliente cliente;

    public Pix(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente = cliente;
    
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            JTextField pix = new JTextField();
            JOptionPane.showMessageDialog(tela, pix, "Digite o valor da transferencia:", JOptionPane.INFORMATION_MESSAGE);
            float valPix = Float.parseFloat(pix.getText());

            if (valPix >= cliente.getConta().getSaldo()) {
                int x = 100 / 0;
            } else {

            tela.jpMenuOpcoes.setVisible(false);
            tela.painelPix = new JPanel();
            tela.painelPix.setVisible(true);
            tela.repaint();

            tela.painelPix.add(new JLabel("CPF/CNPJ do destinatário: "));
            tela.valCpf = new JTextField(15);
            tela.painelPix.add(tela.valCpf);
            
            String cpf = tela.getValCpf().getText();
                tela.jpMenuOpcoes.setVisible(false);
                tela.painelPix = new JPanel();
                tela.painelPix.setVisible(true);
                tela.repaint();

//            tela.panelPix.add(new JLabel("Valor do Pix: "));
//            tela.valPix = new JTextField(15);
//            tela.panelPix.add(tela.valPix);
                tela.painelPix.add(new JLabel("CPF/CNPJ do destinatário: "));
                tela.valCpf = new JTextField(15);
                tela.painelPix.add(tela.valCpf);

//            float val = Float.parseFloat(tela.getValPix().getText());

                JButton btnPixRealizado = new JButton("Fazer o PIX!");
                btnPixRealizado.addActionListener(new RealizaPix(tela, cpf, valPix, cliente));

                tela.painelPix.add(btnPixRealizado);

                tela.btnVoltar.addActionListener(new VoltarPix(tela, cliente));
                tela.painelPix.add(tela.btnVoltar, BorderLayout.SOUTH);//BOTAO VOLTAR 
                tela.add(tela.painelPix, BorderLayout.CENTER);
            }
        } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(tela, "Digite o valor da transferência apenas com números");
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(tela, "Saldo insuficiente!");
        }
    }
}
