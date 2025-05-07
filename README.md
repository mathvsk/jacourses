# Jacourses

**Jacourses** é uma aplicação web desenvolvida em **Java** com **Spring Boot**, voltada para o gerenciamento de cursos. A API permite criar, listar, atualizar, ativar/desativar e excluir cursos de maneira simples e organizada, utilizando um banco de dados **PostgreSQL** para persistência.

---

## Estrutura do Projeto

A organização do código segue o padrão do Spring Boot:

```
src/
├── main/
│   ├── java/
│   │   └── com.matheus.jacourses/
│   │       ├── controllers/     # Camada de controle (API REST)
│   │       ├── useCases/        # Regras de negócio (casos de uso)
│   │       ├── repositories/    # Interfaces de persistência (Spring Data JPA)
│   │       ├── models/          # Entidades JPA
│   │       ├── dtos/            # Data Transfer Objects
│   │       └── exceptions/      # Tratamento de exceções
│   └── resources/
│       └── application.properties  # Configurações da aplicação
└── test/
    └── java/                   # Testes unitários e de integração
```

---

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.5**
- **PostgreSQL**
- **Lombok**
- **Maven**
- **Docker** (opcional para rodar o banco de dados)

---

## Configuração do Ambiente

### Pré-requisitos

- Java 21+
- Maven
- Docker (opcional, mas recomendado)

### Configuração do Banco de Dados

1. Crie um arquivo `.env` na raiz do projeto baseado no `.env-example`:

    ```env
    POSTGRES_USER=seu_usuario
    POSTGRES_PASSWORD=sua_senha
    POSTGRES_DB=nome_do_banco
    ```

2. Suba o container com Docker Compose:

    ```bash
    docker-compose up -d
    ```

---

## Execução da Aplicação

Com o banco de dados em execução, inicie a aplicação:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

---

## Endpoints da API

> Base URL: `http://localhost:8080/api/v1/courses`

| Método | Rota                | Descrição                        |
|--------|---------------------|----------------------------------|
| GET    | `/`                 | Lista todos os cursos            |
| POST   | `/`                 | Cria um novo curso               |
| PUT    | `/{id}`             | Atualiza um curso existente      |
| PATCH  | `/{id}/active`      | Ativa ou desativa um curso       |
| DELETE | `/{id}`             | Remove um curso                  |

### Exemplo de Requisições

#### Criar Curso (POST `/`)

```json
{
  "name": "Nome do Curso",
  "category": "Categoria do Curso",
  "active": true //opcional
}
```

#### Atualizar Curso (PUT `/{id}`)

```json
{
  "name": "Novo Nome",
  "category": "Nova Categoria"
}
```

---

## Tratamento de Exceções

A aplicação conta com um manipulador global (`GlobalExceptionHandler`) para capturar e padronizar respostas de erro:

| Código HTTP | Situação                             |
|-------------|---------------------------------------|
| 400         | Erros de validação ou requisições inválidas |
| 404         | Recurso não encontrado                |