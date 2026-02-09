package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.Datos;
import com.aluracursos.desafio.model.DatosPersonajes;
import com.aluracursos.desafio.service.ConsumoAPI;
import com.aluracursos.desafio.service.ConvierteDatos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {

    private static final String URL_BASE = "https://genshin.jmp.blue/characters";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    ObjectMapper mapper = new ObjectMapper();

    public void muestraElMenu() throws JsonProcessingException {
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        List<String> datos = mapper.readValue(json, new TypeReference<List<String>>() {});
        System.out.println(datos);
    }
}
