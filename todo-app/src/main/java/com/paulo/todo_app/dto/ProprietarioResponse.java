package com.paulo.todo_app.dto;

import com.paulo.todo_app.model.Tarefa;

import java.util.List;

public record ProprietarioResponse(String nome, List<TarefaDTO> tarefas) {
}
