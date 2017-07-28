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
	function ShowSub()
	{
		j("#Cform").show();
		j("#Cform2").hide();
	}
	function ShowSub2()
	{
		if (j("#Cform").css("display")!="block")
		{
			j("#Lv1").hide();
			j("#Lv2").hide();
			j("#Lv3").hide();
			j("#Cform2").hide();
			j("#Cform").show();
		}
		else
		{
			j("#Lv1").show();
			j("#Lv2").show();
			j("#Lv3").show();
			j("#Cform").hide();
		}
	}
	
	function ShowSub3()
	{
		j("#Cform2").show();
		j("#Cform").hide();
	}
	function ShowSub4()
	{
		if (j("#Cform2").css("display")!="block")
		{
			j("#Lv1").hide();
			j("#Lv2").hide();
			j("#Lv3").hide();
			j("#Cform").hide();
			j("#Cform2").show();
		}
		else
		{
			j("#Lv1").show();
			j("#Lv2").show();
			j("#Lv3").show();
			j("#Cform2").hide();
		}
	}
	
	function SetGame(obj)
	{
		j("#Ginfo").val(obj.innerHTML);
	}
	
	function HideSub()
	{
		j("#Lv1").show();
		j("#Lv2").show();
		j("#Lv3").show();
		j("#Cform").hide();
		j("#Cform2").hide();
	}
	
	
	
	
	function ShowClass(id, span) {
    var uls = document.getElementById('Div1').getElementsByTagName("UL");//DepositList
    for (var i = 0; i < uls.length; i++) uls[i].style.display = 'none';
        document.getElementById(id).style.display = 'block';
        var spans = document.getElementById('Cmenu').getElementsByTagName("a");//DepositClass
    for (var i = 0; i < spans.length; i++) {
        if (typeof spans[i].onmouseover == 'function') { spans[i].className = '' }
    }
    span.className = "now";
    
}

function ShowClass2(id, span) {
    var uls = document.getElementById('Div2').getElementsByTagName("UL");//DepositList
    for (var i = 0; i < uls.length; i++) uls[i].style.display = 'none';
        document.getElementById(id).style.display = 'block';
        var spans = document.getElementById('Cmenu2').getElementsByTagName("a");//DepositClass
    for (var i = 0; i < spans.length; i++) {
        if (typeof spans[i].onmouseover == 'function') { spans[i].className = '' }
    }
    span.className = "now"; 
}




	
	
	