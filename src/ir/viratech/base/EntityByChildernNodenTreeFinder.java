package ir.viratech.base;

import java.util.List;

public interface EntityByChildernNodenTreeFinder<E> {
	
	List<E> getChildren(E e);
}
