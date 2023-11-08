package brufjfdcc025.trabalhooo.ViweControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VoltarCadastro implements ActionListener{
    
    private final Menu tela;

    public VoltarCadastro(Menu tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.jpMenuInicial.setVisible(false);
        tela.repaint();
        tela.menuPossuiConta();
    }
}
