package common;

public interface Visitable {

    Object accept(Visitor visitor);
}
