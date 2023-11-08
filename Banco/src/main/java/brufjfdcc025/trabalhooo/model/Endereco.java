package brufjfdcc025.trabalhooo.model;

public class Endereco {
    private String cidade, rua, bairro, cep, complemento;
    private int numero;

    public Endereco(String cidade, String rua, String bairro, String cep, int numero, String complemento) {
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }
    
    public String getRua() {
        return rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return this.cidade+ ";" + this.rua + ";" + 
                this.bairro + ";" + this.cep + ";" + this.numero +
                ";" + this.complemento;
    }
}
