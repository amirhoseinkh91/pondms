angular.module('formModule').config(['$stateProvider', function($stateProvider) {
	var formStates = [
		{
			state: "home.national.form",
			config: {
				url: '/form/',
				views: {
					'content@home.national': {
						templateUrl: "app/modules/management/national/form/form.html",
						controller: 'formCtrl'
					}
				}
			}
		}
	];
	formStates.forEach(function(state) {
		$stateProvider.state(state.state, state.config);
	});
			
}]);
