
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author teddycormier
 */
public class GameScreen extends javax.swing.JFrame {
    /**
     * Creates new form GameScreen
     * @throws java.io.IOException
     */
    RulesScreen rulesScreen;
    private ImageIcon icon;
    public boolean playerThirdCard = false;
    public boolean playerFourthCard = false;
    public boolean playerFifthCard = false;
    public boolean dealerThirdCard = false;
    public boolean dealerFourthCard = false;
    public boolean dealerFifthCard = false;
    
    ArrayList<Integer> player_cards = new ArrayList<Integer>();
    ArrayList<Integer> dealer_cards = new ArrayList<Integer>();
    ArrayList<String> card_suits = new ArrayList<String>();
    ArrayList<String> card_faces = new ArrayList<String>();
    
    private void newSetOfCards(){
        // ----------------
        card_suits.add("H");
        card_suits.add("C");
        card_suits.add("S");
        card_suits.add("D");
        // ----------------
        card_faces.add("J");
        card_faces.add("Q");
        card_faces.add("K");
        // ----------------
        
        try {
            dealer_cards.add(DeckResponse.getCardFromDeck());
            int dealer_card1 = dealer_cards.get(0);
            if (dealer_card1 == 1){
                dealer_cards.set(0, 11);
                dealer_card1 = dealer_cards.get(0);
            }
            dealer_cards.add(DeckResponse.getCardFromDeck());
            int dealer_card2 = dealer_cards.get(1);
            if ((dealer_card2 == 1) && (dealer_card1 != 11)){
                dealer_cards.set(1, 11);
                dealer_card2 = dealer_cards.get(1);
            }
            
            //------------------------------------------------------------
            
            int card1 = dealer_cards.get(0);
            String https = "https://deckofcardsapi.com/static/img/";
            int tmp_convert = card1;
            Collections.shuffle(card_suits);
            Collections.shuffle(card_faces);
            if (tmp_convert == 10){
                String card_num = card_faces.get(0);
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https + card_num + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                dealer_card_1.setIcon(icon);
            }
            else if ((tmp_convert == 1) || (tmp_convert == 11)){
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https + "A" + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                dealer_card_1.setIcon(icon);
            }
            else if (tmp_convert < 10){
                String card_num = String.valueOf(tmp_convert);
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https + card_num + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                dealer_card_1.setIcon(icon);
            }
            
            int card2 = dealer_cards.get(1);
            String https2 = "https://deckofcardsapi.com/static/img/";
            int tmp_convert2 = card2;
            Collections.shuffle(card_suits);
            Collections.shuffle(card_faces);
            if (tmp_convert2 == 10){
                String card_num = card_faces.get(0);
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https2 + card_num + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                dealer_card_2.setIcon(icon);
            }
            else if ((tmp_convert2 == 1) || (tmp_convert2 == 11)){
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https2 + "A" + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                dealer_card_2.setIcon(icon);
            }
            else if (tmp_convert2 < 10){
                String card_num = String.valueOf(tmp_convert2);
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https2 + card_num + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                dealer_card_2.setIcon(icon);
            }
        
            //----------------------------------------------------------------------
            
            int dealer_sum = 0;
            for (int number : dealer_cards){
                dealer_sum += number;
            }
            System.out.println("Dealer's Starting Cards: " + "\n" + "?" + "\n" + dealer_card2 + "\n" + "Dealer Current Hand Total: " + "?" + "\n");
            
            player_cards.add(DeckResponse.getCardFromDeck());
            int player_card1 = player_cards.get(0);
            if (player_card1 == 1){
                player_cards.set(0, 11);
                player_card1 = player_cards.get(0);
            }
            player_cards.add(DeckResponse.getCardFromDeck());
            int player_card2 = player_cards.get(1);
            if ((player_card2 == 1) && (player_card1 != 11)){
                player_cards.set(1, 11);
                player_card2 = player_cards.get(1);
            }
            
            // ---------------------------------------------
            int card3 = player_cards.get(0);
            String https3 = "https://deckofcardsapi.com/static/img/";
            int tmp_convert3 = card3;
            Collections.shuffle(card_suits);
            Collections.shuffle(card_faces);
            if (tmp_convert3 == 10){
                String card_num = card_faces.get(0);
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https3 + card_num + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                player_card_1.setIcon(icon);
            }
            else if ((tmp_convert3 == 1) || (tmp_convert3 == 11)){
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https3 + "A" + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                player_card_1.setIcon(icon);
            }
            else if (tmp_convert3 < 10){
                String card_num = String.valueOf(tmp_convert3);
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https3 + card_num + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                player_card_1.setIcon(icon);
            }
            //------------------------------------------------------------
            
            int card4 = player_cards.get(1);
            String https4 = "https://deckofcardsapi.com/static/img/";
            int tmp_convert4 = card4;
            Collections.shuffle(card_suits);
            Collections.shuffle(card_faces);
            if (tmp_convert4 == 10){
                String card_num = card_faces.get(0);
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https4 + card_num + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                player_card_2.setIcon(icon);
            }
            else if ((tmp_convert4 == 1) || (tmp_convert4 == 11)){
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https4 + "A" + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                player_card_2.setIcon(icon);
            }
            else if (tmp_convert4 < 10){
                String card_num = String.valueOf(tmp_convert4);
                String card_suit = card_suits.get(0);
                String file_type = ".png";
                String total_URL = https4 + card_num + card_suit + file_type;
                System.out.println(total_URL);
                URL url = new URL(total_URL);
                BufferedImage bufferedImage = ImageIO.read(url);
                Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
                icon = new ImageIcon(image);
                player_card_2.setIcon(icon);
            }
        
        //----------------------------------------------------------------------
        
            int player_sum = 0;
            for (int number : player_cards){
                player_sum += number;
            }
            System.out.println("Player's Starting Cards: " + "\n" + player_card1 + "\n" + player_card2 + "\n" + "Player Current Hand Total: " + player_sum + "\n");
        } catch (IOException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getDealerThirdCard() throws IOException{
        dealerThirdCard = true;
        dealer_card_3.setVisible(true);
        dealer_cards.add(DeckResponse.getCardFromDeck());
        int card = dealer_cards.get(2);
        String https = "https://deckofcardsapi.com/static/img/";
        int tmp_convert = card;
        Collections.shuffle(card_suits);
        Collections.shuffle(card_faces);
        if (tmp_convert == 10){
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            dealer_card_3.setIcon(icon);
        }
        else if ((tmp_convert == 1) || (tmp_convert == 11)){
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + "A" + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            dealer_card_3.setIcon(icon);
        }
        else if (tmp_convert < 10){
            String card_num = String.valueOf(tmp_convert);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            dealer_card_3.setIcon(icon);
        }
    }
    
    public void getDealerFourthCard() throws IOException{
        dealerFourthCard = true;
        dealer_card_4.setVisible(true);
        dealer_cards.add(DeckResponse.getCardFromDeck());
        int card = dealer_cards.get(3);
        String https = "https://deckofcardsapi.com/static/img/";
        int tmp_convert = card;
        Collections.shuffle(card_suits);
        Collections.shuffle(card_faces);
        if (tmp_convert == 10){
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            dealer_card_4.setIcon(icon);
        }
        else if ((tmp_convert == 1) || (tmp_convert == 11)){
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + "A" + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            dealer_card_4.setIcon(icon);
        }
        else if (tmp_convert < 10){
            String card_num = String.valueOf(tmp_convert);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            dealer_card_4.setIcon(icon);
        }
    }
    
    public void getDealerFifthCard() throws IOException{
        dealerFifthCard = true;
        dealer_card_5.setVisible(true);
        dealer_cards.add(DeckResponse.getCardFromDeck());
        int card = dealer_cards.get(4);
        String https = "https://deckofcardsapi.com/static/img/";
        int tmp_convert = card;
        Collections.shuffle(card_suits);
        Collections.shuffle(card_faces);
        if (tmp_convert == 10){
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            dealer_card_5.setIcon(icon);
        }
        else if ((tmp_convert == 1) || (tmp_convert == 11)){
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + "A" + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            dealer_card_5.setIcon(icon);
        }
        else if (tmp_convert < 10){
            String card_num = String.valueOf(tmp_convert);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            dealer_card_5.setIcon(icon);
        }
    }
    
    public void getPlayerThirdCard() throws IOException{
        playerThirdCard = true;
        player_card_3.setVisible(true);
        player_cards.add(DeckResponse.getCardFromDeck());
        int card = player_cards.get(2);
        String https = "https://deckofcardsapi.com/static/img/";
        int tmp_convert = card;
        Collections.shuffle(card_suits);
        Collections.shuffle(card_faces);
        if (tmp_convert == 10){
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            player_card_3.setIcon(icon);
        }
        else if ((tmp_convert == 1) || (tmp_convert == 11)){
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + "A" + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            player_card_3.setIcon(icon);
        }
        else if (tmp_convert < 10){
            String card_num = String.valueOf(tmp_convert);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            player_card_3.setIcon(icon);
        }
    }
    
    public void getPlayerFourthCard() throws IOException{
        playerFourthCard = true;
        player_card_4.setVisible(true);
        player_cards.add(DeckResponse.getCardFromDeck());
        int card = player_cards.get(3);
        String https = "https://deckofcardsapi.com/static/img/";
        int tmp_convert = card;
        Collections.shuffle(card_suits);
        Collections.shuffle(card_faces);
        if (tmp_convert == 10){
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            player_card_4.setIcon(icon);
        }
        else if ((tmp_convert == 1) || (tmp_convert == 11)){
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + "A" + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            player_card_4.setIcon(icon);
        }
        else if (tmp_convert < 10){
            String card_num = String.valueOf(tmp_convert);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            player_card_4.setIcon(icon);
        }
    }
    
    public void getPlayerFifthCard() throws IOException{
        playerFifthCard = true;
        player_card_5.setVisible(true);
        player_cards.add(DeckResponse.getCardFromDeck());
        int card = player_cards.get(4);
        String https = "https://deckofcardsapi.com/static/img/";
        int tmp_convert = card;
        Collections.shuffle(card_suits);
        Collections.shuffle(card_faces);
        if (tmp_convert == 10){
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            player_card_5.setIcon(icon);
        }
        else if ((tmp_convert == 1) || (tmp_convert == 11)){
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + "A" + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            player_card_5.setIcon(icon);
        }
        else if (tmp_convert < 10){
            String card_num = String.valueOf(tmp_convert);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            System.out.println(total_URL);
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
            player_card_5.setIcon(icon);
        }
    }
    
    public void cleanUp(){
        playerThirdCard = false;
        playerFourthCard = false;
        playerFifthCard = false;
        dealerThirdCard = false;
        dealerFourthCard = false;
        dealerFifthCard = false;
        player_card_3.setVisible(false);
        player_card_4.setVisible(false);
        player_card_5.setVisible(false);
        dealer_card_3.setVisible(false);
        dealer_card_4.setVisible(false);
        dealer_card_5.setVisible(false);
    }
    
    private void newCardsAfterBeatingDealer() throws IOException{
        JOptionPane.showMessageDialog
        (null,"You beat the dealer", "", JOptionPane.OK_OPTION);

        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
        cleanUp();
    }
    
    private void newCardsAfterLosingToDealer() throws IOException{
        JOptionPane.showMessageDialog
        (null,"You lost to the dealer", "", JOptionPane.OK_OPTION);

        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
        cleanUp();
    }
    
    private void newCardsAfterPlayerHitBlackjack() throws IOException{
        JOptionPane.showMessageDialog
        (null,"BLACKJACK", "", JOptionPane.OK_OPTION);

        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
        cleanUp();
    }
    
    private void newCardsAfterDealerHitBlackjack() throws IOException{
        JOptionPane.showMessageDialog
        (null,"DEALER HIT BLACKJACK", "", JOptionPane.OK_OPTION);

        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
        cleanUp();
    }
    
    private void newCardsAfterPush() throws IOException{
        JOptionPane.showMessageDialog
        (null,"It's a push", "", JOptionPane.OK_OPTION);

        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
        cleanUp();
    }
    
    public GameScreen() throws IOException {
        initComponents();
        newSetOfCards();
        
        rulesScreen = new RulesScreen();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stand_button = new javax.swing.JButton();
        hit_button = new javax.swing.JButton();
        button_rules = new javax.swing.JButton();
        dealer_card_1 = new javax.swing.JLabel();
        dealer_card_2 = new javax.swing.JLabel();
        dealer_card_3 = new javax.swing.JLabel();
        dealer_card_4 = new javax.swing.JLabel();
        dealer_card_5 = new javax.swing.JLabel();
        player_card_1 = new javax.swing.JLabel();
        player_card_2 = new javax.swing.JLabel();
        player_card_3 = new javax.swing.JLabel();
        player_card_4 = new javax.swing.JLabel();
        player_card_5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GAME");
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(null);

        stand_button.setBackground(new java.awt.Color(204, 204, 204));
        stand_button.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        stand_button.setText("Stand");
        stand_button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        stand_button.setMaximumSize(new java.awt.Dimension(68, 22));
        stand_button.setMinimumSize(new java.awt.Dimension(68, 22));
        stand_button.setPreferredSize(new java.awt.Dimension(68, 22));
        stand_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stand_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(stand_button);
        stand_button.setBounds(890, 210, 68, 22);

        hit_button.setBackground(new java.awt.Color(204, 204, 204));
        hit_button.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        hit_button.setText("Hit");
        hit_button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hit_button.setMaximumSize(new java.awt.Dimension(68, 22));
        hit_button.setMinimumSize(new java.awt.Dimension(68, 22));
        hit_button.setPreferredSize(new java.awt.Dimension(68, 22));
        hit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hit_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(hit_button);
        hit_button.setBounds(890, 250, 68, 22);

        button_rules.setBackground(new java.awt.Color(204, 204, 204));
        button_rules.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        button_rules.setText("Rules");
        button_rules.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button_rules.setMaximumSize(new java.awt.Dimension(30, 30));
        button_rules.setMinimumSize(new java.awt.Dimension(30, 30));
        button_rules.setPreferredSize(new java.awt.Dimension(30, 30));
        button_rules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_rulesActionPerformed(evt);
            }
        });
        getContentPane().add(button_rules);
        button_rules.setBounds(900, 10, 60, 20);

