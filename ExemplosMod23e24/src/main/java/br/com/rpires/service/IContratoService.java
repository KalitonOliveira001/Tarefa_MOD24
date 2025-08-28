// Diz que esta interface está no pacote "service".
package br.com.rpires.service;

// Importa o molde Contrato.
import br.com.rpires.Contrato;

/**
 * Esta é a Interface (as "regras") para o nosso Serviço de Contrato.
 * Ela define o que o nosso "chefe" de operações de contrato precisa saber fazer.
 */
public interface IContratoService {

    // Regra 1: Precisa ter um método "salvar" que devolve uma mensagem (String).
    String salvar();

    // Regra 2: Precisa ter um método "buscar" que recebe um ID e devolve um Contrato.
    Contrato buscar(Long id);

    // Regra 3: Precisa ter um método "atualizar" que recebe um Contrato e devolve uma mensagem.
    String atualizar(Contrato contrato);

    // Regra 4: Precisa ter um método "excluir" que recebe um ID e devolve uma mensagem.
    String excluir(Long id);
}
