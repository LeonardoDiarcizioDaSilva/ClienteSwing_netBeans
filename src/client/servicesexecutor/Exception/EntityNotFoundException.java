/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.servicesexecutor.Exception;

/**
 *
 * @author lheop
 */
public class EntityNotFoundException extends Exception{
    
    public EntityNotFoundException() {
        super(" não foi encontrado!");
    }
    
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
