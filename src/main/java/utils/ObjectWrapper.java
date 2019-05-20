/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author CMQ
 * @param <T>
 */
public class ObjectWrapper<T> {
    private T object;

    public ObjectWrapper(T object) {
        this.object = object;
    }

    public ObjectWrapper() {
    }

    /**
     * Get the value of object
     *
     * @return the value of object
     */
    public T getObject() {
        return object;
    }

    /**
     * Set the value of object
     *
     * @param object new value of object
     */
    public void setObject(T object) {
        this.object = object;
    }
}
