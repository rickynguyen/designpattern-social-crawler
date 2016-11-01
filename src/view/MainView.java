package view;

import data.TreeNode;
import processing.TreeDataProvider;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MainView extends DataView {
    private view.swing.MainView mainView;

    private TreeRender render;

    private JFrame frame;

    public MainView() {
        this.render = new TreeRender();
        this.mainView = new view.swing.MainView();
    }

    @Override
    public void setDataProvider(TreeDataProvider dataProvider) {
        super.setDataProvider(dataProvider);
    }

    synchronized public void notify(TreeNode root) {
        javax.swing.tree.TreeNode treeRoot = (javax.swing.tree.TreeNode) root.accept(this.render);
        DefaultTreeModel model = (DefaultTreeModel) this.mainView.getTree().getModel();
        model.setRoot(treeRoot);
    }

    @Override
    public void show() {
        JFrame f = new JFrame();
        f.setContentPane(this.mainView.getContentView());
        f.pack();
        f.setSize(600, 800);
        f.setVisible(true);
        frame = f;
    }

    @Override
    public void hide() {
        frame.setVisible(false);
        frame.dispose();
    }
}
