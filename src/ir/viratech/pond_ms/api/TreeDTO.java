package ir.viratech.pond_ms.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import ir.viratech.commons.api.dto.SimpleUltraLightDTO;
import ir.viratech.base.UIDAndDisplayStringAndTreeProvider;

public class TreeDTO<E extends UIDAndDisplayStringAndTreeProvider<E>> extends SimpleUltraLightDTO<E> {
	
	private int childCount;
	@JsonProperty
	public int getChildCount() {
		return childCount;
	}
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
	
	@Override
	public void loadFrom(E obj) {
		super.loadFrom(obj);
		setChildCount(obj.getChildCount());
	}
	
	@SuppressWarnings("rawtypes")
	public static <E extends UIDAndDisplayStringAndTreeProvider<E>> Class<TreeDTO> getTreeGenericClass() {
		return TreeDTO.class;
	}

}
