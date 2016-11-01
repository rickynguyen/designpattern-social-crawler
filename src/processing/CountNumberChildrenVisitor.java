package processing;


import common.Visitor;
import data.FolderNode;
import data.SimpleNode;
import data.TreeNode;

public class CountNumberChildrenVisitor implements Visitor {

    @Override
    public Object visit(TreeNode visitable) {
        return visitable;
    }

    public Object visit(SimpleNode node) {
        node.setTotalChildren((node.getFolder() != null) ? node.getFolder().getList().size() : 0);

        FolderNode folder = null;
        if (node.getFolder() != null) {
            folder = (FolderNode) node.getFolder().accept(this);
        }
        if (folder != null) {
            for (TreeNode simpleNode : folder.getList()) {
                node.setTotalChildren(((SimpleNode) simpleNode).getTotalChildren() + node.getTotalChildren());
            }
        }
        return node;
    }

    public Object visit(FolderNode folderNode) {
        for (TreeNode simpleNode : folderNode.getList()) {
            simpleNode.accept(this);
        }
        return folderNode;
    }
}
