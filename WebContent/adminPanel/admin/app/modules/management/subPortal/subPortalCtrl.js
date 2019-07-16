angular.module('subPortalModule').controller('subPortalCtrl', function($scope, $rootScope, $state, homeSrvc, configObj, SUBPORTAL_MENUS, NATIONAL_MENUS){

	$scope.Data = {
		orgUid: configObj.userConfig.orguid,
		menuList: SUBPORTAL_MENUS,
		minitMenuList: NATIONAL_MENUS
	};
	
	$scope.isActive = function(menu){
		return $state.$current.name == menu.uiSref;
	}
	
	
	if($scope.stateName=="home.subPortal")
		$state.go('home.subPortal.layer', {orgUid:$state.params.orgUid});
	
});