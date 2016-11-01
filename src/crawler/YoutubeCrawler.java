package crawler;

import data.TreeNode;

import java.util.ArrayList;

public class YoutubeCrawler extends Crawler {
    @Override
    public ArrayList<TreeNode> crawl(String query) {
        FakeDataFactory factory = new FakeDataFactory(query, "Youtube");
        return factory.createData();
    }
}
