package brufjfdcc025.trabalhooo.model;

public class Data {
    private int mes, ano, dia;

    public int Diferenca(Data date){
        int dif=0;
        if(date.ano == this.ano){
            if(this.mes > date.mes)
                dif = this.mes - date.mes;
            else
                dif = date.mes - this.mes;
        }
        else if(date.ano > this.ano){
            int ano = this.ano;
            while(true){
                if(this.mes == date.mes){
                    dif = dif + (date.ano-this.ano)*12;
                    break;
                }
                if(this.mes==12){
                    this.mes = 0;
                    this.ano++;
                }
                dif++;
                this.mes++;
            }
        }
        else{
            while(true){
                if(this.mes == date.mes){
                    dif = dif + (this.ano - date.ano)*12;
                        break;
                }
                if(this.mes==1){
                    this.mes = 13;
                    this.ano--;
                }
                dif++;
                this.mes--;
            }
        }
        return dif;
    }
    
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    
}
