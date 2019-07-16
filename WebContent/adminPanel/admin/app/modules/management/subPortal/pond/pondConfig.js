angular.module('pondModule').config(['$stateProvider', function($stateProvider) {
	var pondStates = [
		{
			state: "home.subPortal.pond",
			config: {
				url: '/pond/',
				views: {
					'content@home.subPortal': {
						templateUrl: "app/modules/management/subPortal/pond/pond.html",
						controller: 'pondCtrl'
					}
				}
			}
		},
		{
			state: "home.subPortal.pondInfo",
			config: {
				url: '/pond/info/:uid',
				views: {
					'content@home.subPortal': {
						templateUrl: "app/modules/management/subPortal/pond/pondInfo.html",
						controller: 'pondInfoCtrl'
					}
				}
			}
		}
	];
	pondStates.forEach(function(state) {
		$stateProvider.state(state.state, state.config);
	});
			
}]);
