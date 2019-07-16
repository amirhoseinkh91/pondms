var pondMS =  pondMS || {};
pondMS.jalaliDateJustDate =  function() {
	return function(inputDate, format) {
		var date = moment(parseInt(inputDate));
		if (!!!date._i) {
			return "";
		}
		return date.format(format);
	}
};