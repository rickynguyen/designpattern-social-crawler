package data;

import java.util.Objects;

public class HappyState extends StatusState {

    public HappyState(Integer currentTotalLike, Integer currentTotalDislike) {
        super(currentTotalLike, currentTotalDislike);
    }

    @Override
    public String getStatus() {
        return "Happy";
    }

    @Override
    public void setTotalLike(Integer totalLike, TreeNode node) {
        this.currentTotalLike = totalLike;
        if (currentTotalLike <= currentTotalDislike) {
            node.setStatusState(new NormalState(currentTotalLike, currentTotalDislike));
        }
    }

    @Override
    public void setTotalDislike(Integer totalDislike, TreeNode node) {
        this.currentTotalDislike  = totalDislike;
        if (currentTotalLike <= currentTotalDislike) {
            node.setStatusState(new NormalState(currentTotalLike, currentTotalDislike));
        }
    }
}
