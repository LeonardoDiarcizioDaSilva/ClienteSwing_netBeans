/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.servicesexecutor.Exception;

/**
 *
 * @author lheop
 */
public class EntityAlredyExistsException extends Exception{
    
    public EntityAlredyExistsException() {
        super(" já esta cadastrado!");
    }
    
    public EntityAlredyExistsException(String msg) {
        super(msg);
    }
}
