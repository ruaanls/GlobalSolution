# API de Gerenciamento de Usuários - Global Solution

Esta é uma API RESTful construída com Java e Spring Boot para gerenciar usuários, utilizando autenticação segura baseada em tokens JWT (JSON Web Token).

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3+**
- **Spring Security 6+** (Para autenticação e autorização)
- **Spring Data JPA** (Para persistência de dados)
- **Banco de Dados Oracle**
- **Auth0 JWT** (Para geração e validação de tokens)
- **Maven** (Gerenciador de dependências)

## Como Executar o Projeto
1.  **Pré-requisitos:**
    - JDK 17 ou superior instalado.
    - Maven instalado.
    - Um banco de dados Oracle acessível.

2.  **Configuração:**
    - Clone o repositório: `git clone <url_do_seu_repositorio>`
    - Navegue até a pasta do projeto.
    - Configure suas credenciais de banco de dados e a chave secreta do JWT no arquivo `src/main/resources/application.properties`.

3.  **Execução:**
    - Execute o arquivo globalsolution1Aplication
    - A aplicação estará disponível em `http://52.179.20.23`.

## Autenticação (JWT)

A maioria dos endpoints desta API é protegida e requer um token de autenticação. O fluxo é o seguinte:

1.  **Registro (Opcional):** Se você for um novo usuário, primeiro precisa se registrar.
    - `POST /auth/registrar`

2.  **Login:** Após o registro, você deve fazer login para obter um token de acesso.
    - `POST /auth/login`

3.  **Uso do Token:** A chamada de login retornará um token JWT. Para acessar os endpoints protegidos, você deve incluir este token no cabeçalho `Authorization` de cada requisição, no formato `Bearer`.

    **Exemplo de Cabeçalho:**
    ```
    Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
    ```

---

## Endpoints da API

### Auth Controller (Endpoints Públicos)
Estes endpoints são usados para registro e autenticação.

#### `POST /auth/registrar`
Registra um novo usuário no sistema.

- **Autenticação:** Não requerida.
- **Request Body:**
  ```json
  {
      "nome": "João da Silva",
      "cidade": "São Paulo",
      "idade": 30,
      "tipo_usuario": "USUARIO",
      "username": "joao.silva",
      "password": "senhaForte123"
  }




  