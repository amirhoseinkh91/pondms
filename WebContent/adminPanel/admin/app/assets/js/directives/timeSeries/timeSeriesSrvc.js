angular.module('timeSeriesModule', []);
angular.module('timeSeriesModule').factory('timeSeriesSrvc', [ 'Restangular', 'vtSearchSrvc', '$q',
	function(Restangular, vtSearchSrvc, $q) {

	return{

		uploadTimeSeries: function(data){
			return Restangular.all('time-series/add').post(data);
		}, 
		
		getTimeSeriesGroupList(){
			return Restangular.all('time_series_group/items').getList();
		}, 
		
		getTimeSeriesRootCategories: function(uid){
			return Restangular.all('time-series/get/' + uid).getList();
		}
	}
	
}]);