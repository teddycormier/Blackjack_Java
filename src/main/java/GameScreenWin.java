
// Teddy Cormier
// Window for the game screen
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author teddycormier
 */
public class GameScreenWin extends javax.swing.JFrame {

    /**
     * Creates new form GameScreen
     *
     * @throws java.io.IOException
     */
    public RulesScreenWin rulesScreen;
    private ImageIcon icon;
    private int dealer_card_num = 0;
    private int player_card_num = 0;
    private int tmp_player_card = 0;
    private int tmp_dealer_card = 0;
    private int dealer_score = 0;
    private int player_score = 0;
    private int dealer_sum = 0;
    private int player_sum = 0;
    private final String you_win_png = "youwin.png";
    private final String push_png = "push.png";
    private final String you_lost_png = "youjustlost.png";
    private final String you_hit_blackjack_png = "blackjack.png";
    private final String directory = "src/main/resources/";
    private final String https = "https://deckofcardsapi.com/static/img/";
    private final String closed_handed_icon = "src/main/resources/backcard.png";
    private final String file_type = ".png";

    private final ArrayList<Integer> player_cards = new ArrayList<Integer>();
    private final ArrayList<Integer> dealer_cards = new ArrayList<Integer>();
    private final ArrayList<String> card_suits = new ArrayList<String>();
    private final ArrayList<String> card_faces = new ArrayList<String>();
    private final JLabel[] player_card_labels = new JLabel[5];
    private final JLabel[] dealer_card_labels = new JLabel[5];

