/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author ...
 */
public class DeckVazio extends Exception {
        @Override
        public String getMessage() { return "DECK VAZIO!! (UNDERFLOW!)"; }
}