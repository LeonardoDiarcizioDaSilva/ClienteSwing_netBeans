/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.dao;

import cliente.domain.Cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

/**
 *
 * @author lheop
 */
public class ClienteMapDAO implements IClienteDAO{

    private Map<String, Cliente> map;
    
    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }
    
    public boolean cadastrar (Cliente cliente) {
        
        if (map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }
    
    public void excluir (String cpf) {
        
        this.map.remove(cpf);
    }
    
    public void alterar (Cliente cliente) {
        
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        
        if (clienteCadastrado != null) {
            
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setCpf(cliente.getCpf());
            clienteCadastrado.setCel(cliente.getCel());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setNum(cliente.getNum());
            clienteCadastrado.setEmail(cliente.getEmail());    
            
            this.map.remove(cliente.getCpf());
            this.map.put(cliente.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public Cliente consultar (String cpf) {
        
        return this.map.get(cpf);
    }
    
    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
    
    public Collection<String> buscarTodosString () {
        
        Map<String, String> m1 = (Map) this.map.values();
        return m1.values();
    }
}
