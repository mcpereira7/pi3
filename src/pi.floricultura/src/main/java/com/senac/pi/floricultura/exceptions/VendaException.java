/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.exceptions;

/**
 *
 * @author Vinicius
 */
public class VendaException extends Exception {

    public VendaException(String message, Throwable cause) {
        super(message, cause);
    }

    public VendaException(String message) {
        super(message);
    }

}
