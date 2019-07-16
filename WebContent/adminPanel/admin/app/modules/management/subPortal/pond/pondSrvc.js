angular.module('pondModule', []);
angular.module('pondModule').factory('pondSrvc', [ 'Restangular', 'vtSearchSrvc', '$q',
	function(Restangular, vtSearchSrvc, $q) {

	return{
		getFullpondList: function(orgUid, startPage, pageLen){
			return Restangular.all( 'org/'+orgUid+'/pond/items').getList(
					{start:startPage, len:pageLen, extent:"full"});
		},
		getExtendpondList: function(orgUid){
			return Restangular.all( 'org/'+orgUid+'/pond/items').getList({len:-1});
		},
		getpondList: function(orgUid){
			return Restangular.all( 'org/'+orgUid+'/pond/items').getList();
		},
		getpond: function(orgUid, uid){
			return Restangular.one( 'org/'+orgUid+'/pond/items/'+uid).get();
		},
		savepond: function(orgUid, data){
			return Restangular.all( 'org/'+orgUid+'/pond/items').post(data);
		},
		updatepond: function(orgUid, data){
			var uid = data.uid;
			delete data.pondname;
			return Restangular.all( 'org/'+orgUid+'/pond/items/'+uid).post(data);
		},
		deletepond: function(orgUid, uid){
			return Restangular.one( 'org/'+orgUid+'/pond/items/'+uid).remove();
		},
		searchpond: function(orgUid, query, start, len){
			return Restangular.all('org/'+orgUid+ '/pond/items').customPOST(query,'',
					{start:start,len:len,extent:'full'},{'X-HTTP-Method-Override':'GET'});
		},


		getPondLayerList: function(orgUid){
			var query = vtSearchSrvc.createSingleSearchRestriction('boolean', 'isPond', true);
			return Restangular.all( '/layer/items').customPOST(query,'',
					{len:-1},{'X-HTTP-Method-Override':'GET'});
		},
		getLeafLayerList: function(layeruid){
			return Restangular.all('layer/leaf-sublayers/'+layeruid).getList();
		},

		getSchemaList: function(){
			return Restangular.all('pond/form-keys').getList();
		}

	}

}]);