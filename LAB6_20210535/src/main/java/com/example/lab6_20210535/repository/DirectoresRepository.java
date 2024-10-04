package com.example.lab6_20210535.repository;

import com.example.lab6_20210535.entity.Directores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoresRepository extends JpaRepository<Directores, Integer> {
}
