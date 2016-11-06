package processing;

import common.BaseObservable;
import common.Observer;
import crawler.Crawler;
import data.FolderNode;
import data.SimpleNode;
import data.TreeNode;

import java.util.List;

public class TreeDataProvider extends BaseObservable{

    private List<Crawler> crawlerList;
    private DataProcessor processor;

    private SimpleNode root;

    public TreeDataProvider(List<Crawler> crawlerList, DataProcessor processor) {
        this.crawlerList = crawlerList;
        this.processor = processor;
        root = new SimpleNode();
        root.setFolder(new FolderNode());
    }

    synchronized public void query(String query) {

        System.out.println(String.format("Background query %s", query));
        this.root.getFolder().removeAll();
        for (Crawler crawler : crawlerList) {
            this.root.getFolder().mergeNodeList(crawler.crawl(query));
        }
        this.root = processor.process(root);
        for (Observer observer : this.observers) {
            observer.notify(root);
        }
    }

    synchronized public SimpleNode getRoot() {
        return this.root;
    }

    public void preProcess() {
        this.root = processor.process(root);
        for (Observer observer : this.observers) {
            observer.notify(root);
        }
    }
}
