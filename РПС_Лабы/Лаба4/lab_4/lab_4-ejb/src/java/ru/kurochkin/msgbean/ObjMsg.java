/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurochkin.msgbean;

import java.io.Serializable;

/**
 *
 * @author mikhail
 */
public class ObjMsg implements Serializable {
    public int id;
    public String content;
    public ObjMsg(int id, String content) {
        this.content= content;
        this.id = id;
    }
}