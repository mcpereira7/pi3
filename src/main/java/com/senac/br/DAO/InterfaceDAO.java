/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.DAO;

import com.senac.br.model.Card;
import java.sql.SQLException;

/**
 *
 * @author aayan
 */
public interface InterfaceDAO {

    public abstract void create(Card novo) throws SQLException;

    public abstract Card read(Object e) throws SQLException;

    public abstract void update(Object e) throws SQLException;

    public abstract void delete(Object e) throws SQLException;

}
