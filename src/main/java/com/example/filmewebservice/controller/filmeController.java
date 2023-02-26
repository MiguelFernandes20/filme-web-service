package com.example.filmewebservice.controller;

import com.example.filmewebservice.model.entites.filme;
import com.example.filmewebservice.model.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("filme")
public class filmeController {

    @Autowired
    private FilmeService filmeservice;

    @GetMapping("ola")
    public String olamundo(){
        return "Olá Mundo";
    }

    @GetMapping
    public ResponseEntity<List <filme>>buscaTodosFilmes() {
        List<filme> filmes = filmeservice.buscaTodos();
        return ResponseEntity.status(HttpStatus.OK).body(filmes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<filme> buscaPorId(@PathVariable Long id){
        filmeservice.buscaPorId(id);
        filme filme = filmeservice.buscaPorId(id);
        return filme == null? ResponseEntity.status(HttpStatus.NO_CONTENT).build():  ResponseEntity.status(HttpStatus.OK).body(filme);

    }


}
