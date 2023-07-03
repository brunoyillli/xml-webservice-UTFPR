/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brunoyillli.operacoesrequest.rs;

import io.github.brunoyillli.operacoesrequest.data.Soma;
import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

/**
 *
 * @author wolft
 */
public class SomaRestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/OperacoesProvider/resources/";

    public SomaRestClient() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rest");
    }

    public int somar(int operacao1, int operacao2) throws ClientErrorException {
        Response response = webTarget.path("somar")
                .path("/" + operacao1 + "/" + operacao2)
                .request().post(Entity.entity("", MediaType.APPLICATION_JSON));
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            int resultado = response.readEntity(Integer.class);
            return resultado;
        } else {
            String errorMessage = response.readEntity(String.class);
            throw new RuntimeException("Falha na requisição: "
                    + response.getStatus() + " " + errorMessage);
        }
    }

    public ArrayList<Soma> getAllSomas() throws ClientErrorException {
        Response response = webTarget.path("somas")
                .request(MediaType.APPLICATION_JSON)
                .get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            ArrayList<Soma> listSoma = response.readEntity(new GenericType<ArrayList<Soma>>() {
            });
            return listSoma;
        } else {
            String errorMessage = response.readEntity(String.class);
            throw new RuntimeException("Falha na requisição: "
                    + response.getStatus() + " " + errorMessage);
        }
    }

    public Soma somar(Soma somar) throws ClientErrorException {

        Response response = webTarget.path("somar")
                .request()
                .post(Entity.entity(somar, MediaType.APPLICATION_JSON));
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            Soma resultado = response.readEntity(Soma.class);
            return resultado;
        } else {
            String errorMessage = response.readEntity(String.class);
            throw new RuntimeException("Falha na requisição: "
                    + response.getStatus() + " " + errorMessage);
        }
    }

}
