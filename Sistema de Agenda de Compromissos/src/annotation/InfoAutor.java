package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação personalizada para informações do autor
 * 
 * @InfoAutor - Anotação para marcar classes com informações do autor
 * Retém em tempo de execução (RUNTIME) e pode ser aplicada em tipos (classes)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface InfoAutor {
    /**
     * Nome do autor
     */
    String nome();
    
    /**
     * Data de criação ou versão
     */
    String data();
    
    /**
     * Versão do projeto
     */
    String versao() default "1.0";
    
    /**
     * Descrição do componente
     */
    String descricao() default "";
}