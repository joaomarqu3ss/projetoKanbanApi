📝 Kanban API - Spring Boot
---

Esta é uma API REST desenvolvida com Spring Boot para gerenciamento de tarefas em um sistema Kanban. Permite cadastrar, editar, excluir e consultar tarefas, com persistência de dados no PostgreSQL utilizando ORM com JPA/Hibernate.

---

**🚀 Tecnologias Utilizadas**

Java 21

Spring DevTools

Spring Boot

Spring Data JPA

PostgreSQL

Docker / Docker Compose

Swagger (Springdoc OpenAPI)

Postman (para testes manuais)

---
**🧪 Testes da API Swagger UI**

A documentação interativa da API está disponível em:

📍 http://localhost:8084/swagger-ui.html

---

**⚙️ Funcionalidades**
Criar tarefa: cadastrar uma nova tarefa com título, descrição e status.

Listar tarefas: retornar todas as tarefas registradas.

Buscar por ID: consultar uma tarefa específica.

Atualizar tarefa: editar informações de uma tarefa existente.

Excluir tarefa: deletar uma tarefa do sistema.

---

**🗄️ Banco de Dados**

O banco de dados utilizado é o PostgreSQL, com mapeamento ORM feito via JPA/Hibernate.

O serviço do banco é executado em container Docker, conforme especificado no arquivo docker-compose.yml.

---

| Método | Endpoint               | Descrição               |
| ------ | ---------------------- | ----------------------- |
| POST   | `/api/v1/tarefas`      | Criar uma nova tarefa   |
| PUT    | `/api/v1/tarefas/{id}` | Atualizar tarefa por ID |
| DELETE | `/api/tarefas/{id}`    | Deletar tarefa por ID   |
| GET    | `/api/tarefas`         | Listar todas as tarefas |

