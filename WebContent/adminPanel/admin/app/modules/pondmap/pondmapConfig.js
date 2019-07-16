angular.module('pondmapModule').config(['$stateProvider', function($stateProvider) {
	var pondmapStates = [
		{
			state: "home.pondmap",
			config: {
				url: '/map',
				views: {
					'mainContent@home': {
						templateUrl: "app/modules/pondmap/pondmap.html",
						controller: 'pondmapCtrl'
					}
				}
			}
		}
	];
	pondmapStates.forEach(function(state) {
		$stateProvider.state(state.state, state.config);
	});
			
}]);