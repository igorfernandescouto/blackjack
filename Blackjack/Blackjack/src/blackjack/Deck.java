/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import java.util.Random;

/* Implementando um deck de cartas como se fosse uma pilha (stack) mesmo */

/**
 *
 * @author ...
 */
public class Deck {
    private Carta cartaNoTopo;  /* TOP da pilha
                                 Classe Carta tem um atributo proximaCarta,
                                 Sem isso eu teria que ter usado List da biblioteca padrão */
    
    private Carta cartaNoFim; /* HEAD da pilha */
    private int qtd_cartas;
     
    public Deck(boolean inicializado) {
        if (inicializado) {
            this.inicializaDeck();       
        }
    }
    
    public Deck() {
        this(true);
    }
    
    private void inicializaDeck() {
        for (Naipe naipe : Naipe.values()) {
            for (ValorCarta valor : ValorCarta.values()) {
                this.colocaCartaTopo(new Carta(naipe, valor));
            }
        }
        
        this.qtd_cartas = 52;
    }
    
    public boolean deckVazio() {
        return (this.cartaNoTopo ==  null);
    }
    
    public void swapTopoComPos(int pos_to_swap) throws DeckVazio {
        Deck baralhoTemporario = new Deck(false);
        Carta cartaDescer = this.retiraCartaTopo();
        
        for (int i = 0; i < pos_to_swap; i++)
            baralhoTemporario.colocaCartaTopo(this.retiraCartaTopo());

        Carta cartaSubir = this.retiraCartaTopo();
        this.colocaCartaTopo(cartaDescer);        
        
        for (int i = 0; i < pos_to_swap; i++) {
            this.colocaCartaTopo(baralhoTemporario.retiraCartaTopo());
        }
        
        this.colocaCartaTopo(cartaSubir);    
    }
        
        
    /* Eu quero realmente evitar usar List e ou ArrayList 
       Então eu realmente fiz um embaralhar para uma estrutura de pilha
       Usando uma pilha temporaria
    */
    public void embaralhar(Random semente) throws DeckVazio {
        Deck deckFinal = new Deck(false); /* Pilha vazia */
        
        Random rand = new Random();
        int n = this.qtd_cartas;
        
        while (n > 1) {
            n--;
            int k = rand.nextInt(n + 1);
            this.swapTopoComPos(k-1);
            deckFinal.colocaCartaTopo(this.retiraCartaTopo());
        }
        
        /* O Jeito que eu implementei o swap final deixa sempre uma carta sobrando */
        deckFinal.colocaCartaTopo(this.retiraCartaTopo());
        while (!deckFinal.deckVazio())
            this.colocaCartaTopo(deckFinal.retiraCartaTopo());
        
    }
          
    public void colocaCartaTopo(Carta carta) { /* Equivalente PUSH da pilha */
        if (this.deckVazio()) {
            this.cartaNoFim = carta;
            this.cartaNoTopo = carta;
        } else {
            this.cartaNoTopo.setProximaCarta(carta);
            this.cartaNoTopo = carta;
        }
        
        this.qtd_cartas++;
    }
    
    public Carta retiraCartaTopo() throws DeckVazio { /* Equivalente POP da pilha */
        if (this.deckVazio()) {
            throw new DeckVazio(); /* Uma Exceção customizada */
        } else {
            Carta cartaRetornada = this.cartaNoTopo;
            
            if (this.cartaNoFim == this.cartaNoTopo) { /* Tratando o caso de ter uma carta só */
                this.cartaNoFim = null;
                this.cartaNoTopo = null;
            } else {
                /* Vamos ter que iterar como se fosse uma lista
                   Anular o ultimo elemento e mudar o topo para a carta anterior ( a carta de baixo do topo )
                */
                Carta temp = this.cartaNoFim;
                while (temp.getProximaCarta() != this.cartaNoTopo) 
                    temp = temp.getProximaCarta();
                
                temp.setProximaCarta(null); /* Topo original foi anulado */
                this.cartaNoTopo = temp; /* Agora o topo é a carta anterior */   
            }
            
            this.qtd_cartas--;
            return cartaRetornada;
        } /* Fechando aquele if ... else do começo do metodo */
    } /* Fechando o método retiraCartaTopo */
    
}
