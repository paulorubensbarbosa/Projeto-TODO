package com.paulo.todo_app.repository;

import com.paulo.todo_app.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
}
