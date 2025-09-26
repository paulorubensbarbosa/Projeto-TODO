package com.paulo.todo_app.dto;

import com.paulo.todo_app.model.Proprietario;
import com.paulo.todo_app.model.Tarefa;

import java.util.List;

public record ProprietarioRequest(String nome, List<TarefaDTO> tarefas, Proprietario proprietario) {
    //Quando a lista de tarefas ainda estava vazia, a tarefa vinha como NULL e não como uma lista vazia, dendo erro ao usar o STREAM
    public List<TarefaDTO> tarefas(){
        return tarefas == null ? List.of() : tarefas;
    }
}
