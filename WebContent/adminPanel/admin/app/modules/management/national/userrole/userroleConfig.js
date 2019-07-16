angular.module('userroleModule').config(['$stateProvider', function($stateProvider) {
	var userroleStates = [
		{
			state: "home.national.userrole",
			config: {
				url: '/userrole/',
				views: {
					'content@home.national': {
						templateUrl: "app/modules/management/national/userrole/userrole.html",
						controller: 'userroleCtrl'
					}
				}
			}
		}
	];
	userroleStates.forEach(function(state) {
		$stateProvider.state(state.state, state.config);
	});
			
}]);
