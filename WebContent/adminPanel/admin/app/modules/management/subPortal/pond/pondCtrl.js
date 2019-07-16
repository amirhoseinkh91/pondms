angular.module('pondModule').controller('pondCtrl', function($scope, $state, pondSrvc) {

	$scope.Data = {
		orgUid: $state.params.orgUid,
		mode: 'view',
		searchMode: 'none',
		pondList: [],
		selectedpond: {},
		originalpond: {},
		layerList: [],
		validationClicked: false
	}
	
	$scope.Func = {
		onAddpondClick: function(){
			$scope.Data.mode = 'add';
			$scope.Func.reset();
		},
		onSelectpond: function(pond){
			pondSrvc.getpond($scope.Data.orgUid, pond.uid).then(function(response){
				$scope.Data.selectedpond = response.data.originalElement;
				$scope.Data.originalpond = angular.copy($scope.Data.selectedpond);
				$scope.Func.initiatelayer();
				$scope.Data.mode='view';
			});
		},
		onEditpondClick: function(){
			$scope.Data.mode = 'edit';
		},
		onSavepondClick: function(){
			if($scope.pondForm.$valid){
				pondSrvc.savepond($scope.Data.orgUid, $scope.Data.selectedpond).then(function(response){
					$scope.Controller.pondListController.refreshList()
					$scope.Func.resetForm();
				});
			}else{
				$scope.Data.validationClicked = true;
			}
		},
		onUpdatepondClick: function(){
			if($scope.pondForm.$valid){
				pondSrvc.updatepond($scope.Data.orgUid, $scope.Data.selectedpond).then(function(response){
					$scope.Controller.pondListController.refreshList()
					$scope.Func.resetForm();
				});
			}else{
				$scope.Data.validationClicked = true;
			}
		},
		onDeletepondClick: function(){
			pondSrvc.deletepond($scope.Data.orgUid, $scope.Data.selectedpond.uid).then(function(response){
				$scope.Func.resetForm();
				$scope.Func.reset();
				$scope.Controller.pondListController.refreshList();
			});
		},
		onCancelClick: function(){
			$scope.Data.selectedpond = angular.copy($scope.Data.originalpond);
			$scope.Func.initiatelayer();
			$scope.Func.resetForm();
		},
		onDetailClick: function(){
			$state.go('home.subPortal.pondInfo', {uid:$scope.Data.selectedpond.uid})
		},
		
		onChangeSearchModeClick: function(mode){
			$scope.Data.searchMode = mode;
		},
		onSearchClick: function(advancedMode){
			if(advancedMode){
				$scope.Func.onChangeSearchModeClick('advanced');
				$scope.Controller.pondListController.searchQuery = $scope.Controller.pondAdvancedSearchController.searchQuery;
				$scope.Controller.pondListController.searchableFieldInfo = $scope.Controller.pondAdvancedSearchController.searchableFieldInfo;
			}else{
				$scope.Func.onChangeSearchModeClick('quick');
				$scope.Controller.pondListController.searchQuery = $scope.Controller.pondSearchController.searchQuery;
				$scope.Controller.pondListController.searchableFieldInfo = $scope.Controller.pondSearchController.searchableFieldInfo;			
			}
			$scope.Controller.pondListController.refreshList(true);
		},
		onExitSearchModeClick: function(){
			$scope.Func.onChangeSearchModeClick('none');
			$scope.Controller.pondAdvancedSearchController.searchQuery = {};
			$scope.Controller.pondSearchController.searchQuery = {};
			$scope.Controller.pondListController.exitSearchMode();
		},
		
		getlayerList: function(){
			pondSrvc.getPondLayerList($scope.Data.orgUid).then(function(response){
				for ( var int = 0; int < response.data.originalElement.length; int++) {
					$scope.Data.layerList.push(response.data.originalElement[int]);					
				}
			});
		},
		onSelectlayer: function(layer){
			$scope.Data.layer = layer;
			$scope.Data.selectedpond.layer = {
				uid:$scope.Data.layer.uid,
				name:$scope.Data.layer.title
			};
		},
		initiatelayer: function(){
			$scope.Data.layer = null;
			if($scope.Data.selectedpond.layer){
				for ( var int = 0; int < $scope.Data.layerList.length; int++) {
					if($scope.Data.layerList[int].uid==$scope.Data.selectedpond.layer.uid)
						$scope.Data.layer = $scope.Data.layerList[int];
				}
			}
		},
		
		reset: function(){
			$scope.Data.selectedpond = {};
			$scope.Data.layer = null;
		},
		resetForm: function() {
			$scope.Data.mode = 'view';
			$scope.Data.validationClicked = false;
		}
		
	}
	
	$scope.Controller = {
		pondListController : {
			headers: [
				{key:'title', label:'نام'},		
				{key:'layer.name', label:'لایه'},
			],
			getList: function(start, len){
				return pondSrvc.getFullpondList($scope.Data.orgUid, start, len);
			},
			onListItemSelect: $scope.Func.onSelectpond,
			searchFunction: function(query, start, len){
				return pondSrvc.searchpond($scope.Data.orgUid, query, start, len);
			}
		},
		pondSearchController: {
			advanced: false,
			searchableFieldInfo: [
				{key:"title", type:"string", label:"نام"},
				{key:"layer", type:"enum", label:"لایه", itemList:$scope.Data.layerList},
			],
			onSearchClick: $scope.Func.onSearchClick,
			onExitSearchModeClick: $scope.Func.onExitSearchModeClick
		},
		pondAdvancedSearchController: {
			advanced: true,
			searchableFieldInfo: [
				{key:"title", type:"string", label:"نام"},
				{key:"layer", type:"enum", label:"لایه", itemList:$scope.Data.layerList},
			],
			onSearchClick: $scope.Func.onSearchClick,
			onExitSearchModeClick: $scope.Func.onExitSearchModeClick
		}
	}
	
	var Run = function(){
		$scope.Func.getlayerList();
	}
	
	Run();
});
