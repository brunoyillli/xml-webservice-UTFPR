package io.github.brunoyillli.petshopxmlwebconf.data.domain;

import jakarta.xml.bind.annotation.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author wolft
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Animal", propOrder = {
    "nome",
    "especie",
    "raca",
    "genero",
    "dataNascimento"
})
@Getter
@Setter
public class Animal {

    @XmlElement(required = true)
    protected String nome;

    @XmlElement(required = true)
    protected String especie;

    @XmlElement(required = true)
    protected String raca;

    @XmlElement(required = true)
    protected String genero;

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date dataNascimento;

}
