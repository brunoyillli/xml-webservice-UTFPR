/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package io.github.brunoyillli.operacoesrequest.jsf;

import io.github.brunoyillli.operacoesrequest.data.Soma;
import io.github.brunoyillli.operacoesrequest.ejb.EjbSoma;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author wolft
 */
@Named(value = "jsfSoma")
@RequestScoped
public class jsfSoma {
    
    @EJB
    private EjbSoma ejbSoma;

    @Getter
    private int resultadoSoma;

    @Getter
    @Setter
    private int operador1;
    @Getter
    @Setter
    private int operador2;

    public jsfSoma() {
    }

    public ArrayList<Soma> getAll(){
        return ejbSoma.getAll();
    }

    public void somar(int operador1, int operador2){
        resultadoSoma = ejbSoma.add(operador1, operador2);
    }

    public void somar(Soma soma){
        ejbSoma.add(soma);
    }
    
}
