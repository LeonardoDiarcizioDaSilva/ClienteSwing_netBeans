/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.domain;

import java.util.Objects;

/**
 *
 * @author lheop
 */
public class Cliente {
    
    private String nome;
    private String cpf;
    private String celular;
    private String endereco;
    private String numero;
    private String email;
    
    public Cliente (String nome, String cpf, String email, String endereco, String numero, String celular) {
        
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
        Cliente cliente = (Cliente) o;
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
