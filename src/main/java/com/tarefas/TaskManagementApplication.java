package com.tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("API de Gerenciamento de Tarefas iniciada!");
        System.out.println("Acesse: http://localhost:8080/api/tasks");
        System.out.println("Console H2: http://localhost:8080/h2-console");
        System.out.println("========================================\n");
    }
}
