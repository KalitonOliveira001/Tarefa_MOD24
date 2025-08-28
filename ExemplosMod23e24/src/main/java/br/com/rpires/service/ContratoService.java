// Diz que esta classe está no pacote "service".
package br.com.rpires.service;

// Importa o molde Contrato.
import br.com.rpires.Contrato;
// Importa as regras do DAO, pois o serviço vai precisar de um DAO para trabalhar.
import br.com.rpires.dao.IContratoDao;

/**
 * Esta é a implementação do nosso Serviço.
 * A palavra "implements IContratoService" diz que esta classe PROMETE seguir as regras daquela interface.
 */
public class ContratoService implements IContratoService {

    // O serviço tem uma "gaveta" para guardar o DAO (o funcionário) que ele vai usar.
    private IContratoDao contratoDao;

    /**
     * Este é o construtor do serviço. Quando criamos um ContratoService,
     * somos OBRIGADOS a entregar um DAO para ele trabalhar. Isso se chama "Injeção de Dependência".
     */
    public ContratoService(IContratoDao dao) {
        // Guarda o DAO que recebemos na nossa "gaveta".
        this.contratoDao = dao;
    }

    // Implementação do método "salvar" que a interface nos obrigou a ter.
    @Override
    public String salvar() {
        // Manda o DAO (nosso funcionário) fazer a ação de salvar.
        contratoDao.salvar();
        // Devolve a mensagem "Sucesso" para quem chamou.
        return "Sucesso";
    }

    // Implementação do método "buscar".
    @Override
    public Contrato buscar(Long id) {
        // Pede para o DAO buscar o contrato e devolve o que ele encontrar.
        return contratoDao.buscar(id);
    }

    // Implementação do método "atualizar".
    @Override
    public String atualizar(Contrato contrato) {
        // Manda o DAO atualizar o contrato.
        contratoDao.atualizar(contrato);
        // Devolve a mensagem "Sucesso".
        return "Sucesso";
    }

    // Implementação do método "excluir".
    @Override
    public String excluir(Long id) {
        // Manda o DAO excluir o contrato.
        contratoDao.excluir(id);
        // Devolve a mensagem "Sucesso".
        return "Sucesso";
    }
}
