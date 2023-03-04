// Define o pacote onde a classe filmeController será armazenada
package com.example.filmewebservice.controller;

// Importa a classe "filme" do pacote "model.entites"
import com.example.filmewebservice.model.entites.filme;

// Importa a classe "FilmeService" do pacote "model.service"
import com.example.filmewebservice.model.service.FilmeService;

// Importa a classe "Autowired" do framework Spring
import org.springframework.beans.factory.annotation.Autowired;

// Importa a classe "HttpStatus" do framework Spring
import org.springframework.http.HttpStatus;

// Importa a classe "ResponseEntity" do framework Spring
import org.springframework.http.ResponseEntity;

// Importa a classe "GetMapping" do framework Spring
import org.springframework.web.bind.annotation.*;

// Importa a classe "PathVariable" do framework Spring

// Importa a classe "RequestMapping" do framework Spring

// Importa a classe "RestController" do framework Spring

// Importa a classe "List" do pacote java.util
import java.util.List;

// Define que a classe filmeController é um controlador REST
@RestController

// Define o caminho raiz dos endpoints dessa classe
@RequestMapping("filme")
public class filmeController {
    // Injeta a dependência do objeto FilmeService
    @Autowired
    private FilmeService filmeservice;

    // Mapeia o endpoint "/ola" para o método olamundo()
    @GetMapping("ola")
    public String olamundo(){
        return "Olá Mundo";
    }

    // Mapeia o endpoint raiz para o método buscaTodosFilmes() e retorna uma lista de filmes
    @GetMapping
    public ResponseEntity<List <filme>>buscaTodosFilmes() {

        // Chama o método "buscaTodos()" do objeto filmeservice e armazena o resultado na variável "filmes"
        List<filme> filmes = filmeservice.buscaTodos();

        // Retorna a lista de filmes dentro de uma ResponseEntity com o status "OK"
        return ResponseEntity.status(HttpStatus.OK).body(filmes);
    }

    // Mapeia o endpoint "/{id}" para o método buscaPorId() e retorna um filme com base no id passado como parâmetro
    @GetMapping("/{id}")
    public ResponseEntity<filme> buscaPorId(@PathVariable Long id){

        // Chama o método "buscaPorId()" do objeto filmeservice com o id passado como parâmetro
        filmeservice.buscaPorId(id);

        // Chama o método "buscaPorId()" do objeto filmeservice com o id passado como parâmetro e armazena o resultado na variável "filme"
        filme filme = filmeservice.buscaPorId(id);

        // Se a variável "filme" for nula, retorna uma ResponseEntity com o status "NO_CONTENT"
        // Caso contrário, retorna uma ResponseEntity com o filme encontrado e o status "OK"
        return filme == null? ResponseEntity.status(HttpStatus.NO_CONTENT).build():  ResponseEntity.status(HttpStatus.OK).body(filme);
    }

    @PostMapping
    public ResponseEntity<filme>criafilme(@RequestBody filme filme){
        filme filmeSalvo = filmeservice.criaFilme(filme);
        return  ResponseEntity.status(HttpStatus.CREATED).body(filmeSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFilme(@PathVariable Long id){
        filmeservice.deleteFilme(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}