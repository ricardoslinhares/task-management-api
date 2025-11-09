package com.tarefas;

import jakarta.validation.Valid;
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
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada"));
        return ResponseEntity.ok(task);
    }

    /**
     * POST - Adiciona uma nova tarefa
     * Endpoint: POST /api/tasks
     */
    @PostMapping
    public ResponseEntity<Task> criarTarefa(@Valid @RequestBody Task task) {
        Task novaTarefa = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    /**
     * PUT - Atualiza uma tarefa existente
     * Endpoint: PUT /api/tasks/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizarTarefa(@PathVariable Long id, @Valid @RequestBody Task taskAtualizada) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada"));

        task.setTitulo(taskAtualizada.getTitulo());
        task.setDescricao(taskAtualizada.getDescricao());
        task.setConcluida(taskAtualizada.getConcluida());

        Task taskSalva = taskRepository.save(task);
        return ResponseEntity.ok(taskSalva);
    }

    /**
     * DELETE - Exclui uma tarefa
     * Endpoint: DELETE /api/tasks/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada"));

        taskRepository.delete(task);
        return ResponseEntity.noContent().build();
    }
}
