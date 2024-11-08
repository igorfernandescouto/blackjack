/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

import java.util.Random;

/**
 *
 * @author ....
 */
public class Blackjack {

    public static String resultadoJogada(Jogador jogador, Jogador mesa) { 
        if (jogador.getPontuacao() == 21) /* Redundante mas achei mais claro */
            return jogador.getNome() + " VENCEU! por 21";
        
        if (mesa.getEstourou())
            return "Mesa Estourou e perdeu para " + jogador.getNome();
        else if (jogador.getPontuacao() == mesa.getPontuacao())
            return "FOI UM EMPATE!";
        else if (jogador.getEstourou())
            return jogador.getNome() + " Estourou e perdeu para Mesa";
        else if (jogador.getPontuacao() > mesa.getPontuacao())
            return jogador.getNome() + " VENCEU!";
        
        return "Mesa VENCEU de " + jogador.getNome();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Deck baralhoDaMesa = new Deck();
        
        Random rand = new Random();
        try {
            baralhoDaMesa.embaralhar(rand);
            
            System.out.println("--------------------");
            Mesa mesa = new Mesa(baralhoDaMesa);

            Jogador eu   = new JogadorCONSOLE("Robert", baralhoDaMesa);
            Jogador igor = new JogadorCONSOLE("Igor", baralhoDaMesa);
            Jogador beatriz  = new JogadorCONSOLE("Beatriz", baralhoDaMesa);
            

            mesa.entrarNaMesa(eu);
            mesa.entrarNaMesa(igor);
            mesa.entrarNaMesa(beatriz);
            
            System.out.println("");
            mesa.traversal();
            
            System.out.println(resultadoJogada(igor, mesa.getJogadorMesa()));
            System.out.println(resultadoJogada(eu, mesa.getJogadorMesa()));
            System.out.println(resultadoJogada(beatriz, mesa.getJogadorMesa()));
            
            /*
            while (eu.podeContinuar())
                eu.jogada();
            
            while (mesa.podeContinuar())
                mesa.jogada();
            
            System.out.println(eu.getPontuacao());
            System.out.println(mesa.getPontuacao());
            System.out.println(resultadoJogada(eu, mesa));
            */
            
        } catch (DeckVazio stackUnderflow) {
            System.out.println("VISH");
        }

        
        

    }
    
}
