var pondMS =  pondMS || {};
pondMS.checkmark = function() {
	return function(input) {
		return input ? '\u2713' : '\u2718';
	};
};