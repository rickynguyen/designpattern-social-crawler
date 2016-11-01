package view;

import common.Observer;
import data.TreeNode;
import processing.TreeDataProvider;

public abstract class DataView implements Observer {

    protected TreeDataProvider dataProvider;

    abstract public void notify(TreeNode root);

    public abstract void show();

    public void setDataProvider(TreeDataProvider dataProvider) {
        dataProvider.addObserver(this);
        this.dataProvider = dataProvider;
        this.notify(dataProvider.getRoot());
    }

    public abstract void hide();
}
