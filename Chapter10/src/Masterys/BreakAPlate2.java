/*

Program: BreakAPlate2         Last Date of this Revision: October 4, 2024

Purpose: The BreakAPlate2 application simulates a carnival game where the user can throw objects to break plates and earn prizes.

Author: 

School: CHHS

Course: Computer Programming 30

*/

package Masterys;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BreakAPlate2 {
    private JFrame frame;
    private JLabel[] plates = new JLabel[3];
    private JButton playButton;
    private JLabel resultLabel;
    private ImageIcon unbrokenPlate, brokenPlate;
    private JLabel animationLabel, prizeLabel;

    public static void main(String[] args) {
        // Launch the application
        EventQueue.invokeLater(() -> {
            try {
                BreakAPlate2 window = new BreakAPlate2();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Constructor
    public BreakAPlate2() {
        initialize();
    }

    // Initialize the frame and its components
    private void initialize() {
        setupFrame();
        loadImages();
        createUIComponents();
    }

    // Setup the main JFrame
    private void setupFrame() {
        frame = new JFrame("Break a Plate Game");
        frame.setBounds(100, 100, 450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
    }

    // Load images for plates
    private void loadImages() {
        unbrokenPlate = new ImageIcon("unbroken_plate.png"); // Replace with the actual path to unbroken plate image
        brokenPlate = new ImageIcon("broken_plate.png");     // Replace with the actual path to broken plate image
    }

    // Create and arrange UI components
    private void createUIComponents() {
        createPlatePanel();
        createResultLabel();
        createButtonPanel();
    }

    // Create the panel to display plates
    private void createPlatePanel() {
        JPanel platePanel = new JPanel();
        platePanel.setLayout(new BoxLayout(platePanel, BoxLayout.Y_AXIS));

        // Add unbroken plates
        for (int i = 0; i < plates.length; i++) {
            plates[i] = new JLabel(unbrokenPlate);
            platePanel.add(plates[i]);
        }

        // Add animation and prize labels
        animationLabel = new JLabel();
        animationLabel.setIcon(new ImageIcon("C:\\Users\\27298008\\Downloads\\plates.gif")); // Replace with animation path
        platePanel.add(animationLabel);

        prizeLabel = new JLabel();
        prizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        platePanel.add(prizeLabel);

        frame.getContentPane().add(platePanel, BorderLayout.CENTER);
    }

    // Create the label to display the result
    private void createResultLabel() {
        resultLabel = new JLabel(" ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(resultLabel, BorderLayout.NORTH);
    }

    // Create the panel with the play button
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

    // Simulate the plate-breaking game
    private void playGame() {
        Random random = new Random();
        int brokenCount = 0;

        // Reset plates to unbroken
        for (int i = 0; i < plates.length; i++) {
            plates[i].setIcon(unbrokenPlate);
        }

        // Randomly break plates
        for (int i = 0; i < plates.length; i++) {
            int randValue = random.nextInt(2);  // Generate 0 or 1
            if (randValue == 1) {
                plates[i].setIcon(brokenPlate);
                brokenCount++;
            }
        }

        // Update the result based on the number of broken plates
        updateResult(brokenCount);
        playButton.setText("Play Again");
    }

    // Update the result and prize based on the number of broken plates
    private void updateResult(int brokenCount) {
        if (brokenCount == 3) {
            resultLabel.setText("You win: Tiger Plush!");
            ChangeImage(prizeLabel, "tiger_plush");
        } else {
            resultLabel.setText("You win: Sticker!");
            ChangeImage(prizeLabel, "sticker");
        }
    }

    // Helper method to change the image of a JLabel
    public static void ChangeImage(JLabel uiObject, String imageID) {
        uiObject.setIcon(new ImageIcon("C:\\Users\\27298008\\Downloads\\" + imageID + ".gif"));
    }
}

