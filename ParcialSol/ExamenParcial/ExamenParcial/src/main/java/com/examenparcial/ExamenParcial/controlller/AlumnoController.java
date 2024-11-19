package com.examenparcial.ExamenParcial.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenparcial.ExamenParcial.model.Alumno;
import com.examenparcial.ExamenParcial.service.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public List<Alumno> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public Alumno guardar(@RequestBody Alumno alumno) {
        return service.guardar(alumno);
    }

    @PutMapping("/{id}")
    public Alumno actualizar(@PathVariable Integer id, @RequestBody Alumno alumno) {
        Alumno existente = service.obtenerPorId(id);
        existente.setNombre(alumno.getNombre());
        existente.setNota(alumno.getNota());
        return service.guardar(existente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
