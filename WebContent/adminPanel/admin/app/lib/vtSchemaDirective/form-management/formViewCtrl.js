angular.module('vtFormManagement').controller('formViewCtrl',
		function($scope, entitySrvc, $uibModalInstance, toaster, topicSrvc, jsonSchema) {
			$scope.isCol7 = true;
			$scope.jsonSchema = jsonSchema;
			$scope.model = {};
			$scope.schemaFormViewModalApi = {
				onInit : function() {
					// this.setMode("SEARCH");
				}
			}
			$scope.onReturnClick = function() {
				$uibModalInstance.dismiss('return');
			};

		});