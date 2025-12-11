/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.domain;

import java.util.Objects;

/**
 *
 * @author lheop
 */
public class Client {
    
    private String nome;
    private String cpf;
    private String celular;
    private String endereco;
    private String numero;
    private String email;
    
    public Client (String nome, String cpf, String email, String endereco, String numero, String celular) {
        
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.numero = numero;
        this.celular = celular;
    }
    
    public String getNome () {
        return nome;
    }
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public String getCpf () {
        return cpf;
    }
    public void setCpf (String cpf) {
        this.cpf = cpf;
    }
    
    public String getCel () {
        return celular;
    }
    public void setCel (String celular) {
        this.celular = celular;
    }
    
    public String getEnd () {
        return endereco;
    }
    public void setEnd (String endereco) {
        this.endereco = endereco;
    }
    
    public String getNum () {
        return numero;
    }
    public void setNum (String numero) {
        this.numero = numero;
    }
    
    public String getEmail () {
        return email;
    }
    public void setEmail (String email) {
        this.email = email;
    }
    
    @Override
    public boolean equals (Object o) {
      
        if (o == null) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client cliente = (Client) o;
        return Objects.equals (cpf, cliente.getCpf());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
    
    @Override
    public String toString() {
        return "Cliente{ " +
                "nome = '" + nome + '\'' +
                ", cpf = " + cpf +
                '}';
    }
}
