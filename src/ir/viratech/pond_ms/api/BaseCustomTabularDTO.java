package ir.viratech.pond_ms.api;

import ir.viratech.commons.api.dto.TabularCollectionDTO;
import ir.viratech.commons.api.search.field.DtoFieldInfo;
import ir.viratech.commons.api.search.field.FieldInfo;
import ir.viratech.commons.api.search.field.PrimitiveFieldInfo;
import ir.viratech.commons.api.search.field.dto.AbstractFieldInfoDTO;
import ir.viratech.commons.api.search.field.dto.CompoundFieldInfoDTO;
import ir.viratech.commons.api.search.field.dto.PrimitiveFieldInfoDTO;
import ir.viratech.commons.api.search.field.types.FieldInfo_Boolean;
import ir.viratech.commons.api.search.field.types.FieldInfo_Double;
import ir.viratech.commons.api.search.field.types.FieldInfo_Dto;
import ir.viratech.commons.api.search.field.types.FieldInfo_Integer;
import ir.viratech.commons.api.search.field.types.FieldInfo_Long;
import ir.viratech.commons.api.search.field.types.FieldInfo_String;
import ir.viratech.commons.api.search.field.types.FieldInfo_Timestamp;
import ir.viratech.commons.util.SimpleJava;
import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.pond_ms.core.i18n.MessageService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import com.vividsolutions.jts.geom.Point;

public abstract class BaseCustomTabularDTO <E> implements TabularCollectionDTO<E>{
	
	private List<E> list ;
	private final Map<String, FieldInfo<?>> fieldInfoMap = new HashMap<String, FieldInfo<?>>();
	private String bundlePrefix;
	private MessageTranslator messageTranslator ;
	private Long totalCount;
	
	public BaseCustomTabularDTO(){
		messageTranslator = MessageService.getMessageTranslator();
	}
	
	public BaseCustomTabularDTO(List<E> list , String bundlePrefix){
		this.messageTranslator = MessageService.getMessageTranslator();
		this.list = list ;
		this.bundlePrefix = bundlePrefix;
	}
	
	public void setList(List<E> list) {
		this.list = list;
	}
	
	public List<E> getList() {
		return list;
	}
	
	public void setBundlePrefix(String bundlePrefix) {
		this.bundlePrefix = bundlePrefix + ".";
	}
	
	public String getBundlePrefix() {
		return bundlePrefix;
	}
	
	public abstract void putAllFieldInfo();
	
	public Collection<AbstractFieldInfoDTO<?>> getFields() {
		putAllFieldInfo();
		return createFieldInfoDtoCollection(this.bundlePrefix, fieldInfoMap.values(), messageTranslator);
	}
	
	@Override
	public Collection<E> getItems() {
		return list ;
	}

	@Override
	public long getTotalCount() {
		if(this.totalCount == null) return 0 ;
		if(totalCount > 0) return this.totalCount;
		else if(CollectionUtils.isEmpty(list))
			return 0;
		return list.size();
	}
	
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	
	private Collection<AbstractFieldInfoDTO<?>> createFieldInfoDtoCollection(String bundlePrefix, Collection<FieldInfo<?>> allFieldInfo, MessageTranslator messageTranslator) {
		Collection<AbstractFieldInfoDTO<?>> res = new ArrayList<>();
		for (FieldInfo<?> fieldInfo : SimpleJava.wrapNotNull(allFieldInfo)) {
			AbstractFieldInfoDTO<?> fieldInfoDto = createFieldInfoDto(fieldInfo, bundlePrefix, messageTranslator);
			if (fieldInfoDto != null) {
				res.add(fieldInfoDto);
			}
		}
		return res;
	}
	
	protected FieldInfo_String createFieldInfo_String(String externalName, String internalName, String internalSearchExpression,
			String typeKey, String bundleKey, boolean searchable, Boolean sortable){
		return new FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
	}
	
	protected FieldInfo_Integer createFieldInfo_Integer(String externalName, String internalName, String internalSearchExpression,
			String typeKey, String bundleKey, Boolean searchable, Boolean sortable){
		return  new FieldInfo_Integer(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
	}
	
	protected FieldInfo_Boolean createFieldInfo_Boolean(String externalName, String internalName, String internalSearchExpression,
			String typeKey, String bundleKey, Boolean searchable, Boolean sortable){
		return  new FieldInfo_Boolean(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
	}
	
	protected FieldInfo_Double createFieldInfo_Double(String externalName, String internalName, String internalSearchExpression,
			String typeKey, String bundleKey, Boolean searchable, Boolean sortable){
		return  new FieldInfo_Double(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
	}
	
	protected FieldInfo_Long createFieldInfo_Long(String externalName, String internalName, String internalSearchExpression,
			String typeKey, String bundleKey, Boolean searchable, Boolean sortable){
		return  new FieldInfo_Long(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
	}
	
	protected FieldInfo_Timestamp createFieldInfo_Timestamp(String externalName, String internalName, String internalSearchExpression,
			String typeKey, String bundleKey, Boolean searchable, Boolean sortable){
		return  new FieldInfo_Timestamp(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
	}
	
	protected FieldInfo_Dto<GeoJsonPoint, Point> createFieldInfo_Point(String externalName, String internalName, String internalSearchExpression,
			String typeKey, String bundleKey, Boolean searchable, Boolean sortable){
		return new FieldInfo_Dto<>(externalName, internalName, internalSearchExpression, bundleKey, searchable, null, null);
	}
	
	protected void putFieldInfo(FieldInfo<?> fieldInfo) {
		this.fieldInfoMap.put(fieldInfo.getExternalName(), fieldInfo);
	}
	
	private AbstractFieldInfoDTO<?> createFieldInfoDto(FieldInfo<?> fieldInfo, String bundlePrefix, MessageTranslator messageTranslator) {
		if (fieldInfo instanceof PrimitiveFieldInfo) {
			PrimitiveFieldInfo<?> primitiveFieldInfo = (PrimitiveFieldInfo<?>) fieldInfo;
			return new PrimitiveFieldInfoDTO(primitiveFieldInfo, bundlePrefix, messageTranslator);
		}
		if (fieldInfo instanceof DtoFieldInfo) {
			DtoFieldInfo<?, ?> dtoFieldInfo = (DtoFieldInfo<?, ?>) fieldInfo;
			return new CompoundFieldInfoDTO(dtoFieldInfo, bundlePrefix, messageTranslator);
		}
		return null;
	}
}