/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.servicesexecutor;

import client.dao.generic.GenericDAO;
import client.domain.Client;
import clientstable.IObserver;
/**
 *
 * @author lheop
 */
public class ClientServiceExecutor extends GenericDAO<Client>{

    public ClientServiceExecutor() {
        super();
    }
    /*
    *    Diz qual a classe para o banco de dados.
    */
    @Override
    public Class<Client> getClassType() {
        return Client.class;
    }
    
    private static IObserver iObserver;
    /*
    *    Faz a injeção de dependência do observer
    *    sem que meu ClientServiceExecutor tenha necessidade de saber da interface.
    */
    public void attach(IObserver iObserver) {
        this.iObserver = iObserver;
    }
    /*
    *    Responsável chamar o método que cria o cliente, e enviar o sinal que ele foi criado.
    */
    public void create(Client client) {
        
        mapCreate(client);
        
        if (iObserver != null) {
            iObserver.created(client);
        }
    }
    //Busca e retorna o cliente para quem fez a chamada
    public Client read(String cpf) {return  mapRead(cpf);}

    /*
    *    Recebe o cpf para buscar e salvar o cliente antigo, depois recebe o cliente novo
    *        faz a substituição peganos o cliente antigo e fazendo um setter nas informações pedidas
    /        MENOS o cpf, que é o ID principal e NUNCA deve ser mudado.
    */
    public void update(String cpf, Client client) {
        
        Client oldClient = mapRead(cpf);
        oldClient.setNome(client.getNome());
        oldClient.setEmail(client.getEmail());
        oldClient.setEnd(client.getEnd());
        oldClient.setNum(client.getNum());
        oldClient.setCel(client.getCel());
        
        mapUpdate(cpf, client);
        
        if (iObserver != null) {
            iObserver.updated(oldClient);
        }
    }
    /*
    *    Faz a busca do cliente pelo cpf, depois chama o método de exclusão.
    */
    public void delete(String cpf) {
        
        var client = mapRead(cpf);
        
        mapDelete(client);
        
        if (iObserver != null) {
            iObserver.deleted(client);
        }
    }
}
