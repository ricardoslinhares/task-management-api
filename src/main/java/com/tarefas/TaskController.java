package com.tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * GET - Recupera todas as tarefas
     * Endpoint: GET /api/tasks
     */
    @GetMapping
    public ResponseEntity<List<Task>> listarTodas() {
        List<Task> tasks = taskRepository.findAll();
        return ResponseEntity.ok(tasks);
    }

    /**
     * GET - Recupera uma tarefa específica por ID
     * Endpoint: GET /api/tasks/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> buscarPorId(@PathVariable Long id) {
        return taskRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST - Adiciona uma nova tarefa
     * Endpoint: POST /api/tasks
     */
    @PostMapping
    public ResponseEntity<Task> criarTarefa(@RequestBody Task task) {
        if (task.getTitulo() == null || task.getTitulo().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Task novaTarefa = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    /**
     * PUT - Atualiza uma tarefa existente
     * Endpoint: PUT /api/tasks/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizarTarefa(@PathVariable Long id, @RequestBody Task taskAtualizada) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitulo(taskAtualizada.getTitulo());
                    task.setDescricao(taskAtualizada.getDescricao());
                    task.setConcluida(taskAtualizada.getConcluida());
                    Task taskSalva = taskRepository.save(task);
                    return ResponseEntity.ok(taskSalva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE - Exclui uma tarefa
     * Endpoint: DELETE /api/tasks/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    taskRepository.delete(task);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
