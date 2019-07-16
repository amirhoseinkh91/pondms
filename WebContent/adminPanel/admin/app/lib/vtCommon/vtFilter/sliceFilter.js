var pondMS =  pondMS || {};
pondMS.slice =  function(){
  return function(arr, start, end)
         {
            return (arr)?arr.slice(start, end):null;
		 };
};