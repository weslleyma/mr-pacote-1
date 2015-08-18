/*
 * Copyright (c) 2015. Instituto de Informática (UFG)
 */

package br.inf.ufg.fabrica.mr;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Valida decisões de tipos em Java empregados pela
 * implementação do Modelo de Referência.
 */
public class ModeloDeReferenciaSupportTest {

    @Test
    public void armazeneByte() {
        byte b = 0;
        for (int i = 0; i < 256; i++) {
            b = (byte)i;
            assertEquals(i, obtenhaByte(b));
        }
    }

    /**
     * Obtém valor inteiro correspondente a um
     * valor de 0 a 255, armazenado em um byte.
     *
     * @param entrada Valor do byte (com sinal em Java).
     * @return Valor inteiro, de 0 a 255, inclusive,
     * armazenado em um único byte com sinal.
     */
    public static int obtenhaByte(byte entrada) {
        return entrada & 0xFF;
    }

}