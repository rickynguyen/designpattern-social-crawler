package view.swing;

import app.Application;
import data.SimpleNode;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainView {
    private JTree tree;
    private JButton searchButton;
    private JTextField textField1;
    private JPanel searchPanel;
    private JPanel contentView;

    public MainView() {
        searchButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Object object = e.getSource();
                System.out.println("State change");
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButton.setEnabled(false);
                Application.getInstance().setQueryString(textField1.getText());
            }
        });
        textField1.setText(Application.getInstance().getQueryString());
        TreeModel model = new DefaultTreeModel(null);
        tree.setModel(model);
        tree.setCellRenderer(new DefaultTreeCellRenderer());
        tree.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                JTree tree = (JTree) e.getSource();
                if (tree.getSelectionPath() == null) {
                    return;
                }
                DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                SimpleNode node = (SimpleNode) selected.getUserObject();
                try {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_ENTER:
                            Application.getInstance().navigateTo("MainController", "detail", node);
                            break;
                        case KeyEvent.VK_1:
                            node.setLike(node.getLike() + 1);
                            break;
                        case KeyEvent.VK_2:
                            node.setLike(Math.max(node.getLike() - 1, 0));
                            break;
                        case KeyEvent.VK_3:
                            node.setDislike(Math.max(node.getDislike() + 1, 0));
                            break;
                        case KeyEvent.VK_4:
                            node.setDislike(Math.max(node.getDislike() - 1, 0));
                            break;
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                Application.getInstance().getDataProvider().preProcess();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public JPanel getContentView() {
        return contentView;
    }

    public JTree getTree() {
        return tree;
    }
}
