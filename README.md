# Conversor de Moedas API 🪙

Uma API REST desenvolvida em Spring Boot para consultar cotações de moedas em tempo real e realizar conversões de valores.

## 🚀 Tecnologias Utilizadas
* Java
* Spring Boot (Web)
* AwesomeAPI (API externa para cotações)
* Jackson (Manipulação de JSON)

## ⚙️ Como funciona
A API recebe uma moeda alvo e um valor na URL, vai até a internet buscar a cotação do momento e devolve um JSON com o valor já multiplicado.

## 💻 Exemplo de Uso
Para converter 15 Dólares em Reais, acesse no navegador:
`http://localhost:8080/conversor/USD?valor=15`

**Resposta:**
```json
{
  "ask": "5.27",
  "valorConvertido": 79.11
}