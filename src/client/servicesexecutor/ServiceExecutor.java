/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.servicesexecutor;

import client.dao.generic.IGenericDAO;
import client.domain.Persistent;
import clientregisterswing.RegisterInterface;

/**
 *
 * @author lheop
 */
public abstract class ServiceExecutor<T extends Persistent>{
    
    public IGenericDAO<T> iGenericDAO;
    public static RegisterInterface registerInterface;
    
    public ServiceExecutor(IGenericDAO dao) {
        iGenericDAO = dao;
    }
    public static void setInterface(RegisterInterface view) {
        registerInterface = view;
    }
    
    protected T entity;
    
    public boolean validator(String code) {
        
        this.entity = iGenericDAO.getEntity(code);
        return this.entity != null;
    }
    
    public T getEntity() {
        return this.entity;
    }
    
    protected abstract boolean create(T entity);
    protected abstract T read(String code);
    protected abstract boolean update(T entity);
    protected abstract boolean delete(String code);
}
