package brufjfdcc025.trabalhooo.model;

public abstract class Cliente {
    private String senha;
    private String telefone, nome;
    private Endereco endereco;
    private Conta conta;
    private float divida = 0f;
    private Data dataemprestimo;


    public Cliente(String senha, String telefone, String nome) {
        this.senha = senha;
        this.telefone = telefone;
        this.nome = nome;
        this.conta = new Conta();
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Conta getConta() {
        return conta;
    }
    
    public float getDivida() {
        return divida;
    }

    public void setDivida(float divida) {
        this.divida = divida;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataemprestimo() {
        return dataemprestimo;
    }

    public void setDataemprestimo(Data dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }
    

    @Override
    public String toString() {
        return "Nome: "+this.nome +"\nTelefone: "+this.telefone +
                "\nConta: "+this.conta.toString()+
                "\nEndereço: "+this.endereco.toString();
    }
    
    public abstract String getTipo();
}
