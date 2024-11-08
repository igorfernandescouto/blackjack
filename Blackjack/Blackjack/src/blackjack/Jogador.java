/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/* Tambem serve de celula para a lista circular que é a Mesa */

/**
 *
 * @author ...
 */
public class Jogador {
    private String nome;
    private Deck baralho; /* De onde as cartas estao sendo tiradas */
    private Deck mao;     /* Cartas na sua mao, que contaram sua pontuacao */
    private boolean estourou; /* O jogador pode continuar pedindo cartas? */
    private int pontuacao;
    private Jogador proximoJogador; /* Caso tenha um só jogador podemos setar isso como null,
                                       Caso tenha mais jogadores a Classe inteira é usada como celula de lista circular */
 
    
    public Jogador(String nome, Deck baralhoJogador) throws DeckVazio {
        this.proximoJogador = null; /* Assume que ainda não existe a Mesa (LISTA CIRCULAR) */
        this.nome = nome;
        this.baralho = baralhoJogador;
        
        this.mao = new Deck(false);
        /* Sempre começa pedindo 2 cartas */
        for (int i = 0; i < 2; i++)
            jogada();
        
        System.out.printf("%s tem pontuacao: %d\t\t\t| %s |\n",
                this.nome, this.getPontuacao(), 
                this.getEstourou() ? "ESTOUROU" : "PODE PEDIR MAIS CARTAS");
        
    }
    
    public Carta continuar() throws DeckVazio {
        return this.baralho.retiraCartaTopo();
    }
    
    public boolean podeContinuar() {
        return (this.pontuacao <= 21);
    }
    
    public void jogada() throws DeckVazio {
        Carta carta = this.continuar();
        /*                      getENUM_VALOR().getINT_VALOR() */
        this.pontuacao += carta.getValor().getValor();
        this.mao.colocaCartaTopo(carta);
        this.estourou = !this.podeContinuar();
    }
    
    public int getPontuacao() {
        return this.pontuacao;
    }
    
    public boolean getEstourou() {
        return this.estourou;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Jogador getProximoJogador() {
        return this.proximoJogador;
    }
    
    public void setProximoJogador(Jogador proximoJogador) {
        this.proximoJogador = proximoJogador;
    }
    
}
