$(".addBtn").on("click", function() {
	var addbtn = window.location.href;
	
	var adbtn = addbtn.split('/');
	
	addbtn = adbtn[4];
	
	location.href = "add?board="+addbtn;	
});