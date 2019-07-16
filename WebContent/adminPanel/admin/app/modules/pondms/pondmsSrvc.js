angular.module('pondmsModule', []);
angular.module('pondmsModule').factory('pondmsSrvc', [ 'Restangular', function(Restangular) {

	return {
		downloadByLink: function(url, fileName){
			var link = document.createElement("a");
            link.setAttribute("href", url);
            link.setAttribute("download", fileName);
            link.style = "visibility:hidden";
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
            
//          linkDownload = $("<iframe style='display:none;'>", {
//			id : 'idown',
//			src : url
//		}).hide().appendTo('body');

		}
	}

}]);