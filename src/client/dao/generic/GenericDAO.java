/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.dao.generic;

import client.domain.Persistent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lheop
 */
public abstract class GenericDAO<T extends Persistent> implements IGenericDAO<T>{
    
    protected Map<Class, Map<String, T>> map;
    
    public GenericDAO() {
        
        this.map = new HashMap();
        
        Map<String, T> internalMap = this.map.get(getClassType());
        if(internalMap == null) {
            internalMap = new HashMap();
            this.map.put(getClassType(), internalMap);
        }
    }
    
    public abstract Class<T> getClassType();
    @Override
    public boolean mapCreate(T entity) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        if(internalMap.containsKey(entity.getCode())) return false;
        internalMap.put(entity.getCode(), entity);
        return true;
    }
    
    @Override
    public T mapRead(T entity) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        if(!internalMap.containsKey(entity.getCode())) return null;
        return entity;
    }
    
    @Override
    public boolean mapUpdate(T entity) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        if(!internalMap.containsKey(entity.getCode())) return false;
        
        internalMap.remove(entity);
        internalMap.put(entity.getCode(), entity);
        
        return true;
    }
    
    @Override
    public void mapDelete(T entity) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        internalMap.remove(entity.getCode(), entity);
    }
    
    @Override
    public T getEntity(String code) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        return internalMap.get(code);
    }
}