        dealer_card_1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dealer_card_1);
        dealer_card_1.setBounds(40, 50, 110, 160);

        dealer_card_2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dealer_card_2);
        dealer_card_2.setBounds(200, 50, 110, 160);

        dealer_card_3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dealer_card_3);
        dealer_card_3.setBounds(360, 50, 110, 160);

        dealer_card_4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dealer_card_4);
        dealer_card_4.setBounds(520, 50, 110, 160);

        dealer_card_5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dealer_card_5);
        dealer_card_5.setBounds(680, 50, 110, 160);

        player_card_1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(player_card_1);
        player_card_1.setBounds(40, 270, 110, 160);

        player_card_2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(player_card_2);
        player_card_2.setBounds(200, 270, 110, 160);

        player_card_3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(player_card_3);
        player_card_3.setBounds(360, 270, 110, 160);

        player_card_4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(player_card_4);
        player_card_4.setBounds(520, 270, 110, 160);

        player_card_5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(player_card_5);
        player_card_5.setBounds(680, 270, 110, 160);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sunset.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stand_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stand_buttonActionPerformed

        int player_sum = 0;
        for (int number : player_cards){
            player_sum += number;
        }
        int dealer_sum = 0;
        for (int number: dealer_cards){
            dealer_sum += number;
        }
        if (dealer_sum < 17){
            try {
                getDealerThirdCard();
                int dealer_card3 = dealer_cards.get(2);
                int dealer_sum2 = dealer_sum + dealer_card3;
                dealer_sum = dealer_sum2;
                System.out.println("Dealer had to hit." + "\n" + "Dealer new card: " + dealer_card3 + "\n" + "New Dealer Total: " + "\n" + dealer_sum2 + "\n");
                if (dealer_sum2 < 17){
                    getDealerFourthCard();
                    int dealer_card4 = dealer_cards.get(3);
                    int dealer_sum3 = dealer_sum2 + dealer_card4;
                    dealer_sum = dealer_sum3;
                    System.out.println("Dealer had to hit." + "\n" + "Dealer new card: " + dealer_card4 + "\n" + "New Dealer Total: " + "\n" + dealer_sum3 + "\n");
                    if (dealer_sum3 < 17){
                        getDealerFifthCard();
                        int dealer_card5 = dealer_cards.get(4);
                        int dealer_sum4 = dealer_sum3 + dealer_card5;
                        dealer_sum = dealer_sum4;
                        System.out.println("Dealer had to hit." + "\n" + "Dealer new card: " + dealer_card5 + "\n" + "New Dealer Total: " + "\n" + dealer_sum4 + "\n");
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (player_sum == 21)
        {
            try {
                newCardsAfterPlayerHitBlackjack();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (dealer_sum == 21)
        {
            try {
                newCardsAfterDealerHitBlackjack();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ((dealer_sum == player_sum))
        {
            try {
               newCardsAfterPush();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ((dealer_sum > 21) && (player_sum <= 21))
        {
            try {
                newCardsAfterBeatingDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ((player_sum < 21) && (dealer_sum < 21) && (player_sum > dealer_sum))
        {
            try {
                newCardsAfterBeatingDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ((dealer_sum < 21) && (player_sum < 21) && (dealer_sum > player_sum))
        {
            try { 
                newCardsAfterLosingToDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ((player_sum > 21) && (dealer_sum <= 21))
        {
            try {
                newCardsAfterLosingToDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_stand_buttonActionPerformed

    private void hit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hit_buttonActionPerformed
       
        try {
            if (playerThirdCard != true){
                getPlayerThirdCard();
            }
            else if (playerFourthCard != true){
                getPlayerFourthCard();
            }
            else if (playerFifthCard != true){
                getPlayerFifthCard();
            }
        } catch (IOException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        int sum = 0;
        for (int number : player_cards){
            sum += number;
        }
        System.out.println("Current Cards: ");
        for (int number : player_cards){
            System.out.println(number);
        }
        System.out.println("Current Hand Total: " + sum + "\n");

        if (sum == 21)
        {
            try {
                newCardsAfterPlayerHitBlackjack();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (sum > 21)
        {
            try {
                newCardsAfterLosingToDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_hit_buttonActionPerformed

    private void button_rulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_rulesActionPerformed
        rulesScreen.setLocationRelativeTo(null);
        rulesScreen.setVisible(true);
    }//GEN-LAST:event_button_rulesActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_rules;
    private javax.swing.JLabel dealer_card_1;
    private javax.swing.JLabel dealer_card_2;
    private javax.swing.JLabel dealer_card_3;
    private javax.swing.JLabel dealer_card_4;
    private javax.swing.JLabel dealer_card_5;
    private javax.swing.JButton hit_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel player_card_1;
    private javax.swing.JLabel player_card_2;
    private javax.swing.JLabel player_card_3;
    private javax.swing.JLabel player_card_4;
    private javax.swing.JLabel player_card_5;
    private javax.swing.JButton stand_button;
    // End of variables declaration//GEN-END:variables
}
