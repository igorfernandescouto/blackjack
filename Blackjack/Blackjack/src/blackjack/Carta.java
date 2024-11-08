/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/* Isto é uma celula para ser colocado em uma lista encadeda */

/**
 *
 * @author ...
 */
public class Carta {
    private Naipe naipe;
    private ValorCarta valor;
    private Carta proximaCarta; /* Eh bem estranho fazer isso
                                   Mas foi o jeito de não usar uma List Ou ArrayList */
    
    public Carta(Naipe naipe, ValorCarta valorCarta) {
        this.naipe = naipe;
        this.valor = valorCarta;
        this.proximaCarta = null;
    }
    
    public Naipe getNaipe() {
        return this.naipe;    
    }
    
    public ValorCarta getValor() {
        return this.valor;
    }
    
    public Carta getProximaCarta() {
        return this.proximaCarta;
    }
    
    public void setProximaCarta(Carta proxima) {
        this.proximaCarta = proxima;
    }
    
    @Override
    public String toString() {
        /* Aproveitando o polimorfismo dos tipos enumerados */
        return this.getValor().toString() + this.getNaipe().toString();
    }
    
} 
