angular.module('rtmap').factory('olMapDefaults', function(olPopupTemplateSrvc) {

/********* default styles **********/
	var getDefaultPointStyle = function(){
		var style = new ol.style.Style({
            image: new ol.style.Icon({
                anchor: [0.5, 50],
                anchorXUnits: 'fraction',
                anchorYUnits: 'pixels',
                opacity: 0.90,
                snapToPixel: true,
                src: 'app/lib/rtmap/assets/img/map-marker-red.png'
            })
        });
		return style;
	};
	
	var getDefaultLineStyle = function(){
		var style = new ol.style.Style({
		    stroke: new ol.style.Stroke({
		        color: 'blue',
		        width: 1.5
		      })
		});
		return style;
	};
	
	var getDefaultLineFirstCoordsStyle = function(){
		var style = {
				image: new ol.style.Circle({
					radius: 7,
					fill: new ol.style.Fill({
						color: 'red'
					})
				})
		};
		return style
	};
	
	var getDefaultLineLastCoordsStyle = function(){
		var style = {
				image: new ol.style.Circle({
					radius: 7,
					fill: new ol.style.Fill({
						color: '#000000'
					})
				})
		};
		return style
	};
	
	var getDefaultPolygonStyle = function() {
		var style = new ol.style.Style({
		    fill: new ol.style.Fill({
		        color: 'rgba(255,255,255,0.5)'
		      }),
		      stroke: new ol.style.Stroke({
		        color: 'red',
		        width: 1.5
		      })
		});
		return style;
	};
	
	var getDefaultCircleStyle = function() {
		var style = new ol.style.Style({
		    fill: new ol.style.Fill({
		        color: 'rgba(255,255,255,0.5)'
		      }),
		      stroke: new ol.style.Stroke({
		        color: 'red',
		        width: 1.5
		      })
		});
		return style;
	}

/********* default Edit mode styles **********/
	var getDefaultEditPointStyle = function(){
		var style = new ol.style.Style({
            image: new ol.style.Icon({
                anchor: [0.5, 50],
                anchorXUnits: 'fraction',
                anchorYUnits: 'pixels',
                opacity: 0.90,
                snapToPixel: true,
                src: 'app/lib/rtmap/assets/img/map-marker-yellow.png'
            })
        });
		return style;
	};
	
	var getDefaultEditLineStyle = function(){
		var style = new ol.style.Style({
		    stroke: new ol.style.Stroke({
		        color: 'orange',
		        width: 3
		      })
		});
		return style;
	};
	
	var getDefaultEditPolygonStyle = function() {
		var style = new ol.style.Style({
		    fill: new ol.style.Fill({
		        color: 'rgba(255,255,255,0.5)'
		      }),
		      stroke: new ol.style.Stroke({
		        color: 'yellow',
		        width: 1.5
		      })
		});
		return style;
	};
	
/********* default Stop mode styles **********/
	var getDefaultStopPointStyle = function(){
		var style = new ol.style.Style({
            image: new ol.style.Icon({
                anchor: [0.5, 50],
                anchorXUnits: 'fraction',
                anchorYUnits: 'pixels',
                opacity: 0.90,
                snapToPixel: true,
                src: 'app/lib/rtmap/assets/img/map-marker-green.png'
            })
        });
		return style;
	};
	
	var getDefaultStopLineStyle = function(){
		var style = new ol.style.Style({
		    stroke: new ol.style.Stroke({
		        color: 'green',
		        width: 1.5
		      })
		});
		return style;
	};
	
	var getDefaultStopPolygonStyle = function() {
		var style = new ol.style.Style({
		    fill: new ol.style.Fill({
		        color: 'rgba(255,255,255,0.5)'
		      }),
		      stroke: new ol.style.Stroke({
		        color: 'green',
		        width: 1.5
		      })
		});
		return style;
	};
	
	return{
		getDefaultStyle: {
			'Point': getDefaultPointStyle(),
			'LineString': getDefaultLineStyle(),
			'Polygon': getDefaultPolygonStyle(),
			'Circle': getDefaultCircleStyle(),
		},
		getDefaultEditStyle: {
			'Point': getDefaultEditPointStyle(),
			'LineString': getDefaultEditLineStyle(),
			'Polygon': getDefaultEditPolygonStyle(),
		},
		getDefaultStopStyle: {
			'Point': getDefaultStopPointStyle(),
			'LineString': getDefaultStopLineStyle(),
			'Polygon': getDefaultStopPolygonStyle(),
		},

		getDefaultLineFirstCoordsStyle: getDefaultLineFirstCoordsStyle,
		getDefaultLineLastCoordsStyle: getDefaultLineLastCoordsStyle,
		
		getDefaultPointStyle: getDefaultPointStyle,
		getDefaultLineStyle: getDefaultLineStyle,
		getDefaultPolygonStyle: getDefaultPolygonStyle,
		
		getDefaultPopupTemplate: function(feature){
			//TODO change default template to show {uid,title} objects
			var defaultTemplate = undefined;
			var template = olPopupTemplateSrvc.getTemplate(feature);
			return template?template:defaultTemplate;
		}
	}
});