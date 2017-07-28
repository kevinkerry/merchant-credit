(function(win,doc,get){
	//getByClass
	var getByClass=function(obj,sClass)
	{
		if(obj.getElementsByClassName)
		{
			return obj.getElementsByClassName(sClass);
		}
		var result=[];
		var arr=obj.getElementsByTagName('*');
		var re=new RegExp('\\b'+sClass+'\\b');
		for(var i=0;i<arr.length;i++)
		{
			if(re.test(arr[i].className))
			{
				result.push(arr[i]);
			}
		}
		return result;
	};
	var tab=function(aBtn,aCon)
	{
		for(var i=0;i<aBtn.length;i++)
		{
			(function(index){
				aBtn[i].onclick=function()
				{
					for(var j=0;j<aBtn.length;j++)
					{
						aCon[j].style.display="none";
						aBtn[j].className="";
					}
					aCon[index].style.display="block";
					aBtn[index].className="active";
				};
			})(i)
		}
	};
	var aBtn=getByClass(document,"tab_btn")[0].getElementsByTagName('a');
	var aCon=getByClass(document,"tab_con")[0].getElementsByTagName('div');;
	tab(aBtn,aCon);


})(window,document,function(id){return document.getElementById(id);})