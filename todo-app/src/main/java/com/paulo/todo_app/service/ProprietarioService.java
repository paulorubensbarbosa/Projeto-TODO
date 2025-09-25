package com.paulo.todo_app.service;

import com.paulo.todo_app.model.Proprietario;
import com.paulo.todo_app.repository.ProprietarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {

    private final ProprietarioRepository repository;

    public ProprietarioService(ProprietarioRepository repository){
        this.repository = repository;
    }

    public Proprietario criarProprietario (Proprietario proprietario){
        return repository.save(proprietario);
    }



}
