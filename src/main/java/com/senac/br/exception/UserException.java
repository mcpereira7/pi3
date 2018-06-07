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
public class UserException extends Exception {

    public UserException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UserException(String msg) {
        super(msg);
    }

}
