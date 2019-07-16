angular.module('pondFormModule', []);
angular.module('pondFormModule').factory('pondFormSrvc', [ 'Restangular', 'vtSearchSrvc', '$q',
	function(Restangular, vtSearchSrvc, $q) {

	return{
		getForm: function(pondUid, schemaKey){
			return Restangular.one('pond/form-instance/'+pondUid).get({form_key:schemaKey});
		},
		saveForm: function(orgUid, pondUid, schemaKey, form){
			return Restangular.all('pond/form-instance/'+pondUid+'?form_key='+schemaKey).post(form);
		}
	}
	
}]);