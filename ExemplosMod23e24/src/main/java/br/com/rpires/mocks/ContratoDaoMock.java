// Diz que esta classe está no pacote "dao.mocks".
package br.com.rpires.dao.mocks;

// Importa o molde Contrato.
import br.com.rpires.Contrato;
// Importa as regras (Interface) que esta classe precisa seguir.
import br.com.rpires.dao.IContratoDao;

// Importa ferramentas do Java para criar um "mapa" em memória.
import java.util.HashMap;
import java.util.Map;

/**
 * Esta é uma implementação "Mock" (de mentirinha) do nosso DAO.
 * A palavra "implements IContratoDao" significa que esta classe PROMETE seguir as regras daquela interface.
 */
public class ContratoDaoMock implements IContratoDao {

    // Aqui criamos um "mapa" para simular nossa tabela do banco de dados. Ele vai guardar Contratos usando o ID como chave.
    private Map<Long, Contrato> armazenamento = new HashMap<>();
    // Este é um contador para gerar IDs novos (1, 2, 3...).
    private Long sequencia = 1L;

    // Este é o método "salvar" que a interface nos obrigou a ter.
    @Override
    public void salvar() {
        // Para o nosso teste, não precisamos fazer nada aqui, pois o "atualizar" já faz o trabalho de salvar.
    }

    // Este é o método "buscar" que a interface nos obrigou a ter.
    @Override
    public Contrato buscar(Long id) {
        // Pega o contrato do nosso "mapa" usando o ID que recebemos. Se não encontrar, devolve null (vazio).
        return armazenamento.get(id);
    }

    // Este é o método "atualizar" que a interface nos obrigou a ter.
    @Override
    public void atualizar(Contrato contrato) {
        // Se o contrato que recebemos ainda não tem um ID...
        if (contrato.getId() == null) {
            // ...nós geramos um novo ID para ele usando nosso contador.
            contrato.setId(sequencia++);
        }
        // Agora, colocamos o contrato (novo ou atualizado) dentro do nosso "mapa" de armazenamento.
        armazenamento.put(contrato.getId(), contrato);
    }

    // Este é o método "excluir" que a interface nos obrigou a ter.
    @Override
    public void excluir(Long id) {
        // Remove o contrato do nosso "mapa" usando o ID que recebemos.
        armazenamento.remove(id);
    }
}
