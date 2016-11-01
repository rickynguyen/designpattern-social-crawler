package view.swing;

import app.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailView {
    private JPanel contentView;
    private JTree tree;
    private JLabel numberChidren;
    private JButton backButton;

    public DetailView() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Application.getInstance().navigateTo("MainController", "main", null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public JPanel getContentView() {
        return contentView;
    }

    public JTree getTree() {
        return tree;
    }

    public JLabel getNumberChidren() {
        return numberChidren;
    }

    public void setNumberChidren(JLabel numberChidren) {
        this.numberChidren = numberChidren;
    }
}
