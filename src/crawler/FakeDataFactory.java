package crawler;

import data.FolderNode;
import data.SimpleNode;
import data.TreeNode;

import java.util.ArrayList;
import java.util.Date;

public class FakeDataFactory {
    private Integer numbers = 2;

    private String source;

    private String query;

    private boolean hasVideo;

    public FakeDataFactory(String query, String source, Integer numbers, boolean hasVideo) {
        this.numbers = numbers;
        this.source = source;
        this.query = query;
        this.hasVideo = hasVideo;
    }

    public FakeDataFactory(String query, String source) {
        this.source = source;
        this.query = query;
    }

    public ArrayList<TreeNode> createData() {
        return createDataRecursive((int) (Math.random() * 5 / 1));
    }

    protected ArrayList<TreeNode> createDataRecursive(Integer level) {
        ArrayList<TreeNode> list = new ArrayList<>();
        for (int i = 0; i <= numbers; i++) {
            Date date = new Date();
            SimpleNode node = new SimpleNode();
            node.setAuthor(String.format("Author %s", i));
            node.setContent(String.format("Content %s %s", query, i));
            node.setLike((int) (Math.random() * 1000 / 100));
            node.setDislike((int) (Math.random() * 1000 / 100));
            node.setSource(source);
            node.setUrl(hasVideo ? "http:://google.com" : null);

            if (level > 0) {
                ArrayList<TreeNode> children = createDataRecursive(level - 1);
                FolderNode folderNode = new FolderNode();
                folderNode.mergeNodeList(children);
                node.setFolder(folderNode);
            }

            list.add(node);
        }

        return list;
    }

}
