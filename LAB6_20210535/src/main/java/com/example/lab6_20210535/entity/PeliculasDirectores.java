package com.example.lab6_20210535.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="peliculas_directores")
public class PeliculasDirectores {
    @ManyToOne
    @JoinColumn(name="peliculaid")
    private Peliculas peliculas;

    @ManyToOne
    @JoinColumn(name="directorid")
    private Directores directores;
}
