package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VoltarTransferencia implements ActionListener {

    private final Menu tela;
    Cliente cliente;

    public VoltarTransferencia(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente = cliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.painelTransferencia.setVisible(false);
        tela.repaint();
        tela.menuOpcoes(cliente);
    }
}