    private void addSuitsFaces() {
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

    private void addAllLabels() {
        // ----------------
        player_card_labels[0] = (player_card_1);
        player_card_labels[1] = (player_card_2);
        player_card_labels[2] = (player_card_3);
        player_card_labels[3] = (player_card_4);
        player_card_labels[4] = (player_card_5);

        // ----------------
        dealer_card_labels[0] = (dealer_card_1);
        dealer_card_labels[1] = (dealer_card_2);
        dealer_card_labels[2] = (dealer_card_3);
        dealer_card_labels[3] = (dealer_card_4);
        dealer_card_labels[4] = (dealer_card_5);
        // ----------------
    }

    private void dealerScoreChange() {
        dealer_score = dealer_score + 1;
        dealer_wins.setText(Integer.toString(dealer_score));
    }

    private void playerScoreChange() {
        player_score = player_score + 1;
        player_wins.setText(Integer.toString(player_score));
    }

    private void shuffleCollections() {
        Collections.shuffle(card_suits);
        Collections.shuffle(card_faces);
    }

    private Integer getSum(ArrayList<Integer> array) {
        int sum = 0;

        for (Integer number : array) {
            sum += number;
        }
        return sum;
    }

    private void createURLandIcon(String card_num, String card_suit) throws IOException {
        try {
            // https://www.geeksforgeeks.org/java-io-bufferedreader-class-java/
            String total_URL = https + card_num + card_suit + file_type;
            URL url = new URL(total_URL);
            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
        } catch (MalformedURLException ex) {
            Logger.getLogger(GameScreenWin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Image messageIcon(String image_file) throws IOException {

        // https://docs.oracle.com/javase/7/docs/api/java/awt/Image.html#getScaledInstance(int,%20int,%20int)
        BufferedImage img = ImageIO.read(new File(directory + image_file));
        Image image = img.getScaledInstance(180, 180, Image.SCALE_DEFAULT);

        return image;
    }

    private void findRightCardD() {
        tmp_dealer_card = dealer_cards.get(dealer_card_num);
    }

    private void setRightIconD() throws InterruptedException {
        for (int i = 0; i < dealer_cards.size(); i++) {
            if (tmp_dealer_card == dealer_cards.get(i) && (!dealer_card_labels[i].isVisible())) {
                dealer_card_labels[i].setVisible(true);
                dealer_card_labels[i].setIcon(icon);
            }
        }
    }

    private void getDealerCard() throws IOException, InterruptedException {
        dealer_cards.add(DeckResponse.getCardFromDeck());
        findRightCardD();
        shuffleCollections();
        if (tmp_dealer_card == 10) {
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            createURLandIcon(card_num, card_suit);
            setRightIconD();
        } else if ((tmp_dealer_card == 1) || (tmp_dealer_card == 11)) {
            String card_suit = card_suits.get(0);
            String card_num = "A";
            createURLandIcon(card_num, card_suit);
            setRightIconD();
        } else if (tmp_dealer_card < 10) {
            String card_num = String.valueOf(tmp_dealer_card);
            String card_suit = card_suits.get(0);
            createURLandIcon(card_num, card_suit);
            setRightIconD();
        }
        dealer_card_num = dealer_card_num + 1;
    }

    private void findRightCardP() {
        tmp_player_card = player_cards.get(player_card_num);
    }

    private void setRightIconP() {
        for (int i = 0; i < player_cards.size(); i++) {
            if (tmp_player_card == player_cards.get(i) && (!player_card_labels[i].isVisible())) {
                player_card_labels[i].setVisible(true);
                player_card_labels[i].setIcon(icon);
            }
        }
    }

    private void getPlayerCard() throws IOException, InterruptedException {
        player_cards.add(DeckResponse.getCardFromDeck());
        player_sum = getSum(player_cards);
        player_sum_total.setText(Integer.toString(player_sum));
        findRightCardP();
        shuffleCollections();
        if (tmp_player_card == 10) {
            String card_num = card_faces.get(0);
            String card_suit = card_suits.get(0);
            createURLandIcon(card_num, card_suit);
            setRightIconP();
        } else if ((tmp_player_card == 1) || (tmp_player_card == 11)) {
            String card_suit = card_suits.get(0);
            String card_num = "A";
            createURLandIcon(card_num, card_suit);
            setRightIconP();
        } else if (tmp_player_card < 10) {
            String card_num = String.valueOf(tmp_player_card);
            String card_suit = card_suits.get(0);
            createURLandIcon(card_num, card_suit);
            setRightIconP();
        }
        player_card_num = player_card_num + 1;
    }

    private void newSetOfCards() throws IOException, InterruptedException {

        cleanUp();
        dealer_cards.clear();
        player_cards.clear();
        addSuitsFaces();

        getDealerCard();
        if (dealer_cards.get(0) == 1) {
            dealer_cards.set(0, 11);
        }
        getDealerCard();
        if ((dealer_cards.get(1) == 1) && (dealer_cards.get(0) != 11)) {
            dealer_cards.set(1, 11);
        }

        dealer_sum = getSum(dealer_cards);
        dealer_sum_total.setText(Integer.toString(dealer_sum));

        getPlayerCard();
        if (player_cards.get(0) == 1) {
            player_cards.set(0, 11);
        }
        getPlayerCard();
        if ((player_cards.get(1) == 1) && (player_cards.get(0) != 11)) {
            player_cards.set(1, 11);
        }

        player_sum = getSum(player_cards);
        player_sum_total.setText(Integer.toString(player_sum));
    }

    private void cleanUp() {
        player_card_num = 0;
        player_sum = 0;
        dealer_sum = 0;
        dealer_card_num = 0;

        for (int i = 0; i < player_card_labels.length; i++) {

            player_card_labels[i].setVisible(false);
        }
        for (int i = 0; i < dealer_card_labels.length; i++) {

            dealer_card_labels[i].setVisible(false);
        }
    }

    private void newCardsAfterBeatingDealer() throws IOException, InterruptedException {
        if (StartScreenWin.closedHanded == true) {
            if (player_sum > dealer_sum) {
                closed_handed_card.setVisible(false);
                JOptionPane.showMessageDialog(null, "You beat the dealer. You had a higher total.", "YOU WIN", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(messageIcon(you_win_png)));
                closed_handed_card.setVisible(true);
            } else if (dealer_sum > 21) {
                closed_handed_card.setVisible(false);
                JOptionPane.showMessageDialog(null, "You beat the dealer. The dealer busted.", "YOU WIN", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(messageIcon(you_win_png)));
                closed_handed_card.setVisible(true);
            }
        } else {
            if (player_sum > dealer_sum) {
                JOptionPane.showMessageDialog(null, "You beat the dealer. You had a higher total.", "YOU WIN", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(messageIcon(you_win_png)));
            } else if (dealer_sum > 21) {
                JOptionPane.showMessageDialog(null, "You beat the dealer. The dealer busted.", "YOU WIN", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(messageIcon(you_win_png)));
            }
        }

        playerScoreChange();
        newSetOfCards();
    }

    private void newCardsAfterLosingToDealer() throws IOException, InterruptedException {
        if (StartScreenWin.closedHanded == true) {
            if (dealer_sum > player_sum) {
                closed_handed_card.setVisible(false);
                JOptionPane.showMessageDialog(null, "You lost to the dealer. The dealer had a higher total.", "YOU LOSE", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(messageIcon(you_lost_png)));
                closed_handed_card.setVisible(true);
            } else if (player_sum > 21) {
                closed_handed_card.setVisible(false);
                JOptionPane.showMessageDialog(null, "You lost to the dealer. You busted.", "YOU LOSE", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(messageIcon(you_lost_png)));
                closed_handed_card.setVisible(true);
            }

        } else {
            if (dealer_sum > player_sum) {
                JOptionPane.showMessageDialog(null, "You lost to the dealer. The dealer had a higher total.", "YOU LOSE", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(messageIcon(you_lost_png)));
            } else if (player_sum > 21) {
                JOptionPane.showMessageDialog(null, "You lost to the dealer. You busted.", "YOU LOSE", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(messageIcon(you_lost_png)));
            }
        }

        dealerScoreChange();
        newSetOfCards();
    }

    private void newCardsAfterPlayerHitBlackjack() throws IOException, InterruptedException {
        if (StartScreenWin.closedHanded == true) {
            closed_handed_card.setVisible(false);
            JOptionPane.showMessageDialog(null, "BLACKJACK - Your hand total was equal to 21", "YOU WIN", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(messageIcon(you_hit_blackjack_png)));
            closed_handed_card.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "BLACKJACK - Your hand total was equal to 21", "YOU WIN", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(messageIcon(you_hit_blackjack_png)));
        }

        playerScoreChange();
        newSetOfCards();
    }

    private void newCardsAfterDealerHitBlackjack() throws IOException, InterruptedException {
        if (StartScreenWin.closedHanded == true) {
            closed_handed_card.setVisible(false);
            JOptionPane.showMessageDialog(null, "DEALER HIT BLACKJACK", "DEALER WINS", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(messageIcon(you_lost_png)));
            closed_handed_card.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "DEALER HIT BLACKJACK", "DEALER WINS", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(messageIcon(you_lost_png)));
        }

        dealerScoreChange();
        newSetOfCards();
    }

    private void newCardsAfterPush() throws IOException, InterruptedException {
        if (StartScreenWin.closedHanded == true) {
            closed_handed_card.setVisible(false);
            JOptionPane.showMessageDialog(null, "It's a push. You and the dealer had the same total.", "PUSH", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(messageIcon(push_png)));
            closed_handed_card.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "It's a push. You and the dealer had the same total.", "PUSH", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(messageIcon(push_png)));
        }

        newSetOfCards();
    }

    public GameScreenWin() throws IOException, InterruptedException {

        initComponents();

        addAllLabels();

        newSetOfCards();

        rulesScreen = new RulesScreenWin();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closed_handed_card = new javax.swing.JLabel();
        stand_button = new javax.swing.JButton();
        hit_button = new javax.swing.JButton();
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
        dealer_wins_to_change = new javax.swing.JLabel();
        dealer_wins = new javax.swing.JLabel();
        player_wins_label = new javax.swing.JLabel();
        dealer_sum_label = new javax.swing.JLabel();
        dealer_sum_total = new javax.swing.JLabel();
        player_wins = new javax.swing.JLabel();
        player_sum_label = new javax.swing.JLabel();
        player_sum_total = new javax.swing.JLabel();
        button_rules1 = new javax.swing.JButton();
        background_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BLACKJACK");
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1000, 500));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(null);

