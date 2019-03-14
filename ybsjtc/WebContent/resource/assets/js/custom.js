//图弹窗
jQuery(document).ready(function() {
	jQuery("a[class*=fancybox]").fancybox({
		'overlayOpacity'	:	0.7,
		'overlayColor'		:	'#000000',
		'transitionIn'		: '',
		'transitionOut'		: '',
		'easingIn'      	: 'easeOutBack',
		'easingOut'     	: 'easeInBack',
		'speedIn' 			: '700',
		'centerOnScroll'	: true,
		
	});
});
//图滚动
jQuery.noConflict();
jQuery(window).load(function(){
	var $featured_content = jQuery('.featured'),
		et_disable_toptier = jQuery("meta[name=et_disable_toptier]").attr('content'),
		et_cufon = jQuery("meta[name=et_cufon]").attr('content'),
		et_featured_slider_pause = jQuery("meta[name=et_featured_slider_pause]").attr('content'),
		et_featured_slider_auto = jQuery("meta[name=et_featured_slider_auto]").attr('content'),
		et_featured_auto_speed = jQuery("meta[name=et_featured_auto_speed]").attr('content');
				
	if ($featured_content.length) {
		var $featured_slides = $featured_content.find('.slide').show(),
			slides_pos = [],
			slides_zindex = [],
			active_slide_width = 500,
			small_slide_width = 250,
			slide_margin = 16,
			featured_animation = 'easeInOutQuad', //'easeInOutQuad','easeInOutQuint', 'easeInOutQuart'
			et_animation_running = false,
			last_slide = false,
			pause_scroll = false,
			top_slide_pos,
			left_slide_pos,
			slide_opacity;
		
		$featured_content.css( 'backgroundImage', 'none' );
		
		$featured_slides.each(function(index, domEle){
			var $this_slide = jQuery(domEle);
			
			top_slide_pos = 82;
			slide_opacity = 0.3;
			
			if ( index === 0 ) {
				top_slide_pos = 0;
				slide_opacity = 1;
				left_slide_pos = 230;
			}
			if ( index === 1 ) left_slide_pos = 620;
			if ( index === 2 ) left_slide_pos = 90;
			if ( index > 2 ) {
				if ( index % 2 === 1 ) left_slide_pos = slides_pos[index-2].left + small_slide_width + slide_margin;
				else left_slide_pos = slides_pos[index-2].left - small_slide_width - slide_margin;
			}
			
			if ( index !== 0 ) {
				$this_slide.find('img').attr({
					width: '250',
					height: '169'
				});
			}
							
			slides_pos[index] = {
				width: $this_slide.width(),
				top: top_slide_pos,
				left: left_slide_pos,
				opacity: slide_opacity
			};
			
			$this_slide.css('zIndex',$featured_slides.length-index);
			slides_zindex[index] = $this_slide.css('zIndex');
			
			$this_slide.animate(slides_pos[index],100,function(){
				// fixes the slide title display bug in Opera
				jQuery(this).css( 'width', 'auto' );
			});
			jQuery(domEle).data('slide_pos',index);
		});
		
		jQuery('a.nextslide').live('click',function(event){
			event.preventDefault();
			if (!et_animation_running) rotate_slide('next');
			if ( typeof(et_auto_animation) !== 'undefined' ) clearInterval(et_auto_animation);
		});
		
		jQuery('a.prevslide').live('click',function(event){
			event.preventDefault();
			if (!et_animation_running) rotate_slide('prev');
			if ( typeof(et_auto_animation) !== 'undefined' ) clearInterval(et_auto_animation);
		});
		
		$featured_slides.hover(function(){
			if ( !et_animation_running ) {
				if ( jQuery(this).hasClass('active') ){
					jQuery(this).find('.additional').stop(true, true).animate({'opacity':'show'},300);
				}
			}
			if ( et_featured_slider_pause == 1 ) pause_scroll = true;
		},function(){
			if ( !et_animation_running ) {
				jQuery(this).find('.additional').stop(true, true).animate({'opacity':'hide'},300);
			}
			if ( et_featured_slider_pause == 1 ) pause_scroll = false;
		});
		
		var et_mousex = 0,
			et_mousey = 0,
			featured_activeslide_x = $featured_content.find('.container').offset().left + 230,
			featured_activeslide_y = $featured_content.find('.container').offset().top;
		
		jQuery(document).mousemove(function(e){
			et_mousex = e.pageX;
			et_mousey = e.pageY;
		});
		 
		function rotate_slide(direction){
			$featured_slides.removeClass('active');
							
			$featured_slides.each(function(index, domEle){
				var $this_slide = jQuery(domEle),
					next_slide_num = $this_slide.data('slide_pos');
				
				et_animation_running = true;	
				last_slide = false;
				
				$featured_slides.find('.additional').css('display','none');
				
				if ( direction === 'next' ){
					if ( next_slide_num === 0 ) next_slide_num = 2;
					else if ( next_slide_num === 1 ) next_slide_num = 0;
					else if ( $featured_slides.length % 2 === 0 && next_slide_num === ( $featured_slides.length - 2 ) ) {
						next_slide_num = $featured_slides.length - 1;
					}
					else {
						if ( next_slide_num !== ($featured_slides.length - 1) ) {
							if ( next_slide_num % 2 === 0 )  next_slide_num = next_slide_num + 2;
							else next_slide_num = next_slide_num - 2;
						} else {
							if ( $featured_slides.length % 2 === 0 ) {
								if ( next_slide_num % 2 === 0 )  next_slide_num = next_slide_num + 2;
								else next_slide_num = next_slide_num - 2;
							}
							else { 
								next_slide_num = $featured_slides.length - 2;
								last_slide = true;
							}
						}
					}
				} else {
					if ( next_slide_num === 0 ) next_slide_num = 1;
					else if ( $featured_slides.length % 2 === 0 && next_slide_num === ( $featured_slides.length - 1 ) ) {
						next_slide_num = $featured_slides.length - 2;
					}
					else {
						if ( $featured_slides.length % 2 === 0 ) {
							if ( next_slide_num % 2 === 0 ) next_slide_num = next_slide_num - 2;
							else next_slide_num = next_slide_num + 2;
						} else {
							if ( next_slide_num !== ($featured_slides.length - 2) ) {
								if ( next_slide_num % 2 === 0 ) next_slide_num = next_slide_num - 2;
								else next_slide_num = next_slide_num + 2;
							} else {
								next_slide_num = $featured_slides.length-1;
								last_slide = true;
							}
						}
					}
				}
							
				if ( last_slide ) {
					$this_slide.css('left',slides_pos[next_slide_num].left);
				}
									
				$this_slide.stop(true, true).animate(slides_pos[next_slide_num],600,featured_animation,function(){
					if ( index === $featured_slides.length - 1 ) et_animation_running = false;
									
					if ( !et_animation_running ) {
						if ( et_mousex > featured_activeslide_x && et_mousex < (featured_activeslide_x + 500) && et_mousey > featured_activeslide_y && et_mousey < (featured_activeslide_y + 335) ){
							if ( next_slide_num === 0 ) $featured_content.find('.slide').filter(':eq('+($featured_slides.length - 1)+')').find('.additional').stop(true, true).animate({'opacity':'show'},300);
							else $featured_content.find('.active .additional').stop(true, true).animate({'opacity':'show'},300);
							
							if ( et_featured_slider_pause == 1 ) pause_scroll = true;
						}
					}
					
					// fixes the slide title display bug in Opera
					jQuery(this).css( 'width', 'auto' );
				});
				if ( next_slide_num != 0 ) {
					$this_slide.find('img').stop(true, true).animate({'width':'250px','height':'169px'},600,featured_animation);
				}
				else { 
					$this_slide.find('img').stop(true, true).animate({'width':'500px','height':'335px'},600,featured_animation,function(){
						$this_slide.addClass('active');
					});
				}
					
				setTimeout(function(){
					$this_slide.css({zIndex: slides_zindex[next_slide_num]});
				},300);
				
				$this_slide.data('slide_pos',next_slide_num);
			});
		}
		
		if ( et_featured_slider_auto == 1 ) {
			et_auto_animation = setInterval(function(){
				if ( !pause_scroll ) rotate_slide('next');
			}, et_featured_auto_speed);
		}
		
		if ( $featured_content.find('.slide').length == 1 ){
			$featured_content.find('.slide').css({'position':'absolute','top':'0','left':'0'}).show();
			jQuery('.featured a.prevslide, .featured a.nextslide').hide();
		}
	}
});


