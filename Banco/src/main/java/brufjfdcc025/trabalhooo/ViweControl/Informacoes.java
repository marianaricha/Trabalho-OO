package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import brufjfdcc025.trabalhooo.model.PessoaFisica;
import brufjfdcc025.trabalhooo.model.PessoaJuridica;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Informacoes implements ActionListener{
    private final Menu tela;
    private Cliente cliente;

    public Informacoes(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente=cliente;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            tela.painelInfo = new JPanel();
            tela.painelInfo.setLayout(new GridLayout(0,2));
            tela.jpMenuOpcoes.setVisible(false);
            tela.painelInfo.setVisible(true);
            
            tela.painelInfo.add(new JLabel("Nome: "));
            tela.painelInfo.add(new JLabel(cliente.getNome()));
            tela.painelInfo.add(new JLabel("Telefone: "));
            tela.painelInfo.add(new JLabel(cliente.getTelefone()));
            if(cliente.getTipo().equals("F")){
                PessoaFisica p = (PessoaFisica) cliente;
                tela.painelInfo.add(new JLabel("CPF: "));
                tela.painelInfo.add(new JLabel(p.getCpf()));
            }
            else{
                PessoaJuridica p = (PessoaJuridica) cliente;
                tela.painelInfo.add(new JLabel("CNPJ: "));
                tela.painelInfo.add(new JLabel(p.getCnpj()));
            }
            tela.painelInfo.add(new JLabel("Numero da conta: "));
            tela.painelInfo.add(new JLabel(cliente.getConta().getNumero()));
            tela.painelInfo.add(new JLabel("Saldo: "));
            tela.painelInfo.add(new JLabel(String.valueOf(cliente.getConta().getSaldo())));
            tela.painelInfo.add(new JLabel("Cep: "));
            tela.painelInfo.add(new JLabel(cliente.getEndereco().getCep()));
            tela.painelInfo.add(new JLabel("Cidade: "));
            tela.painelInfo.add(new JLabel(cliente.getEndereco().getCidade()));
            tela.painelInfo.add(new JLabel("Bairro: "));
            tela.painelInfo.add(new JLabel(cliente.getEndereco().getBairro()));
            tela.painelInfo.add(new JLabel("Rua: "));
            tela.painelInfo.add(new JLabel(cliente.getEndereco().getRua()));
            tela.painelInfo.add(new JLabel("Numero: "));
            tela.painelInfo.add(new JLabel(String.valueOf(cliente.getEndereco().getNumero())));
            tela.painelInfo.add(new JLabel("Complemento: "));
            tela.painelInfo.add(new JLabel(cliente.getEndereco().getComplemento()));
            
            JButton voltar = new JButton("Voltar");
            voltar.addActionListener(new VoltarInfo(tela, cliente));
            tela.painelInfo.add(voltar);
            
            tela.add(tela.painelInfo);
            tela.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Não foi possível mostrar o perfil","ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
