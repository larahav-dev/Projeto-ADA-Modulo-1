
# 🎬 Catálogo de Filmes

Um projeto em Java focado em cadastro e consulta de **Atores**, **Diretores** e **Filmes** através de uma interface de linha de comando (console). A modelagem utiliza conceitos de herança com uma classe base abstrata (`Pessoa`) e serviços que encapsulam as regras de negócio e a persistência em memória.

-----

## 🌟 Visão Geral

  - **Objetivo:** Oferecer um fluxo amigável em linha de comando para **cadastrar**, **listar** e **visualizar** atores, diretores e filmes.
  - **Modelagem:** Utiliza a classe abstrata `Pessoa` como base para `Ator` e `Diretor`. A classe `Filme` faz a agregação de diretores e elenco.
  - **Serviços:** As classes `ServicosAtor`, `ServicosDiretor` e `ServicosFilme` gerenciam as coleções de dados e as regras de negócio, sem a necessidade de um banco de dados.
  - **Console:** A classe `Main` é o ponto de entrada, responsável por exibir os menus e coordenar as interações com os serviços.

  - Trabalho apresentado ao projeto do curso ADA Desenvolva+ #1420

-----

## DIAGRAMA - Estrutura desenhada


<img width="1000" height="9500" alt="imagea (1)" src="https://github.com/user-attachments/assets/51cb3667-b5cd-45a4-adcc-f12dae7f808f" />



## ✨ Funcionalidades

### 👥 Atores

  - **Cadastro:** Adiciona novos atores, prevenindo duplicação com base no nome.
  - **Listagem:** Exibe todos os atores cadastrados.
  - **Visualização:** Busca e exibe os detalhes de um ator específico pelo nome.

### 🎥 Diretores

  - **Cadastro:** Adiciona novos diretores, prevenindo duplicação.
  - **Listagem:** Exibe todos os diretores cadastrados.
  - **Visualização:** Busca e exibe os detalhes de um diretor específico, incluindo os filmes que ele dirigiu.

### 🎬 Filmes

  - **Cadastro:** Permite registrar filmes com informações detalhadas como título, data de lançamento, classificação indicativa, gênero, orçamento e descrição.
      - **Criação sob Demanda:** Se um ator ou diretor não existir durante o cadastro do filme, o sistema solicita os dados necessários e o cadastra automaticamente, tornando o processo mais fluido.
  - **Listagem:** Exibe todos os filmes no catálogo.
  - **Visualização:** Permite buscar e ver os detalhes de um filme específico pelo título.

-----

## ⚙️ Arquitetura e Estrutura de Classes

### `Pessoa` (abstrata)

Uma classe base que define atributos e comportamentos comuns a atores e diretores.

  - **Atributos:** `nome`, `genero` (booleano), `dataNascimento`, `nacionalidade`.
  - **Métodos:** `getIdadeAnos()`, `exibirInfo()` (abstrato) e métodos para igualdade (`equals`, `hashCode`) e representação textual (`toString`).

### `Ator` (extends `Pessoa`)

  - Implementa o método abstrato `exibirInfo()` para formatar a exibição de seus dados.

### `Diretor` (extends `Pessoa`)

  - **Atributos:** Possui uma lista de `filmesDirigidos`.
  - **Métodos:** `adicionarFilme(String)` e `exibirInfo()`. O *getter* da lista retorna uma cópia defensiva para garantir o encapsulamento.

### `Filme`

  - **Atributos:** `titulo`, `dataLancamento`, `classificacaoIndicativa`, `genero`, `orcamento`, `descricao`, `diretorPrincipal`, `elenco (List<Ator>)`, `diretores (List<Diretor>)`.

### `Servicos`

  - **`ServicosAtor` / `ServicosDiretor`:** Responsáveis por gerenciar o cadastro (com prevenção de duplicatas), a listagem (retornando cópias defensivas) e a busca por nome.
  - **`ServicosFilme`:** Gerencia o cadastro, busca e listagem de filmes. **Integração Crucial:** Ao cadastrar um filme, esta classe coordena a busca ou a criação sob demanda de diretores e atores, e associa o filme ao histórico do diretor.



