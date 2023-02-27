// Define o pacote onde a classe filme será armazenada
package com.example.filmewebservice.model.entites;

// Importa a biblioteca Lombok para gerar getters, setters e outros métodos automaticamente
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

// Adiciona as anotações Lombok para gerar automaticamente getters, setters, construtor com todos os campos e outros métodos úteis
@Data
@AllArgsConstructor

// Define a classe filme
public class filme {
    // Define os campos da classe filme, incluindo o ID, o título e o autor do filme
    private long id;
    private String titulo;
    private String autor;

}