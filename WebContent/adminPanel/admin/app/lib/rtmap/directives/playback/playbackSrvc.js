angular.module('rtmap').factory('playbackSrvc', [ 'Restangular', '$q',
	function(Restangular, $q) {

	return{
		getPlaybackData: function(data){
//			var defferd = $q.defer();
//			var simulationData;
//			var client = new XMLHttpRequest();
//			client.open('GET', 'app/lib/rtmap/directives/playback/playbackdata.json');
//			/**
//			 * Handle data loading.
//			 */
//			client.onload = function() {
//				simulationData = JSON.parse(client.responseText);
//				defferd.resolve({data:simulationData});
//			};
//			client.send();
//			return defferd.promise;
			return Restangular.all('vehicle/playback').post(data);
		},
		
	}
	
}]);