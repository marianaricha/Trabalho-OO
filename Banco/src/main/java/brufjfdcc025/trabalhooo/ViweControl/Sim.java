package brufjfdcc025.trabalhooo.ViweControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Sim implements ActionListener{

    private final Menu tela;

    public Sim(Menu tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            tela.painel.setVisible(false);
            tela.menuLogin();
            tela.repaint();   
        }catch(Exception e){
            JOptionPane.showMessageDialog(tela, "Deu ruim!");
            tela.painel.setVisible(true);
        }
        
    }
    
}
