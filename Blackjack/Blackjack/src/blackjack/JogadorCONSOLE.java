/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author ...
 */
public class JogadorCONSOLE extends Jogador {
    boolean jogoInterativo;
    
    public JogadorCONSOLE(String nome, Deck baralho) throws DeckVazio {
        super(nome, baralho);
        jogoInterativo = true;
        
    }
    
    @Override
    public void jogada() throws DeckVazio {
        Scanner sc = new Scanner(System.in);
        
        if (jogoInterativo) {
            System.out.printf("%s quer pedir mais uma carta? [SIM ou NAO] --> ", this.getNome());
        
            if (sc.next().equalsIgnoreCase("SIM")) {
                super.jogada();
             }
        } else {
            super.jogada();
        }
        
        
    }
}
