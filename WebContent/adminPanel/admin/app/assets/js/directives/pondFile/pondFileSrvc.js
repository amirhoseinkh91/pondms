angular.module('pondFileModule', []);
angular.module('pondFileModule').factory('pondFileSrvc', [ 'Restangular', 'vtSearchSrvc', '$q',
	function(Restangular, vtSearchSrvc, $q) {

	return{

		getLayerFileHistory: function(uid){
			return Restangular.all('layer/datafile/get/' + uid).getList();
		},
		uploadlayerData: function(data){
			return Restangular.all('layer/datafile/add').post(data);
		},
		deleteFileFromHistory: function(data, layer_uid) {
			return Restangular.all('layer/datafile/delete/' + layer_uid).post(data);
		}
		
	}
	
}]);