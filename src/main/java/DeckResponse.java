
// Teddy Cormier
// DeckResponse -- get a card from the API and get its value
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author teddycormier
 */
public class DeckResponse {

    private CardResponse[] cards;

    // getting cards from API
    public static int getCardFromDeck() throws MalformedURLException, IOException {
        Gson gson = new Gson();
        URL cardsAPI = new URL("https://www.deckofcardsapi.com/api/deck/new/draw/?count=1");
        BufferedReader in = new BufferedReader(new InputStreamReader(cardsAPI.openStream()));
        DeckResponse loadedItem = gson.fromJson(in, DeckResponse.class);
        String card_value = loadedItem.cards[0].value;

        if (null != card_value) {
            switch (card_value) {
                case "JACK" -> {
                    String val = "10";
                    card_value = val;
                }
                case "QUEEN" -> {
                    String val = "10";
                    card_value = val;
                }
                case "KING" -> {
                    String val = "10";
                    card_value = val;
                }
                case "ACE" -> {
                    String val = "1";
                    card_value = val;
                }
                default -> {
                }
            }
        }

        int card_int_value = Integer.parseInt(card_value);
        return card_int_value;
    }
}