        closed_handed_card.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(closed_handed_card);
        closed_handed_card.setBounds(40, 40, 110, 160);

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
        players_hand_onscreen_text.setBounds(10, 240, 150, 20);

        dealers_hand_onscreen_text1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dealers_hand_onscreen_text1.setForeground(new java.awt.Color(255, 255, 255));
        dealers_hand_onscreen_text1.setText("DEALERS HAND");
        getContentPane().add(dealers_hand_onscreen_text1);
        dealers_hand_onscreen_text1.setBounds(10, 10, 200, 21);

        dealer_wins_to_change.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        dealer_wins_to_change.setForeground(new java.awt.Color(255, 255, 255));
        dealer_wins_to_change.setText("LOSSES");
        getContentPane().add(dealer_wins_to_change);
        dealer_wins_to_change.setBounds(890, 80, 60, 20);

        dealer_wins.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        dealer_wins.setForeground(new java.awt.Color(255, 255, 255));
        dealer_wins.setText("0");
        dealer_wins.setAlignmentY(0.0F);
        dealer_wins.setBounds(new java.awt.Rectangle(905, 120, 60, 50));
        dealer_wins.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(dealer_wins);
        dealer_wins.setBounds(905, 120, 60, 50);

        player_wins_label.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        player_wins_label.setForeground(new java.awt.Color(255, 255, 255));
        player_wins_label.setText("WINS");
        getContentPane().add(player_wins_label);
        player_wins_label.setBounds(890, 320, 40, 20);

