/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brunoyillli.operacoesprovider.repository;

import io.github.brunoyillli.operacoesprovider.entity.Soma;
import java.util.ArrayList;

/**
 *
 * @author wolft
 */
public class SomaRepository {

    private static ArrayList<Soma> listSoma = new ArrayList<>();
    private static int nextId = 0;

    public void add(Soma soma) {
        soma.setId(nextId++);
        listSoma.add(soma);
    }

    public ArrayList<Soma> getAll() {
        return listSoma;
    }

    public Soma getSoma(int id) {
        for (Soma soma : listSoma) {
            if (soma.getId() == id) {
                return soma;
            }
        }
        return null;
    }

    public void remove(int id) {
        Soma somaToRemove = null;
        for (Soma soma : listSoma) {
            if (soma.getId() == id) {
                somaToRemove = soma;
                break;
            }
        }
        if (somaToRemove != null) {
            listSoma.remove(somaToRemove);
        }
    }
}
