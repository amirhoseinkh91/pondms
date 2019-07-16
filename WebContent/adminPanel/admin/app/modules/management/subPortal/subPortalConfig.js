angular.module('subPortalModule', ['userModule', 'layerModule', 'pondModule']);
angular.module('subPortalModule').config(['$stateProvider', function($stateProvider) {
	var subPortalStates = [
		{
			state : "home.subPortal",
			config : {
				url : "/sub-portal/:orgUid",
				views : {
					'mainContent@home' : {
						templateUrl : "app/modules/management/subPortal/subPortal.html",
						controller : 'subPortalCtrl',
					}
				},
				resolve : {}
			}
		}
	];
	subPortalStates.forEach(function(state) {
		$stateProvider.state(state.state, state.config);
	});
			
}]);