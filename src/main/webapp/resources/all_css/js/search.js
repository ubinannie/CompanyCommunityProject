
$("#search").click(function(){
	var findType = 'findType=' +$("#select option:selected").val() + '&';	
	var word = 'word=' + $("#searchBox").val();
	var origin = '/fboard/search?';
	var q = origin + findType + word; 
	$(location).attr('href', q);
});


