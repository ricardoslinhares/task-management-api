# Changelog

## Atividade 4 - Estruturação e Versionamento

### O que foi feito:

- Reorganizada estrutura do projeto em pacotes
  - controller/ - Controladores REST
  - service/ - Lógica de negócio
  - model/ - Entidades do banco
  - repository/ - Acesso a dados
  - exception/ - Tratamento de erros
  - config/ - Configurações

- Criada camada de serviço (TaskService)
  - Separação de responsabilidades
  - Lógica de negócio isolada do controller

- Implementado versionamento da API
  - Endpoints agora em /api/v1/tasks
  - Preparado para futuras versões

- Adicionada documentação Swagger/OpenAPI
  - Interface interativa em /swagger-ui.html
  - Documentação automática dos endpoints
  - Testes diretamente pelo navegador

- Atualizado README com nova estrutura

## Atividade 3 - Melhorias e Validações

### O que foi feito:

- Adicionada validação de dados nas tarefas
  - Título: obrigatório, entre 3 e 100 caracteres
  - Descrição: máximo 500 caracteres

- Melhorado tratamento de erros
  - Mensagens de erro mais claras
  - Respostas padronizadas com timestamp e status

- Criadas novas classes:
  - ResourceNotFoundException: para erros de tarefa não encontrada
  - GlobalExceptionHandler: para tratar todos os erros da API

- Atualizado README com exemplos de erros e validações

## Atividade 2 - Implementação Inicial

- Criado projeto Spring Boot
- Implementados métodos GET, POST, PUT e DELETE
- Configurado banco de dados H2
- Criada documentação da API
