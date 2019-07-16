angular.module('pondmapModule').controller('timeSeriesModalCtrl', function($scope, $uibModalInstance, $filter, pondmapSrvc, geoObject) {

	$scope.geoObject = geoObject;
	$scope.chartDrawn = false;
	$scope.selectedCategory = {};
	
	
	$scope.onCancelClick = function(){
		$uibModalInstance.dismiss();
	}
	
	
	var Run = function() {
		pondmapSrvc.getTimeSeriesRootCategories($scope.geoObject.uid).then(function(response){
			$scope.rootCategories = response.data;
		});
	}
	
	$scope.onFirstListChange = function(){
		pondmapSrvc.getCategory($scope.selectedCategory.first.uid).then(function(response){
			$scope.secondLevelCategories = response.data.children;
		});
		$scope.selectedCategory.third = null;
		$scope.selectedCategory.second = null;
		$scope.selectedCategory.thirdLevelCategories = null;
	}
	
	$scope.onSecondListChange = function(){
		$scope.chartDrawn = false;
		pondmapSrvc.getCategory($scope.selectedCategory.second.uid).then(function(response){
			if (!$scope.selectedCategory.second.isLeaf) {
				$scope.thirdLevelCategories = response.data.children;
				$scope.selectedCategory.third = null;
			}
			else {
				$scope.initChart(response.data);
				$scope.chartDrawn = true;
			}
		});
		$scope.selectedCategory.third = null;
	}
	
	$scope.onThirdListChange = function(){
		$scope.chartDrawn = false;
		if ($scope.selectedCategory.third.isLeaf) {
			pondmapSrvc.getCategory($scope.selectedCategory.third.uid).then(function(response){
				$scope.initChart(response.data);
				$scope.chartDrawn = true;
			});
		}
	}
	
	$scope.initChart = function(category) {
		$scope.data = [];
		$scope.labels = [];
		$scope.series = [category.name];
		category.values.sort(function(a, b){
		    var keyA = new Date(a.submisstionTime),
		        keyB = new Date(b.submisstionTime);
		    // Compare the 2 dates
		    if(keyA < keyB) return -1;
		    if(keyA > keyB) return 1;
		    return 0;
		});
		for (item of category.values) {
			$scope.data.push(item.timeSeriValue);
			$scope.labels.push($filter('persianDate')(item.submisstionTime, 'yyyy'));
		}
		$scope.options = {
				scales: {
				      yAxes: [
				        {
				          id: 'y-axis-1',
				          type: 'bar',
				          display: true,
				          position: 'left',
				          scaleLabel: {
				              display: true,
//				              labelString: 'جمعیت'
				            }
				        }
				      ],
				      xAxes: [
						        {
						          id: 'x-axis-1',
						          display: true,
						          scaleLabel: {
						              display: true,
//						              labelString: 'سال'
						            }
						        }
						      ]

				    }
				  };
	}

	Run();
	
});
