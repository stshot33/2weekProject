$(".subbtn").on("click", function () {
	var queryString = $("#calculator").serialize();
	
	$.ajax({
		type: "post",
		url: 'calorie',
		data: queryString,
		dataType: 'json',
		error: function(request, status, error) {
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		},
		success: function(data) {
			$(".total_kcal").text(data.calorie.m_calorie + "kcal");
			$(".tan_kcal").text(data.calorie.m_tan + "kcal");
			$(".tan_g").text((data.calorie.m_tan/4).toFixed() + "g");
			$(".dan_kcal").text(data.calorie.m_dan + "kcal");
			$(".dan_g").text((data.calorie.m_dan/4).toFixed() + "g");
			$(".zi_kcal").text(data.calorie.m_zi + "kcal");
			$(".zi_g").text((data.calorie.m_zi/9).toFixed() + "g");
		}
	});
})