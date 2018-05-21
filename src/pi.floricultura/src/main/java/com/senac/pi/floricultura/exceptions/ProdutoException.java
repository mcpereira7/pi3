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
public class ProdutoException extends Exception {

    public ProdutoException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ProdutoException(String msg) {
        super(msg);
    }

}
