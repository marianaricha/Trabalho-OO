package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import brufjfdcc025.trabalhooo.model.PessoaJuridica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ProximoJuridico implements ActionListener {

    private final Menu tela;

    public ProximoJuridico(Menu tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            //verificando áreas vazias
            if(tela.getjSenha().getText().isEmpty() || tela.getjTelefone().getText().isEmpty() ||
                    tela.getjNome().getText().isEmpty() || tela.getjCnpj().getText().isEmpty()){
                int x = 100/0;
            }   
            //verificando se os valores de cpf, rg e telefone são numeros
            int y;
            if(!tela.getjCnpj().getText().substring(0,tela.getjCnpj().getText().length()).matches("[0-9]*") ||
                !tela.getjTelefone().getText().substring(0,tela.getjTelefone().getText().length()).matches("[0-9]*"))
                y = 100/0;
            PessoaJuridica cliente = new PessoaJuridica(tela.getjCnpj().getText(), tela.getjTelefone().getText(),
                    tela.getjNome().getText(), tela.getjSenha().getText());

            tela.getClientes().add(cliente);
            tela.menuCadastraEndereco(cliente);
            tela.repaint();
        } 
        
        catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(tela, "Não deixe campos vazios");
        } 
        
        catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(tela, "Um ou mais campos preenchidos incorretamente");
        }

    }

}
