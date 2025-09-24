package com.paulo.todo_app.service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class PLService {
    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall validarCall;
    private SimpleJdbcCall moverCall;

    public PLService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        this.validarCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("VALIDAR_TAREFA")
                .withSchemaName("TODO_APP");
        this.moverCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("MOVER_TAREFA_CONCLUIDA")
                .withSchemaName("TODO_APP");
    }

    public void validarDataLimite(LocalDate dataLimite){
        Map<String, Object> in = new HashMap<>();
        in.put("P_DATA_LIMITE", (dataLimite == null) ? null : Date.valueOf(dataLimite));
        try{
            validarCall.execute(in);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro na validação da data: " + e.getMessage(), e);
        }
    }

    public void moverTarefaConcluida(Long id) {
        Map<String, Object> in = Map.of("p_tarefa_id", id);
        moverCall.execute(in);
    }

}
