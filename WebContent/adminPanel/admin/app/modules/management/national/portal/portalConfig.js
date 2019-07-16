angular.module('portalModule').config(['$stateProvider', function($stateProvider) {
	var portalStates = [
		{
			state: "home.national.portal",
			config: {
				url: '/portal/',
				views: {
					'content@home.national': {
						templateUrl: "app/modules/management/national/portal/portal.html",
						controller: 'portalCtrl'
					}
				}
			}
		},
		{
			state: "home.national.portalInfo",
			config: {
				url: '/portal/info/:uid',
				views: {
					'content@home.national': {
						templateUrl: "app/modules/management/national/portal/portalInfo.html",
						controller: 'portalInfoCtrl'
					}
				}
			}
		}
	];
	portalStates.forEach(function(state) {
		$stateProvider.state(state.state, state.config);
	});
			
}]);
