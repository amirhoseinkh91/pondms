angular.module('rtmap').factory('mapSrvc', function mapSrvc(Restangular, olMapDefaults) {
	
	var getFeatureProjection = function(feature) {
		var proj = (new ol.format.GeoJSON()).readProjection(feature);
		return proj.getCode();
	}
	
	var generateId = function() {
		var d = new Date().getTime();
	    var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
	        var r = (d + Math.random()*16)%16 | 0;
	        d = Math.floor(d/16);
	        return (c=='x' ? r : (r&0x3|0x8)).toString(16);
	    });
	    return uuid;
	};
	
	return{
		generateId: generateId,
		createPoint: function(layer, pointOption){
			var point = new ol.Point(pointOption);
			point.set('name', pointOption.name);
			point.setStyle(pointOption.style?pointOption.style:olMapDefaults.getDefaultPointStyle());
			point.setId(pointOption.uid?pointOption.uid:generateId());
			layer.addFeature(point);
			return point;
		},
		createLine: function(layer, lineOption) {
			var lineString = new ol.Line(lineOption);
			lineString.set('name', lineOption.name);
			lineString.setStyle(lineOption.style?lineOption.style:olMapDefaults.getDefaultLineStyle());
			lineString.setId(lineOption.uid?lineOption.uid:generateId());
			layer.addFeature(lineString);
			return lineString;
		},
		createPolygon: function(layer, polygonOption) {
			var polygon = new ol.Polygon(polygonOption);
			polygon.set('name', polygonOption.name);
			polygon.setStyle(polygonOption.style?polygonOption.style:olMapDefaults.getDefaultPolygonStyle());
			polygon.setId(polygonOption.uid?polygonOption.uid:generateId());
			layer.addFeature(polygon);
			return polygon;
		},
		
		createGeojson: function(feature) {
			feature.getGeometry().transform('EPSG:3857', 'EPSG:4326');
			return JSON.parse((new ol.format.GeoJSON()).writeFeature(feature));
		},
		
		createPointStyle: function(imageSrc){
			var style = new ol.style.Style({
                image: new ol.style.Icon({
                    anchor: [0.5, 33],
                    anchorXUnits: 'fraction',
                    anchorYUnits: 'pixels',
                    opacity: 0.90,
                    src: imageSrc,
                    snapToPixel: true
                })
            });
			return style;
		},
		
		addPopupToMap: function(map, popup, callbackFn) {
			var temp = '';
			map.on('singleclick', function(evt) {
				this.forEachFeatureAtPixel(evt.pixel, function(feature, layer) {
					if(feature){
						if(_.isFunction(callbackFn)){
							callbackFn(feature);							
						}
					    var featureId = feature.getId();
						if(popup.isOpen()){
							popup.hide();
							if(temp !== featureId){
								popup.show(feature.getGeometry().getCoordinates(), olMapDefaults.getDefaultPopupTemplate(feature), true);
								temp = featureId;
							}else{
								temp = '';
							}
						}else{
							temp = featureId;
							popup.show(feature.getGeometry().getCoordinates(), olMapDefaults.getDefaultPopupTemplate(feature), true);																								
						}
					}
				});
			});
		}
	}
	
});