var SubList={
		"All":{"请先选中商品所属的<b>游戏厂商</b>":"#nogo"},
		"Snda":{"全部":"#nogo","龙之谷":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","超级跑跑2":"#nogo","超级跑跑3":"#nogo","超级跑跑4":"#nogo","其他商品":"#"},
		"Tencent":{"全部":"#nogo","龙之谷1":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"163":{"全部":"#nogo","龙之谷2":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"huge":{"全部":"#nogo","龙之谷3":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"jy":{"全部":"#nogo","龙之谷4":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"9c":{"全部":"#nogo","通灵5王":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"js":{"全部":"#nogo","通灵6王":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"wl":{"全部":"#nogo","通灵7王":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"sohu":{"全部":"#nogo","通8灵王":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"js":{"全部":"#nogo","通9灵王":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"prefect":{"全部":"#nogo","通11灵王":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"gy":{"全部":"#nogo","通12灵王":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"sj":{"全部":"#nogo","通13灵王":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"other":{"全部":"#nogo","通14灵王":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"},
		"sl":{"全部":"#nogo","通15灵王":"#nogo","龙之舞":"#nogo","传奇世界":"#nogo","热血传奇":"#nogo","超级跑跑":"#nogo","其他商品":"javascript:ShowSub();"}
		
	}
	
function ShowList(key, obj) {
	var Sb;
	if(typeof(getCompanySubList)=="function"){
		Sb = getCompanySubList(key);
	}    
    var sion = 1;
    var maxlength = getLength(Sb);
	var html = "";
    for (var i in Sb) {
        html += '<a href="#nogo" data="' + Sb[i] + '" onclick="onProductNameChange(this.getAttribute(\'data\'));" class="search_item">'+i+'</a>';
        sion++;
    }
    j("#shangping").html(html);
    j("#shangping>a:first-child").attr("class", "search_selected");
    var inner_html = j("#inner").html();
    j("#shangping>a:last-child").after(inner_html).attr("id", "Ginfo");
    var index = j("#shangping>a").length;
    if (index>1) j("#shangping>a:last").addClass("font_orange_normal");
	if (index==1) j("#shangping>a:last").attr("class","font_gray_normal_m7");
	onGameProducerChange(obj.getAttribute("data"));

}
function getLength(obj) {
    var i = 0;
    for (var e in obj) {
        i++;
    }
    return i;
}
	
j(document).ready(function(){
		j("#Cmenu a").each(function(){
			j(this).click(function(){
				j("#Cmenu a").each(function(){
					this.className="";
				});
				this.className="now";
				this.blur();
			});
		});
	});


function ShowSub() {
   // j("#Cform").show();
   // j("#Cform2").hide();
}


function ShowSub3() {
    j("#Cform2").show();
    j("#Cform").hide();
}

function SetGame(obj) {
    j("#Ginfo").text("其他商品（" + obj.innerHTML + "）");
	 HideSub();
}

/*/设置文本后，重新计算其宽度
*/
function SetCompany(obj) {
   j("#other_Company").text("其他厂商（" + obj.innerHTML + "）");
   HideSub();
   onOhterGameProducerChange(obj.getAttribute("data"));
}
function HideSub() {
    j("#Cform").hide();
    j("#Cform2").hide();
	j(".game_overlay").hide();
}

	
function ShowClass(id, span, divid, cmenu) {
    var uls = document.getElementById(divid).getElementsByTagName("UL"); //DepositList
    for (var i = 0; i < uls.length; i++) uls[i].style.display = 'none';
    document.getElementById(id).style.display = 'block';
    var spans = document.getElementById(cmenu).getElementsByTagName("a"); //DepositClass
    for (var i = 0; i < spans.length; i++) {
        if (typeof spans[i].onmouseover == 'function') {
            spans[i].className = ''
        }
    }
    span.className = "now";
	j(".game_overlay").height(j("#Cform").height()).show();
}

/*  调整按钮和弹出层的位置
	btn - jquery object
	layer - jquery object
*/

function fixPostion(layer,btn){
	if(!btn){
		btn=layer.parent().prev();
	}
	layer.css("margin-left",-btn.outerWidth());
	var referDiv=btn.parent();
	var offset=layer.width()-referDiv.width()+layer.offset().left-referDiv.offset().left;
	if(offset>0){
		layer.css("margin-left",-offset-btn.outerWidth());
	}
}
//绑定一个按钮和一个弹出层，根据按钮位置调整弹出层的位置
function bindBtnAndLayer(btn){

	var oShowing=null;//当前显示层
	btn.live("click",function(){
		var that=j(this);
		closeShownCform();
		oShowing=that.next(".Pform").children(".cform_box").show();
		
		fixPostion(oShowing);
		
		that.unbind("onTextChange").bind("onTextChange",function(e,s){
			fixPostion(oShowing);
			return this;
			
		});	
	j(".game_overlay").height(oShowing.height()).show();
	});

	btn.bind("onTextChange",function(){
		fixPostion(oShowing);
		return this;
	});	
	
	j(window).resize(function(){
		if(oShowing&&oShowing.filter(":visible").length)
		fixPostion(oShowing);
	});
};

//关闭所有的层
function closeShownCform(){
	j(".cform_box:visible").hide();
}
/*jQuery extend

	override jquery text function

	assign a callback function

	重写jquery text 方法，使用能触发onTextChange事件
***/
j.fn.__tmpFunc=j.fn.text;
j.fn.text=function(){

	var ret=this.__tmpFunc.apply(this,arguments);
	if(arguments[0]){
		this.trigger("onTextChange",arguments);
	}
	
	return ret;
	
};
//调用
bindBtnAndLayer(j("#other_Company,#Ginfo"));


//选择游戏厂商改变
function onGameProducerChange(id){
	alert(id);
	//to do
}
//选择其他游戏厂商
function onOhterGameProducerChange(id){
	alert(id);
	ShowList1(id);
}
//选择商品名称
function onProductNameChange(id){
	alert(id);
	//to do
}
//选择其它商品名称
function onOtherProductNameChange(id){
	alert(id);
	//to do
}
//在此配置汉字对应的键名
ConfigName={
/*	producer:"游戏厂商",
	channel:"销售渠道",
	source:"商品来源",
	time:"销售时间",
	name:"商品名称",
	type:"商品类型"*/
	"游戏厂商":"producer",
	"销售渠道":"channel",
	"商品来源":"source",
	//"销售时间":"time",
	"商品名称":"name",
	"商品类型":"type"
};
/*/
	获得查询参数(除开“关键字”和“销售时间”)

*/
function getSearchParameters(){
	var ret={};
	j(".advanced_search_sub:visible").each(function(){
		var title=j(this).children(".advanced_search_sub_title").text().replace(/[:：]/,"");
		var selectedTxt=j(this).children(".advanced_search_list").children(".search_selected").text();
		if(ConfigName[title])
		ret[ConfigName[title]]=selectedTxt;
	});
	return ret;
}
