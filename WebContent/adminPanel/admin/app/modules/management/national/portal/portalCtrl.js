angular.module('portalModule').controller('portalCtrl', function($scope, $state, portalSrvc, mapSrvc) {

	$scope.Data = {
		mode: 'view',
		searchMode: 'none',
		portalList: [],
		selectedportal: {},
		originalportal: {}
	}
	
	$scope.Func = {
		onAddportalClick: function(){
			$state.go('home.national.portalInfo');
		},
		onSelectportal: function(portal){
			portalSrvc.getportal(portal.uid).then(function(response){
				$scope.Data.selectedportal = response.data.originalElement;
				$scope.Data.originalportal = angular.copy($scope.Data.selectedportal);
				
				$scope.layer.getSource().clear();
				mapSrvc.createPolygon($scope.layer, {coords: [$scope.Data.selectedportal.map.boundingBox.coordinates]});
				mapSrvc.createPoint($scope.layer, {coords: $scope.Data.selectedportal.map.center.coordinates});
				
				$scope.Data.mode='view';
			});
		},
		onEditportalClick: function(){
			$state.go('home.national.portalInfo', {uid: $scope.Data.selectedportal.organization.uid});
		},
		onDeleteportalClick: function(){
			portalSrvc.deleteportal($scope.Data.selectedportal.uid).then(function(response){
				$scope.Func.reset();
				$scope.Controller.portalListController.refreshList();
			});
		},
		
		onChangeSearchModeClick: function(mode){
			$scope.Data.searchMode = mode;
		},
		onSearchClick: function(advancedMode){
			if(advancedMode){
				$scope.Func.onChangeSearchModeClick('advanced');
				$scope.Controller.portalListController.searchQuery = $scope.Controller.portalAdvancedSearchController.searchQuery;
				$scope.Controller.portalListController.searchableFieldInfo = $scope.Controller.portalAdvancedSearchController.searchableFieldInfo;
			}else{
				$scope.Func.onChangeSearchModeClick('quick');
				$scope.Controller.portalListController.searchQuery = $scope.Controller.portalSearchController.searchQuery;
				$scope.Controller.portalListController.searchableFieldInfo = $scope.Controller.portalSearchController.searchableFieldInfo;			
			}
			$scope.Controller.portalListController.refreshList(true);
		},
		onExitSearchModeClick: function(){
			$scope.Func.onChangeSearchModeClick('none');
			$scope.Controller.portalAdvancedSearchController.searchQuery = {};
			$scope.Controller.portalSearchController.searchQuery = {};
			$scope.Controller.portalListController.exitSearchMode();
		},
		
		reset: function(){
			$scope.Data.selectedportal = {};
		}
	}
	
	$scope.Controller = {
		portalListController: {
			headers: [
				{key:'title'},
				{key:'sub_domain'}
			],
			getList: portalSrvc.getFullportalList,
			onListItemSelect: $scope.Func.onSelectportal,
			searchFunction: portalSrvc.searchportal,
		},
		portalSearchController: {
			advanced: false,
			searchableFieldInfo: [
				{key:"title", type:"string"},
				{key:"sub_domain", type:"string"},
			],
			onSearchClick: $scope.Func.onSearchClick,
			onExitSearchModeClick: $scope.Func.onExitSearchModeClick
		},
		portalAdvancedSearchController: {
			advanced: true,
			searchableFieldInfo: [
				{key:"title", type:"string"},
				{key:"sub_domain", type:"string"}
			],
			onSearchClick: $scope.Func.onSearchClick,
			onExitSearchModeClick: $scope.Func.onExitSearchModeClick
		}
	}
	
	
	$scope.map = new ol.RTMap({
		target: 'map',
		layers: [
			new ol.layer.Vector({
				name: 'data',
				source: new ol.source.Vector()
			})
		],
		zoom: 4,
		center: [54.250852, 32.413656]
	});
	
	
	var Run = function(){
		$scope.layer = $scope.map.getOneLayer('data');
	}
	
	Run();
});