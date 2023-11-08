package brufjfdcc025.trabalhooo.ViweControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Sair implements ActionListener {

    private final Menu tela;

    public Sair(Menu tela) {

        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int option = JOptionPane.showConfirmDialog(tela, "Sair da conta?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
//            JOptionPane.showMessageDialog(tela, "Saindo da conta"); //configurar para se a pessoa apertar no close, não sair

        if (option == 0) {
            tela.jpMenuOpcoes.setVisible(false);
            tela.repaint();
            tela.painel.setVisible(true);
        }
    }
}
