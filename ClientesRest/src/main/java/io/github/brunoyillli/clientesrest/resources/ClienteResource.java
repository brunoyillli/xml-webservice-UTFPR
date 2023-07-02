/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brunoyillli.clientesrest.resources;

import io.github.brunoyillli.clientesrest.ejb.EjbCliente;
import io.github.brunoyillli.clientesrest.entity.Cliente;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import lombok.NoArgsConstructor;

/**
 *
 * @author wolft
 */
@Path("cliente")
@NoArgsConstructor
public class ClienteResource {

    @Inject
    private EjbCliente ejbCliente;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClientes() {
        List<Cliente> listCliente = ejbCliente.findAll();
        return Response.status(Status.OK).entity(listCliente).build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteByCodigo(@PathParam("codigo") int codigo) {
        Cliente cliente = ejbCliente.findByCodigo(codigo);
        if (cliente != null) {
            return Response.status(Status.OK).entity(cliente).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarCliente(Cliente cliente) {
        ejbCliente.addCliente(cliente);
        return Response.status(Status.CREATED).build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterarCliente(Cliente cliente) {
        ejbCliente.putCliente(cliente);
        return Response.status(Status.OK).build();

    }

    @DELETE
    @Path("/{codigo}")
    public Response deletarCliente(@PathParam("codigo") int codigo) {
        ejbCliente.removeClienteByCodigo(codigo);
        return Response.status(Status.NO_CONTENT).build();

    }
}
