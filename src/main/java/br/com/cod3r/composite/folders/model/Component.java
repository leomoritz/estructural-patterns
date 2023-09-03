package br.com.cod3r.composite.folders.model;

public interface Component {

    /**
     * Permite adicionar componentes ao componente atual.
     *
     * @param component que se deseja adicionar.
     */
    void add(Component component);

    /**
     * Permite remover componentes do componente atual.
     *
     * @param component que se deseja remover.
     */
    void delete(Component component);

    /**
     * Exibe a estrutura de componentes a partir do componente atual.
     *
     * @param structure com a estrutura de componentes.
     */
    void print(String structure);

    /**
     * Verifica se um componente existe no componente atual.
     *
     * @param component que de deseja consultar.
     * @return verdadeiro se o componente existir.
     */
    boolean contains(Component component);

}
