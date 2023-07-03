package io.github.brunoyillli.operacoesprovider.resources;

import io.github.brunoyillli.operacoesprovider.entity.Soma;
import io.github.brunoyillli.operacoesprovider.repository.SomaRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import lombok.NoArgsConstructor;

/**
 *
 * @author
 */
@Path("rest")
@NoArgsConstructor
public class SomaResource {

    @POST
    @Path("somar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Soma somatoria(Soma soma) {
        soma.setResultado(soma.getOperador1().add(soma.getOperador2()));
        new SomaRepository().add(soma);
        return soma;
    }
    
    @POST
    @Path("somar/{operador1}/{operador2}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Integer add(
            @PathParam("operador1") int operador1,
            @PathParam("operador2") int operador2){
        Soma soma = new Soma();
        soma.setOperador1(BigDecimal.valueOf(operador1));
        soma.setOperador2(BigDecimal.valueOf(operador2));
        soma.setResultado(soma.getOperador1().add(soma.getOperador2()));
        new SomaRepository().add(soma);
        return soma.getResultado().intValue();
    }

    @GET
    @Path("somas")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Soma> getAllSomas() {
        ArrayList<Soma> listSoma = new SomaRepository().getAll();
        return listSoma;
    }
}
