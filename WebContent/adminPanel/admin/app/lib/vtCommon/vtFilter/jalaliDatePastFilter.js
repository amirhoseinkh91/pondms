var pondMS =  pondMS || {};
pondMS.jalaliDatePast =  function() {
	return function(inputDate, format) {
		var date = moment(parseInt(inputDate));
		if (!!!date._i) {
			return "";
		}
		return date.fromNow();
	}
};