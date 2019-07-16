angular.module('homeModule').controller('homeCtrl', function($scope, $rootScope, $state, homeSrvc, currentUserConfig) {

		$scope.isLoading=false;
		$scope.menuData = homeSrvc.generateMenuData();
		$scope.userFullName = currentUserConfig.userConfig.userFullName;
		$rootScope.features = currentUserConfig.userConfig.features;
		$scope.stateName = $state.$current.name;
		$scope.time = new Date();
		
		$scope.isMenuActive = function(uiSref) {
			var currentState = $state.current.name;
			var splittedCurrentState = currentState.split(".");
			var splittedSref = uiSref.split(".");
			var isEqual = true;
			for ( var i = 0; i < splittedSref.length; i++) {
				if (splittedSref[i] !== splittedCurrentState[i]) {
					isEqual = false;
				}
			}
			return isEqual;
		};
		
		$scope.onManagementClick = function(){
			if(currentUserConfig.userConfig.orguid)
				$state.go('home.subPortal', {orgUid: currentUserConfig.userConfig.orguid});
			else
				$state.go('home.national');
		}
		
		if($scope.stateName=="home")
			$state.go('home.pondmap');
		
		$scope.$on('$stateChangeSuccess', function() {
			$scope.stateName = $state.$current.name;
		});
		
		if(currentUserConfig.userConfig.passwordExpired){
			$state.go('home.changePassword');
		}
});
