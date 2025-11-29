/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cliente.dao;

import cliente.domain.Cliente;
import java.util.Collection;

/**
 *
 * @author lheop
 */
public interface IClienteDAO {
    
    public boolean cadastrar(Cliente cliente);
    
    public void excluir (String cpf);
    
    public void alterar (Cliente cliente);
    
    public Cliente consultar (String cpf);
    
    public Collection<Cliente> buscarTodos();
}
