package com.paulo.todo_app.controller;

import com.paulo.todo_app.model.Tarefa;
import com.paulo.todo_app.model.TarefaConcluida;
import com.paulo.todo_app.service.TarefaHistoryService;
import com.paulo.todo_app.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
    private final TarefaService service;
    private final TarefaHistoryService serviceHistory;

    public TarefaController(TarefaService service, TarefaHistoryService tarefaHistoryService){
        this.service = service;
        this.serviceHistory = tarefaHistoryService;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa){
        Tarefa saved = service.criar(tarefa);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{id}/concluir")
    public ResponseEntity<Void> concluir(@PathVariable Long id) {
        service.concluir(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar (){
        service.deletar();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/historico")
    public List<TarefaConcluida> getTarefasHistory (){
        return serviceHistory.getHistorico();
    }

}
