$(".answerbtn").on("click", function () {
	var queryString = $("#answer").serialize();
	
	$.ajax({
		type: "post",
		url: 'answer',
		data: queryString,
		dataType: 'json',
		error: function(request, status, error) {
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		},
		success: function(data) {
			document.location.reload();
		}
	});
})