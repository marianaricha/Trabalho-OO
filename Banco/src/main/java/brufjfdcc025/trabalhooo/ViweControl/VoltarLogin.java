package brufjfdcc025.trabalhooo.ViweControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VoltarLogin implements ActionListener {
    
    private final Menu tela;

    public VoltarLogin(Menu tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.painelLogin.setVisible(false);
        tela.repaint();
        tela.painel.setVisible(true);
    }    
}
