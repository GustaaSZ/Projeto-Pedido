package composicao.exercicioFixacao.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    // Objeto de formatação de data
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Atributos
    private String nome;
    private String email;
    private Date dataNascimento;
    
    // Construtores
    public Client(String nome, String email, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
    public Client(){

    }

    // Encpsulamento dos atributos
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String toString(){
        return nome + ", ("+sdf.format(dataNascimento) + "), "+email;
    }
    
}
