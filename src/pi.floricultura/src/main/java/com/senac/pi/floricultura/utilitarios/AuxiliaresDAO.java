package com.senac.pi.floricultura.utilitarios;

public class AuxiliaresDAO {
    public static String ligaVetorAND(String[] str){
        String concat = "";
        for (String string : str) {
            if (concat.equals("")){
                if (string != null){
                    concat += string;
                }
            }else{
                if (string != null){
                    concat += " AND " + string;
                }
            }
        }
        return concat;
    }
}
