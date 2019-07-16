angular.module('layerModule').controller('layerModalCtrl', function($scope, $uibModalInstance, layerSrvc, mode, data, list, gradients) {
	$uibModalInstance.rendered.then(function() {
		$scope.Data = {
			mode: mode,
			layer: {},
			formList: list,
			gradientList: gradients
		}

		$scope.Func = {
			onSaveClick: function() {
				//TODO validation
				$scope.Data.layer.formSchemaKey = $scope.Data.form?$scope.Data.form.key:null;
				$scope.Data.layer.secret = $scope.Data.layer.secret=='true'?true:false;
				if($scope.Data.layer.type == 'leaf')
					$scope.Data.layer.type = $scope.Data.layerType;
				$uibModalInstance.close($scope.Data.layer);
			},
			onCancelClick: function(){
				$uibModalInstance.dismiss();
			}
		}

		var Run = function () {
			if($scope.Data.mode == 'edit'){
				$scope.Data.layer = data;
				if($scope.Data.layer.type == 'vector' || $scope.Data.layer.type == 'raster'){
					$scope.Data.layerType = $scope.Data.layer.type; 
					data.type = 'leaf';
				}
				$scope.Data.formList.forEach(function(form){
					if(form.key == $scope.Data.layer.formSchemaKey){
						$scope.Data.form = form;
						return;
					}
				})
			}
		}

		Run();

	});
});