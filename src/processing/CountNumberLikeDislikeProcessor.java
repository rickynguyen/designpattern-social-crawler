package processing;

import data.SimpleNode;

public class CountNumberLikeDislikeProcessor extends AdvanceDataProcessor {
    private CountLikeVisitor countCountLikeVisitor;

    public CountNumberLikeDislikeProcessor(DataProcessor innerDataProcessor) {
        super(innerDataProcessor);
        countCountLikeVisitor = new CountLikeVisitor();
    }

    @Override
    SimpleNode processAdvance(SimpleNode root) {
        return (SimpleNode) root.accept(countCountLikeVisitor);
    }
}
