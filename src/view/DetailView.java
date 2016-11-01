package view;

import data.SimpleNode;
import data.TreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class DetailView extends DataView {
    private view.swing.DetailView detailView;

    private TreeRender render;

    private JFrame frame;

    private SimpleNode currentRoot;

    public DetailView() {
        this.render = new TreeRender();
        this.detailView = new view.swing.DetailView();
    }

    public void setCurrentRoot(SimpleNode root) {
        currentRoot = root;
    }

    synchronized public void notify(TreeNode root) {
        javax.swing.tree.TreeNode treeRoot = (javax.swing.tree.TreeNode) currentRoot.accept(this.render);
        DefaultTreeModel model = (DefaultTreeModel) this.detailView.getTree().getModel();
        model.setRoot(treeRoot);
        this.detailView.getNumberChidren().setText(String.valueOf(currentRoot.getTotalChildren()));
    }

    @Override
    public void show() {
        JFrame f = new JFrame();
        f.setContentPane(this.detailView.getContentView());
        f.pack();
        f.setLocation(400, 400);
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
