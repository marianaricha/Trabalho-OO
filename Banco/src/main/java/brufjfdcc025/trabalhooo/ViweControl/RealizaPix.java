package brufjfdcc025.trabalhooo.ViweControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import brufjfdcc025.trabalhooo.model.Cliente;
import brufjfdcc025.trabalhooo.model.PessoaFisica;
import brufjfdcc025.trabalhooo.model.PessoaJuridica;
import java.util.Calendar;

public class RealizaPix implements ActionListener {

    private final Menu tela;
    private final String cpf;
    private float valPix;
    private Cliente cliente;

    public RealizaPix(Menu tela, String cpf, float valPix, Cliente cliente) {
        this.tela = tela;
        this.cpf = cpf;
        this.valPix = valPix;
        this.cliente = cliente;

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            int numcpf = Integer.parseInt(tela.getValCpf().getText()); //para verificar se o textfield do cpf ta sendo preenchido apenas com numeros

            //fazer uma busca pelo cpf da pessoa e creditar nele
            boolean boolcpf = false;

            for (Cliente c : tela.getClientes()) {
                if (c.getTipo().equals("F")) {
                    PessoaFisica p = (PessoaFisica) c;
                    if (p.getCpf().equals(tela.getjCpf().getText())) {

                        boolcpf = true;

                      //  p.getConta().addExtrato("Pix", valPix, Calendar.getInstance().getTime());
                        this.cliente.getConta().addExtrato("Pix", -valPix, Calendar.getInstance().getTime());
                        JOptionPane.showMessageDialog(tela, "Pix realizado com sucesso!");

                        break;
                    }
                } else {
                    PessoaJuridica p = (PessoaJuridica) c;
                    if (p.getCnpj().equals(tela.getjCnpj().getText())) {
                        boolcpf = true;

                       // p.getConta().addExtrato("Pix", valPix, Calendar.getInstance().getTime());
                        this.cliente.getConta().addExtrato("Pix", -valPix, Calendar.getInstance().getTime());
                        JOptionPane.showMessageDialog(tela, "Pix realizado com sucesso!");

                        break;
                    }
                }
            }

            if (boolcpf == true) {
                tela.painelPix.setVisible(false);
                tela.repaint();
                tela.menuOpcoes(cliente);
            } else {
                System.out.println(boolcpf);
                JOptionPane.showMessageDialog(tela, "CPF/CNPJ inválido!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e2) {
            JOptionPane.showMessageDialog(tela, "CPF/CNPJ inválido. Digite apenas os números do CPF/CNPJ do destinatário do Pix!");

        }
    }
}
