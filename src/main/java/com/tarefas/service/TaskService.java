package com.tarefas.service;

import com.tarefas.exception.ResourceNotFoundException;
import com.tarefas.model.Task;
import com.tarefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listarTodas() {
        return taskRepository.findAll();
    }

    public Task buscarPorId(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada"));
    }

    public Task criar(Task task) {
        return taskRepository.save(task);
    }

    public Task atualizar(Long id, Task taskAtualizada) {
        Task task = buscarPorId(id);
        task.setTitulo(taskAtualizada.getTitulo());
        task.setDescricao(taskAtualizada.getDescricao());
        task.setConcluida(taskAtualizada.getConcluida());
        return taskRepository.save(task);
    }

    public void deletar(Long id) {
        Task task = buscarPorId(id);
        taskRepository.delete(task);
    }
}
