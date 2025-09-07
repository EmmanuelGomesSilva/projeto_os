# Projeto_OS – API de Pedidos ✅

Uma API RESTful para gerenciar **Clientes**, **Produtos** e **Pedidos**, desenvolvida em **Spring Boot** com MySQL.

---

## 🛠 Tecnologias Utilizadas

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)  
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)  
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)  
[![Lombok](https://img.shields.io/badge/Lombok-ED1C24?style=for-the-badge&logo=lombok&logoColor=white)](https://projectlombok.org/)  
[![Insomnia](https://img.shields.io/badge/Insomnia-REST%20Client-orange)](https://insomnia.rest/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/)

---

## 📦 Estrutura do Projeto
```
Projeto_OS
├─ src/main/java/com/emmanuel/Projeto_OS
│ ├─ controller
│ │ ├─ ClienteController.java
│ │ ├─ PedidoController.java
│ │ └─ ProdutoController.java
│ ├─ model
│ │ ├─ enums
│ │ │ └─ StatusPedido.java
│ │ ├─ Cliente.java
│ │ ├─ Pedido.java
│ │ └─ Produto.java
│ ├─ repository
│ │ ├─ ClienteRepository.java
│ │ ├─ PedidoRepository.java
│ │ └─ ProdutoRepository.java
│ └─ service
│ ├─ ClienteService.java
│ ├─ PedidoService.java
│ └─ ProdutoService.java
└─ src/main/resources
└─ application.properties
```

---

## 📊 Modelo de Dados

**Entidades e Relacionamentos:**

- **Cliente** – 1:N → Pedido
- **Produto** – 1:N → Pedido
- **Pedido**
    - status: ENUM `ABERTO`, `CONCLUIDO`, `CANCELADO`
    - quantidade: Número positivo ou zero

---

## 🚀 Endpoints da API

### Cliente
- `POST /clientes` – Criar cliente
- `POST /clientes/varios` – Criar múltiplos clientes
- `GET /clientes` – Listar todos
- `PUT /clientes/{id}` – Atualizar cliente
- `DELETE /clientes/{id}` – Remover cliente

### Produto
- `POST /produtos` – Criar produto
- `POST /produtos/varios` – Criar múltiplos produtos
- `GET /produtos` – Listar todos
- `PUT /produtos/{id}` – Atualizar produto
- `DELETE /produtos/{id}` – Remover produto

### Pedido
- `POST /pedidos` – Criar pedido
- `GET /pedidos` – Listar todas
- `GET /pedidos/{id}` – Buscar por ID
- `PUT /pedidos/{id}` – Atualizar pedido
- `DELETE /pedidos/{id}` – Remover pedido

---

## 📝 Testes

Recomendado utilizar **Insomnia** (ou **Postman**) para testar todos os endpoints.
- Validar campos obrigatórios (`@NotBlank`, `@Positive`)
- Verificar relacionamentos entre entidades
- Testar criação de múltiplos registros

---

## 📝 Exemplos de Requisições e Respostas

### Criar Pedido

**Request:**
```json
{
  "quantidade": 3,
  "status": "ABERTO",
  "cliente": { "id": 1 },
  "produto": { "id": 1 }
}
```

**Response**
```json
{
  "id": 7,
  "quantidade": 1,
  "status": "ABERTO",
  "cliente": {
    "id": 2,
    "nome": "João da Silva",
    "email": "joaoatualizado@email.com",
    "telefone": "22 99999-9999"
  },
  "produto": {
    "id": 3,
    "nome": "Teclado Gamer",
    "preco": 250.8,
    "quantidade": 8
  }
}
```

### Criar Cliente

**Request**
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "telefone": "11 99999-9999"
}
```

**Response**
```json
[
  {
    "id": 2,
    "nome": "João da Silva",
    "email": "joaoatualizado@email.com",
    "telefone": "22 99999-9999"
  }
]
```

### Criar Produto

**Request**
```json
{
  "nome": "Mouse Gamer",
  "preco": 120.90,
  "quantidade": 10
}
```

**Response**
```json
{
  "id": 1,
  "nome": "Mouse Gamer",
  "preco": 120.90,
  "quantidade": 10
}
```

## 📂 Deploy & Portfólio (Planejado)

- Deploy sugerido: Heroku, Railway ou outro.
- Incluir prints dos testes e links no LinkedIn ou portfólio.

---

## ⚡ Observações Profissionais

- ✅ Código limpo e enxuto com **Lombok**
- ✅ Retornos consistentes usando **ResponseEntity**
- ✅ Validações aplicadas com **Bean Validation** (`@Valid`, `@NotBlank`, `@Positive`)
- ✅ Monitoramento de logs com **Slf4j**

## 👤 Autor

**Emmanuel Gomes** – Desenvolvedor responsável por todo o projeto, da modelagem ao deploy planejado.  
[LinkedIn](https://www.linkedin.com/in/emmanuel-gomes-b6670754/) | [GitHub](https://github.com/EmmanuelGomesSilva)
