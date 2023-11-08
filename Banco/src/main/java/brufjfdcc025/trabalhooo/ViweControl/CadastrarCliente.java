package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import brufjfdcc025.trabalhooo.model.Endereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastrarCliente implements ActionListener {

    private final Menu tela;
    List<Cliente> clientes;
    Cliente cliente;

    public CadastrarCliente(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente = cliente;
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            
            //tratando campos vazios
            if(tela.getjCidade().getText().isEmpty() ||  tela.getjRua().getText().isEmpty() || 
                    tela.getjBairro().getText().isEmpty() ||  tela.getjCep().getText().isEmpty() || 
                    tela.getjNumero().getText().isEmpty()){
                    int x= 10/0;
            }
            //tratando campos que só pode números
            int num = Integer.parseInt(tela.getjNumero().getText());
            int numCep = Integer.parseInt(tela.getjCep().getText());
            
            //Cadastrar o cliente na lista de clientes
            Endereco end = new Endereco(tela.getjCidade().getText(), tela.getjRua().getText(),
                    tela.getjBairro().getText(), tela.getjCep().getText(),
                    num, tela.getjComplemento().getText());
            
            cliente.setEndereco(end);
             
            JOptionPane.showMessageDialog(tela, "Cadastro realizado!");
            tela.jpMenuEndereco.setVisible(false);
            tela.menuLogin();
            tela.repaint();

        } 
        
        catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(tela, "Não deixe campos vazios");
        } 
        
        catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(tela, "Um ou mais campos preenchidos incorretamente");
        } catch (Exception ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
