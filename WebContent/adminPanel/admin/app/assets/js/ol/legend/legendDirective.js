angular.module('rtmap').directive('legend', function () {
    return {
		restrict: "AE",
        templateUrl: 'app/assets/js/ol/legend/legendTemplate.html',
        scope: {
			layerList: "="
		},
        controller: function ($scope, colorPickerSrvc) {

        	$scope.createLineLegend = function(layer){
        		return {
        			'width': '40px',
        			'height': '0px',
        			'border': 'solid ' + parseFloat(layer.width) + 'px ' + colorPickerSrvc.convertHex(layer.color, 100),
        			'background-color': colorPickerSrvc.convertHex(layer.fill, 100),
        			'margin-top': '14px'
        		}
        	}
        	
        	$scope.createPolygonLegend = function(layer){
        		return {
        			'width': '40px',
        			'height': '30px',
        			'border': 'solid ' + parseFloat(layer.width) + 'px ' + colorPickerSrvc.convertHex(layer.color, 100),
        			'background-color': colorPickerSrvc.convertHex(layer.fill, 50) 
        		}
        	}
        	
		}
    }
});
