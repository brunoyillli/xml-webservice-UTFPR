/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brunoyillli.clientesrest.rs;

import io.github.brunoyillli.clientesrest.entity.Cidade;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author wolft
 */
public class CidadeRestClient {
    
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = 
            "http://overleaf.cp.utfpr.edu.br/RCidades/resources/";
    
    public CidadeRestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("cidades");
    }
    
    public List<Cidade> getAllCidades() throws ClientErrorException{
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            List<Cidade> listCidade = 
                    response.readEntity(new GenericType<List<Cidade>>() {
            });
            return listCidade;
        } else {
            String errorMessage = response.readEntity(String.class);
            throw new RuntimeException("Falha na requisição: "
                    + response.getStatus() + " " + errorMessage);
        }
    }
}
