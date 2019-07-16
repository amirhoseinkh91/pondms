angular.module('portalModule').controller('portalInfoCtrl', function($scope, $state, portalSrvc) {

	$scope.Data = {
		uid: $state.params.uid,
		mode: $state.params.uid?'edit':'add',
		selectedportal: {
			organization: {},
			map: {}
		},
		originalportal: {},
		validationClicked: false
	}
	
	$scope.Func = {
		getportal: function(uid){
			portalSrvc.getportal(uid).then(function(response){
				$scope.Data.selectedportal = response.data.originalElement;
				$scope.Data.originalportal = angular.copy($scope.Data.selectedportal);
				$scope.Data.mapModel = {
						polygon: $scope.Data.selectedportal.map.boundingBox,
						point: $scope.Data.selectedportal.map.center
				}
				$scope.Controller.crud.init();
			});
		},
		onSaveportalClick: function(){
			$scope.Func.prepareMapData();
			if($scope.portalForm.$valid){
				portalSrvc.saveportal($scope.Data.selectedportal).then(function(response){
					$state.go('home.national.portal', {}, {reload: true});
				});
			}else{
				$scope.Data.validationClicked = true;
			}
		},
		onUpdateportalClick: function(){
			$scope.Func.prepareMapData();
			if($scope.portalForm.$valid){
				portalSrvc.updateportal($scope.Data.selectedportal).then(function(response){
					$state.go('home.national.portal');
				});
			}else{
				$scope.Data.validationClicked = true;
			}
		},
		onCancelClick: function(){
			$state.go('home.national.portal');
		},
		
		
		prepareMapData: function(){
			var p = $scope.Controller.crud.getData('polygon');
			$scope.Data.selectedportal.map.boundingBox = {
					type: p.geometry.type,
					coordinates: p.geometry.coordinates[0]
			}
			$scope.Data.selectedportal.map.center = $scope.Controller.crud.getData('point').geometry;
		}
	}
	
	$scope.Controller = {
		crud: {}
	}
	
	var Run = function(){
		if($scope.Data.mode == 'edit')
			$scope.Func.getportal($scope.Data.uid);
	}
	
	Run();
});