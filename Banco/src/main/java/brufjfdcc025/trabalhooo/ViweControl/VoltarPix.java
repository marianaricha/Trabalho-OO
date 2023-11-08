package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class VoltarPix  implements ActionListener{
    
      private final Menu tela;
      Cliente cliente;
   

    public VoltarPix(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente=cliente;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            tela.painelPix.setVisible(false);
            tela.repaint();
            tela.menuOpcoes(cliente);
        }catch(Exception e2){
            JOptionPane.showMessageDialog(tela, "ERROR","ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
