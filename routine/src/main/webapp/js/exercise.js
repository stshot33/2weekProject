$(function () {
	
	var $sidebar   = $(".nav_bar"), 
        $window    = $(window),
        offset     = $sidebar.offset(),
        topPadding = 500;

    $window.scroll(function() {
    	
        if ($window.scrollTop() > offset.top) {
            $sidebar.stop().animate({
                marginTop: $window.scrollTop() - offset.top + topPadding
                
            });
        } else {
            $sidebar.stop().animate({
                marginTop: 50
            });
        }
        
    });
});

$(document).ready(function($) {

        $(".scroll_move").click(function(event){         

                event.preventDefault();

                $('html,body').animate({scrollTop:$(this.hash).offset().top}, 500);

        });

});