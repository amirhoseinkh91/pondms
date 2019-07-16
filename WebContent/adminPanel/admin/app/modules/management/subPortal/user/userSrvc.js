angular.module('userModule', []);
angular.module('userModule').factory('userSrvc', [ 'Restangular', '$q',
	function(Restangular, $q) {

	return{
		getFulluserList: function(orgUid, startPage, pageLen){
			return Restangular.all( '/user/items').getList(
					{start:startPage, len:pageLen, extent:"full"});
		},
		getExtenduserList: function(orgUid){
			return Restangular.all( '/user/items').getList({len:-1});
		},
		getuserList: function(orgUid){
			return Restangular.all( '/user/items').getList();
		},
		getuser: function(orgUid, uid){
			return Restangular.one( '/user/items/'+uid).get();
		},
		saveuser: function(orgUid, data){
			return Restangular.all( '/user/items').post(data);
		},
		updateuser: function(orgUid, data){
			var uid = data.uid;
			delete data.username;
			return Restangular.all( '/user/items/'+uid).post(data);
		},
		deleteuser: function(orgUid, uid){
			return Restangular.one( '/user/items/'+uid).remove();
		},
		searchuser: function(orgUid, query, start, len){
			return Restangular.all( '/user/items').customPOST(query,'',
					{start:start,len:len,extent:'full'},{'X-HTTP-Method-Override':'GET'});
		},
		
	}
	
}]);