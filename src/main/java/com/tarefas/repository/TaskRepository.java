package com.tarefas.repository;

import com.tarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // O JpaRepository já fornece os métodos básicos:
    // - findAll() - listar todas as tarefas
    // - findById() - buscar tarefa por ID
    // - save() - criar ou atualizar tarefa
    // - deleteById() - deletar tarefa por ID
}
