package com.paulo.todo_app.controller;

import com.paulo.todo_app.dto.ProprietarioRequest;
import com.paulo.todo_app.dto.ProprietarioResponse;
import com.paulo.todo_app.model.Proprietario;
import com.paulo.todo_app.service.ProprietarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/proprietarios")
public class ProprietarioController {

    private final ProprietarioService service;

    public ProprietarioController (ProprietarioService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProprietarioResponse> criarProprietario (@RequestBody ProprietarioRequest proprietario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarProprietario(proprietario));
    }

}
