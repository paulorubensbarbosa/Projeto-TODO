package com.paulo.todo_app.service;

import com.paulo.todo_app.model.Tarefa;
import com.paulo.todo_app.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository repository;
    private final PLService plService;

    public TarefaService(TarefaRepository repository, PLService plService){
        this.repository = repository;
        this.plService = plService;
    }

    @Transactional
    public Tarefa criar(Tarefa tarefa){
        LocalDate data = tarefa.getDataLimite();
        plService.validarDataLimite(data);

        tarefa.setStatus("PENDENTE");
        return repository.save(tarefa);
    }

    public List<Tarefa> listarTodas(){
        return repository.findAll();
    }

    @Transactional
    public void concluir(Long id){
        Tarefa tf = repository.findById(id).orElseThrow();
        tf.setStatus("CONCLUIDA");
        repository.save(tf);

        repository.flush();

        plService.moverTarefaConcluida(tf.getId());
    }

    @Transactional
    public void deletar(){
        repository.deleteAll();
    }

}
