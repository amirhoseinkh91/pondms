angular.module('layerModule').config(['$stateProvider', function($stateProvider) {
	var layerStates = [
		{
			state: "home.subPortal.layer",
			config: {
				url: '/layer/',
				views: {
					'content@home.subPortal': {
						templateUrl: "app/modules/management/subPortal/layer/layer.html",
						controller: 'layerCtrl'
					}
				}
			}
		},
		{
			state: "home.subPortal.feature",
			config: {
				url: '/feature/:layerUid',
				views: {
					'content@home.subPortal': {
						templateUrl: "app/modules/management/subPortal/layer/feature.html",
						controller: 'featureCtrl'
					}
				}
			}
		}
	];
	layerStates.forEach(function(state) {
		$stateProvider.state(state.state, state.config);
	});
			
}]);
