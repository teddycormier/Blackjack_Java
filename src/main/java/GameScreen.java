
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

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
    ArrayList<Integer> player_cards = new ArrayList<Integer>();
    ArrayList<Integer> dealer_cards = new ArrayList<Integer>();
    ArrayList<String> card_suits = new ArrayList<String>();
    ArrayList<String> card_faces = new ArrayList<String>();
    
    private void newSetOfCards(){
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
            dealer_card_1.setText(String.valueOf(dealer_card1));
            dealer_card_2.setText(String.valueOf(dealer_card2));
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
            player_card_1.setText(String.valueOf(player_card1));
            player_card_2.setText(String.valueOf(player_card2));
             player_card_3.setText(null);
            int player_sum = 0;
            for (int number : player_cards){
                player_sum += number;
            }
            System.out.println("Player's Starting Cards: " + "\n" + player_card1 + "\n" + player_card2 + "\n" + "Player Current Hand Total: " + player_sum + "\n");
        } catch (IOException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void newCardsAfterBeatingDealer() throws IOException{
        JOptionPane.showMessageDialog
        (null,"You beat the dealer", "", JOptionPane.OK_OPTION);

        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
    }
    
    private void newCardsAfterLosingToDealer() throws IOException{
        JOptionPane.showMessageDialog
        (null,"You lost to the dealer", "", JOptionPane.OK_OPTION);

        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
    }
    
    private void newCardsAfterPlayerHitBlackjack() throws IOException{
        JOptionPane.showMessageDialog
        (null,"BLACKJACK", "", JOptionPane.OK_OPTION);

        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
    }
    
    private void newCardsAfterDealerHitBlackjack() throws IOException{
        JOptionPane.showMessageDialog
        (null,"DEALER HIT BLACKJACK", "", JOptionPane.OK_OPTION);

        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
    }
    
    private void newCardsAfterPush() throws IOException{
        JOptionPane.showMessageDialog
        (null,"It's a push", "", JOptionPane.OK_OPTION);

        dealer_cards.clear();
        player_cards.clear();
        newSetOfCards();
    }
    
    private void getCardImage() throws IOException{
        player_cards.add(DeckResponse.getCardFromDeck());
        int new_card = player_cards.get(2);
        String https = "https://deckofcardsapi.com/static/img/";
        int tmp_convert = new_card;
        Collections.shuffle(card_suits);
        Collections.shuffle(card_faces);
        if (tmp_convert == 10){
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            ImageIcon card = new ImageIcon(total_URL);
            player_card_3.setIcon(card);
            System.out.println(total_URL);
        }
        else if (tmp_convert != 10){
            String card_num = String.valueOf(tmp_convert);
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            ImageIcon card = new ImageIcon(total_URL);
            player_card_3.setIcon(card);
            System.out.println(total_URL);
        }
        else if ((tmp_convert == 1) || (tmp_convert == 11)){
            String card_num = "A";
            String card_suit = card_suits.get(0);
            String file_type = ".png";
            String total_URL = https + card_num + card_suit + file_type;
            ImageIcon card = new ImageIcon(total_URL);
            player_card_3.setIcon(card);
            System.out.println(total_URL);
        }
    }
    
    public GameScreen() throws IOException {
        initComponents();
        newSetOfCards();
        
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
        player_card_1 = new javax.swing.JLabel();
        player_card_2 = new javax.swing.JLabel();
        player_card_3 = new javax.swing.JLabel();
        dealer_card_1 = new javax.swing.JLabel();
        dealer_card_2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GAME");
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(926, 567));
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
        stand_button.setBounds(810, 240, 68, 22);

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
        hit_button.setBounds(810, 280, 68, 22);

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
        button_rules.setBounds(840, 10, 60, 20);
        getContentPane().add(player_card_1);
        player_card_1.setBounds(60, 390, 80, 30);
        getContentPane().add(player_card_2);
        player_card_2.setBounds(190, 390, 80, 30);
        getContentPane().add(player_card_3);
        player_card_3.setBounds(320, 390, 100, 30);
        getContentPane().add(dealer_card_1);
        dealer_card_1.setBounds(50, 30, 100, 30);
        getContentPane().add(dealer_card_2);
        dealer_card_2.setBounds(190, 30, 100, 30);

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
                dealer_cards.add(DeckResponse.getCardFromDeck());
                int dealer_card3 = dealer_cards.get(2);
                int dealer_sum2 = dealer_sum + dealer_card3;
                dealer_sum = dealer_sum2;
                System.out.println("Dealer had to hit." + "\n" + "Dealer new card: " + dealer_card3 + "\n" + "New Dealer Total: " + "\n" + dealer_sum2 + "\n");
                if (dealer_sum2 < 17){
                    dealer_cards.add(DeckResponse.getCardFromDeck());
                    int dealer_card4 = dealer_cards.get(3);
                    int dealer_sum3 = dealer_sum2 + dealer_card4;
                    dealer_sum = dealer_sum3;
                    System.out.println("Dealer had to hit." + "\n" + "Dealer new card: " + dealer_card4 + "\n" + "New Dealer Total: " + "\n" + dealer_sum3 + "\n");
                    if (dealer_sum3 < 17){
                        dealer_cards.add(DeckResponse.getCardFromDeck());
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
        if (dealer_sum == 21){
            try {
                newCardsAfterDealerHitBlackjack();
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
        if ((dealer_sum == player_sum))
        {
            try {
               newCardsAfterPush();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ((dealer_sum > 21) && (player_sum <= 21))
        {
            try {
                newCardsAfterBeatingDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ((player_sum < 21) && (dealer_sum < 21) && (player_sum > dealer_sum))
        {
            try {
                newCardsAfterBeatingDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ((dealer_sum < 21) && (player_sum < 21) && (dealer_sum > player_sum))
        {
            try { 
                newCardsAfterLosingToDealer();
            } catch (IOException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ((player_sum > 21) && (dealer_sum <= 21))
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
            getCardImage();
        } catch (IOException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        int new_card = player_cards.get(2);
        player_card_3.setText(String.valueOf(new_card));

        int sum = 0;
        for (int number : player_cards){
            sum += number;
        }
        System.out.println("Current Cards: ");
        for (int number : player_cards){
            System.out.println(number);
        }
        System.out.println("Current Hand Total: " + sum + "\n");
        
        if (sum == 21){
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
//        rulesScreen.setLocationRelativeTo(null);
//        rulesScreen.setVisible(true);
//        this.setVisible(false);x
    }//GEN-LAST:event_button_rulesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
    private javax.swing.JButton hit_button;
    private javax.swing.JLabel player_card_1;
    private javax.swing.JLabel player_card_2;
    private javax.swing.JLabel player_card_3;
    private javax.swing.JButton stand_button;
    // End of variables declaration//GEN-END:variables
}
