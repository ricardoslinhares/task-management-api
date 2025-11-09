package com.tarefas.controller;

import com.tarefas.model.Task;
import com.tarefas.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * GET - Recupera todas as tarefas
     * Endpoint: GET /api/v1/tasks
     */
    @GetMapping
    public ResponseEntity<List<Task>> listarTodas() {
        List<Task> tasks = taskService.listarTodas();
        return ResponseEntity.ok(tasks);
    }

    /**
     * GET - Recupera uma tarefa específica por ID
     * Endpoint: GET /api/v1/tasks/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> buscarPorId(@PathVariable Long id) {
        Task task = taskService.buscarPorId(id);
        return ResponseEntity.ok(task);
    }

    /**
     * POST - Adiciona uma nova tarefa
     * Endpoint: POST /api/v1/tasks
     */
    @PostMapping
    public ResponseEntity<Task> criarTarefa(@Valid @RequestBody Task task) {
        Task novaTarefa = taskService.criar(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    /**
     * PUT - Atualiza uma tarefa existente
     * Endpoint: PUT /api/v1/tasks/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizarTarefa(@PathVariable Long id, @Valid @RequestBody Task taskAtualizada) {
        Task taskSalva = taskService.atualizar(id, taskAtualizada);
        return ResponseEntity.ok(taskSalva);
    }

    /**
     * DELETE - Exclui uma tarefa
     * Endpoint: DELETE /api/v1/tasks/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        taskService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
