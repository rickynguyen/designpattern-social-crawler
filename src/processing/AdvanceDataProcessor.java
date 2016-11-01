package processing;

import data.SimpleNode;

abstract class AdvanceDataProcessor extends DataProcessor {
    private DataProcessor innerDataProcessor;

    AdvanceDataProcessor(DataProcessor innerDataProcessor) {
        this.innerDataProcessor = innerDataProcessor;
    }

    @Override
    public SimpleNode process(SimpleNode root) {
        SimpleNode node = this.innerDataProcessor.process(root);
        return this.processAdvance(node);
    }

    abstract SimpleNode processAdvance(SimpleNode root);
}