        dealer_sum_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dealer_sum_label.setForeground(new java.awt.Color(255, 255, 255));
        dealer_sum_label.setText("| SUM : ");
        getContentPane().add(dealer_sum_label);
        dealer_sum_label.setBounds(160, 10, 70, 21);

        dealer_sum_total.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dealer_sum_total.setForeground(new java.awt.Color(255, 255, 255));
        dealer_sum_total.setText("0");
        getContentPane().add(dealer_sum_total);
        dealer_sum_total.setBounds(230, 10, 70, 21);

        player_wins.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        player_wins.setForeground(new java.awt.Color(255, 255, 255));
        player_wins.setText("0");
        player_wins.setAlignmentY(0.0F);
        player_wins.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(player_wins);
        player_wins.setBounds(910, 360, 60, 50);

        player_sum_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        player_sum_label.setForeground(new java.awt.Color(255, 255, 255));
        player_sum_label.setText("| SUM : ");
        getContentPane().add(player_sum_label);
        player_sum_label.setBounds(160, 240, 70, 21);

        player_sum_total.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        player_sum_total.setForeground(new java.awt.Color(255, 255, 255));
        player_sum_total.setText("0");
        getContentPane().add(player_sum_total);
        player_sum_total.setBounds(230, 240, 70, 21);

