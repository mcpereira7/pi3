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
public class EstoqueException extends Exception {

    public EstoqueException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public EstoqueException(String msg) {
        super(msg);
    }

}
