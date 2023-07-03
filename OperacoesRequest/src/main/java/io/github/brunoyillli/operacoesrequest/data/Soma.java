/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brunoyillli.operacoesrequest.data;

import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author wolft
 */
@Data
public class Soma {

    private Integer id;
    private BigDecimal operador1;
    private BigDecimal operador2;
    private BigDecimal resultado;

}
