/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package io.github.brunoyillli.petshopxmlwebconf.jsf;

import io.github.brunoyillli.petshopxmlwebconf.data.domain.Animal;
import io.github.brunoyillli.petshopxmlwebconf.ejb.EjbAnimal;
import jakarta.xml.bind.JAXBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author wolft
 */
@Named(value = "jsfAnimal")
@SessionScoped
public class JsfAnimal implements Serializable {

    @EJB
    private EjbAnimal ejbAnimal;
    private Animal animal = new Animal();

    public JsfAnimal() {
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void lerXML() {
        try {
            ejbAnimal.lerXML();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void escreverXML() {
        try {
            ejbAnimal.escreverXML();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    public void adicionarAnimal() {
        ejbAnimal.adicionarAnimal(animal);
        animal = new Animal();
    }

}
