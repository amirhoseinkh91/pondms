angular.module('rtmap').run(function(mapSrvc, olMapDefaults){
	ol.Point = function(option){
		option = option || {};
		ol.Feature.call(this, {
			geometry: new ol.geom.Point(option.coords).transform('EPSG:4326', 'EPSG:3857'),
			name: 'Point',
			population: 4000,
			rainfall: 500,
			entityType: option.entityType?option.entityType:'',
			data: option.data
		});
	}

	ol.inherits(ol.Point, ol.Feature);

});