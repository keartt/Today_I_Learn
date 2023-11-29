// Javascritp by Jquery
$(document).ready(function () {
  $(".toggleButton").click(function () {
    if($(this).hasClass('on')){
      console.log('OFF')
    }else{
      console.log('ON')
    }
    $(this).toggleClass("on off");
  })
});