package controller;

import app.Application;
import data.SimpleNode;
import data.TreeNode;
import view.DataView;
import view.DetailView;
import view.MainView;

public class MainController extends Controller {

    public DataView main() {

        DataView view = new MainView();
        view.setDataProvider(Application.getInstance().getDataProvider());
        return view;
    }

    public DataView detail(SimpleNode targetNode) {
        DetailView view = new DetailView();
        view.setCurrentRoot(targetNode);
        view.setDataProvider(Application.getInstance().getDataProvider());
        return view;
    }
}
