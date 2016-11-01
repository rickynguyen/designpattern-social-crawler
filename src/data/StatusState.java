package data;

public abstract class StatusState {
    protected Integer currentTotalLike = 0;
    protected Integer currentTotalDislike = 0;

    public StatusState(Integer currentTotalLike, Integer currentTotalDislike) {
        this.currentTotalLike = currentTotalLike;
        this.currentTotalDislike = currentTotalDislike;
    }

    public Integer getCurrentTotalLike() {
        return currentTotalLike;
    }

    public Integer getCurrentTotalDislike() {
        return currentTotalDislike;
    }

    abstract public String getStatus();

    abstract public void setTotalLike(Integer totalLike, TreeNode node);

    abstract public void setTotalDislike(Integer totalDislike, TreeNode node);
}
