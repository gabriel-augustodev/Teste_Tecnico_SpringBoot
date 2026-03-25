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

### 1. Clone o repositório
```bash
git clone https://github.com/gabriel-augustodev/Teste_Tecnico_SpringBoot.git
cd Teste_Tecnico_SpringBoot
```
### 2. Execute a aplicação
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

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /api/produtos | Criar produto |
| GET | /api/produtos | Listar todos |
| GET | /api/produtos/{id} | Buscar por ID |
| PUT | /api/produtos/{id} | Atualizar |
| DELETE | /api/produtos/{id} | Deletar |

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

## 📄 Acesse a aplicação

- API: http://localhost:8080
- Swagger: http://localhost:8080/swagger-ui/
- H2 Console: http://localhost:8080/h2-console

------------------------------------------------------------------------

## 🧪 Testes

A API pode ser testada via: - Postman - Swagger UI

## Login(obter token)

``` bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@exemplo.com",
    "senha": "admin123"
  }'
```
## Criar produto (substituir TOKEN)

``` bash
curl -X POST http://localhost:8080/api/produtos \
  -H "Authorization: Bearer SEU_TOKEN_AQUI" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Notebook ",
    "preco": 3500,
    "descricao": "Notebook Top",
    "categoria": "Eletrônicos"
  }'
```

## Listar todos os produtos
``` bash
curl -X GET http://localhost:8080/api/produtos \
  -H "Authorization: Bearer SEU_TOKEN_AQUI"
```

## Buscar produto por ID
``` bash
curl -X GET http://localhost:8080/api/produtos/1 \
  -H "Authorization: Bearer SEU_TOKEN_AQUI"
```

## Atualizar produto
``` bash
curl -X PUT http://localhost:8080/api/produtos/1 \
  -H "Authorization: Bearer SEU_TOKEN_AQUI" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Notebook  Atualizado",
    "preco": 3200,
    "descricao": "Notebook Top",
    "categoria": "Eletrônicos"
  }'
```

##  Deletar produto
``` bash
curl -X DELETE http://localhost:8080/api/produtos/1 \
  -H "Authorization: Bearer SEU_TOKEN_AQUI"
```


------------------------------------------------------------------------
## 👨‍💻 Autor

**Gabriel Augusto**

[![GitHub](https://img.shields.io/badge/GitHub-@gabriel--augustodev-181717?style=for-the-badge&logo=github)](https://github.com/gabriel-augustodev)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Gabriel%20Augusto-0A66C2?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/gabriel-augusto-ferreira-maia/)
[![Email](https://img.shields.io/badge/Email-gabrielaugustofmaia@gmail.com-EA4335?style=for-the-badge&logo=gmail)](mailto:gabrielaugustofmaia@gmail.com)
