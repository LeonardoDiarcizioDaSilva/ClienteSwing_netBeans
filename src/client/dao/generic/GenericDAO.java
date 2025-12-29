/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.dao.generic;

import client.domain.GetCode;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author lheop
 */
public abstract class GenericDAO<T> implements IGenericDAO<T>{
    
    protected Map<Class, Map<String, T>> map;
    
    public GenericDAO() {
        
        this.map = new HashMap();
        
        Map<String, T> internalMap = this.map.get(getClassType());
        if(internalMap == null) {
            internalMap = new HashMap();
            this.map.put(getClassType(), internalMap);
        }
    }
    
    public String getCode(T entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field: fields) {
            if(field.isAnnotationPresent(GetCode.class)) {
                GetCode getId = field.getAnnotation(GetCode.class);
                try {
                    Method method = entity.getClass().getDeclaredMethod(getId.value());   
                    return (String) method.invoke(entity);
                } catch(NoSuchMethodException e) {
                    JOptionPane.showMessageDialog(null, "Erro para buscar, por favor contate o suporte.");
                    return null;
                } catch(IllegalAccessException | InvocationTargetException e) {
                    return null;
                }
            }
        }
        return null;
    }
    
    public abstract Class<T> getClassType();
    
    @Override
    public void mapCreate(T entity) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        internalMap.put(getCode(entity), entity);
    }
    
    @Override
    public T mapRead(String code) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        return internalMap.containsKey(code) ? internalMap.get(code) : null;
    }
    
    @Override
    public void mapUpdate(String code, T entity) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        internalMap.replace(code, entity);
    }
    
    @Override
    public void mapDelete(T entity) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        internalMap.remove(getCode(entity), entity);
    }
}
