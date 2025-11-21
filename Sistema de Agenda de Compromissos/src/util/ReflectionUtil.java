package util;

import annotation.InfoAutor;

/**
 * Utilitário para leitura de anotações via Reflection
 */
public class ReflectionUtil {
    
    /**
     * Lê e imprime informações da anotação @InfoAutor de uma classe
     * @param clazz A classe a ser analisada
     */
    public static void lerInfoAutor(Class<?> clazz) {
        if (clazz.isAnnotationPresent(InfoAutor.class)) {
            InfoAutor info = clazz.getAnnotation(InfoAutor.class);
            System.out.println("=== Informações do Autor ===");
            System.out.println("Classe: " + clazz.getSimpleName());
            System.out.println("Autor: " + info.nome());
            System.out.println("Data: " + info.data());
            System.out.println("Versão: " + info.versao());
            if (!info.descricao().isEmpty()) {
                System.out.println("Descrição: " + info.descricao());
            }
            System.out.println("=============================");
        } else {
            System.out.println("Classe " + clazz.getSimpleName() + " não possui anotação @InfoAutor");
        }
    }
    
    /**
     * Lê informações de todas as classes em um pacote (simplificado)
     * @param classes Array de classes para verificar
     */
    public static void lerTodasAnotacoes(Class<?>... classes) {
        System.out.println("\n📖 LENDO ANOTAÇÕES VIA REFLECTION");
        for (Class<?> clazz : classes) {
            lerInfoAutor(clazz);
        }
    }
}