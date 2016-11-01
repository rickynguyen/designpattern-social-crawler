package data;

import common.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FolderNode extends TreeNode{
    private ArrayList<TreeNode> children;

    public FolderNode() {
        this.children = new ArrayList<>();
    }


    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public TreeNode addNode(TreeNode node) {
        children.add(node);
        return node;
    }

    public Integer mergeNodeList(List<TreeNode> list) {
        if (null == list) {
            return 0;
        }
        Integer result = 0;
        for (TreeNode treeNode : list) {
            addNode(treeNode);
            result++;
        }

        return result;
    }

    public TreeNode removeNode(TreeNode node) {
        children.remove(node);
        return node;
    }

    public List<TreeNode> getList() {

        return this.children;
    }

    public void removeAll() {
        children.clear();
    }
}
