angular.module('userModule').config(['$stateProvider', function($stateProvider) {
	var userStates = [
		{
			state: "home.subPortal.user",
			config: {
				url: '/user/',
				views: {
					'content@home.subPortal': {
						templateUrl: "app/modules/management/subPortal/user/user.html",
						controller: 'userCtrl'
					}
				}
			}
		}
	];
	userStates.forEach(function(state) {
		$stateProvider.state(state.state, state.config);
	});
			
}]);
