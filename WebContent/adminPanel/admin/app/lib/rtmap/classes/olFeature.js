angular.module('rtmap').run(function($q, olMapDefaults){
	ol.Feature.prototype.changeFormat = function(){
		return (new ol.format.GeoJSON()).readFeature(this, {featureProjection:'EPSG:3857' , dataProjection:'EPSG:4326'});
	}
	ol.Feature.prototype.changeWriteFormat = function(){
		JSON.parse((new ol.format.GeoJSON()).writeFeature(this, {featureProjection: 'EPSG:3857', dataProjection: 'EPSG:4326'}));
	}
	
	ol.Feature.prototype.startEdit = function(map){
		var featuresCollection = new ol.Collection(),
			_feature = this;
		//this.cursor = 'pointer';
		this.setStyle(olMapDefaults.getDefaultEditStyle[this.getGeometry().getType()]);
		featuresCollection.push(_feature);
		modify = new ol.interaction.Modify({
			features: featuresCollection,
			deleteCondition: function(event) {
				return ol.events.condition.shiftKeyOnly(event) &&	ol.events.condition.singleClick(event);
			}
		});
		map.addInteraction(modify);

		modify.on('modifyend', function (e) {
			var geojson = JSON.parse((new ol.format.GeoJSON()).writeFeature(_feature, {featureProjection: 'EPSG:3857', dataProjection: 'EPSG:4326'}));
		});
	};

	ol.Feature.prototype.stopEdit = function(map){

		//TODO: add arrow to Polygon  , !LineString is OK

		/********* Start: code for adding arrow ********/
//		if(this.getGeometry().getType()=='Polygon' && this.getGeometry().getType()=='Point'){
//			this.getGeometry().forEachSegment(function(start, end) {
//				var middle = [];
//				middle[0]= (start[0]+end[0])/2;
//				middle[1]= (start[1]+end[1])/2;
//				var dx = end[0] - start[0];
//				var dy = end[1] - start[1];
//				var rotation = Math.atan2(dy, dx);
//				styles.push(
//					new ol.style.Style({
//						geometry: new ol.geom.Point(middle),
//						image: new ol.style.Icon({
//							src: 'app/lib/rtmap/assets/img/arrow.png',
//							anchor: [0.75, 0.5],
//							rotateWithView: false,
//							rotation: -rotation
//						})
//					})
//				);
//			});
		/********* End: code for adding arrow ********/

		var deffered = $q.defer(),
			that = this;
			var style = [olMapDefaults.getDefaultStopStyle[this.getGeometry().getType()]];

			if(this.getGeometry().getType() ==='LineString'){
				var firstPoint = this.getGeometry().getFirstCoordinate();
				var lastPoint =  this.getGeometry().getLastCoordinate();
				
				var firstLineCoordsStyle = olMapDefaults.getDefaultLineFirstCoordsStyle();
				firstLineCoordsStyle.geometry = new ol.geom.Point(firstPoint);
				style.push(new ol.style.Style(firstLineCoordsStyle));
				
				var lastLineCoordsStyle = olMapDefaults.getDefaultLineLastCoordsStyle();
				lastLineCoordsStyle.geometry = new ol.geom.Point(lastPoint);
				style.push(new ol.style.Style(lastLineCoordsStyle));
			}
			this.setStyle(style);

			map.getInteractions().forEach(function (interaction) {
				  if(interaction instanceof ol.interaction.Modify) {
					  map.removeInteraction(interaction);
					  deffered.resolve({data:that});
				  }
			});
		
		return deffered.promise;
	};
	
	ol.Feature.prototype.singleDraw = function(map, layerName, style){
		var deffered = $q.defer(),
			layerSource = map.getLayer(layerName).getSource(),
			type = this.get('geometryType'),
			geometryFunction,
			maxPoints,
			that = this;

		
		/* feature types
			Point
			LineString
			Polygon
			Circle
			Square
			Box
		*/
		
		
		if (type === 'Square') {
			type = 'Circle';
			geometryFunction = ol.interaction.Draw.createRegularPolygon(4);
		}else if(type === 'Circle'){
			type = 'Circle';
			geometryFunction = ol.interaction.Draw.createRegularPolygon(37);
		}else if (type === 'Box') {
			type = 'LineString';
			maxPoints = 2;
			geometryFunction = function(coordinates, geometry) {
				if (!geometry) {
					geometry = new ol.geom.Polygon(null);
				}
				var start = coordinates[0],
					end = coordinates[1];
				
				geometry.setCoordinates([[start, [start[0], end[1]], end, [end[0], start[1]], start]]);
				return geometry;
			};
		}		

		draw = new ol.interaction.Draw({
			source: layerSource,
			type: type,
			geometryFunction: geometryFunction,
            maxPoints: maxPoints
		});
		map.addInteraction(draw);
		
		draw.on('drawend', function (event) {
			event.feature.setStyle(olMapDefaults.getDefaultStyle[type]);
			map.removeInteraction(draw);
			deffered.resolve({feature:event.feature});
		});
		return deffered.promise;
	}
	
	ol.Feature.prototype.remove = function(layer) {
		layer.getSource().removeFeature(this);
	}
	
	ol.Feature.prototype.fitZoom = function(map){
		var extent = this.getLayer(map).getSource().getExtent();
		map.getView().fit(extent,map.getSize(),{
	        padding: [30, 30, 30, 30]
	    })
	    map.render();
	}
	
	ol.Feature.prototype.getLayer = function(map) {
		var this_ = this, layer_, layersToLookFor = [];
		/** Populates array layersToLookFor with only layers that have features **/
		var check = function(layer){
			var source = layer.getSource();
			if(source instanceof ol.source.Vector){
				var features = source.getFeatures();
				if(features.length > 0){
					layersToLookFor.push({
						layer: layer,
						features: features
					});
				}
			}
		};
		//loop through map layers
		map.getLayers().forEach(function(layer){
			if (layer instanceof ol.layer.Group) {
				layer.getLayers().forEach(check);
			} else {
				check(layer);
			}
		});
		layersToLookFor.forEach(function(obj){
			var found = obj.features.some(function(feature){
				return this_ === feature;
			});
			if(found){
				//this is the layer we want
				layer_ = obj.layer;
			}
		});
		return layer_;
	};
	
	ol.Feature.prototype.getTwoDimensionalCoordinates = function(){
		if(this.getGeometry().getType() === 'Polygon'){
			return this.getGeometry().transform('EPSG:3857', 'EPSG:4326').getCoordinates()[0];
		}else{
			return this.getGeometry().transform('EPSG:3857', 'EPSG:4326').getCoordinates();
		}
	}
});