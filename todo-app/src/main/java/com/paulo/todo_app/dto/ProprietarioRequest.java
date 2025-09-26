package com.paulo.todo_app.dto;

import com.paulo.todo_app.model.Proprietario;
import com.paulo.todo_app.model.Tarefa;

import java.util.List;

public record ProprietarioRequest(String nome, List<TarefaDTO> tarefas, Proprietario proprietario) {
}
