/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brunoyillli.restrequester.data;

import io.github.brunoyillli.restinterface.model.ICidade;
import lombok.Data;

/**
 *
 * @author wolft
 */
@Data
public class Cidade implements ICidade {
    private int id;
    private String nome;
}