-----



## 🚀 Como Usar

### Pré-requisitos

  - **Java:** Versão 11 ou superior.
  - **Ferramenta de Build:** Não é necessária, pois o projeto é simples, mas pode ser integrado a ferramentas como **Maven** ou **Gradle** se desejar.

### 📁 Estrutura de Pastas Sugerida

```
src
├── Entity
│   ├── Pessoa.java
│   ├── Ator.java
│   ├── Diretor.java
│   └── Filme.java
├── Services
│   ├── ServicosAtor.java
│   ├── ServicosDiretor.java
│   └── ServicosFilme.java
└── Main.java
```

### 💻 Compilar e Executar no Terminal

1.  Navegue até a pasta `src`:
    ```bash
    cd src
    ```
2.  Compile os arquivos Java:
    ```bash
    javac Entity/*.java Services/*.java Main.java
    ```
3.  Execute o programa:
    ```bash
    java Main
    ```

> 💡 **Dica:** Caso a classe `Main` esteja em um pacote, você precisará ajustar o comando de execução usando o classpath e o nome completo da classe.



-----



## 📜 Exemplo de Sessão

Veja um resumo de como seria a interação para cadastrar um novo filme:

```bash
==== Catálogo de Filmes ====
1. Atores
2. Diretores
3. Filmes
4. Sair
Escolha uma opção: 3

== Menu Filmes ==
1. Cadastrar filme
2. Listar filmes
3. Visualizar filme
4. Voltar
Opção: 1

--- Cadastro de Filme ---
Título: A Origem
Data de Lançamento (dd/MM/yyyy): 16/07/2010
...
Diretores (separados por vírgula): Christopher Nolan
Atores (separados por vírgula): Leonardo DiCaprio, Joseph Gordon-Levitt

🔹 Diretor 'Christopher Nolan' não encontrado. Vamos cadastrá-lo!
Gênero (M/F): M
Data de Nascimento (dd/MM/yyyy): 30/07/1970
...
🔹 Ator 'Leonardo DiCaprio' não encontrado. Vamos cadastrá-lo!
Gênero (M/F): M
Data de Nascimento (dd/MM/yyyy): 11/11/1974
...
✅ Filme cadastrado com sucesso: A Origem
```



-----



## 🏗️ Decisões de Design e Próximos Passos

### 🛠️ Decisões de Design

  - **Encapsulamento:** Utiliza `protected` em `Pessoa` e retorna **cópias defensivas** de listas para proteger o estado interno.
  - **Herança:** A classe `Pessoa` estabelece um contrato claro (`exibirInfo()`), que deve ser implementado pelas subclasses (`Ator`, `Diretor`).
  - **Igualdade Semântica:** Os métodos `equals()` e `hashCode()` são sobrescritos para que as buscas e a prevenção de duplicatas funcionem corretamente, baseando-se nos atributos de `Pessoa`.
  - **Experiência do Usuário (UX):** A criação sob demanda é uma escolha de design para otimizar o fluxo de cadastro no console, evitando interrupções.

### 📈 Próximos Passos

  - **Persistência de Dados:** Implementar um repositório para salvar os dados em arquivos ou em um banco de dados, para que não se percam ao encerrar o programa.
  - **Arquitetura:** Evoluir a arquitetura para separar a lógica de domínio da interface de console, usando **DTOs** (Data Transfer Objects) para um design mais limpo.
  - **Testes:** Adicionar **testes unitários** para garantir a corretude dos serviços e entidades.
  - **Interface:** Expandir o projeto com uma interface gráfica (usando **JavaFX** ou **Swing**) ou expor uma **API REST** (usando **Spring Boot**) para torná-lo mais moderno e acessível.
