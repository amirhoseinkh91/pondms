angular.module('rtmap').run(function(mapSrvc, olMapDefaults){
	ol.Polygon = function(option){
		option = option || {};
		
		ol.Feature.call(this, {
			geometry: new ol.geom.Polygon(option.coords).transform('EPSG:4326', 'EPSG:3857'),
			name: 'Polygon',
			entityType: option.entityType?option.entityType:'',
			data: option.data
		});
	}

	ol.inherits(ol.Polygon, ol.Feature);

});