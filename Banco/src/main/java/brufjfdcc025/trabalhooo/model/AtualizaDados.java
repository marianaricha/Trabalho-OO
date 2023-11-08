package brufjfdcc025.trabalhooo.model;

import brufjfdcc025.trabalhooo.ViweControl.Menu;
import brufjfdcc025.trabalhooo.Arquivo.Arquivo;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.JOptionPane;

public class AtualizaDados implements WindowListener {

    private Menu tela;
    private List<Cliente> clientes;
    private static final String  Dados = "Dados.txt";

    public AtualizaDados(Menu tela, List<Cliente> clientes) {
        this.tela = tela;
        this.clientes = clientes;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try {
            clientes = Arquivo.lerArquivo(Dados);
            tela.setClientes(clientes);
            tela.repaint();
            
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(tela, "Não foi possível ler os dados!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            List<Cliente> clientes = tela.getClientes();
            Arquivo.escreverArquivo(Dados, clientes);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tela, "Deu ruim!", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