/*easing*/
jQuery.easing['jswing'] = jQuery.easing['swing'];

jQuery.extend( jQuery.easing,
{
	def: 'easeOutQuad',
	swing: function (x, t, b, c, d) {
		//alert(jQuery.easing.default);
		return jQuery.easing[jQuery.easing.def](x, t, b, c, d);
	},
	easeInQuad: function (x, t, b, c, d) {
		return c*(t/=d)*t + b;
	},
	easeOutQuad: function (x, t, b, c, d) {
		return -c *(t/=d)*(t-2) + b;
	},
	easeInOutQuad: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t + b;
		return -c/2 * ((--t)*(t-2) - 1) + b;
	},
	easeInCubic: function (x, t, b, c, d) {
		return c*(t/=d)*t*t + b;
	},
	easeOutCubic: function (x, t, b, c, d) {
		return c*((t=t/d-1)*t*t + 1) + b;
	},
	easeInOutCubic: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t + b;
		return c/2*((t-=2)*t*t + 2) + b;
	},
	easeInQuart: function (x, t, b, c, d) {
		return c*(t/=d)*t*t*t + b;
	},
	easeOutQuart: function (x, t, b, c, d) {
		return -c * ((t=t/d-1)*t*t*t - 1) + b;
	},
	easeInOutQuart: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t + b;
		return -c/2 * ((t-=2)*t*t*t - 2) + b;
	},
	easeInQuint: function (x, t, b, c, d) {
		return c*(t/=d)*t*t*t*t + b;
	},
	easeOutQuint: function (x, t, b, c, d) {
		return c*((t=t/d-1)*t*t*t*t + 1) + b;
	},
	easeInOutQuint: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t*t + b;
		return c/2*((t-=2)*t*t*t*t + 2) + b;
	},
	easeInSine: function (x, t, b, c, d) {
		return -c * Math.cos(t/d * (Math.PI/2)) + c + b;
	},
	easeOutSine: function (x, t, b, c, d) {
		return c * Math.sin(t/d * (Math.PI/2)) + b;
	},
	easeInOutSine: function (x, t, b, c, d) {
		return -c/2 * (Math.cos(Math.PI*t/d) - 1) + b;
	},
	easeInExpo: function (x, t, b, c, d) {
		return (t==0) ? b : c * Math.pow(2, 10 * (t/d - 1)) + b;
	},
	easeOutExpo: function (x, t, b, c, d) {
		return (t==d) ? b+c : c * (-Math.pow(2, -10 * t/d) + 1) + b;
	},
	easeInOutExpo: function (x, t, b, c, d) {
		if (t==0) return b;
		if (t==d) return b+c;
		if ((t/=d/2) < 1) return c/2 * Math.pow(2, 10 * (t - 1)) + b;
		return c/2 * (-Math.pow(2, -10 * --t) + 2) + b;
	},
	easeInCirc: function (x, t, b, c, d) {
		return -c * (Math.sqrt(1 - (t/=d)*t) - 1) + b;
	},
	easeOutCirc: function (x, t, b, c, d) {
		return c * Math.sqrt(1 - (t=t/d-1)*t) + b;
	},
	easeInOutCirc: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return -c/2 * (Math.sqrt(1 - t*t) - 1) + b;
		return c/2 * (Math.sqrt(1 - (t-=2)*t) + 1) + b;
	},
	easeInElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		return -(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
	},
	easeOutElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
	},
	easeInOutElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d/2)==2) return b+c;  if (!p) p=d*(.3*1.5);
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		if (t < 1) return -.5*(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
		return a*Math.pow(2,-10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )*.5 + c + b;
	},
	easeInBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158;
		return c*(t/=d)*t*((s+1)*t - s) + b;
	},
	easeOutBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158;
		return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
	},
	easeInOutBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158; 
		if ((t/=d/2) < 1) return c/2*(t*t*(((s*=(1.525))+1)*t - s)) + b;
		return c/2*((t-=2)*t*(((s*=(1.525))+1)*t + s) + 2) + b;
	},
	easeInBounce: function (x, t, b, c, d) {
		return c - jQuery.easing.easeOutBounce (x, d-t, 0, c, d) + b;
	},
	easeOutBounce: function (x, t, b, c, d) {
		if ((t/=d) < (1/2.75)) {
			return c*(7.5625*t*t) + b;
		} else if (t < (2/2.75)) {
			return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
		} else if (t < (2.5/2.75)) {
			return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
		} else {
			return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
		}
	},
	easeInOutBounce: function (x, t, b, c, d) {
		if (t < d/2) return jQuery.easing.easeInBounce (x, t*2, 0, c, d) * .5 + b;
		return jQuery.easing.easeOutBounce (x, t*2-d, 0, c, d) * .5 + c*.5 + b;
	}
});

