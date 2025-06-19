# Sistema de Gerenciamento de Posto de Combustível - Posto Leal

## ⛽ Descrição

O **Posto Leal** é um sistema de linha de comando (CLI) desenvolvido em Java para simular o gerenciamento das operações básicas de um posto de combustível. Ele permite o cadastro de bombas de combustível, clientes e funcionários, além de registrar abastecimentos e gerar relatórios.

Este projeto foi criado como uma forma de aplicar conceitos de Programação Orientada a Objetos (POO), incluindo encapsulamento, herança e tratamento de exceções.

---

## ✨ Funcionalidades

O sistema oferece um menu interativo com as seguintes opções:

* **Adicionar Bomba:** Cadastra uma nova bomba de combustível, especificando o tipo (Gasolina, Etanol, Diesel) e a quantidade inicial de combustível.
* **Cadastrar Cliente:** Registra novos clientes no sistema.
* **Cadastrar Funcionário:** Registra novos funcionários, que serão associados aos abastecimentos.
* **Realizar Abastecimento:** Simula a operação de abastecimento, associando um cliente e um funcionário, e atualizando o estoque da bomba.
* **Gerar Relatório:** Cria um arquivo de texto (`.txt`) com o histórico detalhado de todos os abastecimentos realizados.
* **Fechar Caixa:** Encerra a aplicação e gera um relatório final de abastecimentos.

---

## 📂 Estrutura do Projeto

O código-fonte está organizado seguindo o padrão Model-View-Controller (MVC) para separar as responsabilidades:

```
src/
└── main/
└── java/
├── App.java            # Ponto de entrada da aplicação
├── controller/
│   └── PostoController.java # Orquestra a lógica do negócio
├── model/
│   ├── Abastecimento.java
│   ├── Bomba.java
│   ├── Cliente.java
│   ├── Combustivel.java
│   ├── Funcionario.java
│   ├── Pessoa.java
│   ├── Registro.java
│   └── exceptions/
│       └── EstoqueInsuficienteException.java
└── view/
└── PostoView.java      # Responsável pela interface com o usuário (menu CLI)
```

* **`view`**: Contém a classe `PostoView`, que exibe o menu e captura as entradas do usuário.
* **`controller`**: A classe `PostoController` atua como uma ponte, processando as requisições da `view` e manipulando os dados no `model`.
* **`model`**: Inclui as classes de domínio que representam as entidades do sistema (Bomba, Cliente, etc.), a lógica de negócio e as exceções personalizadas.

---

## 🚀 Como Executar

Para compilar e executar o projeto, você precisará ter o **JDK (Java Development Kit)** instalado em sua máquina.

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/eduardoleeaal/posto-leal.git
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd posto-leal
    ```

3.  **Compile os arquivos Java:**
    Se você estiver na raiz do projeto, pode compilar usando o seguinte comando:
    ```bash
    javac -d target/classes src/main/java/**/*.java
    ```

4.  **Execute a aplicação:**
    A partir da raiz do projeto, execute a classe principal `App`:
    ```bash
    java -cp target/classes App
    ```
    O menu interativo será exibido no seu terminal.

---

## 🛠️ Tecnologias Utilizadas

* **Java**: Linguagem de programação principal.
* **Maven**: Ferramenta de gerenciamento de dependências e build do projeto.

---

## ✒️ Autor

* **Eduardo Leal** - [eduardoleeaal](https://github.com/eduardoleeaal)
