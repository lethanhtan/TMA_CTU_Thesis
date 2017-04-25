/* Hide menu on scroll down, show on scroll up */
var prev = 0;
var $window = $(window);
var nav = $('.nav');

$window.on('scroll', function(){
  var scrollTop = $window.scrollTop();
  nav.toggleClass('hidden', scrollTop > prev);
  nav.addClass("show");
  prev = scrollTop;
});
/* End Hide menu on scroll down, show on scroll up */