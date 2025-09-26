package com.paulo.todo_app.dto;

import com.paulo.todo_app.model.Proprietario;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public record TarefaDTO(String titulo, String descricao, String status, Proprietario proprietario, LocalDate dataLimite) {
}
