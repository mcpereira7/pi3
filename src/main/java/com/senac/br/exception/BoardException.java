/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.exception;

/**
 *
 * @author aayan
 */
public class BoardException extends Exception {
    
     public BoardException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BoardException(String msg) {
        super(msg);
    }
}
