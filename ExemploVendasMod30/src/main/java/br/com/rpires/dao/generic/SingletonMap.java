package br.com.rpires.dao.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Singleton que garante que o map será único
 * durante toda a vida da aplicação.
 */
public class SingletonMap {

    private static SingletonMap instance;

    /**
     * Estrutura que simula o banco de dados em memória.
     */
    private final Map<Class<?>, Map<?, ?>> map;

    private SingletonMap() {
        this.map = new HashMap<>();
    }

    /**
     * Retorna a única instância da classe.
     */
    public static SingletonMap getInstance() {
        if (instance == null) {
            instance = new SingletonMap();
        }
        return instance;
    }

    public Map<Class<?>, Map<?, ?>> getMap() {
        return this.map;
    }
}