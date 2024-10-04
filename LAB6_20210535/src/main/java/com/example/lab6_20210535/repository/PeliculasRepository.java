package com.example.lab6_20210535.repository;

import com.example.lab6_20210535.entity.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasRepository extends JpaRepository<Peliculas, Integer> {


}
