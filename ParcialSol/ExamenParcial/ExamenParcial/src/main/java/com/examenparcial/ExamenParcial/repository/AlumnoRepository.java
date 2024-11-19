package com.examenparcial.ExamenParcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenparcial.ExamenParcial.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}