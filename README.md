 Tarefa_MOD24
 Testes e Mocks com JUnit



Este projeto contém a implementação completa da tarefa do Módulo 24, que pedia para expandir o projeto anterior com as operações de CRUD (criar, ler, atualizar, excluir) e a criação de testes unitários seguindo a metodologia TDD.

O que foi feito neste projeto?

Seguindo todos os requisitos do exercício, foram implementadas as seguintes funcionalidades:

Novos Métodos no DAO e Service:
      Foram adicionados os métodos `buscar`, `atualizar` e `excluir` nas interfaces `IContratoDao` e `IContratoService`, definindo o contrato para as novas operações.
 Implementação com Mock (Simulador):
       A classe `ContratoDaoMock` foi atualizada para simular o comportamento de um banco de dados em memória. Ela implementa os novos métodos e permite que os testes sejam executados sem a necessidade de um banco de dados real.

  Implementação da Camada de Serviço:
      A classe `ContratoService` foi criada para conter a lógica de negócio. Ela utiliza o DAO (via injeção de dependência) para orquestrar as operações e retorna "Sucesso" conforme o padrão do exercício.

Testes Unitários com TDD (JUnit):
       A classe `ContratoServiceTest` contém 4 testes, um para cada operação do CRUD (`salvar`, `buscar`, `atualizar` e `excluir`).
      Os testes validam o "caminho feliz", garantindo que o serviço se comporta como esperado ao interagir com o `ContratoDaoMock`.

 Como Rodar os Testes
  Abra o projeto em uma IDE Java (como o IntelliJ IDEA).
  Certifique-se de que as dependências do Maven foram baixadas.
  Navegue até o arquivo: `src/test/java/br/com/rpires/ContratoServiceTest.java`.
  Clique com o botão direito no arquivo e escolha a opção para rodar os testes (Ex: "Run 'ContratoServiceTest'").
Resultado esperado: Todos os 4 testes devem passar com sucesso, exibindo uma barra verde. ✅


