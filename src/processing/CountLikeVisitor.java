package processing;


import common.Visitor;
import data.FolderNode;
import data.SimpleNode;
import data.TreeNode;

public class CountLikeVisitor implements Visitor {

    @Override
    public Object visit(TreeNode visitable) {
        return visitable;
    }

    public Object visit(SimpleNode node) {
        node.setTotalLike(node.getLike());
        node.setTotalDislike(node.getDislike());

        FolderNode folder = null;
        if (node.getFolder() != null) {
            folder = (FolderNode) node.getFolder().accept(this);
        }
        if (folder != null) {
            for (TreeNode simpleNode : folder.getList()) {
                node.setTotalLike(((SimpleNode)simpleNode).getTotalLike() + node.getTotalLike());
                node.setTotalDislike(((SimpleNode)simpleNode).getTotalDislike() + node.getTotalDislike());
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
