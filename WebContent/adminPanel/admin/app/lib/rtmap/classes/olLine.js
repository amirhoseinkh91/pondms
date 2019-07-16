angular.module('rtmap').run(function(mapSrvc, olMapDefaults){
	ol.Line = function(option){
		option = option || {};

		ol.Feature.call(this, {
			geometry: new ol.geom.LineString(option.coords).transform('EPSG:4326', 'EPSG:3857'),
			name: 'Line',
			entityType: option.entityType?option.entityType:'',
			data: option.data
		});
	}

	ol.inherits(ol.Line, ol.Feature);

});