package crawler;

import data.TreeNode;

import java.util.ArrayList;

public class VnExpressCrawler extends Crawler {
    @Override
    public ArrayList<TreeNode> crawl(String query) {
        FakeDataFactory factory = new FakeDataFactory(query, "VnExpress");
        return factory.createData();
    }
}
