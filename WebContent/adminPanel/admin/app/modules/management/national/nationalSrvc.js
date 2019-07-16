angular.module('nationalModule', ['userroleModule', 'formModule', 'portalModule']);
angular.module('nationalModule').factory('nationalSrvc', ['$rootScope', 'Restangular', function($rootScope, Restangular) {
	return {
		
		getOrgList: function(){
			return Restangular.all('organization/availables').getList();
		}

	}

}]);
