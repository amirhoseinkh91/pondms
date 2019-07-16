angular.module('rtmap').directive('mapDrawing', function () {
    return {
		restrict: "AE",
        templateUrl: 'app/assets/js/ol/drawing/mapDrawingTemplate.html',
        scope: {
			mode: "=",
			model: "=",
			api: "="
		},
        controller: function ($scope, mapSrvc, olMapDefaults,$timeout) {
        	// TODO Add lineString support
        	// TODO Extract drawing as dependent directive

			$scope.uniqueId =_.uniqueId("map");
			var polygonLayer,pointLayer;
			$timeout(function () {
				$scope.map = new ol.RTMap({
					target: $scope.uniqueId,
					layers: [
						new ol.layer.Vector({
							name: 'polygon',
							source: new ol.source.Vector()
						}),
						new ol.layer.Vector({
							name: 'point',
							source: new ol.source.Vector()
						})
					],
					zoom: 11,
				});
				if(!$scope.model)$scope.model={};

				/* *************************** Globals ************************************ */
				polygonLayer = $scope.map.getOneLayer('polygon');
				pointLayer = $scope.map.getOneLayer('point');
				$scope.map.updateSize();


			},1);



			/* *************************** Named functions ************************************ */
			var editFeature = function(type) {
				if(type === 'polygon'){
					$scope.polygonFeature.startEdit($scope.map);
				}else if(type === 'point'){
					$scope.pointFeature.startEdit($scope.map);
				}
			};

			var init = function() {
				if($scope.model.polygon && $scope.model.polygon.coordinates && $scope.model.polygon.coordinates.length){
					$scope.polygonFeature = mapSrvc.createPolygon(polygonLayer, {
						coords: $scope.model.polygon.coordinates[0][0][0] ? $scope.model.polygon.coordinates : [$scope.model.polygon.coordinates]
					});
				}

				if($scope.model.point && $scope.model.point.coordinates && $scope.model.point.coordinates.length){
					$scope.pointFeature = mapSrvc.createPoint(pointLayer, {
						coords: $scope.model.point.coordinates,
					});
				}
				$scope.map.panToCoords($scope.model.point.coordinates);
			};
			var resetMap= function () {
				if($scope.pointFeature){
					$scope.pointFeature.remove(pointLayer);
					$scope.pointFeature = undefined;
				}
			};

			var drawFeatureByHand = function(type){
				if(type === 'polygon'){
					$scope.Func.removeFeature(type);
					var feature = new ol.Feature({geometryType: 'Box'});
					feature.singleDraw($scope.map, 'polygon').then(function(obj) {
						$scope.polygonFeature = obj.feature;
						editFeature(type);
					});
				}else if(type === 'point'){
					$scope.Func.removeFeature(type);
					var feature = new ol.Feature({geometryType: 'Point'});
					feature.singleDraw($scope.map, 'point').then(function(obj) {
						$scope.pointFeature = obj.feature;
						editFeature(type);
					});
				}
			};

			var getData = function (type) {
				var Geo;
				if($scope.polygonFeature && type === 'polygon'){
					Geo = angular.copy(mapSrvc.createGeojson($scope.polygonFeature));
				}else if($scope.pointFeature && type === 'point'){
					Geo = angular.copy(mapSrvc.createGeojson($scope.pointFeature));
				}
				return Geo;
			};

			/* *************************** View Functions *************************** */
			$scope.Func = {
				changeType: function(type){
					$scope.type = type;
					if((type=='polygon' && $scope.polygonFeature) || (type=='point' && $scope.pointFeature))
						editFeature(type);
					else
						drawFeatureByHand(type);
				},
				removeFeature : function(type){
					if(type === 'polygon'){
						if($scope.polygonFeature){
							$scope.polygonFeature.remove(polygonLayer);
							$scope.polygonFeature = undefined;
							drawFeatureByHand(type);
						}
					}else if(type === 'point'){
						if($scope.pointFeature){
							$scope.pointFeature.remove(pointLayer);
							$scope.pointFeature = undefined;
							drawFeatureByHand(type);
						}
					}
				}
			};

			$scope.api = {
				resetMap:resetMap,
				getData: getData,
				init: init
			}
			

		}
    }
});
