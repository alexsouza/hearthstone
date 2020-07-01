package com.hearthstone.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Baralho extends PanacheEntity {
    public String nome;

    @Enumerated(EnumType.STRING)
    public Classe classe;

    @ManyToMany
    @Size(min = 0, max = 30, message = "Máximo de 30 cartas permitido")
    public List<Carta> cartas;
}