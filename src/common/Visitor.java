package common;

import data.FolderNode;
import data.SimpleNode;
import data.TreeNode;

public interface Visitor {

    Object visit(TreeNode visitable);

    Object visit(SimpleNode simpleNode);

    Object visit(FolderNode folderNode);
}
