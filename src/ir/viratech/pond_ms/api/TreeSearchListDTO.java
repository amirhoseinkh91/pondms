package ir.viratech.pond_ms.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ir.viratech.base.UIDAndDisplayStringAndTreeProvider;

public class TreeSearchListDTO<E extends UIDAndDisplayStringAndTreeProvider<E>> {

	public TreeSearchListDTO() {
	}

	public TreeSearchListDTO(List<TreeSearchNodeDTO<E>> items, long totalSize) {
		setItems(items);
		setTotalSize(totalSize);
	}

	@JsonSerialize
	private long totalSize;
	public long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	@JsonSerialize
	private List<TreeSearchNodeDTO<E>> items;
	public List<TreeSearchNodeDTO<E>> getItems() {
		return items;
	}
	public void setItems(List<TreeSearchNodeDTO<E>> items) {
		this.items = items;
	}
	public List<TreeSearchNodeDTO<E>> getCreatedItems() {
		if(getItems() == null) {
			setItems(new ArrayList<>());
		}
		return getItems();
	}

	private TreeSearchNodeDTO<E> getNode(E e) {
		TreeSearchNodeDTO<E> dto = new TreeSearchNodeDTO<>();
		dto.loadFrom(e);
		return dto;
	}

	private void addEntityAndAncestors(E e) {
		TreeSearchNodeDTO<E> result = getNode(e);
		result.getCreatedChildren();
		E next = e.getParent();
		while(next != null){
			TreeSearchNodeDTO<E> tmp = getNode(next);
			tmp.getCreatedChildren().add(result);
			result = tmp;
			next = next.getParent();
		}
		getCreatedItems().add(result);
	}

	public void loadFrom(Collection<E> items) {
		if(items != null) {
			setTotalSize(items.size());
			for(E e :items) {
				addEntityAndAncestors(e);
			}
		} else {
			setTotalSize(0);
			setItems(Collections.emptyList());
		}
	}
}