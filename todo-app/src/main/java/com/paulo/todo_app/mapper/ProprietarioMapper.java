package com.paulo.todo_app.mapper;

import com.paulo.todo_app.dto.ProprietarioRequest;
import com.paulo.todo_app.dto.ProprietarioResponse;
import com.paulo.todo_app.dto.TarefaDTO;
import com.paulo.todo_app.model.Proprietario;
import com.paulo.todo_app.model.Tarefa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProprietarioMapper  {

    public Proprietario toEntity (ProprietarioRequest request){
        Proprietario p = new Proprietario();
        p.setNome(request.nome());

        List<Tarefa> tarefas = request.tarefas().stream().map(t -> {
            Tarefa tarefa = new Tarefa();

            tarefa.setProprietario(p);
            tarefa.setTitulo(t.titulo());
            tarefa.setDescricao(t.descricao());
            tarefa.setStatus(t.status());

            return tarefa;
        }).toList();

        p.setTarefas(tarefas);

        return p;
    }

    public ProprietarioResponse toResponse(Proprietario p) {
        List<TarefaDTO> tarefas = p.getTarefas().stream().map( d -> new TarefaDTO(d.getTitulo(), d.getDescricao(), d.getStatus(), d.getProprietario(), d.getDataLimite())).toList();
        return new ProprietarioResponse(p.getNome(), tarefas);
    }



}
