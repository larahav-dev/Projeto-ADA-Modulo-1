# Catálogo de filmes

Um projeto em Java focado em cadastro e consulta de Atores, Diretores e Filmes via console. A modelagem usa herança com uma classe base abstrata (Pessoa) e serviços que encapsulam regras de negócio e persistência em memória.

------

## Visão geral

- **Objetivo:** permitir cadastrar, listar e visualizar atores, diretores e filmes, com fluxo amigável em linha de comando.
- **Modelo:** `Pessoa` (abstrata) é a base para `Ator` e `Diretor`. `Filme` agrega elenco e direção.
- **Serviços:** camadas `ServicosAtor`, `ServicosDiretor` e `ServicosFilme` administram coleções e regras (sem banco de dados).
- **Console:** o `Main` exibe menus e orquestra o fluxo com os serviços.

------

## Funcionalidades

- Atores:
  - Cadastrar, listar e visualizar por nome.
  - Evita duplicidade via `equals`/`hashCode`.
- Diretores:
  - Cadastrar, listar e visualizar por nome.
  - Associação de filmes dirigidos (sem duplicatas).
- Filmes:
  - Cadastrar com título, data de lançamento, classificação, gênero, orçamento e descrição.
  - **Criação on-demand:** se um ator/diretor não existir, o sistema coleta dados completos e cadastra automaticamente.
  - Listar todos e visualizar por título.

------

## Arquitetura e classes

- Pessoa (abstrata):

   atributos comuns e contrato de exibição.

  - Atributos: `nome`, `genero` (true = masculino, false = feminino), `dataNascimento`, `nacionalidade`.
  - Métodos: `getIdadeAnos()`, `exibirInfo()` (abstrato), `equals`/`hashCode`/`toString`.

- Ator (extends Pessoa):

  - Construtor: `Ator(String nome, boolean genero, LocalDate dataNascimento, String nacionalidade)`.
  - Implementa `exibirInfo()` e formata `toString()`.

- Diretor (extends Pessoa):

  - Atributos: lista de `filmesDirigidos` com cópia defensiva no getter.
  - Construtor: `Diretor(String nome, boolean genero, LocalDate dataNascimento, String nacionalidade)`.
  - Métodos: `adicionarFilme(String)`, `exibirInfo()`.

- Filme:

  - Atributos: `titulo`, `dataLancamento`, `classificacaoIndicativa`, `genero`, `orcamento`, `descricao`, `diretorPrincipal`, `elenco (List<Ator>)`, `diretores (List<Diretor>)`.
  - Usado pelo serviço para compor o catálogo.

- ServicosAtor:

  - **Responsabilidades:** cadastrar (com prevenção de duplicatas), listar (cópia defensiva), buscar por nome (Optional).

- ServicosDiretor:

  - **Responsabilidades:** cadastrar (com prevenção de duplicatas), listar (cópia defensiva), buscar por nome (Optional).

- ServicosFilme:

  - **Responsabilidades:** cadastrar filme, buscar por título, listar filmes.
  - **Integração:** ao cadastrar, busca ou cria Ator/Diretor solicitando dados faltantes via console; adiciona o filme ao histórico do Diretor.

------

## Configuração e execução

- **Pré-requisitos:**

  - **Java:** 11 ou superior.
  - **Build:** pode ser compilado via `javac` (projeto simples) ou integrado a Maven/Gradle (opcional).

- **Estrutura sugerida de pastas:**

  - `src/Entity` → `Pessoa.java`, `Ator.java`, `Diretor.java`, `Filme.java`
  - `src/Services` → `ServicosAtor.java`, `ServicosDiretor.java`, `ServicosFilme.java`
  - `src` → `Main.java`

- **Compilar via terminal:**

  ```bash
  cd src
  javac Entity/*.java Services/*.java Main.java
  ```

- **Executar:**

  ```bash
  java Main
  ```

> Dica: se usar pacotes nomeados no `Main` também, ajuste o comando de execução com o nome do pacote e o classpath.

------

## Exemplos de uso

- **Fluxo de filmes:**
  - **Cadastrar filme:** informe título, data de lançamento, classificação, gênero, orçamento, descrição e listas de nomes (diretores/atores).
  - **Criação on-demand:** se “Christopher Nolan” não existir, o sistema pedirá gênero, data de nascimento e nacionalidade para criar o diretor.
  - **Lista/visualização:** visualize todos os filmes ou um específico pelo título.
- **Busca e prevenção de duplicidade:**
  - **Atores/Diretores:** cadastro evita duplicatas com base em igualdade semântica (atributos de `Pessoa` e, no caso de `Diretor`, sua lista de filmes quando pertinente).
  - **Listas protegidas:** getters retornam cópias para não expor estado interno.

Exemplo de sessão (resumida):

```
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
Classificação Indicativa: 14
Gênero: Ficção
Orçamento (ex: 160000000): 160000000
Descrição: Sonhos dentro de sonhos.
Diretores (separados por vírgula): Christopher Nolan
Atores (separados por vírgula): Leonardo DiCaprio, Joseph Gordon-Levitt

🔹 Diretor 'Christopher Nolan' não encontrado. Vamos cadastrá-lo!
Gênero (M/F): M
Data de Nascimento (dd/MM/yyyy): 30/07/1970
Nacionalidade: Britânica

🔹 Ator 'Leonardo DiCaprio' não encontrado. Vamos cadastrá-lo!
Gênero (M/F): M
Data de Nascimento (dd/MM/yyyy): 11/11/1974
Nacionalidade: Americana
...
✅ Filme cadastrado com sucesso: A Origem
```

------

## Decisões de design e próximos passos

- **Design:**
  - **Encapsulamento:** campos `protected` em `Pessoa`; listas expostas via cópia defensiva.
  - **Validação:** `requireNonNull`, `trim` e checagens de entrada em setters/construtores e serviços.
  - **Herança clara:** `Pessoa` concentra responsabilidades comuns; `exibirInfo()` exige implementação nas subclasses.
  - **Igualdade semântica:** `equals`/`hashCode` sustentam buscas e prevenção de duplicatas.
  - **UX em console:** serviços guiam o usuário quando dados faltam (criação on-demand).
- **Próximos passos:**
  - **Persistência:** integrar um repositório (arquivo/DB) para manter dados entre execuções.
  - **DTOs e camada de aplicação:** separar I/O de console da lógica de domínio (limpeza arquitetural).
  - **Validações ricas:** datas plausíveis, orçamento não negativo, listas mínimas (ex.: ao menos 1 diretor).
  - **Testes unitários:** cobrir serviços e entidades (equals/hashCode, regras de cadastro, buscas).
  - **Interface gráfica ou REST:** evoluir para JavaFX/Swing ou expor APIs com Spring Boot..