// Diz que esta interface está no pacote "dao".
package br.com.rpires.dao;

// Precisamos "importar" o molde Contrato para poder falar sobre ele aqui.
import br.com.rpires.Contrato;

/**
 * Esta é a Interface (o "contrato de regras") para o nosso Acessador de Dados (DAO).
 * Qualquer classe que queira acessar os dados de Contrato no banco de dados
 * é OBRIGADA a ter estes 4 métodos.
 */
public interface IContratoDao {

    // Regra 1: A classe contratada precisa ter um método chamado "salvar".
    void salvar();

    // Regra 2: Precisa ter um método chamado "buscar" que recebe um ID e devolve um Contrato.
    Contrato buscar(Long id);

    // Regra 3: Precisa ter um método chamado "atualizar" que recebe um Contrato para atualizar.
    void atualizar(Contrato contrato);

    // Regra 4: Precisa ter um método chamado "excluir" que recebe um ID para apagar.
    void excluir(Long id);
}
