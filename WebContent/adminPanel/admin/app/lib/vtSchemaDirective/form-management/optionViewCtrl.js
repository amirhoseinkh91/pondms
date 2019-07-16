angular.module('vtFormManagement').controller('optionViewCtrl',
		function($scope, $uibModalInstance, baseSelector) {
			$scope.baseSelector = baseSelector;
			$scope.onReturnClick = function() {
				$uibModalInstance.dismiss('return');
			};

		});