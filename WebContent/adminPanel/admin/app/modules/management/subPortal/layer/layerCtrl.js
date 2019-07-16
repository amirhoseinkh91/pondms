angular.module('layerModule').controller('layerCtrl', function($scope, $state, $rootScope, $uibModal, layerSrvc) {

	$scope.Data = {
		orgUid : $state.params.orgUid,
		mode : 'view',
		originallayer : {},
		newlayer : {},
		entityTypeList : [],
		gradientList : [],
		validationClicked : false,
		api: {}
	}

	
	$scope.Func = {
		onSelectMap: function(map){
			$scope.Data.originalmap = {uid:map.uid};
		},
		onSelectlayer : function(layer) {
			$scope.Data.originallayer = layer;
			if (layer.type == 'vector' || layer.type == 'raster')
				$scope.Data.api.call(layer);
		},
		onAddlayerClick : function(nodeType) {
			$scope.Func.openModal('add');
		},
		onEditlayerClick : function() {
			$scope.Func.openModal('edit');
		},
		onSavelayerClick : function(layer) {
			layer.parentLayer = $scope.Data.originallayer.uid?{uid: $scope.Data.originallayer.uid}:null;
			layer.map = $scope.Data.originallayer.map?$scope.Data.originallayer.map:$scope.Data.originalmap;
			layerSrvc.savelayer($scope.Data.orgUid, layer).then(function(response) {
				$scope.Controller.layerTreeController.addChild($scope.Controller.layerTreeController.selectedNode, response.data);
			});
		},
		onUpdatelayerClick : function(layer) {
			layer.parentLayer = $scope.Data.originallayer.parentLayer;
			layer.map = $scope.Data.originallayer.map?$scope.Data.originallayer.map:$scope.Data.originalmap;
			layerSrvc.updatelayer($scope.Data.orgUid, layer).then(function(response) {
				$scope.Controller.layerTreeController.updateNode($scope.Controller.layerTreeController.selectedNode, layer);
			});
		},
		onDeletelayerClick : function() {
			layerSrvc.deletelayer($scope.Data.orgUid, $scope.Data.originallayer.uid).then(function(response) {
				$scope.Controller.layerTreeController.removeNode($scope.Data.originallayer.uid);
			});
		},
		
		openModal: function(mode){
			var modalInstance = $uibModal.open({
				size: 'lg',
				templateUrl: 'app/modules/management/subPortal/layer/layerModal.html',
				controller: 'layerModalCtrl',
				resolve:{
					mode: function(){
						return mode;
					},
					data: function(){
						return $scope.Data.originallayer;
					},
					list: function(){
						return $scope.Data.entityTypeList;
					},
					gradients: function() {
						return $scope.Data.gradientList;
					}
				}
			});
			modalInstance.result.then(function(data){
				if(mode == 'add')
					$scope.Func.onSavelayerClick(data);
				else if(mode == 'edit')
					$scope.Func.onUpdatelayerClick(data);
			});
		},
		
		getEntityTypeList : function() {
			layerSrvc.getEntityTypeList().then(function(response) {
				for (var int = 0; int < response.data.originalElement.length; int++) {
					$scope.Data.entityTypeList.push(response.data.originalElement[int]);
				}
			});
		},
		
		getGradientList : function() {
			layerSrvc.getGradientList().then(function(response) {
				for (var int = 0; int < response.data.originalElement.length; int++) {
					$scope.Data.gradientList.push(response.data.originalElement[int]);
				}
			});
		},
		
		goToFeaturePage: function(){
			$state.go("home.subPortal.feature", {layerUid: $scope.Data.originallayer.uid});
		}
	}

	
	$scope.Controller = {
		layerTreeController: {
			inTreeAction: false,
			getRootList : function() {
				return layerSrvc.getRoot($scope.Data.orgUid)
			},
			getNodeInfo: function(uid){
				return layerSrvc.getlayer($scope.Data.orgUid, uid)
			},
			onSelectNode: $scope.Func.onSelectlayer,
			onSelectRoot: $scope.Func.onSelectMap
		},
		layerSearchController: {
			advanced: false,
			searchableFieldInfo: [
				{key:"name", type:"string"},
				{key:"type", type:"string"},
			],
			onSearchClick: $scope.Func.onSearchClick,
			onExitSearchModeClick: $scope.Func.onExitSearchModeClick
		}
	}

	var Run = function() {
		$scope.Func.getEntityTypeList();
		$scope.Func.getGradientList();
	}

	Run();
});