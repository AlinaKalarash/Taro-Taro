package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI  {
    GameManager gm;
    JFrame window;

    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];
    public UI(GameManager gm) {
        this.gm = gm;

        createMainScreen();
        generateScreen();

        window.setVisible(true);
    }

    public void createMainScreen(){
        window = new JFrame();
        window.setSize(1200, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

//        messageText = new JTextArea("Карта\nдня");
//        messageText.setBounds(15,170,240,200);
//        messageText.setBackground(Color.PINK);
//        messageText.setForeground(Color.WHITE);
//        messageText.setEnabled(false);
//        messageText.setLineWrap(true);
//        messageText.setWrapStyleWord(true);
//        messageText.setFont(new Font("Kyiv*Type Serif", Font.PLAIN, 46));
//        window.add(messageText);
    }
    public void createMessage(int msgx, int msgy, int msgWidth, int msgHeight, String msgText){
        messageText = new JTextArea(msgText);
        messageText.setBounds(msgx, msgy, msgWidth, msgHeight);
        messageText.setBackground(Color.PINK);
        messageText.setForeground(Color.WHITE);
        messageText.setEnabled(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Kyiv*Type Serif", Font.PLAIN, 46));
//        window.add(messageText);
    }
    public void createBackGround(int bgNum, String bgFileName){
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(10,10,1180,780);
        bgPanel[bgNum].setBackground(Color.MAGENTA);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,1180,780);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
        bgLabel[bgNum].setIcon(bgIcon);

    }

    public void createObject(int bgNum, int objx, int objy, int obgWidth, int objHeight, String objName, String buttonName){
        JButton button = new JButton();
        button.setBounds(objx,objy,obgWidth,objHeight);
        ImageIcon buttonIcon = new ImageIcon(getClass().getClassLoader().getResource(objName));
        button.setBorder(null);
        button.setContentAreaFilled(false); // Робимо кнопку прозорою
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Kyiv*Type Serif", Font.PLAIN, 26));
        button.setActionCommand(buttonName);
        button.setIcon(buttonIcon);

        // Додаємо обробник подій
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                switch (command) {
                    case "Карта дня":
                        System.out.println("Відкрита карта дня!");
                        int cardNum = (int) (Math.random()*22);
                            Cards card = Cards.getById(cardNum);
                        JOptionPane.showMessageDialog(window, "Ваша карта: " + card.getName() + "\nЇї тлумачення: " + card.getDescription());
                        break;
                    case "Сумісність":
                        int percent = (int) (Math.random()*100);
                        String mess = "";
                        if (percent <= 10) {
                            mess = "Тіряйся, тюбік.";
                        } else if (percent <= 15) {
                            mess = "Твої шанси низькі, як і твоя самооцінка.";
                        } else if (percent <= 20) {
                            mess = "Давайте не допустимо тут катастрофи.";
                        } else if (percent <= 30) {
                            mess = "Ваш зв’язок нагадує Wi-Fi – сильний сигнал, але є перешкоди.";
                        } else if (percent <= 40) {
                            mess = "Ваша сумісність – як новий рецепт: варто спробувати, щоб зрозуміти, чи це ваш смак.";
                        } else if (percent <= 45) {
                            mess = "Тримайте пальці схрещеними";
                        } else if (percent <= 50) {
                            mess = "Ми віримо в вас";
                        }else if (percent <= 55) {
                            mess = "Хімія між вами сильна, але трохи фізики все ж не завадить.";
                        } else if (percent <= 60) {
                            mess = "Між вами є іскра, головне – не загубити вогонь.";
                        } else if (percent <= 70) {
                            mess = "Ваш зв’язок – як схід і захід сонця: завжди різний, але завжди магічний.";
                        } else if (percent <= 75) {
                            mess = "Це схоже на горнятко чаю – вам потрібно більше тепла, щоб все стало ідеальним.";
                        } else if (percent <= 80) {
                            mess = "Ви близькі до чогось...";
                        } else if (percent <= 85) {
                            mess = "Ви – як два бокали вина: гарно поєднуєтесь, але важлива пропорція.";
                        } else if (percent <= 90) {
                            mess = "Це як код і компілятор – важливо розуміти одне одного без зайвих помилок.";
                        } else if (percent <= 100) {
                            mess = "Схоже, ви – пазли, які ідеально доповнюють одне одного.";
                        }
                        JOptionPane.showMessageDialog(window, "Сумісність: " + percent + "%. " + mess);
                        break;
                    case "Класичний розклад":
                        cardNum = (int) (Math.random()*22);
                        Cards card1 = Cards.getById(cardNum);
                        cardNum = (int) (Math.random()*22);
                        Cards card2 = Cards.getById(cardNum);
                        cardNum = (int) (Math.random()*22);
                        Cards card3 = Cards.getById(cardNum);
                        JOptionPane.showMessageDialog(window, "Ваша 1 карта: " + card1.getName() + "\nЇї тлумачення: " + card1.getDescription() +
                                "\nВаша 2 карта: " + card2.getName() + "\nЇї тлумачення: " + card3.getDescription() +
                                "\nВаша 3 карта: " + card3.getName() + "\nЇї тлумачення: " + card3.getDescription());
                        break;
                    case "Так/ні":
                        int chance = (int) (Math.random()*2);
                        if (chance == 1) {
                            JOptionPane.showMessageDialog(window, "Так!");
                        } else {
                            JOptionPane.showMessageDialog(window, "Ні.");
                        }
                        break;
                    case "Lesson":
                        Cards.getAll(window);
                        break;
                    default:
                        System.out.println("Натиснута кнопка: " + command);
                        break;
                }
            }
        });
        bgPanel[bgNum].add(button);

//        JLabel objectLabel = new JLabel();
//        objectLabel.setBounds(objx,objy,obgWidth,objHeight);
//        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objName));
//        objectLabel.setIcon(objectIcon);
//        bgPanel[bgNum].add(objectLabel);
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }

    public void generateScreen(){
//        SCREEN 1
        createBackGround(1,"assets/back.jpg");
        createObject(1,340,120,450,450,"assets/hert.png", "Сумісність");
        createObject(1,20,100,300,100,"assets/dailyCard.png", "Карта дня");
        createObject(1,780,100,300,100,"assets/classical.png", "Класичний розклад");
        createObject(1,50,550,300,100,"assets/yes-no.png", "Так/ні");
        createObject(1,750,550,300,100,"assets/lessons.png", "Lesson");

    }
}
