/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package io.github.brunoyillli.operacoesrequest.ejb;

import io.github.brunoyillli.operacoesrequest.data.Soma;
import io.github.brunoyillli.operacoesrequest.rs.SomaRestClient;
import jakarta.ejb.Stateless;
import java.util.ArrayList;

/**
 *
 * @author wolft
 */
@Stateless
public class EjbSoma {

      SomaRestClient somaRestClient;

    public EjbSoma() {
        somaRestClient = new SomaRestClient();
    }

    public ArrayList<Soma> getAll(){
        return somaRestClient.getAllSomas();
    }

    public int add(int operador1, int operador2){
        return somaRestClient.somar(operador1, operador2);
    }

    public Soma add(Soma soma){
        return somaRestClient.somar(soma);
    }
}
