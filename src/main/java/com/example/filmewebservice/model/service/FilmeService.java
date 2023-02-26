package com.example.filmewebservice.model.service;

import com.example.filmewebservice.model.entites.filme;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class FilmeService {

    private  List<filme> filmes = Arrays.asList(
            new filme( 1L, "Jogos Vorazes", "Susan Colins" ),
            new filme(2L, "Harry Potter", "JK Rolling"));


    public List<filme> buscaTodos() {
        return filmes;
    }

    public filme buscaPorId(Long id) {
        for (filme filme: filmes){
            if (filme.getId() == id)
                return filme;
        }
        return null;
    }
}
