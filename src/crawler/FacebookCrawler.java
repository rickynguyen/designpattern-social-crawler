package crawler;

import data.TreeNode;

import java.util.ArrayList;

public class FacebookCrawler extends Crawler {
    @Override
    public ArrayList<TreeNode> crawl(String query) {
        FakeDataFactory factory = new FakeDataFactory(query, "facebook");
        return factory.createData();
    }
}
