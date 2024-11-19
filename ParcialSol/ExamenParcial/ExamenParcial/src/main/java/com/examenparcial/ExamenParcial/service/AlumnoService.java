package com.examenparcial.ExamenParcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenparcial.ExamenParcial.model.Alumno;
import com.examenparcial.ExamenParcial.repository.AlumnoRepository;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    public List<Alumno> listar() {
        return repository.findAll();
    }

    public Alumno obtenerPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
    }

    public Alumno guardar(Alumno alumno) {
        return repository.save(alumno);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
