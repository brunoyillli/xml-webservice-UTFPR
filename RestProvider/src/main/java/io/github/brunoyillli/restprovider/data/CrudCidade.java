/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brunoyillli.restprovider.data;

import java.util.ArrayList;

/**
 *
 * @author wolft
 */
public class CrudCidade {

    private static ArrayList<Cidade> lcid = new ArrayList<>();

    public void add(Cidade cid) {
        lcid.add(cid);
    }

    public ArrayList<Cidade> getAll() {
        return lcid;
    }

    public Cidade getCidade(int id) {
        for (Cidade cidade : lcid) {
            if (cidade.getId() == id) {
                return cidade;
            }
        }
        return null;
    }
}
