/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author ...
 */
public enum Naipe {
    ESPADAS('♠'), COPAS('♥'), OUROS('♦'), PAUS('♣');
    
    /* Construtor do enum, deve ser privado e recebe os simbolos definidos acima */
    private final char simbolo;
    Naipe(char simbolo) {
        this.simbolo = simbolo;
    }
    
    /* Ja aproveitando o proprio valueOf dos simbolos */
    @Override
    public String toString() {
        return String.valueOf(this.simbolo);
    }
    
    /* Setters e Getters não foram necessários (como de costume para muitos enums */ 
}
