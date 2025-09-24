package com.paulo.todo_app.service;

import com.paulo.todo_app.model.Tarefa;
import com.paulo.todo_app.model.TarefaConcluida;
import com.paulo.todo_app.repository.TarefaHistoryRepository;
import com.paulo.todo_app.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaHistoryService {
    private final TarefaHistoryRepository repository;

    public TarefaHistoryService(TarefaHistoryRepository tarefaRepository){
        this.repository = tarefaRepository;
    }

    @Transactional
    public List<TarefaConcluida> getHistorico(){
        return repository.findAll();
    }
}
