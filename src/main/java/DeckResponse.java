
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author teddycormier
 */
public class DeckResponse {
    String deck_id;
//    boolean success;
    CardResponse[] cards;
    
    public static int getCardFromDeck() throws MalformedURLException, IOException{
        Gson gson = new Gson();
        URL cardsAPI = new URL("https://www.deckofcardsapi.com/api/deck/new/draw/?count=1");
        BufferedReader in = new BufferedReader
        (new InputStreamReader(cardsAPI.openStream()));
        DeckResponse loadedItem = gson.fromJson(in, DeckResponse.class);
        String first_card_value = loadedItem.cards[0].value;
       
        if (null != first_card_value)switch(first_card_value) {
            case "JACK" -> {
                String val = "10";
                first_card_value = val;
                }
            case "QUEEN" -> {
                String val = "10";
                first_card_value = val;
                }
            case "KING" -> {
                String val = "10";
                first_card_value = val;
                }
            case "ACE" -> {
                String[] options = { "1", "11"};
                var selection = JOptionPane.showOptionDialog
                (null, "You've drawn an ACE." + "\n" + "Select desired value:", "CHOICE", 0, 2, null, options, options[0]);
                    if (selection == 0) {
                      String val = "1";
                      first_card_value = val;
                    }
                    if (selection == 1) { 
                      String val = "11";
                      first_card_value = val;
                    }
                }
            default -> {
            }
        }
               
        int first_value = Integer.parseInt(first_card_value);
        return first_value;
    }
    
//    public static int getDrawCard() throws MalformedURLException, IOException{
//        Gson gson = new Gson();
//        URL cardsAPI = new URL("https://www.deckofcardsapi.com/api/deck/new/draw/?count=2");
//        BufferedReader in = new BufferedReader(
//        new InputStreamReader(cardsAPI.openStream()));
//        DeckResponse loadedItem = gson.fromJson(in, DeckResponse.class);
//        String first_card_value = loadedItem.cards[0].value;
//        
//        System.out.println(card_value);
//        
//        if (null != card_value)switch(card_value) {
//            case "JACK" -> {
//                String val = "10";
//                card_value = val;
//                }
//            case "QUEEN" -> {
//                String val = "10";
//                card_value = val;
//                }
//            case "KING" -> {
//                String val = "10";
//                card_value = val;
//                }
//            case "ACE" -> {
//                String[] options = { "11", "1"};
//                var selection = JOptionPane.showOptionDialog
//                (null, "Select desired value:", "CHOICE", 0, 2, null, options, options[0]);
//                    if (selection == 0) {
//                      String val = "11";
//                      card_value = val;
//                    }
//                    if (selection == 1) { 
//                      String val = "1";
//                      card_value = val;
//                    }
//                }
//            default -> {
//            }
//        }
//        
//        int value = Integer.parseInt(card_value);
//        
//        return value;
//    }
    
    public static String getCardImage() throws MalformedURLException, IOException{
        Gson gson = new Gson();
        URL cardsAPI = new URL("https://www.deckofcardsapi.com/api/deck/new/draw/?count=1");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(cardsAPI.openStream()));
        DeckResponse loadedItem = gson.fromJson(in, DeckResponse.class);
        String first_image_code = loadedItem.cards[0].code;
        
        String first_image_url = ("https://deckofcardsapi.com/static/img/" + first_image_code + ".png");
        
        System.out.println(first_image_url);
        
        return first_image_url;
    }
}


