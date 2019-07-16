angular.module('portalModule', []);
angular.module('portalModule').factory('portalSrvc', [ 'Restangular', '$q',
	function(Restangular, $q) {

	return{
		getFullportalList: function(startPage, pageLen){
			return Restangular.all('portal/items').getList(
					{start:startPage, len:pageLen, extent:"full"});
		},
		getExtendportalList: function(){
			return Restangular.all('portal/items').getList({len:-1});
		},
		getportalList: function(){
			return Restangular.all('portal/items').getList();
		},
		getportal: function(uid){
			return Restangular.one('portal/items/'+uid).get();
		},
		saveportal: function(data){
			return Restangular.all('portal/items').post(data);
		},
		updateportal: function(data){
			var uid = data.organization.uid;
			return Restangular.all('portal/items/'+uid).post(data);
		},
		deleteportal: function(uid){
			return Restangular.one('portal/items/'+uid).remove();
		},
		searchportal: function(query, start, len){
			return Restangular.all('portal/items').customPOST(query,'',
					{start:start,len:len,extent:'full'},{'X-HTTP-Method-Override':'GET'});
		},
		
	}
	
}]);