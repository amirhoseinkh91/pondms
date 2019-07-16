angular.module('pondmsModule').constant('MAP_CONFIG', {
		mapServerAddress : 'http://89.235.69.85:8080/google_maps/street/{z}/gm_{x}_{y}_{z}.png',
		center: [51.3890, 35.6892],
		projection: 'EPSG:3857',
		maxZoom: 18,
		minZoom: 1,
		zoom: 11
    }
)