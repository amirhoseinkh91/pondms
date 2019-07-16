var pondMS =  pondMS || {};
angular.module('commonFiltersModule', [])
.filter('checkmark', pondMS.checkmark )
.filter('FaToEnNumberArray',pondMS.faToEnNumberArray )
.filter('EnToFaNumber', pondMS.enToFaNumber )
.filter('EnToFaButton', pondMS.enToFaButton )
.filter('jalaliDatePast', pondMS.jalaliDatePast )
.filter('jalaliDate', pondMS.jalaliDate )
.filter('jalaliDateJustDate', pondMS.jalaliDateJustDate )
.filter('slice', pondMS.slice )
.filter('splitString', pondMS.splitString)
.filter('showUndefined', pondMS.showUndefined)
    