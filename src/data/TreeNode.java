package data;

import common.*;

public abstract class TreeNode extends BaseObservable implements Visitable, Observable{
    public TreeNode() {
        statusState = new NormalState(0, 0);
    }

    protected StatusState statusState;

    public StatusState getStatusState() {
        return statusState;
    }

    public void setStatusState(StatusState statusState) {
        this.statusState = statusState;
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    protected void updateObserver() {
        for (Observer observer : observers) {
            observer.notify(this);
        }
    }
}
