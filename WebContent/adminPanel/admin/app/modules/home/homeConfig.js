angular.module('homeModule').config(['$stateProvider', function($stateProvider) {
	var HameStates = [
		{
			state : "home",
			config : {
				url : "",
				templateUrl : "app/modules/home/home.html",
				controller : 'homeCtrl',
				resolve : {
					currentUserConfig : function(configSrvc) {
						return configSrvc.getConfigAndConfigModules();
					},
					features : function(homeSrvc, currentUserConfig) {
						return homeSrvc.setMenuAndFeatures(currentUserConfig.userConfig);
					}
				}
			}
		},
		{
			state: "home.changePassword",
			config: {
				url: '/change_password',
				views: {
					'mainContent@home': {
						templateUrl: "app/modules/home/changePassword/changePassword.html",
						controller: 'changePasswordCtrl'
					}
				}
			}
		}
	];
	HameStates.forEach(function(state) {
		$stateProvider.state(state.state, state.config);
	});
			
}]);