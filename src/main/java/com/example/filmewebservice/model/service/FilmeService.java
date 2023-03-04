// Define o pacote onde a classe FilmeService será armazenada
package com.example.filmewebservice.model.service;

// Importa a classe filme do pacote com.example.filmewebservice.model.entites
import com.example.filmewebservice.model.entites.filme;

// Indica que essa classe é um serviço gerenciado pelo Spring
import org.springframework.stereotype.Service;

// Importa a classe Array da biblioteca padrão Java
import java.lang.reflect.Array;

// Importa a classe List da biblioteca padrão Java
import java.util.ArrayList;
import java.util.List;

// Importa a classe Arrays da biblioteca padrão Java
import java.util.Arrays;

// Define a classe FilmeService
@Service
public class FilmeService {

    // Cria uma lista imutável de filmes
    private  List<filme> filmes = new ArrayList<>();

    // Método que retorna todos os filmes
    public List<filme> buscaTodos() {
        return filmes;
    }

    // Método que busca um filme por id
    public filme buscaPorId(Long id) {
        // Itera sobre a lista de filmes
        for (filme filme: filmes){
            // Se o id do filme atual for igual ao id informado, retorna o filme
            if (filme.getId() == id)
                return filme;
        }
        // Se não encontrou um filme com o id informado, retorna null
        return null;
    }

    public filme criaFilme(filme filme) {
        Long id;
        if (filmes.isEmpty())
            id = 1L;
        else
            id = filmes.get(filmes.size() -1).getId() + 1;
        filme.setId(id);

        filmes.add(filme);
        return filme;
    }

    public void deleteFilme(Long id) {
        filme filme = buscaPorId(id);
        filmes.remove(filme);
    }
}
