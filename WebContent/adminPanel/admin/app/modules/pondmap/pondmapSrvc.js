angular.module('pondmapModule', []);
angular.module('pondmapModule').factory('pondmapSrvc', ['$rootScope', 'Restangular', 'vtSearchSrvc', function($rootScope, Restangular, vtSearchSrvc) {
	return {
		
		getGisMapList: function(){
			return Restangular.all('/gis-map/availables').getList({extent:'full'});
		},
		getGisMap: function(uid){
			return Restangular.one('gis-map/items/' + uid).get();
		},
		
		getLayer: function(uid){
			return Restangular.one('layer/items/'+uid).get();
		},
		searchLayer: function(query, start, len){
			var query = vtSearchSrvc.createSingleSearchRestriction('string', 'name', query);
			return Restangular.all('layer/items').customPOST(query,'',
					{start:start,len:len,extent:'full'},{'X-HTTP-Method-Override':'GET'});
		},
		
		getVectorObjectList: function(layerUid, start, len){
			return Restangular.one('layer/vector-object/items/' + layerUid).get({start:start, len:len});
		},
		getVectorObject: function(uid){
			return Restangular.one('gis-vector-object/items/'+uid).get({extent:'map'});
		},
		searchVectorObject: function(query, start, len){
			var query = vtSearchSrvc.createSingleSearchRestriction('string', 'name', query);
			return Restangular.all('gis-vector-object/items').customPOST(query,'',
					{start:start,len:len,extent:'full'},{'X-HTTP-Method-Override':'GET'});
		},
		
		getEntityType: function(key){
			return Restangular.one('entity_type/items/' + key).get();
		},
		
		getPondSchemaList: function(){
			return Restangular.all('pond/form-keys').getList();
		},
		
		getForm: function(pondUid, schemaKey){
			return Restangular.one('pond/form-instance/'+pondUid).get({form_key:schemaKey});
		},
		
		getTimeSeriesRootCategories: function(uid){
			return Restangular.all('time-series/get/' + uid).getList();
		},
		
		getCategory: function(category) {
			return Restangular.one('category/items/' + category).get();
		},
		
		getZonalStatistics: function(layer, polygon){
			return Restangular.all('layer/zonal-statistics/' + layer.uid).post(polygon);
		},
		identifyRaster: function(layer, point){
			return Restangular.all('layer/identify-point/' + layer.uid).post(point);
		}

	}

}]);
