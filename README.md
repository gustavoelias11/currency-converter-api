# 🪙 API Conversor de Moedas (Spring Boot)

Uma API RESTful desenvolvida em Java com Spring Boot. O objetivo principal da aplicação é consumir uma API externa de cotações de moedas em tempo real e fornecer endpoints para cálculo e armazenamento de histórico de conversões.

## 📖 Sobre o Projeto

Este projeto foi desenvolvido como parte dos meus estudos iniciais em Java e Spring Boot. A aplicação recebe um valor e a sigla de uma moeda estrangeira (ex: USD, EUR), consulta a cotação atualizada na [API Awesome](https://docs.awesomeapi.com.br/) e retorna o valor convertido para Real (BRL). 

Além da conversão em tempo real, a API conta com integração a um banco de dados para salvar e listar o histórico das cotações calculadas.

**Principais aprendizados com este projeto:**
* Criação de uma API REST com o ecossistema Spring (`@RestController`, `@GetMapping`, `@PostMapping`).
* Consumo de APIs externas utilizando `RestTemplate`.
* Manipulação e extração de dados de arquivos JSON utilizando a biblioteca `Jackson` (`ObjectMapper`, `JsonNode`).
* Persistência de dados utilizando o **Spring Data JPA** (`JpaRepository`).
* Injeção de Dependências (`@Autowired`).

## 🛠️ Tecnologias Utilizadas

* **Java** * **Spring Boot**
* **Spring Web** (Criação de endpoints REST)
* **Spring Data JPA** (Persistência no Banco de Dados)
* **Jackson** (Processamento de JSON)

## 🔗 Endpoints da API

A API possui os seguintes endpoints disponíveis (base URL: `http://localhost:9091`):

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/conversor/{moeda}?valor={valor}` | Consulta a cotação em tempo real e retorna o cálculo da conversão, sem salvar no banco de dados. |
| `POST` | `/conversor/calcular/{moeda}?valor={valor}` | Consulta a cotação, calcula a conversão e **salva** o resultado no banco de dados. |
| `GET` | `/conversor/listagem` | Retorna a lista de todas as cotações que foram salvas no banco de dados. |

*Exemplo de uso no Postman ou Navegador:* `GET http://localhost:9091/conversor/USD?valor=100`  
*(Irá retornar a conversão de 100 Dólares para Reais)*

## 🚀 Como Executar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/gustavoelias11/currency-converter-api.git
2. Importe o projeto na sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code).

3. Aguarde o Maven/Gradle baixar as dependências do Spring.

4. Execute a classe principal (ConversorMoedasApplication.java).

5. A API estará disponível na porta 9091.
