/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author ....
 */
public class Mesa {
    private Jogador atualJogador;
    final private Jogador jogadorMesa; 
    
    public Mesa(Deck baralhoDoJogo) throws DeckVazio {
        Jogador mesa = new Jogador("MESA", baralhoDoJogo);
        mesa.setProximoJogador(mesa);
        
        this.atualJogador = mesa;
        this.jogadorMesa  = mesa;
    }
    
    public void traversal() throws DeckVazio {
        Jogador temp = this.atualJogador;
        
        do {
            
            /* Não quero complicar demais o codigo usando abstract classes
               Nem tipos diferentes de jogada, no momento todos jogadores pedem apenas mais uma carta
               Sem se importar com nenhuma estrategia.
            */
            temp.jogada();
            
            System.out.println(temp.getNome() + " Pontuacao: " + temp.getPontuacao());
            temp = temp.getProximoJogador();
        } while (temp != this.atualJogador);
        
        System.out.println("---------------------");
    }
    
    /* Equivalente a um inserir no fim */
    public void entrarNaMesa(Jogador jogador) {
        jogador.setProximoJogador(this.atualJogador.getProximoJogador());
        this.atualJogador.setProximoJogador(jogador);
        this.atualJogador = jogador;
    }
    
    public Jogador getJogadorAtual() {
        return this.atualJogador;
    }
    
    public Jogador getJogadorMesa() {
        return this.jogadorMesa;
    }
    
    
}
