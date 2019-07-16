var pondMS =  pondMS || {};
pondMS.showUndefined = function() {
	return function(input,leng) {
		if((typeof input === undefined)  || (input == null)&&(typeof leng === undefined)  || (leng == null) ){
			return 'ندارد';
		}else{
			return leng;
		}
	};
};

