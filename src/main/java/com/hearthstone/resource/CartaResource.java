package com.hearthstone.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hearthstone.model.Carta;
import com.hearthstone.model.Classe;
import com.hearthstone.model.Tipo;

@Path("/carta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartaResource {

    @Transactional
    @POST
    public Carta add(@Valid Carta carta) {
        Carta.persist(carta);
        return carta;
    }

    @Transactional
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Carta.deleteById(id);
    }

    @GET
    @Path("{id}")
    public Carta getById(@PathParam("id") Long id) {
        return Carta.findById(id);
    }

    @GET
    @Path("q")
    public List<Carta> getByAttributes(@QueryParam("nome") String nome, @QueryParam("classe") String classe,
            @QueryParam("tipo") String tipo) {
        if (nome != null) {
            return Carta.list("nome", nome);
        } else if (classe != null) {
            return Carta.list("classe", Classe.valueOf(classe));
        } else if (tipo != null) {
            return Carta.list("tipo", Tipo.valueOf(tipo));
        } else {
            return null;
        }

    }

    @GET
    public List<Carta> listAll() {
        return Carta.listAll();
    }

}