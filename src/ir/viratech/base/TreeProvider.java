package ir.viratech.base;

import java.util.Set;

public interface TreeProvider<E> {

	Set<E> getChildren();

	int getChildCount();

	E getParent();

}
