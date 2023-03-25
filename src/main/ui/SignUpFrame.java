package ui;

import model.Account;
import model.NotValidCardException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpFrame extends JFrame implements ActionListener {
    JButton submitButton;
    JTextField nameField;
    JTextField cardField;

    public SignUpFrame() {
        super("Sign up");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        JLabel name = new JLabel();
        name.setText("Enter username:");

        JLabel card = new JLabel();
        card.setText("Enter card number:");


        submitButton = new JButton();
        submitButton.setLabel("Submit");
        submitButton.addActionListener(this);


        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 50));
        nameField.addActionListener(this);

        cardField = new JTextField();
        cardField.setPreferredSize(new Dimension(150, 50));
        cardField.addActionListener(this);


        this.add(name);
        this.add(nameField);
        this.add(card);
        this.add(cardField);
        this.add(submitButton);
        this.pack();

    }

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
