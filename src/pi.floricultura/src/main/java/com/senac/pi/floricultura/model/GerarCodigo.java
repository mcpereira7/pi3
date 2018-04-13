/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.util.UUID;

/**
 *
 * @author Rerum
 */
public class GerarCodigo {
    private final UUID uuid = UUID.randomUUID();
    private String codigo;

    
    public GerarCodigo() {
    }

    public String getCodigoCli() {
        return codigo;
    }

    public String setCodigoCli() {
        return this.codigo = uuid.toString().replace("-", "C");
    }
    
    public String getCodigoProd() {
        return codigo;
    }

    public String setCodigoProd() {
        return this.codigo = uuid.toString().replace("-", "P");
    }
    
    public String getCodigoFunc() {
        return codigo;
    }

    public String setCodigoFunc() {
        return this.codigo = uuid.toString().replace("-", "F");
    }
    
    public String getCodigoVenda() {
        return codigo;
    }

    public String setCodigoVenda() {
        return this.codigo = uuid.toString().replace("-", "V");
    }
    
    public String getCodigoUsuario() {
        return codigo;
    }

    public String setCodigoUsuario() {
        return this.codigo = uuid.toString().replace("-", "U");
    }
    
    public String getCodigoEnd() {
        return codigo;
    }

    public String setCodigoEnd() {
        return this.codigo = uuid.toString().replace("-", "E");
    }
    
    public String getCodigoContato() {
        return codigo;
    }

    public String setCodigoContato() {
        return this.codigo = uuid.toString().replace("-", "A");
    }
}
