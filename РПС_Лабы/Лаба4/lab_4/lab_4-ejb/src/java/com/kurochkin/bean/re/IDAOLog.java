/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kurochkin.bean.re;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author mikhail
 */
@Remote
public interface IDAOLog {
    List<LogEntity> getAll();
    void add(LogEntity s);
    LogEntity getById(int id);
    void delete(LogEntity s);
    void update(LogEntity s);
}
