angular.module('nationalModule').controller('nationalCtrl', function($scope, $rootScope, $state, nationalSrvc, NATIONAL_MENUS){

	$scope.Data = {
		menuList: NATIONAL_MENUS
	};
	
	$scope.Func = {
		getOrgList: function(){
			nationalSrvc.getOrgList().then(function(response){
				$scope.Data.orgList = response.data;
			});
		},
		onOrgClick: function(org){
			$state.go('home.subPortal', {orgUid: org.uid});
		},
		
		isActive: function(menu){
			return $state.$current.name == menu.uiSref;
		}
	};
	
	
	var Run = function(){
		if($scope.stateName=="home.national")
			$state.go('home.national.portal');
		$scope.Func.getOrgList();
	}
	
	Run();
	
});