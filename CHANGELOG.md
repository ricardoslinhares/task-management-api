# Changelog

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
