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
public class CardException extends Exception {

    public CardException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CardException(String msg) {
        super(msg);
    }

}
