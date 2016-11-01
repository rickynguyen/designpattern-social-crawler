package data;

import common.Observer;
import common.Visitor;

public class SimpleNode extends TreeNode{

    private FolderNode folder;

    private String content;

    private String author;

    private String url;

    private Integer like = 0;

    private Integer share = 0;

    private Integer dislike = 0;

    private Integer totalChildren = 0;

    public Integer getTotalChildren() {
        return totalChildren;
    }

    public void setTotalChildren(Integer totalChildren) {
        this.totalChildren = totalChildren;
    }

    private String source;

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "SimpleNode{" +
                "content='" + content + '\'' +
                ", Status='" + this.statusState.getStatus() +
                ", totalLike='" + this.getTotalLike() +
                ", totalDislike='" + this.getTotalDislike() +
                ", source='" + source + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", like=" + like +
                ", share=" + share +
                ", dislike=" + dislike +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public FolderNode getFolder() {
        return folder;
    }

    public void setFolder(FolderNode folder) {
        this.folder = folder;
    }

    public Integer getTotalLike() {
        return this.statusState.getCurrentTotalLike();
    }

    public void setTotalLike(Integer totalLike) {
        this.statusState.setTotalLike(totalLike, this);
        updateObserver();
    }

    public Integer getTotalDislike() {
        return this.statusState.getCurrentTotalDislike();
    }

    public void setTotalDislike(Integer totalDislike) {
        this.statusState.setTotalDislike(totalDislike, this);
        updateObserver();
    }
}