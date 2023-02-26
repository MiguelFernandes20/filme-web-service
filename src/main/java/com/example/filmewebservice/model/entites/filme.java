package com.example.filmewebservice.model.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class filme {
    private long id;
    private String titulo;
    private String autor;


}
