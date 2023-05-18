package io.github.brunoyillli.petshopxmlwebconf.ejb;

import io.github.brunoyillli.petshopxmlwebconf.data.domain.Animais;
import io.github.brunoyillli.petshopxmlwebconf.data.domain.Animal;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.ejb.Stateless;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wolft
 */
@Stateless
public class EjbAnimalImpl implements EjbAnimal {

    private Animais animais = new Animais();
    private List<Animal> listAnimal = new ArrayList<>();

    @Override
    public void lerXML() throws JAXBException {
        File file = createXmlDir();
        JAXBContext jaxbContext = JAXBContext.newInstance(Animais.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Animais animaisFile = (Animais) jaxbUnmarshaller.unmarshal(file);

        for (Animal animal : animaisFile.getAnimal()) {
            System.out.println(animal.getNome());
            System.out.println(animal.getRaca());
            System.out.println(animal.getGenero());
            System.out.println(animal.getEspecie());
            System.out.println(animal.getDataNascimento());
        }
    }

    @Override
    public void escreverXML() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Animais.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        File file = createXmlDir();

        jaxbMarshaller.marshal(animais, file);
        System.out.println("O arquivo XML foi gerado neste caminho: "
                + System.getProperty("user.dir") + "/petshop/resources/xml/");
    }

    private File createXmlDir() {
        File directory = new File(
                System.getProperty("user.dir") + "/petshop/resources/xml/");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return new File(directory, "animais.xml");
    }

    @Override
    public void adicionarAnimal(Animal animal) {

        listAnimal.add(animal);
        animais.setAnimal(listAnimal);
    }

}
