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

import com.hearthstone.model.Baralho;
import com.hearthstone.model.Carta;
import com.hearthstone.model.Classe;

@Path("/baralho")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BaralhoResource {

    @GET
    public List<Baralho> listAll() {
        return Baralho.listAll();
    }

    @Transactional
    @POST
    public Baralho add(@Valid Baralho baralho) {
        Baralho.persist(baralho);
        return baralho;
    }

    @Transactional
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Baralho.deleteById(id);
    }

    @GET
    @Path("{id}/cartas")
    public List<Carta> getCartas(@PathParam("id") Long id) {
        Baralho baralho = Baralho.findById(id);
        return baralho.cartas;
    }

    @GET
    @Path("q")
    public List<Baralho> getByAttributes(@QueryParam("nome") String nome, @QueryParam("classe") String classe) {
        if (nome != null) {
            return Baralho.list("nome", nome);
        } else if (classe != null) {
            return Baralho.list("classe", Classe.valueOf(classe));
        } else {
            return null;
        }

    }

    @GET
    @Path("{id}")
    public Baralho getById(@PathParam("id") Long id) {
        return Baralho.findById(id);
    }

}