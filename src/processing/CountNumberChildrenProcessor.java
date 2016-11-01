package processing;

import data.SimpleNode;

public class CountNumberChildrenProcessor extends AdvanceDataProcessor {
    private CountNumberChildrenVisitor countCountChildrenVisitor;

    public CountNumberChildrenProcessor(DataProcessor innerDataProcessor) {
        super(innerDataProcessor);
        countCountChildrenVisitor = new CountNumberChildrenVisitor();
    }

    @Override
    SimpleNode processAdvance(SimpleNode root) {
        return (SimpleNode) root.accept(countCountChildrenVisitor);
    }
}
