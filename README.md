# API de Gerenciamento de Tarefas Pessoais

API RESTful desenvolvida em Spring Boot para gerenciamento de tarefas pessoais.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.5**
- **Spring Data JPA**
- **Spring Validation** (validação de dados)
- **Swagger/OpenAPI** (documentação automática)
- **H2 Database** (banco de dados em memória)
- **Maven**

## Funcionalidades

- ✅ CRUD completo de tarefas
- ✅ Validação de dados com anotações
- ✅ Tratamento de exceções personalizado
- ✅ Respostas HTTP padronizadas
- ✅ Mensagens de erro descritivas
- ✅ Versionamento de API (v1)
- ✅ Documentação Swagger UI
- ✅ Arquitetura em camadas (Controller, Service, Repository)

## Como Executar o Projeto

### Pré-requisitos
- Java 21 ou superior instalado
- Maven instalado

### Passos para executar

1. Abra o terminal na pasta do projeto
2. Compile o projeto:
```bash
mvn package
```

3. Execute a aplicação:
```bash
java -jar target/task-management-1.0.0.jar
```

Ou simplesmente:
```bash
run.bat
```

4. A aplicação estará disponível em: `http://localhost:8080`

5. Para parar a aplicação, pressione `Ctrl + C`

## Documentação da API (Swagger)

Acesse a documentação interativa da API através do Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

Você pode testar todos os endpoints diretamente pelo navegador!

---

## Endpoints da API

### Base URL
```
http://localhost:8080/api/v1/tasks
```

**Versão da API:** v1

### 1. GET - Listar todas as tarefas

**Endpoint:** `GET /api/v1/tasks`

**Descrição:** Recupera a lista de todas as tarefas cadastradas.

**Exemplo de requisição:**
```http
GET http://localhost:8080/api/v1/tasks
```

**Resposta de sucesso (200 OK):**
```json
[
  {
    "id": 1,
    "titulo": "Estudar Spring Boot",
    "descricao": "Revisar conceitos de API RESTful",
    "concluida": false,
    "dataCriacao": "2025-11-09T10:30:00",
    "dataAtualizacao": "2025-11-09T10:30:00"
  }
]
```

---

### 2. POST - Criar nova tarefa

**Endpoint:** `POST /api/v1/tasks`

**Descrição:** Adiciona uma nova tarefa.

**Exemplo de requisição:**
```http
POST http://localhost:8080/api/v1/tasks
Content-Type: application/json

{
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar conceitos de API RESTful",
  "concluida": false
}
```

**Resposta de sucesso (201 Created):**
```json
{
  "id": 1,
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar conceitos de API RESTful",
  "concluida": false,
  "dataCriacao": "2025-11-09T10:30:00",
  "dataAtualizacao": "2025-11-09T10:30:00"
}
```

---

### 3. PUT - Atualizar tarefa existente

**Endpoint:** `PUT /api/v1/tasks/{id}`

**Descrição:** Atualiza os dados de uma tarefa existente.

**Exemplo de requisição:**
```http
PUT http://localhost:8080/api/v1/tasks/1
Content-Type: application/json

{
  "titulo": "Estudar Spring Boot - Avançado",
  "descricao": "Estudar JPA e Hibernate",
  "concluida": true
}
```

**Resposta de sucesso (200 OK):**
```json
{
  "id": 1,
  "titulo": "Estudar Spring Boot - Avançado",
  "descricao": "Estudar JPA e Hibernate",
  "concluida": true,
  "dataCriacao": "2025-11-09T10:30:00",
  "dataAtualizacao": "2025-11-09T11:45:00"
}
```

---

### 4. DELETE - Excluir tarefa

**Endpoint:** `DELETE /api/v1/tasks/{id}`

**Descrição:** Exclui uma tarefa do sistema.

**Exemplo de requisição:**
```http
DELETE http://localhost:8080/api/v1/tasks/1
```

**Resposta de sucesso:** 204 No Content (sem corpo de resposta)

---

## Códigos de Resposta HTTP

| Código | Descrição |
|--------|-----------|
| 200 OK | Requisição bem-sucedida |
| 201 Created | Tarefa criada com sucesso |
| 204 No Content | Tarefa excluída com sucesso |
| 400 Bad Request | Dados inválidos na requisição |
| 404 Not Found | Tarefa não encontrada |
| 500 Internal Server Error | Erro interno do servidor |

---

## Validações Implementadas

### Regras de Validação

- **Título**: Obrigatório, entre 3 e 100 caracteres
- **Descrição**: Opcional, máximo 500 caracteres
- **Concluída**: Campo booleano (true/false)

### Exemplo de Erro de Validação

Ao tentar criar uma tarefa com título inválido:

**Requisição:**
```json
{
  "titulo": "AB",
  "descricao": "Descrição"
}
```

**Resposta (400 Bad Request):**
```json
{
  "timestamp": "2025-11-09T17:30:00",
  "status": 400,
  "error": "Erro de validação",
  "errors": {
    "titulo": "Título deve ter entre 3 e 100 caracteres"
  }
}
```

### Exemplo de Erro 404

Ao buscar uma tarefa inexistente:

**Requisição:**
```
GET /api/v1/tasks/999
```

**Resposta (404 Not Found):**
```json
{
  "timestamp": "2025-11-09T17:30:00",
  "status": 404,
  "error": "Recurso não encontrado",
  "message": "Tarefa com ID 999 não encontrada"
}
```

---

## Testando a API

### Usando Postman ou Insomnia

1. Abra o Postman ou Insomnia
2. Crie uma nova requisição
3. Selecione o método HTTP (GET, POST, PUT ou DELETE)
4. Digite a URL do endpoint
5. Para POST e PUT, adicione o corpo JSON na aba "Body" > "raw" > "JSON"
6. Clique em "Send"

---

## Estrutura do Projeto

O projeto segue uma arquitetura em camadas organizada em pacotes:

```
src/
├── main/
│   ├── java/com/tarefas/
│   │   ├── TaskManagementApplication.java    (classe principal)
│   │   ├── controller/
│   │   │   └── TaskController.java           (endpoints REST)
│   │   ├── service/
│   │   │   └── TaskService.java              (lógica de negócio)
│   │   ├── repository/
│   │   │   └── TaskRepository.java           (acesso a dados)
│   │   ├── model/
│   │   │   └── Task.java                     (entidade JPA)
│   │   ├── exception/
│   │   │   ├── ResourceNotFoundException.java
│   │   │   └── GlobalExceptionHandler.java
│   │   └── config/
│   │       └── OpenAPIConfig.java            (configuração Swagger)
│   └── resources/
│       └── application.properties
└── test/
```

### Camadas da Aplicação

- **Controller**: Recebe requisições HTTP e retorna respostas
- **Service**: Contém a lógica de negócio da aplicação
- **Repository**: Faz a comunicação com o banco de dados
- **Model**: Define as entidades do banco de dados
- **Exception**: Trata erros e exceções da API
- **Config**: Configurações da aplicação (Swagger, etc)

---

## Modelo de Dados - Task

| Campo | Tipo | Descrição |
|-------|------|-----------|
| id | Long | Identificador único (gerado automaticamente) |
| titulo | String | Título da tarefa (obrigatório) |
| descricao | String | Descrição detalhada da tarefa |
| concluida | Boolean | Status de conclusão (true/false) |
| dataCriacao | LocalDateTime | Data/hora de criação (automática) |
| dataAtualizacao | LocalDateTime | Data/hora da última atualização (automática) |

---

## Autor

Desenvolvido como projeto acadêmico para a disciplina de Serviços WEB e API RESTful - IPOG.
