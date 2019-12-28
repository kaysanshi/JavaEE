// window.onload = function() {
// 	cartListController.setup();
// }

/*商品分类*/
$(function() {
    // // 这里直接进行对请求商品列表
    // $.ajax({
    //     url:'/product/categorydto/list',
    //     dataType:'json',
    //     type:'get',
    //     success:function (res) {
    //         $(".all-sort-list2").empty();
    //         for (var i = 0; i < res.length; i++) {
    //             $(".all-sort-list2").append(
    //                 '<div class="item">\n' +
    //                 '<h3>\n' +
    //                 '<a href="">' + res[i].name + '</a>\n' +
    //                 '</h3>\n' +
    //                 '<div class="item-list clearfix">\n' +
    //                 '<div class="subitem">\n' +
    //                 '<dl class="fore">\n' +
    //                 '<dt class="dt">\n' +
    //                 '</dt>\n'+
    //                 '<dd class="dd"></dd>'+
    //                 '</dl>\n' +
    //                 '</div>\n' +
    //                 '</div>\n' +
    //                 '</div>');
    //             if (res[i].children!= null) {
    //                 for (var j = 0; j < res[i].children.length; j++) {
    //                     console.log(res[i].children);
    //                     $(".fore .dt").append(
    //                         '<a href="">'+res[i].children[j].name+'</a>\n'
    //                     );
                        // if (res[i].children[j].children!=null){
                        //     for (var x=0;x<res[i].children[j].children.length;x++){
                        //         console.log(res[i].children[j].children[x].name)
                        //         $(".dd").append(
                        //             '<em>'+
                        //             '<a href="">'+res[i].children[j].children[x].name+'</a>\n' +
                        //             '</em>'
                        //         );
                        //
        //                 //     }
        //                 // }
        //             }
        //         }
        //     }
        // },
        // error:function(res) {
    //     //
    //     // }
    // });
	$('.all-sort-list2 > .item').hover(function() {
		//父类分类列表容器的高度

		$(this).addClass('hover');
		$(this).children('.item-list').css('display', 'block');
	}, function() {
		$(this).removeClass('hover');
		$(this).children('.item-list').css('display', 'none');
	});

	$('.item > .item-list > .close').click(function() {
		$(this).parent().parent().removeClass('hover');
		$(this).parent().hide();
	});
});