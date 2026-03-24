# 🚀 API de Produtos - Spring Boot

## 📌 Descrição

API REST para gerenciamento de produtos com autenticação JWT.

------------------------------------------------------------------------

## ⚙️ Tecnologias utilizadas

-   Java 17+
-   Spring Boot 2
-   Spring Security
-   JWT
-   JPA / Hibernate
-   H2 Database
-   Swagger

------------------------------------------------------------------------

## ▶️ Como rodar o projeto

``` bash
mvn spring-boot:run
```

A API estará disponível em: http://localhost:8080

------------------------------------------------------------------------

## 🔐 Autenticação

### Login

POST `/auth/login`

``` json
{
  "email": "admin@exemplo.com",
  "senha": "admin123"
}
```

Resposta:

``` json
{
  "token": "SEU_TOKEN"
}
```

------------------------------------------------------------------------

## 📦 Endpoints

  Método   Endpoint             Descrição
  -------- -------------------- ---------------
  POST     /api/produtos        Criar produto
  GET      /api/produtos        Listar todos
  GET      /api/produtos/{id}   Buscar por ID
  PUT      /api/produtos/{id}   Atualizar
  DELETE   /api/produtos/{id}   Deletar

------------------------------------------------------------------------

## 🔒 Segurança

-   Todos os endpoints (exceto login) requerem token JWT
-   Enviar no header:

Authorization: Bearer TOKEN

------------------------------------------------------------------------

## ⚠️ Tratamento de erros

-   401 → Não autenticado
-   403 → Acesso negado
-   404 → Produto não encontrado

------------------------------------------------------------------------

## 📄 Documentação Swagger

Acesse: http://localhost:8080/swagger-ui/

------------------------------------------------------------------------

## 🧪 Testes

A API pode ser testada via: - Postman - Swagger UI
