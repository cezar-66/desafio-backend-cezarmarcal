# Desafio Backend Cezar Marçal

Este repositório contém o desenvolvimento do desafio técnico proposto, organizado em 4 partes distintas, com a utilização de Java 17, Spring Boot e H2 como banco de dados para o CRUD. A seguir, explico como o desafio foi organizado e as tecnologias utilizadas.

## Estrutura do Projeto

O projeto está dividido nas seguintes pastas:

### 1. **Desafio dos Anagramas**
Na pasta `anagramas/`, você encontrará:
- **GeradorAnagramas.java**: Classe responsável por gerar anagramas.
- **GeradorAnagramasTest.java**: Teste unitário para a classe `GeradorAnagramas.java`.

### 2. **CRUD de Plantas**
O CRUD das plantas está implementado na pasta `crud-plantas/`, com os seguintes arquivos:
- **Planta.java**: Modelo que representa uma planta.
- **PlantaService.java**: Serviço que gerencia a lógica de negócios.
- **PlantaController.java**: Controlador que expõe a API REST para o CRUD.
- **PlantaTest.java**: Testes unitários para o CRUD.

Além disso, criei uma coleção do **Postman** para facilitar a execução dos testes das APIs. A coleção está localizada dentro da pasta `crud-plantas/postman/planta-controller-endpoints.json`.

### 3. **Consultas SQL**
Na pasta `sql/`, separei os desafios de SQL, usei banco H2 pra facilitar a execução de testes, mas poder qualquer outro banco relacional ou NoSQL.

## Tecnologias Utilizadas

- **Java 17**: Utilizado para o desenvolvimento das funcionalidades.
- **Spring Boot**: Framework para facilitar o desenvolvimento da aplicação.
- **H2**: Banco de dados em memória utilizado para o CRUD das plantas.
- **Postman**: Utilizado para testes da API CRUD, com uma coleção inclusa no projeto.

## Como Rodar o Projeto

1. Clone este repositório para sua máquina local:
    ```bash
    git clone https://github.com/cezar-66/desafio-backend-cezarmarcal.git
    ```

2. Navegue até a pasta do projeto:
    ```bash
    cd desafio-backend-cezarmarcal
    navegue até a pasta 'crud-plantas'
    ```

3. Compile e rode a aplicação com o Maven:
    ```bash
    ./mvnw spring-boot:run

    OU
    Execute a classe PlantaApplication.java
    ```

4. A aplicação estará rodando localmente na porta `8080`.

5. Para testar o CRUD das plantas, utilize a coleção do Postman que se encontra em:
    ```
    crud-plantas/postman/planta-controller-endpoints.json
    ```

## Links Importantes
Todas as questões **conceituais** respondi no formulário que está no link abaixo:

[Especificação do Desafio](https://docs.google.com/document/d/1T0TA91LVzMSHuMbwKsNaS1z_1js9ixG4G3GwYUrbLa4/edit?usp=sharing)

## Considerações Finais

A estrutura foi organizada para refletir as várias partes do desafio e facilitar a execução e os testes das funcionalidades propostas. Caso tenha dúvidas ou sugestões, fiquem à vontade para entrar em contato.
