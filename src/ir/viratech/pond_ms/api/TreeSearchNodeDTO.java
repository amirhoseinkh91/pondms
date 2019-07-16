package ir.viratech.pond_ms.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ir.viratech.base.UIDAndDisplayStringAndTreeProvider;
import ir.viratech.commons.api.dto.SimpleUltraLightDTO;

public class TreeSearchNodeDTO<E extends UIDAndDisplayStringAndTreeProvider<E>> extends SimpleUltraLightDTO<E> {
	
	private int childCount;
	@JsonProperty
	public int getChildCount() {
		return childCount;
	}
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
	
	@JsonSerialize
	private List<TreeSearchNodeDTO<E>> children;
	public List<TreeSearchNodeDTO<E>> getChildren() {
		return children;
	}
	public void setChildren(List<TreeSearchNodeDTO<E>> children) {
		this.children = children;
	}
	public List<TreeSearchNodeDTO<E>> getCreatedChildren() {
		if(children == null) {
			setChildren(new ArrayList<>());
		}
		return getChildren();
	}
	
	@Override
	public void loadFrom(E obj) {
		setUid(obj.getExtuid());
		setTitle(obj.getDisplayString());
		setChildCount(obj.getChildCount());
	}
	
	@SuppressWarnings("rawtypes")
	public static <E extends UIDAndDisplayStringAndTreeProvider<E>> Class<TreeSearchNodeDTO> getTreeGenericClass() {
		return TreeSearchNodeDTO.class;
	}

}
