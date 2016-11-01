package view;

import common.Observer;
import common.Visitor;
import data.FolderNode;
import data.SimpleNode;
import data.TreeNode;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TreeRender implements Visitor {
    @Override
    public Object visit(TreeNode visitable) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        return new DefaultTreeModel(root);
    }

    public Object visit(SimpleNode node) {
        ArrayList<?> children = null;
        if (node.getFolder() != null) {
            children = (ArrayList) node.getFolder().accept(this);
        }
        SwingTreeNode treeNode;
        if (children != null) {
            treeNode = new SwingTreeNode(node, true);
            for (Object swingNode : children) {
                treeNode.add((SwingTreeNode) swingNode);
            }
        } else {
            treeNode = new SwingTreeNode(node);
        }

        return treeNode;
    }

    public Object visit(FolderNode folderNode) {
        return folderNode.getList().stream()
                .map(node -> (SwingTreeNode) node.accept(this))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private class SwingTreeNode extends DefaultMutableTreeNode implements Observer {

        SwingTreeNode(SimpleNode node) {
            super(node);
            node.addObserver(this);
        }

        SwingTreeNode(SimpleNode node, boolean b) {
            super(node, b);
            node.addObserver(this);
        }

        @Override
        public void notify(TreeNode observable) {
            this.setUserObject(observable);
        }
    }
}
