package brufjfdcc025.trabalhooo.ViweControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CadastroPessoaFisica implements ActionListener {

    private final Menu tela;

    public CadastroPessoaFisica(Menu tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
         try{
            tela.menuCadastraFisica();
            tela.repaint();
        }catch(Exception e){
            JOptionPane.showMessageDialog(tela, "Deu ruim!");
            tela.painel.setVisible(true);
        }
            
        
    }
        
}