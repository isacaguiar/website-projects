# 🚀 DDD com Java e Spring: DTO, Model e Entity

Projeto de exemplo demonstrando na prática como aplicar **Domain Driven Design (DDD)** utilizando **Java 21, Spring Boot, DTO, Model e Entity**, com mapeamento entre camadas usando **MapStruct**.

👉 Artigo completo:  
https://www.isacaguiar.com.br/blog/ddd-java-spring-dto-model-entity/

---

## 📌 Sobre o projeto

Este projeto foi criado com o objetivo de demonstrar uma arquitetura simples baseada em DDD, separando claramente as responsabilidades entre:

- **DTO (Data Transfer Object)** → comunicação externa
- **Model (Domain)** → regras de negócio
- **Entity (Infrastructure)** → persistência

Essa abordagem ajuda a manter o domínio isolado, melhorar a manutenção e reduzir acoplamento.

---

## 🏗️ Arquitetura
```
src/main/java
├─ application
│ └─ dto
│
├─ domain
│ └─ model
│
└─ infrastructure
└─ entity
```

---

## 🔄 Fluxo de dados

> Request -> DTO -> Model -> Entity -> Banco

> Banco -> Entity -> Model -> DTO -> Response

---

## 🧠 Conceitos aplicados

- Domain Driven Design (DDD)
- Arquitetura em camadas
- Separação de responsabilidades
- Mapeamento entre objetos com MapStruct

---

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot
- MapStruct
- Maven

---

## 📦 Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/isacaguiar/website-projects.git
cd website-projects/ddd-java-spring-dto-model-entitiy
```

### 2. Executar a aplicação

Com Maven:
```bash
mvn spring-boot:run
```

### 🧪 Executar testes

```bash
mvn test
```

---

## 🔗 Links úteis
📖 Artigo completo:

https://www.isacaguiar.com.br/blog/ddd-java-spring-dto-vo-entity/

🌐 Site pessoal:

https://www.isacaguiar.com.br