angular.module('formModule', []);
angular.module('formModule').factory('formSrvc', [ 'Restangular', '$q',
	function(Restangular, $q) {

	var correctForSend = function(obj) {
		delete obj.originalElement;
		if (angular.isString(obj.schema)) {
			obj.schema = JSON.parse(obj.schema);
			obj.schema.title = obj.name;
			obj.schema.key = obj.key;
		}
		obj.schema = JSON.stringify(obj.schema);
		return obj;
	}
	
	return{
		getFullformList: function(start, len){
			return Restangular.all('entity_type/items').getList({
				startItemIndex : start+1, pageSize : len-1, extent : 'full'
			}).then(function(response) {
				if (!response.data.fields || !response.data.fields.length) {
					response.data.fields = [ 
					                         {
						sortable : false, type : "string", label : "کلید انگلیسی", key : "key"
					},
					{
						sortable : false, type : "string", label : "نام",key : "name"
					}];
				}
				return response;
			})
		},
		getExtendformList: function(){
			return Restangular.all('entity_type/items').getList({len:-1});
		},
		getformList: function(){
			return Restangular.all('entity_type/items').getList();
		},
		getform: function(uid){
			return Restangular.one('entity_type/items/'+uid).get({raw:true});
		},
		saveform: function(data){
			data = correctForSend(data);
			return Restangular.all('entity_type/items').post(data);
		},
		updateform: function(data){
			var uid = data.key;
			data = correctForSend(data);
			delete data.key;
			return Restangular.all('entity_type/items/'+uid).post(data);
		},
		deleteform: function(uid){
			return Restangular.one('entity_type/items/'+uid).remove();
		},
		searchform: function(query, start, len){
			return Restangular.all('entity_type/items').customPOST(query,'',
					{startItemIndex:start+1, pageSize:len, extent:'full'},{'X-HTTP-Method-Override':'GET'}
			).then(function(response) {
				if (!response.data.fields || !response.data.fields.length) {
					response.data.fields = [ 
					                         {
						sortable : false, type : "string", label : "کلید انگلیسی", key : "key"
					}, 
					{
						sortable : false, type : "string", label : "نام",key : "name"
					}];
				}
				return response;
			});
		}
		
	}
	
}]);