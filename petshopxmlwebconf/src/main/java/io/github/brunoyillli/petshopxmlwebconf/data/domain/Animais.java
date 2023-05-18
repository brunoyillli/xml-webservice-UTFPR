package io.github.brunoyillli.petshopxmlwebconf.data.domain;

import jakarta.xml.bind.annotation.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author wolft
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Animais", propOrder = {
    "animal"
})
@XmlRootElement(name = "animais")
@Getter
@Setter
public class Animais {

    @XmlElement(required = true)
    protected List<Animal> animal;

}
