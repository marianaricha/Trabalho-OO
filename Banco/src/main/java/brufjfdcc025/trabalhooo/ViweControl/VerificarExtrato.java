package brufjfdcc025.trabalhooo.ViweControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import brufjfdcc025.trabalhooo.model.Cliente;
import brufjfdcc025.trabalhooo.model.Extrato;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class VerificarExtrato implements ActionListener{

    private final Menu tela;
    private Cliente cliente;
    private String[] colunas = {"Operação","Valor","Data"};
    private JTable tabela;
    private DefaultTableModel model;
    private List <Extrato> extrato;

    public VerificarExtrato(Menu tela, Cliente cliente) {
        this.tela = tela;
        this.cliente=cliente;
        this.extrato=cliente.getConta().getExtrato();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        tela.jpMenuOpcoes.setVisible(false);
        tela.painelExtrato = new JPanel();
        tela.painelExtrato.setVisible(true);
        tela.repaint();
        
        model =  new DefaultTableModel();
        model.addColumn(colunas[0]);
        model.addColumn(colunas[1]);
        model.addColumn(colunas[2]);
        
        tabela = new JTable(model);
                
        JScrollPane scroll = new JScrollPane(tabela);
        tela.painelExtrato.add(scroll);
        
        for(Extrato ex: extrato)    
            model.addRow(new Object[]{ ex.getTipo(), ex.getVal(), ex.getData()});
        
        tela.btnVoltar.addActionListener(new VoltarExtrato(tela, cliente));
        tela.painelExtrato.add(tela.btnVoltar, BorderLayout.SOUTH);//BOTAO VOLTAR 
        
        tela.add(tela.painelExtrato, BorderLayout.CENTER);
        tela.repaint();
    }
}
