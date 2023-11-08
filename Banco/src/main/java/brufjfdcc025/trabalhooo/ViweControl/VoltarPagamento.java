package brufjfdcc025.trabalhooo.ViweControl;

import brufjfdcc025.trabalhooo.model.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VoltarPagamento implements ActionListener {

    private Menu tela;
    private Cliente cliente;

    public VoltarPagamento(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente = cliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.painelPagamento.setVisible(false);
        tela.repaint();
        tela.menuOpcoes(cliente);
    }
}
