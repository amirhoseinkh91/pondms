angular.module('pondModule').controller('pondInfoCtrl', function($scope, $state, $rootScope, pondSrvc) {

	$scope.Data = {
		orgUid: $state.params.orgUid,
		pondUid: $state.params.uid,
		showTimeseriesHistory: false,
		selectedpond: {},
		selectedLayer: {},
		leafList: [],
		schemaList: [],
		secretSchemaList: []
	}
	
	$scope.Controller = {
			
	}
	
	$scope.Func = {
		getSchemaList: function(){
			pondSrvc.getSchemaList().then(function(response){
				response.data.originalElement.forEach(function(item){
					if(item.is_secret)
						$scope.Data.secretSchemaList.push(JSON.parse(item.form_schema));
					else
						$scope.Data.schemaList.push(JSON.parse(item.form_schema));
				});
			})
		},
		getLeafLayerList: function(){
			pondSrvc.getpond($scope.Data.orgUid, $scope.Data.pondUid).then(function(res){
				$scope.Data.pond = res.data;
				pondSrvc.getLeafLayerList($scope.Data.pond.layer.uid).then(function(response){
					$scope.Data.leafList = response.data.originalElement;
				});
			})
		},
		
		onShowTimeseriesHistoryClick: function() {
			$scope.Controller.func($scope.Data.pondUid);
			$scope.Data.showTimeseriesHistory = true;
		},
		
		onLayerClick: function(layer){
			$scope.Data.selectedLayer = layer;
			$scope.api.call(layer);
		}
	}
	
	var Run = function(){
		$scope.Func.getSchemaList();
		$scope.Func.getLeafLayerList();
	}
	
	Run();
});