        button_rules1.setBackground(new java.awt.Color(204, 204, 204));
        button_rules1.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        button_rules1.setText("Rules");
        button_rules1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button_rules1.setMaximumSize(new java.awt.Dimension(30, 30));
        button_rules1.setMinimumSize(new java.awt.Dimension(30, 30));
        button_rules1.setPreferredSize(new java.awt.Dimension(30, 30));
        button_rules1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_rules1ActionPerformed(evt);
            }
        });
        getContentPane().add(button_rules1);
        button_rules1.setBounds(900, 10, 60, 20);

        background_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sunset.png"))); // NOI18N
        getContentPane().add(background_label);
        background_label.setBounds(0, 0, 1000, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stand_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stand_buttonActionPerformed

        if (dealer_sum < 17) {
            try {
                getDealerCard();
                int dealer_card3 = dealer_cards.get(2);
                int dealer_sum2 = dealer_sum + dealer_card3;
                dealer_sum = dealer_sum2;
                dealer_sum_total.setText(Integer.toString(dealer_sum));
                if (dealer_sum2 < 17) {
                    getDealerCard();
                    int dealer_card4 = dealer_cards.get(3);
                    int dealer_sum3 = dealer_sum2 + dealer_card4;
                    dealer_sum = dealer_sum3;
                    dealer_sum_total.setText(Integer.toString(dealer_sum));
                    if (dealer_sum3 < 17) {
                        getDealerCard();
                        int dealer_card5 = dealer_cards.get(4);
                        int dealer_sum4 = dealer_sum3 + dealer_card5;
                        dealer_sum = dealer_sum4;
                        dealer_sum_total.setText(Integer.toString(dealer_sum));

                    }
                }
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(GameScreenWin.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (player_sum == 21) {
            try {
                newCardsAfterPlayerHitBlackjack();

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(GameScreenWin.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (dealer_sum == 21) {
            try {
                newCardsAfterDealerHitBlackjack();

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(GameScreenWin.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if ((dealer_sum == player_sum)) {
            try {
                newCardsAfterPush();

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(GameScreenWin.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if ((dealer_sum > 21) && (player_sum <= 21)) {
            try {
                newCardsAfterBeatingDealer();

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(GameScreenWin.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if ((player_sum < 21) && (dealer_sum < 21) && (player_sum > dealer_sum)) {
            try {
                newCardsAfterBeatingDealer();

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(GameScreenWin.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if ((dealer_sum < 21) && (player_sum < 21) && (dealer_sum > player_sum)) {
            try {
                newCardsAfterLosingToDealer();

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(GameScreenWin.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if ((player_sum > 21) && (dealer_sum <= 21)) {
            try {
                newCardsAfterLosingToDealer();

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(GameScreenWin.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_stand_buttonActionPerformed

    private void hit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hit_buttonActionPerformed

        try {
            getPlayerCard();

        } catch (IOException ex) {
            Logger.getLogger(GameScreenWin.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (InterruptedException ex) {
            Logger.getLogger(GameScreenWin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        if (player_sum == 21) {
            try {
                newCardsAfterPlayerHitBlackjack();

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(GameScreenWin.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (player_sum > 21) {
            try {
                newCardsAfterLosingToDealer();

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(GameScreenWin.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_hit_buttonActionPerformed

    private void button_rules1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_rules1ActionPerformed
        rulesScreen.setLocationRelativeTo(null);
        rulesScreen.setVisible(true);
    }//GEN-LAST:event_button_rules1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameScreenWin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background_label;
    private javax.swing.JButton button_rules1;
    public javax.swing.JLabel closed_handed_card;
    private javax.swing.JLabel dealer_card_1;
    private javax.swing.JLabel dealer_card_2;
    private javax.swing.JLabel dealer_card_3;
    private javax.swing.JLabel dealer_card_4;
    private javax.swing.JLabel dealer_card_5;
    public javax.swing.JLabel dealer_sum_label;
    public javax.swing.JLabel dealer_sum_total;
    private javax.swing.JLabel dealer_wins;
    private javax.swing.JLabel dealer_wins_to_change;
    private javax.swing.JLabel dealers_hand_onscreen_text1;
    private javax.swing.JButton hit_button;
    private javax.swing.JLabel player_card_1;
    private javax.swing.JLabel player_card_2;
    private javax.swing.JLabel player_card_3;
    private javax.swing.JLabel player_card_4;
    private javax.swing.JLabel player_card_5;
    public javax.swing.JLabel player_sum_label;
    public javax.swing.JLabel player_sum_total;
    private javax.swing.JLabel player_wins;
    private javax.swing.JLabel player_wins_label;
    private javax.swing.JLabel players_hand_onscreen_text;
    private javax.swing.JButton stand_button;
    // End of variables declaration//GEN-END:variables
}
