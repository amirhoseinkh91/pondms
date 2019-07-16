angular.module('nationalModule').config(['$stateProvider', function($stateProvider) {
	var nationalStates = [
		{
			state : "home.national",
			config : {
				url : "/national",
				views : {
					'mainContent@home' : {
						templateUrl : "app/modules/management/national/national.html",
						controller : 'nationalCtrl',
					}
				},
				resolve : {}
			}
		}
	];
	nationalStates.forEach(function(state) {
		$stateProvider.state(state.state, state.config);
	});
			
}]);