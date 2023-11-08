package brufjfdcc025.trabalhooo.model;

public class PessoaFisica extends Cliente{
    private String nascimento,ocupacao,rg, cpf;
    
    public PessoaFisica(String cpf, String nascimento, String ocupacao, String rg, String telefone, String nome, String senha){
        super(senha, telefone, nome);
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.ocupacao = ocupacao;
        this.rg = rg;
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getOcupacao() {
        return ocupacao;
    }
    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }
    
    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    
   
    @Override
    public String toString() {
        return this.getTipo()+";"+this.getNome() +";"+this.getSenha()+";"+this.getTelefone() +";"+this.getCpf()+
                ";"+ this.getRg()+ ";" + this.getNascimento() + ";"+
                this.getOcupacao()+ ";"+this.getConta().toString()+
                ";"+this.getEndereco().toString();
    }

    @Override
    public String getTipo() {
        return "F";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
 
    
}
