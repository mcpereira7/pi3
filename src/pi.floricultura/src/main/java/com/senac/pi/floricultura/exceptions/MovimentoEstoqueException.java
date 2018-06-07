/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.exceptions;

/**
 *
 * @author aayan
 */
public class MovimentoEstoqueException extends Exception {

    public MovimentoEstoqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovimentoEstoqueException(String message) {
        super(message);
    }

}
