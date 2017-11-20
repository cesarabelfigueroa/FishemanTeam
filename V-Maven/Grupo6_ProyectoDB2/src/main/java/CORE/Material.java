/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CORE;

/**
 *
 * @author Agile
 */
public class Material {
    private String id;
    private String name;
    private char type;

    public Material(String id, String name, char type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Material(String name, char type) {
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
