/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author ...
 */
public enum ValorCarta {
    AS(1, "A"),
    DOIS(2, "2"), TRES(3, "3"), QUATRO(4, "4"), 
    CINCO(5, "5"), SEIS(6, "6"), SETE(7, "7"),
    OITO(8, "8"), NOVE(9, "9"), DEZ(10, "10"),
    VALETE(10, "J"), DAMA(10, "Q"), REI(10, "K");
    
    /* Construtor de um enum tipado */
    private final int valor;
    private final String simbolo;
    ValorCarta(int valor, String simbolo) {
        this.valor = valor;
        this.simbolo = simbolo;
    }
    
    public int getValor() {
        return this.valor;
    }
    
    @Override
    public String toString() {
        return this.simbolo;
    }
    
}
