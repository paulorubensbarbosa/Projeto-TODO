package com.paulo.todo_app.service;

import com.paulo.todo_app.dto.ProprietarioRequest;
import com.paulo.todo_app.dto.ProprietarioResponse;
import com.paulo.todo_app.mapper.ProprietarioMapper;
import com.paulo.todo_app.model.Proprietario;
import com.paulo.todo_app.repository.ProprietarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {

    private final ProprietarioRepository repository;
    private final ProprietarioMapper proprietarioMapper;

    public ProprietarioService(ProprietarioRepository repository, ProprietarioMapper proprietarioMapper){
        this.repository = repository;
        this.proprietarioMapper = proprietarioMapper;
    }

    public ProprietarioResponse criarProprietario (ProprietarioRequest proprietario){
        Proprietario p = proprietarioMapper.toEntity(proprietario);
        return proprietarioMapper.toResponse(repository.save(p));
    }



}
