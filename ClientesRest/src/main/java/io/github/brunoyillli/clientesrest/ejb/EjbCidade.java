/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package io.github.brunoyillli.clientesrest.ejb;

import io.github.brunoyillli.clientesrest.entity.Cidade;
import io.github.brunoyillli.clientesrest.rs.CidadeRestClient;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author wolft
 */
@Stateless
public class EjbCidade {

    CidadeRestClient cidadeRestClient;
    
    public EjbCidade(){
        cidadeRestClient = new CidadeRestClient();
    }
    
    public List<Cidade> getAll(){
        return  cidadeRestClient.getAllCidades();
    }
}
