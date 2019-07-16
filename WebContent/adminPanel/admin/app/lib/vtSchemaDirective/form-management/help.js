angular.module('vtFormManagement').controller('helpCtrl',
		function($scope, $uibModalInstance) {
			
			
			
			$scope.onReturnClick = function() {
				$uibModalInstance.dismiss('return');
			};

		});