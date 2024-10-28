package Masterys;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class breakAPlate {
    private JFrame frame;
    private JLabel[] plates = new JLabel[3];
    private JButton playButton;
    private JLabel resultLabel;
    private ImageIcon unbrokenPlate, brokenPlate;
    private JLabel animationLabel, prizeLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                breakAPlate window = new breakAPlate();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public breakAPlate() {
        initialize();
    }

    private void initialize() {
        setupFrame();
        loadImages();
        createUIComponents();
    }

    private void setupFrame() {
        frame = new JFrame("Break a Plate Game");
        frame.setBounds(100, 100, 450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
    }

    private void loadImages() {
        unbrokenPlate = new ImageIcon("unbroken_plate.png"); // Replace with actual path
        brokenPlate = new ImageIcon("broken_plate.png");     // Replace with actual path
    }

    private void createUIComponents() {
        createPlatePanel();
        createResultLabel();
        createButtonPanel();
    }

    private void createPlatePanel() {
        JPanel platePanel = new JPanel();
        platePanel.setLayout(new BoxLayout(platePanel, BoxLayout.Y_AXIS));

        // Create plates
        for (int i = 0; i < plates.length; i++) {
            plates[i] = new JLabel(unbrokenPlate);
            platePanel.add(plates[i]);
        }

        // Animation and prize labels
        animationLabel = new JLabel();
        animationLabel.setIcon(new ImageIcon("C:\\Users\\27298008\\Downloads\\plates.gif"));
        platePanel.add(animationLabel);

        prizeLabel = new JLabel();
        prizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        platePanel.add(prizeLabel);

        frame.getContentPane().add(platePanel, BorderLayout.CENTER);
    }

    private void createResultLabel() {
        resultLabel = new JLabel(" ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(resultLabel, BorderLayout.NORTH);
    }

    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        });
        buttonPanel.add(playButton);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void playGame() {
        Random random = new Random();
        int brokenCount = 0;

        // Reset plates
        for (int i = 0; i < plates.length; i++) {
            plates[i].setIcon(unbrokenPlate);
        }

        // Generate random values and update plate images
        for (int i = 0; i < plates.length; i++) {
            int randValue = random.nextInt(2);  // Generate 0 or 1
            if (randValue == 1) {
                plates[i].setIcon(brokenPlate);
                brokenCount++;
            }
        }

        // Update result based on number of broken plates
        updateResult(brokenCount);
        playButton.setText("Play Again");
    }

    private void updateResult(int brokenCount) {
        if (brokenCount == 3) {
            resultLabel.setText("You win: Tiger Plush!");
            ChangeImage(prizeLabel, "tiger_plush");
        } else {
            resultLabel.setText("You win: Sticker!");
            ChangeImage(prizeLabel, "sticker");
        }
    }

    public static void ChangeImage(JLabel uiObject, String imageID) {
        uiObject.setIcon(new ImageIcon("C:\\Users\\27298008\\Downloads\\" + imageID + ".gif"));
    }
}
