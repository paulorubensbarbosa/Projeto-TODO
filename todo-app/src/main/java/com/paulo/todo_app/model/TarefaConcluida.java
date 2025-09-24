package com.paulo.todo_app.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;


//OBS sei que a melhor solução seria manter tudo em uma tabela só e depois caso quisesse pegar as tarefas que já foram concluídas, fazer uma Query do tipo: SELECT * FROM TAREFA t WHERE t.status = 'CONCLUIDA'
@Entity
@Table(name = "TAREFA_HISTORICO", schema = "TODO_APP")
public class TarefaConcluida {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Lob
    private String descricao;

    @Column(nullable = false, length = 20)
    private String status; //PENDENTE, EM_ANDAMENTO, CONCLUIDA

    private LocalDate dataLimite;

    private  String categoria;

    private OffsetDateTime criadoEm;

    @PrePersist
    public void prePersist() {
        if (criadoEm == null){
            criadoEm = OffsetDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public OffsetDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(OffsetDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
