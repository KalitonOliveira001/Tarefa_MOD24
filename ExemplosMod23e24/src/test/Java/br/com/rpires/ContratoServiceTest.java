// Diz que esta classe de teste está no pacote "br.com.rpires".
package br.com.rpires;

// Importa as regras do DAO.
import br.com.rpires.dao.IContratoDao;
// Importa nosso DAO de mentirinha (Mock).
import br.com.rpires.dao.mocks.ContratoDaoMock;
// Importa o molde Contrato.
import br.com.rpires.Contrato;
// Importa nosso Serviço.
import br.com.rpires.service.ContratoService;
// Importa as regras do Serviço.
import br.com.rpires.service.IContratoService;

// Importa as ferramentas do JUnit para fazer as verificações (Asserts).
import org.junit.Assert;
// Importa a anotação @Test, que marca um método como um teste.
import org.junit.Test;

/**
 * Esta classe testa o nosso ContratoService para garantir que tudo funciona como esperado.
 * Este é o coração do TDD (Desenvolvimento Guiado por Testes).
 */
public class ContratoServiceTest {

    // A anotação @Test diz ao JUnit: "Ei, este método é um teste, rode ele!".
    @Test
    public void salvarTest() {
        // PREPARAÇÃO: Criamos nosso DAO de mentirinha (Mock).
        IContratoDao mock = new ContratoDaoMock();
        // PREPARAÇÃO: Criamos nosso Serviço, entregando o Mock para ele usar.
        IContratoService service = new ContratoService(mock);
        // AÇÃO: Chamamos o método que queremos testar.
        String retorno = service.salvar();
        // VERIFICAÇÃO: Verificamos se o resultado foi o esperado ("Sucesso").
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscarTest() {
        // PREPARAÇÃO:
        IContratoDao mock = new ContratoDaoMock();
        IContratoService service = new ContratoService(mock);
        // PREPARAÇÃO: Criamos um contrato novo para salvar e depois buscar.
        Contrato contrato = new Contrato();
        contrato.setDescricao("Contrato de Teste");
        // AÇÃO (1): Salvamos o contrato no nosso mock.
        service.atualizar(contrato);

        // AÇÃO (2): Buscamos o contrato que acabamos de salvar (o mock deu o ID 1 para ele).
        Contrato contratoBuscado = service.buscar(1L);

        // VERIFICAÇÃO (1): Verificamos se o contrato encontrado não é nulo (vazio).
        Assert.assertNotNull(contratoBuscado);
        // VERIFICAÇÃO (2): Verificamos se a descrição do contrato encontrado é a mesma que salvamos.
        Assert.assertEquals("Contrato de Teste", contratoBuscado.getDescricao());
    }

    @Test
    public void atualizarTest() {
        // PREPARAÇÃO:
        IContratoDao mock = new ContratoDaoMock();
        IContratoService service = new ContratoService(mock);
        Contrato contrato = new Contrato();
        contrato.setDescricao("Contrato para Atualizar");

        // AÇÃO: Chamamos o método de atualizar.
        String retorno = service.atualizar(contrato);

        // VERIFICAÇÃO: Verificamos se o retorno foi "Sucesso".
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void excluirTest() {
        // PREPARAÇÃO:
        IContratoDao mock = new ContratoDaoMock();
        IContratoService service = new ContratoService(mock);
        Contrato contrato = new Contrato();
        contrato.setDescricao("Contrato para Excluir");
        // AÇÃO (1): Primeiro, salvamos o contrato para ter o que excluir.
        service.atualizar(contrato);

        // AÇÃO (2): Agora, excluímos o contrato (que tem o ID 1).
        String retorno = service.excluir(1L);

        // VERIFICAÇÃO (1): Verificamos se o método de excluir retornou "Sucesso".
        Assert.assertEquals("Sucesso", retorno);

        // VERIFICAÇÃO (2): Tentamos buscar o contrato que foi excluído.
        Contrato contratoExcluido = service.buscar(1L);
        // VERIFICAÇÃO (3): Verificamos se o resultado da busca é nulo (vazio), provando que foi excluído.
        Assert.assertNull(contratoExcluido);
    }
}
