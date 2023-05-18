package io.github.brunoyillli.petshopxmlwebconf.ejb;

import io.github.brunoyillli.petshopxmlwebconf.data.domain.Animal;
import jakarta.xml.bind.JAXBException;
import javax.ejb.Local;

/**
 *
 * @author wolft
 */
@Local
public interface EjbAnimal {
    void lerXML() throws JAXBException;
    void escreverXML() throws JAXBException;
    void adicionarAnimal(Animal animal);
}
