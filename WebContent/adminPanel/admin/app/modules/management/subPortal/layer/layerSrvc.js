angular.module('layerModule', []);
angular.module('layerModule').factory('layerSrvc', [ 'Restangular', '$q', 'vtSearchSrvc',
	function(Restangular, $q, vtSearchSrvc) {

	return{
		getRoot: function(orgUid){
			return Restangular.all('org/'+orgUid+'/gis-map/items').getList({extent:'full'});
		},
		getlayer: function(orgUid, uid){
			return Restangular.one('org/'+orgUid+'/layer/items/'+uid).get();
		},
		savelayer: function(orgUid, data){
			return Restangular.all('org/'+orgUid+'/layer/items').post(data);
		},
		updatelayer: function(orgUid, data){
			var uid = data.uid;
			return Restangular.all('org/'+orgUid+'/layer/items/'+uid).post(data);
		},
		deletelayer: function(orgUid, uid){
			return Restangular.one('org/'+orgUid+'/layer/items/'+uid).remove();
		},

		getEntityTypeList: function(){
			return Restangular.all('entity_type/items').getList({startItemIndex: 1, pageSize: -1});
		},
		getEntityType: function(key){
			return Restangular.one('entity_type/items/' + key).get();
		},

		getFeatureList: function(layerUid, start, len){
			var query = vtSearchSrvc.createSingleSearchRestriction('dto', 'layer', layerUid);
			return Restangular.all('gis-vector-object/items').customPOST(query,'',
					{start:start,len:len,extent:'full'},{'X-HTTP-Method-Override':'GET'});
		},

		getGradientList: function() {
			return Restangular.all('gradient/items').getList();
		},
		updateFeatureListInstance : function (orgUid,instanceUid,data) {
			return Restangular.all('org/'+orgUid+'/gis-vector-object/items/'+instanceUid).post(data);
		},
		deleteFeatureListInstance : function (orgUid,instanceUid) {
			return Restangular.all('org/'+orgUid+'/gis-vector-object/items/'+instanceUid).remove();
		},
		saveNewInstance : function (orgUid,data) {
			return Restangular.all('org/'+orgUid+'/gis-vector-object/items/').post(data);
		},
		getportal : function () {
			return Restangular.one('portal/items').get();
		}
	}

}]);