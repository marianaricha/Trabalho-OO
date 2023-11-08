package brufjfdcc025.trabalhooo.model;

import brufjfdcc025.trabalhooo.ViweControl.Menu;
import java.util.List;
import java.util.ArrayList;

/*
        Trabalho de Orientação a Objetos
    Alunos: Gabriel Evaristo,
            Israel Louback,
            Mariana Richa
 */
public class Banco {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>(); //conjunto de clientes 

        Menu tela = new Menu(clientes);
        tela.mostraMenu();
    }
}
