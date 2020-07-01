package com.hearthstone.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Carta extends PanacheEntity {

    public String nome;
    public String descricao;

    @Min(value = 0, message = "Valor deve ser entre 0 e 10")
    @Max(value = 10, message = "Valor deve ser entre 0 e 10")
    public Integer ataque;

    @Min(value = 0, message = "Valor deve ser entre 0 e 10")
    @Max(value = 10, message = "Valor deve ser entre 0 e 10")
    public Integer defesa;

    @Enumerated(EnumType.STRING)
    public Tipo tipo;

    @Enumerated(EnumType.STRING)
    public Classe classe;
}