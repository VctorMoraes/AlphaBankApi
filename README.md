# [AlphaBankApi](https://github.com/VctorMoraes/AlphaBankApi)

## Projeto
A aplicação tem como objetivo ser uma API para um APP de simulação uma solicitação de empréstimo, [AlphaBank](https://github.com/VctorMoraes/AlphaBankApi).

## How To
AlphaBankApi é uma aplicação Kotlin e SpringBoot. O projeto se encontra no seguinte repositório: https://github.com/VctorMoraes/AlphaBankApi

### Request Loan

| Method   | URL       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `POST` | `/` | Salva usuário no banco de dados e retorna o resultado da solicitação de empréstimo |

Se `month_income` for maior que 5000.0, o empréstimo é aprovado, como o valor máximo de 3 * `month_income`, senão, o empréstimo é recusado.

#### Example body

```
{
  "name": "Victor Moraes",
  "age": 22
  "month_income": 1000.0,
  "city": "Campinas"
}
```

#### Example return
```
{
  "status": "DECLINED",
}
```

OR
```
{
  "status": "APPROVED",
  "max_amount": 10000.0
}
```

## Database

JBDC Template utilizando o seguinte schema: [Schema](https://github.com/VctorMoraes/AlphaBankApi/blob/main/src/main/resources/schema.sql)

![image](https://github.com/VctorMoraes/AlphaBankApi/assets/37370587/27169edb-2521-48ec-8bdb-9d1a30cf14d4)


