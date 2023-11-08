package brufjfdcc025.trabalhooo.ViweControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import brufjfdcc025.trabalhooo.model.Cliente;
import brufjfdcc025.trabalhooo.model.PessoaFisica;
import brufjfdcc025.trabalhooo.model.PessoaJuridica;
import java.util.List;

public class Entrar implements ActionListener {

    private final Menu tela;
    List<Cliente> clientes;

    public Entrar(Menu tela) {
        this.tela = tela;
        this.clientes = tela.getClientes();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            boolean login = false;
            Cliente cliente = null;
            for (Cliente c : this.clientes) {
                if (c.getTipo().equals("F")) {
                    PessoaFisica p = (PessoaFisica) c;
                    if (p.getCpf().equals(tela.getjCpf().getText())
                            && tela.getjSenha().getText().equals(p.getSenha())) {
                        JOptionPane.showMessageDialog(tela, "Bem vindo " + c.getNome() + "!");
                        login = true;
                        
                        cliente = c;
                        break;
                    }
                } else {
                    PessoaJuridica p = (PessoaJuridica) c;
                    if (p.getCnpj().equals(tela.getjCpf().getText())
                            && tela.getjSenha().getText().equals(p.getSenha())) {
                        JOptionPane.showMessageDialog(tela, "Bem vindo " + c.getNome() + "!");
                        login = true;
                        
                        cliente = c;
                        break;
                    }
                }
                
            }
            if (login != true) {
                JOptionPane.showMessageDialog(tela, "Usuário não encontrado!", "Usuário", JOptionPane.ERROR_MESSAGE);
            } else {
                tela.painelLogin.setVisible(false);
                tela.repaint();
                tela.menuOpcoes(cliente);
                tela.repaint();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Algo deu errado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
