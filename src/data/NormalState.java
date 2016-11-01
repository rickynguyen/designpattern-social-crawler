package data;

public class NormalState extends StatusState {

    public NormalState(Integer currentTotalLike, Integer currentTotalDislike) {
        super(currentTotalLike, currentTotalDislike);
    }

    @Override
    public String getStatus() {
        return "Normal";
    }

    @Override
    public void setTotalLike(Integer totalLike, TreeNode node) {
        this.currentTotalLike = totalLike;
        if (currentTotalLike > currentTotalDislike) {
            HappyState newState = new HappyState(currentTotalLike, currentTotalDislike);
            node.setStatusState(newState);
        }
    }

    @Override
    public void setTotalDislike(Integer totalDislike, TreeNode node) {
        this.currentTotalDislike  = totalDislike;
        if (currentTotalLike < currentTotalDislike) {
            node.setStatusState(new SadState(currentTotalLike, currentTotalDislike));
        }
    }
}
