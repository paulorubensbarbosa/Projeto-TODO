package com.paulo.todo_app.repository;

import com.paulo.todo_app.model.Tarefa;
import com.paulo.todo_app.model.TarefaConcluida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaHistoryRepository extends JpaRepository<TarefaConcluida, Long> {
}
