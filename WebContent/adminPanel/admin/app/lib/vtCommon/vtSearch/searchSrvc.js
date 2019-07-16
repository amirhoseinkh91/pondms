angular.module('vtSearch').factory('vtSearchSrvc', function() {
	
	return{
		//TODO support advanced search query
		createSearchQuery : function(jsonQuery, searchableFieldInfo){
			return {
				restrictions: this.createSimpleSearchRestriction(jsonQuery,searchableFieldInfo),
				orders : jsonQuery.orders
			}
		},
		
		createSearchOrder : function(field, dsc){
			return{
				restrictions: [],
				orders: [this.createOrder(field,dsc)]
			}
		},

		createSingleSearchRestriction : function(type, field, query){
			return {
				restrictions: [this.processQuery(type, field, query)],
				orders : []
			}
		},

//		searchableFieldInfo = [{key,type}]
		createSimpleSearchRestriction : function(jsonQuery, searchableFieldInfo){
			var restriction = [];
			for ( var index = 0; index < searchableFieldInfo.length; index++) {
				var fieldSearch = this.createFieldSeach(jsonQuery, searchableFieldInfo[index]);
				if(fieldSearch!=null)
					restriction.push(fieldSearch);
			}
			
			return restriction;		
		},
		
		//TODO
		createCustomSearchRestriction: function(){
			var restriction = [];
			return restriction;
		},
		
		//TODO
		createInnerFieldRestriction : function(){
			
		},
		
		createOrder : function(field, dsc){
			return {
				field: field,
				dir: (dsc?'dsc':'asc')
			}
		},

		createFieldSeach : function(jsonQuery, fieldInfo){
			if(jsonQuery[fieldInfo.key]!=null || fieldInfo.type=='custom')
				return this.processQuery(fieldInfo.type, fieldInfo.key, jsonQuery[fieldInfo.key]);
			return null;	
		},
		
		processQuery : function(type, field, query){
			var fieldSearch = null;
			switch (type) {
				case 'string':
					fieldSearch = this.processStringQuery(query);
					break;
				case 'date':
					fieldSearch = this.processDateQuery(query);
					break;
				case 'timestamp':
					fieldSearch = this.processDateQuery(query);
					break;
				case 'integer':
					fieldSearch = this.processIntegerQuery(query);
					break;
				case 'dto':
					fieldSearch = this.processDtoQuery(query);
					break;
				case 'enum':
					fieldSearch = this.processEumQuery(query);
					break;
				case 'bool':
				case 'boolean':
					fieldSearch = this.processBooleanQuery(query);
					break;
				case 'custom':
					fieldSearch = this.processCustomQuery(query);
					break;
				default:
					break;
			}
			if(fieldSearch!=null)
				fieldSearch.field = field;

			return fieldSearch;
		},

		processStringQuery : function(query){
			if(query!=""){
				if(query.indexOf(',')!=-1)
					return {type:'in',collection:query.split(',')}
				if(query.indexOf('=')==0)
					return {type:'eq',value:query.substr(1)}
				if(query.indexOf('!=')==0)
					return {type:'ne',value:query.substr(2)}	
				
				return {type:'like',value:query}
			}
			return null;
		},
		processDateQuery : function(query){
			var dateList = query.split(',');
			if(dateList.length != 2 || (dateList[0]=='' && dateList[1]==''))
				return null;
			if(dateList[0]=='')
				return {type:'le',value:parseInt(dateList[1])}
			if(dateList[1]=='')
				return {type:'ge',value:parseInt(dateList[0])}
			
			return {type:'betw',value:parseInt(dateList[0]),value2:parseInt(dateList[1])}
		},
		//TODO support between query
		processIntegerQuery : function(query){
			if(query.indexOf(',')!=-1)
				return {type:'in',collection:query.split(',')}
			
			var possibleOperation = [{q:'=',type:'eq'},{q:'!=',type:'ne'},{q:'>',type:'lt'},{q:'>=',type:'le'},{q:'<',type:'gt'},{q:'<=',type:'ge'}];
			for ( var index = 0; index < possibleOperation.length; index++) {
				if(query.indexOf(possibleOperation[index].q)==0)
					return {type:possibleOperation[index].type,value:possibleOperation[index].substr(possibleOperation[index].q.length)}
			}
			
			return {type:'like',value:query}
		},
		processDtoQuery : function(query){
			return {type: 'eq' , value: {uid: query}};
		},
		//TODO support ne
		processEumQuery : function(query){
			//var enumList = query.split(',');
			//if(enumList.length > 1)
			//	return {type:'in',collection:enumList};
			
			return {type:'eq',value:{uid:query.uid}}
		},

		processBooleanQuery : function(query){
			if(query != null)
				return {type:'eq',value:query}
			else
				return null;
		},

		processCustomQuery : function(query){
			return {type:'eq',value:query}
		}


	}
});