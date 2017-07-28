
//兼容getByClassName
		function getByClass(obj,sClass)
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
		}	


		//show弹层
		 function showDiv(id)
		{	
			var doc=document;
			//获取遮罩层
			var oMask=getByClass(doc,'mask')[0];
			//获取弹层
			var obj=document.getElementById(id);
			//获取滚动条的高度
			var scrollTop=doc.documentElement.scrollTop||doc.body.scrollTop;
			//获取屏幕的宽高
			var clientWidth=doc.documentElement.clientWidth||doc.documentElement.clientWidth;
			var clientHeight=doc.documentElement.clientHeight||doc.documentElement.clientHeight;
			
			obj.style.display="block";
			var oWidth=obj.offsetWidth;
			var oHeight=obj.offsetHeight;
			obj.style.top=(clientHeight-oHeight)/2+scrollTop+'px';
			obj.style.left=(clientWidth-oWidth)/2+'px';
			oMask.style.height=clientHeight+scrollTop+'px';
			oMask.style.display="block";
			//关闭
			var close=getByClass(doc,'close_btn')[0];
			close.onclick=function(){
				hide(id);
			};
		}
		//关闭弹窗
		function hide(id)
		{
			var oMask=getByClass(document,'mask')[0];
			var obj=document.getElementById(id);
			
			obj.style.display="none";
			oMask.style.display="none";
		}




	




