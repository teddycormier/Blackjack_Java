
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
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
    private boolean playerFirstCard = false;
    private boolean playerSecondCard = false;
    private boolean playerThirdCard = false;
    private boolean playerFourthCard = false;
    private boolean playerFifthCard = false;
    private boolean dealerFirstCard = false;
    private boolean dealerSecondCard = false;
    private boolean dealerThirdCard = false;
    private boolean dealerFourthCard = false;
    private boolean dealerFifthCard = false;
    private boolean playerCard1 = false;
    private boolean playerCard2 = false;
    private boolean playerCard3 = false;
    private boolean playerCard4 = false;
    private boolean playerCard5 = false;
    private boolean dealerCard1 = false;
    private boolean dealerCard2 = false;
    private boolean dealerCard3 = false;
    private boolean dealerCard4 = false;
    private boolean dealerCard5 = false;
    private int tmp_player_card = 0;
    private int tmp_dealer_card = 0;
    private String https = "https://deckofcardsapi.com/static/img/";
    private String file_type = ".png";
    
    private ArrayList<Integer> player_cards = new ArrayList<Integer>();
    private ArrayList<Integer> dealer_cards = new ArrayList<Integer>();
    private ArrayList<String> card_suits = new ArrayList<String>();
    private ArrayList<String> card_faces = new ArrayList<String>();
    
    private void addSuitsFaces(){
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
    }
    
    private void shuffleCollections(){
        Collections.shuffle(card_suits);
        Collections.shuffle(card_faces);
    }
    
    private int playerSum(){
        int player_sum = 0;
        for (int number : player_cards){
            player_sum += number;
        }
        
        return player_sum;
    }
    
    private int dealerSum(){
        int dealer_sum = 0;
        for (int number : dealer_cards){
            dealer_sum += number;
        }
        
        return dealer_sum;
    }
    
    private void createURLandIcon(String card_num, String card_suit) throws IOException{
        try {
            String total_URL = https + card_num + card_suit + file_type;
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
        } catch (MalformedURLException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void findRightCardD(){
        if (dealerFirstCard != true){
            tmp_dealer_card = dealer_cards.get(0);
            dealerFirstCard = true;
        }
        else if (dealerSecondCard != true){
            
            tmp_dealer_card = dealer_cards.get(1);
            dealerSecondCard = true;
        }
        else if (dealerThirdCard != true){
            tmp_dealer_card = dealer_cards.get(2);
            dealerThirdCard = true;
        }
        else if (dealerFourthCard != true){
            tmp_dealer_card = dealer_cards.get(3);
            dealerFourthCard = true;
        }
        else if (dealerFifthCard != true){
            tmp_dealer_card = dealer_cards.get(4);
            dealerFifthCard = true;
        }
    }
    
    private void setRightIconD(){
        if (tmp_dealer_card == dealer_cards.get(0) && (dealerCard1 == false)){
            dealer_card_1.setVisible(true);
            dealerCard1 = true;
            dealer_card_1.setIcon(icon);
        }
        else if (tmp_dealer_card == dealer_cards.get(1) && (dealerCard2 == false)){
            dealer_card_2.setVisible(true);
            dealerCard2 = true;
            dealer_card_2.setIcon(icon);
        }
        else if (tmp_dealer_card == dealer_cards.get(2) && (dealerCard3 == false)){
            dealer_card_3.setVisible(true);
            dealerCard3 = true;
            dealer_card_3.setIcon(icon);
        }
        else if (tmp_dealer_card == dealer_cards.get(3) && (dealerCard4 == false)){
            dealer_card_4.setVisible(true);
            dealerCard4 = true;
            dealer_card_4.setIcon(icon);
        }
        else if (tmp_dealer_card == dealer_cards.get(4) && (dealerCard5 == false)){
            dealer_card_5.setVisible(true);
            dealerCard5 = true;
            dealer_card_5.setIcon(icon);
        }
    }
    
    private void getDealerCard() throws IOException{
        dealer_cards.add(DeckResponse.getCardFromDeck());
        findRightCardD();
        shuffleCollections();
        if (tmp_dealer_card == 10){
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            createURLandIcon(card_num, card_suit);
            setRightIconD();
        }
        else if ((tmp_dealer_card == 1) || (tmp_dealer_card == 11)){
            String card_suit = card_suits.get(0);
            String card_num = "A";
            createURLandIcon(card_num, card_suit);
            setRightIconD();
        }
        else if (tmp_dealer_card < 10){
            String card_num = String.valueOf(tmp_dealer_card);
            String card_suit = card_suits.get(0);
            createURLandIcon(card_num, card_suit);
            setRightIconD();
        }
    }
    
    private void findRightCardP(){
        if (playerFirstCard != true){
            tmp_player_card = player_cards.get(0);
            playerFirstCard = true;
        }
        else if (playerSecondCard != true){
            tmp_player_card = player_cards.get(1);
            playerSecondCard = true;
        }
        else if (playerThirdCard != true){
            tmp_player_card = player_cards.get(2);
            playerThirdCard = true;
        }
        else if (playerFourthCard != true){
            tmp_player_card = player_cards.get(3);
            playerFourthCard = true;
        }
        else if (playerFifthCard != true){
            tmp_player_card = player_cards.get(4);
            playerFifthCard = true;
        }
    }
    
    private void setRightIconP(){
        if (tmp_player_card == player_cards.get(0) && (playerCard1 == false)){
            player_card_1.setVisible(true);
            playerCard1 = true;
            player_card_1.setIcon(icon);
        }
        else if (tmp_player_card == player_cards.get(1) && (playerCard2 == false)){
            player_card_2.setVisible(true);
            playerCard2 = true;
            player_card_2.setIcon(icon);
        }
        else if (tmp_player_card == player_cards.get(2) && (playerCard3 == false)){
            player_card_3.setVisible(true);
            playerCard3 = true;
            player_card_3.setIcon(icon);
        }
        else if (tmp_player_card == player_cards.get(3) && (playerCard4 == false)){
            player_card_4.setVisible(true);
            playerCard4 = true;
            player_card_4.setIcon(icon);
        }
        else if (tmp_player_card == player_cards.get(4) && (playerCard5 == false)){
            player_card_5.setVisible(true);
            playerCard5 = true;
            player_card_5.setIcon(icon);
        }
    }
    
    
    private void getPlayerCard() throws IOException{
        player_cards.add(DeckResponse.getCardFromDeck());
        findRightCardP();
        shuffleCollections();
        if (tmp_player_card == 10){
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            createURLandIcon(card_num, card_suit);
            setRightIconP();
        }
        else if ((tmp_player_card == 1) || (tmp_player_card == 11)){
            String card_suit = card_suits.get(0);
            String card_num = "A";
            createURLandIcon(card_num, card_suit);
            setRightIconP();
        }
        else if (tmp_player_card < 10){
            String card_num = String.valueOf(tmp_player_card);
            String card_suit = card_suits.get(0);
            createURLandIcon(card_num, card_suit);
            setRightIconP();
        }
    }
    
    private void newSetOfCards() throws IOException{
        cleanUp();
        dealer_cards.clear();
        player_cards.clear();
        addSuitsFaces();

        getDealerCard();
        if (dealer_cards.get(0) == 1){
            dealer_cards.set(0, 11);
        }
        getDealerCard();
        if ((dealer_cards.get(1) == 1) && (dealer_cards.get(0) != 11)){
            dealer_cards.set(1, 11);
        }
        
        dealerSum();

        getPlayerCard();
        if (player_cards.get(0) == 1){
            player_cards.set(0, 11);
        }
        getPlayerCard();
        if ((player_cards.get(1) == 1) && (player_cards.get(0) != 11)){
            player_cards.set(1, 11);
        }
        
        playerSum();
    }
    
    private void cleanUp(){
        playerFirstCard = false;
        playerSecondCard = false;
        playerThirdCard = false;
        playerFourthCard = false;
        playerFifthCard = false;
        dealerFirstCard = false;
        dealerSecondCard = false;
        dealerThirdCard = false;
        dealerFourthCard = false;
        dealerFifthCard = false;
        player_card_3.setVisible(false);
        player_card_4.setVisible(false);
        player_card_5.setVisible(false);
        dealer_card_3.setVisible(false);
        dealer_card_4.setVisible(false);
        dealer_card_5.setVisible(false);
        playerCard1 = false;
        playerCard2 = false;
        playerCard3 = false;
        playerCard4 = false;
        playerCard5 = false;
        dealerCard1 = false;
        dealerCard2 = false;
        dealerCard3 = false;
        dealerCard4 = false;
        dealerCard5 = false;
    }
    
    private void newCardsAfterBeatingDealer() throws IOException{
        JOptionPane.showMessageDialog
        (null,"You beat the dealer", "", JOptionPane.OK_OPTION);

        cleanUp();
        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
    }
    
    private void newCardsAfterLosingToDealer() throws IOException{
        JOptionPane.showMessageDialog
        (null,"You lost to the dealer", "", JOptionPane.OK_OPTION);

        newSetOfCards();
    }
    
    private void newCardsAfterPlayerHitBlackjack() throws IOException{
        JOptionPane.showMessageDialog
        (null,"BLACKJACK", "", JOptionPane.OK_OPTION);

        newSetOfCards();
    }
    
    private void newCardsAfterDealerHitBlackjack() throws IOException{
        JOptionPane.showMessageDialog
        (null,"DEALER HIT BLACKJACK", "", JOptionPane.OK_OPTION);

        newSetOfCards();
    }
    
    private void newCardsAfterPush() throws IOException{
        JOptionPane.showMessageDialog
        (null,"It's a push", "", JOptionPane.OK_OPTION);

        newSetOfCards();
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
        players_hand_onscreen_text = new javax.swing.JLabel();
        dealers_hand_onscreen_text1 = new javax.swing.JLabel();
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
        dealer_card_1.setBounds(40, 40, 110, 160);

        dealer_card_2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dealer_card_2);
        dealer_card_2.setBounds(200, 40, 110, 160);

        dealer_card_3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dealer_card_3);
        dealer_card_3.setBounds(360, 40, 110, 160);

        dealer_card_4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dealer_card_4);
        dealer_card_4.setBounds(520, 40, 110, 160);

        dealer_card_5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dealer_card_5);
        dealer_card_5.setBounds(680, 40, 110, 160);

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

        players_hand_onscreen_text.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        players_hand_onscreen_text.setForeground(new java.awt.Color(255, 255, 255));
        players_hand_onscreen_text.setText("PLAYERS HAND");
        getContentPane().add(players_hand_onscreen_text);
        players_hand_onscreen_text.setBounds(10, 240, 200, 20);

        dealers_hand_onscreen_text1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dealers_hand_onscreen_text1.setForeground(new java.awt.Color(255, 255, 255));
        dealers_hand_onscreen_text1.setText("DEALERS HAND");
        getContentPane().add(dealers_hand_onscreen_text1);
        dealers_hand_onscreen_text1.setBounds(10, 10, 200, 21);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sunset.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stand_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stand_buttonActionPerformed

        playerSum();
        dealerSum();
        int dealer_sum = dealerSum();
        if (dealerSum() < 17){
            try {
                getDealerCard();
                int dealer_card3 = dealer_cards.get(2);
                int dealer_sum2 = dealer_sum + dealer_card3;
                dealer_sum = dealer_sum2;
                System.out.println("Dealer had to hit." + "\n" + "Dealer new card: " + dealer_card3 + "\n" + "New Dealer Total: " + "\n" + dealer_sum2 + "\n");
                if (dealer_sum2 < 17){
                    getDealerCard();
                    int dealer_card4 = dealer_cards.get(3);
                    int dealer_sum3 = dealer_sum2 + dealer_card4;
                    dealer_sum = dealer_sum3;
                    System.out.println("Dealer had to hit." + "\n" + "Dealer new card: " + dealer_card4 + "\n" + "New Dealer Total: " + "\n" + dealer_sum3 + "\n");
                    if (dealer_sum3 < 17){
                        getDealerCard();
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
        if (playerSum() == 21)
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
        else if ((dealer_sum == playerSum()))
        {
            try {
               newCardsAfterPush();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ((dealer_sum > 21) && (playerSum() <= 21))
        {
            try {
                newCardsAfterBeatingDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ((playerSum() < 21) && (dealer_sum < 21) && (playerSum() > dealer_sum))
        {
            try {
                newCardsAfterBeatingDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ((dealer_sum < 21) && (playerSum() < 21) && (dealer_sum > playerSum()))
        {
            try { 
                newCardsAfterLosingToDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ((playerSum() > 21) && (dealer_sum <= 21))
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
                getPlayerCard();
                playerThirdCard = true;
            }
            else if (playerFourthCard != true){
                getPlayerCard();
                playerFourthCard = true;
            }
            else if (playerFifthCard != true){
                getPlayerCard();
                playerFifthCard = true;
            }
        } catch (IOException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        playerSum();
        int sum = playerSum();

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
    private javax.swing.JLabel dealers_hand_onscreen_text1;
    private javax.swing.JButton hit_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel player_card_1;
    private javax.swing.JLabel player_card_2;
    private javax.swing.JLabel player_card_3;
    private javax.swing.JLabel player_card_4;
    private javax.swing.JLabel player_card_5;
    private javax.swing.JLabel players_hand_onscreen_text;
    private javax.swing.JButton stand_button;
    // End of variables declaration//GEN-END:variables
}
