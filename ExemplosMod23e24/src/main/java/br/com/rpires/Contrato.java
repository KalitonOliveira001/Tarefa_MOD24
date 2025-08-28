// Esta linha diz ao Java em qual pacote (pasta) este arquivo está guardado.
package br.com.rpires;

/**
 * Esta classe é o nosso "molde" para criar um objeto do tipo Contrato.
 * Pense nela como uma caixinha de dados com duas etiquetas: "id" e "descricao".
 */
public class Contrato {

    // Esta linha cria uma "etiqueta" privada chamada "id" para guardar o número de identificação do contrato.
    private Long id;

    // Esta linha cria outra "etiqueta" privada chamada "descricao" para guardar o texto do contrato.
    private String descricao;

    /**
     * Este é um "construtor" vazio. O Java às vezes precisa dele para criar
     * uma "caixinha" de Contrato vazia antes de colocar os dados dentro.
     */
    public Contrato() {
    }

    // Este método serve para a gente poder PEGAR (get) o valor que está guardado na etiqueta "id".
    public Long getId() {
        // A palavra "return" significa "devolva". Aqui, ele devolve o valor que está em "id".
        return id;
    }

    // Este método serve para a gente poder COLOCAR (set) um valor na etiqueta "id".
    public void setId(Long id) {
        // "this.id" se refere à etiqueta "id" da nossa caixinha. O outro "id" é o valor que recebemos.
        // Esta linha diz: "Guarde o valor que você recebeu na minha etiqueta id".
        this.id = id;
    }

    // Este método serve para a gente poder PEGAR (get) o valor que está guardado na etiqueta "descricao".
    public String getDescricao() {
        // Devolve o texto que está guardado em "descricao".
        return descricao;
    }

    // Este método serve para a gente poder COLOCAR (set) um valor na etiqueta "descricao".
    public void setDescricao(String descricao) {
        // Guarda o texto que recebemos na nossa etiqueta "descricao".
        this.descricao = descricao;
    }
}
