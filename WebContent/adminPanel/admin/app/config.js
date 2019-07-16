var pondMS = pondMS || {};
pondMS.config = ['$urlRouterProvider', 'RestangularProvider', '$httpProvider', 
	function( $urlRouterProvider, RestangularProvider, $httpProvider) {
	
		//TODO initialize routes
//		var initializeRoutes = function() {
//			angular.forEach(POND_MS_CONFIG_ROUTES.whens, function(route) {
//				$urlRouterProvider.when(route.url, route.handler);
//			});
//			$urlRouterProvider.otherwise(POND_MS_CONFIG_ROUTES.otherwise.handler);
//		};
//		initializeRoutes();
		
		RestangularProvider.setFullResponse(true);
		$httpProvider.interceptors.push('lowLevelHttpInterceptor');

}];
