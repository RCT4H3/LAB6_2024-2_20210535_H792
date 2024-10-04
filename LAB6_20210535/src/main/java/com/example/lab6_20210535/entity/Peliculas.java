package com.example.lab6_20210535.entity;

import com.example.lab6_20210535.ValidationGroup.PeliculasValidationGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name="peliculas")
public class Peliculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="peliculaid",nullable=false)
    private Integer peliculaId;

    @Column(name="titulo")
    @NotBlank(message = "Debe ingresar un título", groups = {PeliculasValidationGroup.class})
    @Size(min = 3, max = 100, message = "El título de la película debe tener entre 3 y 100 caracteres", groups = {PeliculasValidationGroup.class})
    private String titulo;

    @Column(name="fechaestreno")
    @NotBlank(message = "Debe ingresar una fecha de estreno", groups = {PeliculasValidationGroup.class})
    //@PastOrPresent(message = "La fecha de estreno debe ser en el presente o pasado", groups = {PeliculasValidationGroup.class})
    private String fechaEstreno;

    @Column(name="duracionminutos")
    @Positive(message = "La duración de la película debe ser un número positivo", groups = {PeliculasValidationGroup.class})
    @NotBlank(message = "Debe ingresar la duración de la película", groups = {PeliculasValidationGroup.class})
    private Integer duracionMinutos;

}
