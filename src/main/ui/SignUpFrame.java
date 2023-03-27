package ui;

import model.Account;
import model.NotValidCardException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class that represents the sign-up frame.
public class SignUpFrame extends JFrame implements ActionListener {
    JButton submitButton;
    JTextField nameField;
    JTextField cardField;
    private JPanel panel;

    //EFFECTS: constructs a sign up frame, with a name text field, card text field, and submit button.
    public SignUpFrame() {
        super("Sign up");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setLayout(new GridLayout(2, 2));
        this.setSize(450, 200);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        this.add(panel);

        initializeNameField();

        initializeCardField();

        submitButton = new JButton();
        submitButton.setLabel("Submit");
        submitButton.addActionListener(this);
        submitButton.setBounds(10, 80, 80, 25);
        panel.add(submitButton);


        this.setVisible(true);
    }

    //EFFECTS: constructs the name section of the sign-up frame.
    private void initializeNameField() {
        JLabel name = new JLabel();
        name.setBounds(10, 20, 80, 25);
        name.setText("Enter username:");
        panel.add(name);

        nameField = new JTextField(20);
//        nameField.setPreferredSize(new Dimension(150, 50));
        nameField.setBounds(100, 20, 165, 25);
        nameField.addActionListener(this);
        panel.add(nameField);
    }

    //EFFECTS: constructs the card section of the sign-up frame.
    private void initializeCardField() {
        JLabel card = new JLabel();
        card.setText("Enter card number:");
        card.setBounds(10, 50, 80, 25);
        panel.add(card);

        cardField = new JTextField(20);
//        cardField.setPreferredSize(new Dimension(150, 50));
        cardField.addActionListener(this);
        cardField.setBounds(100, 50, 165, 25);
        panel.add(cardField);
    }

    //EFFECTS: handles the user actions.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                String name = nameField.getText();
                String card = cardField.getText();
                Account account = new Account(name, card);
                new WildlifeRescueUI(account);
                this.dispose();
            } catch (NotValidCardException exception) {
                JOptionPane.showMessageDialog(null, "Invalid card. Try again.", null,
                        JOptionPane.ERROR_MESSAGE);
                new SignUpFrame();
                this.dispose();
            }
        }
    }
}
