var rootPath = '';
		var j = jQuery.noConflict();
		jQuery.fx.off = true;


j(document).ready(function(){	
				   

//给客户加款－扣款:约定还款日期显示与隐藏
j(".no_arrange_date").click(function() {
			j(".arrange_date").hide();
		})

j(".yes_arrange_date").click(function() {
			j(".arrange_date").show();
		})

//表格中的排序箭头上下
	 j("._change_order").toggle(								
		function () {
		  j(this).addClass("icon_arrow_down");
		  //alert("dsa");
		},
		function () {
		  j(this).removeClass("icon_arrow_down");
		});


//输入表单变化
j(".change_text").each(function(){
	j(this).val(this.getAttribute('title'))				
});

j(".change_text").focus(function(){
	var tip_text=this.getAttribute("title");
	 if(this.value==tip_text){
		j(this).removeClass("freetext_big").addClass("freetext_big_out").val("");					 
	 }
	 else{
		j(this).removeClass("freetext_big").addClass("freetext_big_out"); 
	 }
});


j(".change_text").blur(function(){
	var tip_text=this.getAttribute("title");
	 if(this.value==tip_text||this.value==""){
		j(this).removeClass("freetext_big_out").addClass("freetext_big").val(tip_text);					 
	 }
	 else{
		j(this).removeClass("freetext_big").addClass("freetext_big_out"); 
	 }
})


//图标的提示信息
j("._img_tip").mouseover(function(){
	j(this).parent().css("position","relative")
	var tip_text=this.getAttribute("title");
	var tip_box="<div>"+tip_text+"</div>";
	j(this).after(tip_box);
});

j(".toggle_tip").focus(function(){
	if(/toggle_tip/.test(this.className))j(this).removeClass("toggle_tip").val("");
}).blur(function(){
	if(!this.value)j(this).addClass("toggle_tip").val(this.title);
}).each(function(){
	if(this.value!=this.title&&/toggle_tip/.test(this.className)){this.className=this.className.replace(/\s?toggle_tip\s?/,"")}
});
						   
						   
						   
//提示信息
	j(".apply_now").each(function(){			
				j(this).mouseover(function(){
					j(".apply_now").each(function(){
						j(this).next().hide();				
						
					});				   
						j(this).next().css("display","inline");
				});
				j(this).mouseout(function(){
					j(".apply_now").each(function(){
						j(this).next().hide();		
						
					});			   
						
				});
				
			})
	
	//直接购买库存表格中的提示信息
	j(".sc_comments_tips").each(function(){			
				j(this).mouseover(function(){
					j(".sc_comments_tips").each(function(){
						j(this).parent().next().hide();				
						
					});				   
						j(this).parent().next().css("display","block");
				});
				j(this).mouseout(function(){
					j(".sc_comments_tips").each(function(){
						j(this).parent().next().hide();		
						
					});			   
						
				});
				
			})
	
	
	j(".bubble_container").each(function(){	
					j(this).mouseover(function(){
						j(this).css("display","inline");						   
					 })	;
					j(this).mouseout(function(){
						j(this).hide();				  
					});
										 
			})	
	
	//设置父集节点Li 的class，通过不同的class控制子节点的显示与隐藏
		j("#mlist h2").each(function(){
					j(this).click(function(){
						if (this.parentNode.className=="panel_min"){
							this.parentNode.className="panel_add";
						}
						else{
								this.parentNode.className="panel_min";
						}
					});
				});
		
		
		//设置里面的子节点class控制
		j("#mlist a").each(function(){			
			j(this).click(function(){
				j("#mlist a").each(function(){
					j(this).removeClass();
				});								
				j(this).addClass("now");
				j(this).blur();
			})
			
			j(this).mouseover(function(){				
				
					if(this.className=="now"){
						this.className="now"
					}
					else{
						this.className="out"
					}					
				
			})
			
			j(this).mouseout(function(){				
				
					if(this.className=="now"){
						this.className="now"
					}
					else{
						this.className=""
					}					
				
			})
				
			
		});
		
		//头部tab显示与隐藏
		var jtab_li = j(".page_header_nav li");
        jtab_li.click(function() {
            j(this).removeClass("page_header_nav_out").addClass("page_header_nav_select") 
            .siblings().removeClass("page_header_nav_select").addClass("page_header_nav_out");
                    
        })
		
		
		j(".section_sub_table :checkbox").attr("checked",false);
		j(".section_sub_table :checkbox").click(function(){
					//alert("fdedf")
					if(j(this).is(":checked")){
					j(this).parent().parent().find(":text").attr({'disabled':false,'class':'freetext_small'});
					}
					else{
					j(this).parent().parent().find(":text").attr({'disabled':true,'class':'freetext_small_out'});	
					}
		});
		
		
		//供货规则-选择模板
		//j(".rule_box>div").hide();
		//j(".rule_box>div").first().show();
		j("#select_moulding").change(function(){
			var index=j("#select_moulding option:selected").index();
			for(var i=0; i<index;i++){
				j(".rule_box>div").eq(i).show().siblings().hide();			
			}							 
		});
		
		//全部区域
		j("#part_region_box").hide();
		j("#all_region").click(function() {
			j("#part_region_box").hide();
		})
		//部分区域
		j("#part_region").click(function() {
			j("#part_region_box").show();
		})
		
		//添加供货区域
		j(".add_part").click(function() {
			var province_html="<div><select class='select_small'><option>省份或直辖市</option><option>省份一</option><option>省份二</option></select>";
			var city_html=" <select class='select_small'><option>城市</option><option>城市二</option></select>";
			var del_html=" <a href='#nogo' class='blue_link del_part'>删除供货区域</a></div>";
			var html=province_html+city_html+del_html;			
			j(this).parent().after(html);
			
		})	


		//删除供货区域
		j(".del_part").click(function() {	
			j(this).parent().remove("div");
		})
		
		//供货区域-选择模板
		j("#select_part_region_box>div").hide();
		j("#select_part_region_box>div").first().show()	
		j("#select_part_region").change(function(){
			var index=j("#select_part_region option:selected").index();
			for(var i=0; i<index;i++){
				j("#select_part_region_box>div").eq(i).show().siblings().hide();			
			}							 
		});
		
		
		//修改密码
		j(".edit_password").click(function() {
				j(".edit_password").each(function(){
					j(this).next().children(".edit_password_layout").hide();
					j(this).attr('readonly',true).addClass("freetext_mini_out2").removeClass("freetext_mini_click2");
				});							   
				j(this).next().children(".edit_password_layout").show();
				j(this).attr('readonly',false).removeClass("freetext_mini_out2").addClass("freetext_mini_click2");	
				j(".edit_quotation_tip").hide();
			})
		j(".close_edit_password").click(function() {
			j(this).parent().parent().hide();
			j(this).parent().parent().parent().prev().addClass("freetext_mini_out2").removeClass("freetext_mini_click2");
        })
		
		
		//类型选择
		j("#select_password,#select_direct").click(function() {	
			j("#manpower").hide();
		})
		
		j("#select_manpower").click(function() {	
			j("#manpower").show();
		})
		
		
		//弹出选择框
		//j(".popup_overlay").css("opacity","0.7");
		j(".open_popup").click(function() {
			//j("#popup_window").css("display","block");
			j("#popup_window").popup();
        })	
		
	 //关闭选择框
	  j(".close").live('click',function() {
			j("#popup_window").css("display","none");
			j(".poput_content,.popup_tip").show();
			j(".poput_content2,.poput_content2>.table_info").hide();			
        })
	
      //确定选择款
	  j("._commit").live('click',function() {
			j("#popup_window").css("display","none");
			j(".poput_content,.popup_tip").show();
			j(".poput_content2,.poput_content2>.table_info").hide();			
        })
	  
	   j(".sure").click(function() {
			j("#tip_suc").html("官方直冲账号添加成功！");	
			
        })
	  
	  
	  //添加直冲账号
	   j(".add_direct").click(function() {
			j(".poput_content,.popup_tip").hide();
			j(".poput_content2,.poput_content2>.table_info").show();
        })
	   
	   j(".back_direct").click(function() {
			j(".poput_content,.popup_tip").show();
			j(".poput_content2,.poput_content2>.table_info").hide();			
        })
	  
	
	//选取当前行
	j("#change_business tbody tr").click(function() {
			j("#change_business tbody tr").each(function(){
						j(this).removeClass("tr_style_select");
						j(this).children().last().empty();
						j(this).children().last().append("<img src='common/img/touming.png' width='1' height='1' />");
				});
			j(this).addClass("tr_style_select");
			j(this).children().last().append("<div class='icon_suc'></div>");			
        }).filter(":odd").addClass("tr_style_odd");
	
	j("#change_business tbody tr").hover(function(){			
			j(this).addClass("tr_style_select2");
										  
	 },function(){	
	 
		 j(this).removeClass("tr_style_select2");		
	 });
	
	
	j(".select_tr tbody tr").click(function() {
				j(".select_tr tbody tr").each(function(){
						j(this).removeClass("tr_style_select");
						j(this).children().last().empty();
						j(this).children().last().append("<img src='common/img/touming.png' width='1' height='1' />");
				});					  
			j(this).addClass("tr_style_select");					  
			j(this).children().last().append("<div class='icon_suc'></div>");
        }).filter(":odd").addClass("tr_style_odd");
	
	j(".select_tr tbody tr").hover(function(){			
			j(this).addClass("tr_style_select2");
										  
	 },function(){	
	 
		 j(this).removeClass("tr_style_select2");		
	 });
	
	//直冲账号管理-通过双击选取账号
	j(".select_user tbody tr").dblclick(function() {
				j(".select_user tbody tr").each(function(){
						j(this).removeClass("tr_style_select");
						j(this).children().last().empty();
						j(this).children().last().append("<img src='common/img/touming.png' width='1' height='1' />");
				});					  
				j(this).addClass("tr_style_select");									 
				if(j(this).children().last().text()!="优先使用"){
					j(this).children().last().append("优先使用");			  				  
					
					//j(this).children().last().append("<img src='common/img/touming.png' width='1' height='1' />");
				}
				else{								  
					j(this).children().last().empty();
					alert("21")
				}
			
        })
	
	//切换主次供货商
	
	j(".changeSupplier").click(function() {
		var Supplier_body=document.getElementById("Supplier_body").childNodes;
		var first=Supplier_body[0].getAttribute("id");
		if(first=="tr01"){
			j("#tr02").insertBefore("#tr01");	
		}
		else{
			j("#tr01").insertBefore("#tr02");	
		}			
        })
	
	//断开供货商
	j(".disconnect").click(function() {
			j(this).parent().find(".open_supplier01,.open_supplier02").text("新增");
			j(this).parent().find(".pause").removeClass("blue_link").addClass("font_gray_margin");
			j(this).attr("class","font_gray_margin");
			j(this).parent().parent().children().slice(0,3).text("");
        })
	
	//暂停供货商	
	j(".pause").click(function() {
			var text=j(this).text();
			if(text=="暂停"){
			j(this).text("恢复").removeClass("blue_link").addClass("font_gray_margin");
			}
			else{
			j(this).text("暂停").removeClass("font_gray_margin").addClass("blue_link");
			}
        })
	
	//弹出选择供货商
	j(".open_supplier01").click(function() {
			j("#popup_window").css("display","block");
			j(".sure01").show();
			j(".sure02").hide();
        })
	
	j(".open_supplier02").click(function() {
			j("#popup_window").css("display","block");	
			j(".sure02").show();
			j(".sure01").hide();
        })
	
	//确定并关闭窗口
	j(".sure01").click(function() {
			j("#popup_window").css("display","none");
			j("#tr01").children().eq(0).text("供货商1");
			j("#tr01").children().eq(1).text("42元");
			j("#tr01").children().eq(2).text("库存充足");
			j("#tr01").children().eq(3).find(".font_gray_margin").attr("class","blue_link");
			j("#tr01").children().eq(3).find(".open_supplier01").text("更换");
			j(".poput_content,.popup_tip").show();
			j(".poput_content2,.poput_content2>.table_info").hide();	
			
        })
	
	j(".sure02").click(function() {
			j("#popup_window").css("display","none");
			j("#tr02").children().eq(0).text("供货商2");
			j("#tr02").children().eq(1).text("42元");
			j("#tr02").children().eq(2).text("库存不足");
			j("#tr02").children().eq(3).find(".font_gray_margin").attr("class","blue_link");
			j("#tr02").children().eq(3).find(".open_supplier02").text("更换");
			j(".poput_content,.popup_tip").show();
			j(".poput_content2,.poput_content2>.table_info").hide();	
        })
	
/*---商城－商品管理---*/
	//修改商品价格
	j(".edit_quotation").click(function() {
		j(".edit_quotation").each(function(){
			j(this).next(".quotation_value").hide();								   
			j(this).siblings().children(".edit_quotation_layout").hide();	
			j(this).show();
		});
			j(this).hide();
			j(this).next(".quotation_value").show();
			var text=j(this).text();
			var text_p=parseInt(text);
			var text_val=j(this).next(".quotation_value").children(".freetext_mini_click").val();
			if(text=="定价"){
				text_val="";
			}
			else{
				text_val=text_p;
			}
			j(this).siblings().children(".edit_quotation_layout").show();
			
        })
	
	
	j(".close_edit_quotation").click(function() {
			j(this).parent().parent().hide();
			var quotation_val=j(this).parent().parent().parent().prev().children(".freetext_mini_click").val();
			var text=j(this).parent().parent().parent().prev().prev().show().text();
			var text_val=parseInt(text);
			if(text=="定价"){
				j(this).parent().parent().parent().prev().children(".freetext_mini_click").val("")
				}
			else{
			j(this).parent().parent().parent().prev().children(".freetext_mini_click").val(text_val);
			}
			j(this).parent().parent().parent().prev().hide().prev().show();
        })
	
	j(".save_quotation").click(function() {
		
			var quotation_val=j(this).parent().parent().parent().prev().children(".freetext_mini_click").val();
			if(quotation_val==""){
				alert("输入错误，请重新输入");
				return false;
			}
			j(this).parent().parent().hide();
			j(this).parent().parent().parent().prev().hide();
			j(this).parent().parent().parent().prev().prev().show().text(quotation_val+"元");
			j(this).parent().parent().parent().parent().parent().find(".notsale").hide();
			j(this).parent().parent().parent().parent().parent().find(".sale").show();
			j(this).parent().parent().parent().parent().find(".edit_quotation").addClass("blue_link").removeClass("orange_link");
			
        })
	
	
	j(".notsale").click(function() {
		j(".edit_quotation").each(function(){
			j(this).parent().parent().find(".edit_quotation").show();
			j(this).parent().parent().find(".quotation_value,.edit_quotation_layout").hide();
		});
			j(this).parent().parent().find(".edit_quotation").hide();
			j(this).parent().parent().find(".quotation_value,.edit_quotation_layout").show();
        })
	
	
	j(".click_look").click(function() {		
		j(this).text("45.3");		
        })
	
	j(".sale").click(function() {
		var text=j(this).text();
		if(text=="正在销售"){
			j(this).addClass("font_red_normal");
			text="暂停销售";
		}
		else if(text=="暂停销售"){
			j(this).removeClass("font_red_normal");
			text="正在销售";
		}
		j(this).text(text);
     })
	
	//j(".close_quotation_tip").click(function() {
//			j(".edit_quotation_tip").hide();
//        })
	
	//商城最低价格地提示信息
	j(".qa_tip").hover(function () {
		j(".qa_tip_layout,.qa_tip_layout_small,.pop_tip_203").show();
	  },
	  function () {
		j(".qa_tip_layout,.qa_tip_layout_small,.pop_tip_203").hide();
	  });
	
	//复选按钮选择当行
//	j(".check_tr").click(function() {
//			if(j(this).is(":checked")){
//				j(this).parent().parent().parent().attr("class","tr_style_select2")
//			}		
//        })
//	
/*---商城－批量设置---*/

	/* 	=================================================数据查询 start=================================================*/
	
	//添加当前选择样式
	
	j(".advanced_search_list>a").live('click', function() {
  		j(this).addClass("search_selected").siblings().removeClass("search_selected").addClass("search_item");
		});
	
	
	//高级搜索和基本搜索的切换
	 j("._btn_search_more").toggle(								
		function () {
		  j(this).text("基本查询").addClass("advanced_search_btn_more");
		  j(".search_more").show();
		},
		function () {
		  j(this).text("更多选项").removeClass("advanced_search_btn_more");
		  j(".search_more").hide();
		});


		//卡密和直冲切换
		j("._select_password").live('click', function() {
			j("._password_table").show();
			j("._password_type").show();
			j("._direct_type").hide();
			j("._direct_table").hide();
		});
		
		j("._select_direct").live('click', function() {
			j("._password_table").hide();
			j("._direct_table").show();
			j("._password_type").hide();
			j("._direct_type").show();
		});
		
		//
		j("._show_cgxx").toggle(	
		function () {
		var text=j(this).attr("title");
		  j(this).text(text);
		  j("._cgxx").show();
		},
		function () {
		var show_text=j(this).attr("show_title");
		  j(this).text(show_text);
		  j("._cgxx").hide();
		});
		
	/* 	=================================================数据查询 end=================================================*/
	
	
	
	/* 	=================================================

		按面值的%生成B2B销售价格 
	
	*/
	j(".val_true").hide();//可以不要这个
	//记录其原始值
	j(".val_show").each(function(){
		this.setAttribute("oriVal",this.innerHTML.replace(/(\d+\.?\d+)元/,"$1"));
	});

	//批量设置B2B销售价格
	function batSet(percent){
		if(typeof(percent)=="undefined"){
			percent=execVal;
		}
		j(".val_show").each(function(){
			this.innerHTML=(parseFloat(this.getAttribute("oriVal"))*percent/100).toFixed(2).replace(/\.?0+$/,"")+"元";//只保留小数点后两位，末位为0的去掉0
		});
	}
	//延迟设置的函数
	function intervalSet(){
		if(execVal==""){
			batSet(100);
		}
		else if(!isNaN(execVal)){
			batSet(execVal);
		}
	}
	
	var oTimer=null,execVal=100;//执行时的值
	j(".change_quotation").blur(function(){
		execVal=this.value;
		intervalSet();
	}).keyup(function(){
		execVal=this.value;
		oTimer=setTimeout(intervalSet,500);
	}).keydown(function(){
		if(oTimer){
			clearTimeout(oTimer);
			oTimer=null;
		}
	}).focus(function(){this.select();}).val("");
	
	/* 	
		按面值的%生成B2B销售价格 
	
	---------------------------------------------------------------------*/
		
	
	
	j(".cl_true").hide();
	j(".ff_no").click(function() {
		var uls = j('#table_date tbody tr');
		for (var i=0; i<uls.length; i++){	
			var text=j(uls[i]).find(".cl_true").text();
			j(uls[i]).find(".cl_show").text(text);;
		}				   
		
	})
	
	j(".ff_01").click(function() {										   
							   
		j("#table_date tr td:nth-child(8)").find(".cl_show").text("策略一");				
	})
	
	j(".ff_02").click(function() {
		 j("#table_date tr td:nth-child(8)").find(".cl_show").text("策略二");			
	})
	
	//var uls = $('.change table_date tr');
//	for (var j=0; j<uls.length; j++) {
//		$(uls[j]).children('td:first').text("3");
//	}

	

/*---商城END---*/
	
	//显示商品简介信息
	j(".show_introduction_box").hover(function() {
				j(".show_introduction_box").each(function(){
						j(this).next().children(".introduction_layout").hide();
				});	
				j(this).next().children(".introduction_layout").show();
				j(this).next().children(".introduction_overlay").show();
				j(this).next().children(".introduction_overlay").height(j(this).next().children(".introduction_layout").height());
        },
	  function () {
		j(this).next().children(".introduction_layout").hide();
		j(this).next().children(".introduction_overlay").hide();
	  });
	
	function next_show(before,childrenbox){
			j(before).hover(function() {
				j(before).each(function(){
						j(this).next().children(childrenbox).hide();
				});	
				j(this).next().children(childrenbox).show();
        },
	  function () {
		j(this).next().children(childrenbox).hide();
	  });	
	}
	
	next_show(".show_remark_box",".remark_layout");
	
	
	 j("#table_date tbody tr").hover(function() {
        j(this).addClass("tr_style_over");
    }, function() {
        j(this).removeClass("tr_style_over");
    }).filter(":odd").addClass("tr_style_odd");
	 
	 j(".table_date tbody tr").hover(function() {
        j(this).addClass("tr_style_over");
    }, function() {
        j(this).removeClass("tr_style_over");
    });

	 j(".table_date tbody").each(function(){
		j(this).children("tr:odd").addClass("tr_style_odd");
	 });

//tab显示与隐藏	

       j(".tab li").click(function() {
			j(this).removeClass("tab_item").addClass("tab_select") 
			.siblings().removeClass("tab_select").addClass("tab_item"); 
			var index = j(".tab li").index(this);
			j(".tab_box > div:eq("+index+"),.tab_box_head>div:eq("+index+")")
				.addClass("tab_box_select").removeClass("tab_box_item")
			.siblings().addClass("tab_box_item").removeClass("tab_box_select"); 
		})
		
		
/*========================== 网吧平台 start========================== */	

 j(".del_setting").click(function() {
            j(this).parent().parent().parent().find(".setting").val("");
        })

j(".delall_setting").click(function() {
            j(":text[name=setting]").val("");
        })

 j(".del_quotation").click(function() {
            j(this).parent().parent().parent().find(".password_quotation").val("");
        })

j(".delall_quotation").click(function() {
            j(":text[name=password_quotation]").val("");
        });


//上下级关系定义-区域方式-选择撤销的经销商


j("._select_cancel_clientele").click(function() {
           //j("#popup_window").css("display","none"); 
		   j("#popup_window").popup();
		   j("#card_goods_list").hide();
			j("#card_client_list").show().children(".popup_content,.popup_tip").show().end().children(".view_detail_content").hide().end();	
		   j("#btn_sure").hide();
		   j("._cancel_clientele_add").show();
        })

j("._cancel_clientele_add").click(function() {
										   
		var selectItem=j(".tr_style_selected td:eq(2)").text();
		j("._select_cancel_clientele").prev().val(selectItem);
           j("#popup_window").hide();
        })

j("._select_cancel_clientele").prev().bind("onValueChange",function(){
	var val=arguments[1];
	//alert("值改变为："+val);
	j("._cancel_clientele_tip").hide();
	j("._cancel_clientele").show();
});

/*========================== 网吧平台 end========================== */	



		j(".select_from_clients").live('click',function(){
			j("#popup_window").popup();
			j("#card_goods_list").hide();
			j("#card_client_list").show().children(".popup_content,.popup_tip").show().end().children(".view_detail_content").hide().end();		
			j("#btn_sure").show();
		   j("._cancel_clientele_add").hide();
			return false;
		});

		j(".select_from_goods").live('click',function(){
			j("#popup_window").popup();
			j("#card_client_list").hide();
			j("#card_goods_list").show().children(".popup_content,.popup_tip").show().end().children(".view_detail_content").hide().end();
			return false;
		});
		
		var toggled=null;//记录上次伸缩的对象 

		//虚拟卡密库存转账 查看客户/商户详情
		
		j(".view_client_detail").click(function(){
			
			toggled=j("#card_client_list .popup_content,#card_client_list .popup_tip").toggle();
			return false;
		});

		j(".view_goods_detail").click(function(){
			toggled=j("#card_goods_list .popup_content,#card_goods_list .popup_tip").toggle();
			return false;
		});
		
		//返回按钮 
		j(".back_2_list").click(function(){
			if(toggled)toggled.toggle();
			toggled=null;
		});
		//-----------------------------------------------------------------------------
		//B2B 采购申请审核 同意按钮触发
	 j(".open_popup_b2b").click(function(){
		var t=j(this).parent(),
		buyer=t.siblings(".b2b_buyer").text(),//获得采购商
		price=t.siblings(".b2b_price").text();//获得价格
		
		var popup=j("#popup_window");
		popup.find(".b2b_buyer").text(buyer);
		popup.find(".b2b_price").text(price);
		popup.find("input:text").val("");//重置输入框
		popup.popup();
	 });


	 //查看详情－－模拟数据 返回值为json
	 function getInfoDetail(infoId){
		return {title:'大量供应特价QB',date:'2010-10-11',content:'支付宝网站停机维护信息通知<br>为满足业务高速发展的需要，运营服务中心计划在2010年2月1日12:22至7月12日12:12进行网站停机维护，届时支付宝全站将停止对外开放，暂停所有服务，请知晓。如有疑问请立即联系技术部服务台，谢谢。<br><br>请相互转告，谢谢合作！'};
	 }

	
	 //供求信息－－－－查看详情
	 j(".open_popup_info").click(function(){
		
		var infoId=j(this).parent().parent().prev().text();
		
		
		var popup=j("#popup_window");
		var infoBox=popup.find(".info_detail"),
			titleBox=infoBox.find("h3"),
			dateBox=infoBox.find(".info_date"),
			contentBox=infoBox.find("div");

		var data=getInfoDetail(infoId);
		titleBox.html(data.title);
		dateBox.html(data.date);
		contentBox.html(data.content);

		popup.popup();
		return false;
	 });



	 //查看信息 供求信息详情
	 j(".open_view_info").click(function(){

		var popup=j("#popup_window");

		popup.popup();;
		
		return false;
	 });

	 //密价设置 判断是否修改过密价，提示保存密价
	var price_changed=0, oriVal;
	j(".price_set").focus(function(){
		oriVal=this.value;
	}).blur(function(){
		if(this.value!=oriVal){
			price_changed=1;
		}
	});

	j(".pagenumber a").click(function(){
		if(price_changed&&confirm("当前页密价已经修改，你确定要保存当前页的修改吗？")){
			//在此保存密价
		}
	});

	//供求信息发布成功
	j(".submit_b2b_info").click(function(){
		alert("恭喜你，新信息已经发布成功。");
	});

	//========================================================================
	//弹出层中供选择的列表
	j(".dialog_select_table>tbody>tr").live('click',function(){
		j(this).siblings("tr.tr_style_selected").removeClass("tr_style_selected").end().addClass("tr_style_selected");
	});

	/*===============================================
		购买限制－－数量限制
	*/

	//缓存变量
	var jUpdateBox=j('#update_box'),currentText=null;
	jUpdateBox.content=jUpdateBox.children(".edit_quotation_layout");
	jUpdateBox.appear=function(){
		return this.content.show().end();
	};
	jUpdateBox.disappear=function(){
		return this.content.hide().end().appendTo("body");
	};

	
	j(".save_update").live("click",update_save);

	j(".close_update").live("click",update_quit);

	//保存修改的值
	function update_save(){
		jUpdateBox.disappear();
		currentText.parent().html(currentText.val());
		currentText=null;
	}

	//td恢复成上次的值
	function update_quit(){
		jUpdateBox.disappear();
		currentText.parent().html(currentText.parent().attr("prevval"));
		currentText=null;
	}	

	
	

	j(".btn_click_update").click(function(){
		if(currentText){
			if(currentText.val()!=currentText.parent().attr("prevval")&&confirm("数量限制已经修改，是否保存？")){
				update_save();
			}else{
				update_quit();
			}
		
		}
		var td=j(this).parent().siblings(".click_update");
		var val=td.text();
		var txt=j('<input type="text" size="4" maxlength="8" />');

		td.attr("prevval",val).empty().append(txt).append("<br/>").append(jUpdateBox.appear());
		jUpdateBox.content.css("margin-left",0);
		jUpdateBox.content.css({
			"margin-left":txt.offset().left-jUpdateBox.content.offset().left
		})
		txt.val(val).focus().select().keyup(function(e){
			if(e.keyCode==13){
				update_save();
			}else{
				
				//this.value=this.value.replace(/[\D]/g,"");
			}

			
		}).inputNumber();

		currentText=txt;
	});
	
	//售卡给用户－－进货价伸缩
	j(".show_stock_price").click(function(){
		if(this.checked){
			j(".col_toggle").css("display","");
		}else{
			j(".col_toggle").css("display","none");
		}
	});

	//b2b对接关系
	j(".toggle_switch").click(function(){
		
		this.innerHTML=(j.trim(this.innerHTML)=="暂停")?"启用":"暂停";
		
	});

	//导卡/销售记录 显示备注

	j(".show_remark").hover(function(){
		j(this).siblings(".bubble_edit_quotation").children().show();
	},function(){
		j(this).siblings(".bubble_edit_quotation").children().hide();
	});

	

	
	
	/*/===============
	
	上级转入库存列表
	===========================*/
	//先发上级/自己库存
	j(".btn_set_priority").click(function(){
		if(this.innerHTML=="先发上级库存"){
			j(this).addClass("font_red_normal");
			this.innerHTML="先发自己库存";
		}else{
			j(this).removeClass("font_red_normal");
			this.innerHTML="先发上级库存";
		}	
	});

	//修正popup的问题
	j(".popup").appendTo("body");


	j("._btn_show_key_card").click(function(){
		j(".popup").popup();
		return false;
	});

	j("#chooseType").click(function(e){
		var tar=e.srcElement||e.target;
		if(tar.tagName=="INPUT"&&tar.type=="radio"){
			if(/\b_show_key\b/.test(tar.className)){
				j("#chooseType").next("tr").show();
			}else{
				j("#chooseType").next("tr").hide();
			}
		}
		
	}).next("tr").show().end().find("._show_key").attr("checked",true);

	
});
//====================document ready end============<<



//====================客服事件 start============<<
function serviceLeftAutoHeight(){
	var R_height=j(".service_body_content").height();
	var L_height=j(".service_left").height();
	if(L_height<R_height){
		j(".service_left").height(R_height);
	}
}
serviceLeftAutoHeight()

j(".panel_small li").click(function(){
				j(".panel_small li").each(function(){
				j(this).removeClass();
})
				j(this).addClass("selected")
});
j("._up_file").click(function(){
	j("#popup_window").popup();	
	j("#up_file_box").show();
	j("#application_box").hide();
})
j("._application").click(function(){
	j("#popup_window").popup();	
	j("#up_file_box").hide();
	j("#application_box").show();
})

j("._up_submit").click(function(){
	j("#popup_window").css("display","none");
	j(".file_show_name").show();
	j(".up_file_text").hide();
})

j("._del_file").click(function(){
	j(".file_show_name").hide();
	j(".up_file_text").show();
})


j("._no_tuikuan").click(function(){
	j("#tuikuan_con").hide();
})
j("._yes_tuikuan").click(function(){
	j("#tuikuan_con").show();
})

j("._yes_tuikuan").click(function(){
	j("#tuikuan_con").show();
})

//人工充值订单

j("._manpower_sure").click(function(){
	j("._manpower_suc").show();
	j("._manpower_cancel").show();
	j(this).hide();
})

j("._manpower_suc").click(function(){
	j("#popup_window").popup();	
	j("#manpower_suc_box,._manpower_suc_content").show();
	j("._manpower_suc__tip,#manpower_cancel_box,._manpower_cancel_content,._manpower_cancel_tip").hide();
})

j("._manpower_suc_sure").click(function(){
	j("._manpower_suc_content").hide();
	j("._manpower_suc__tip").show();
})

j("._manpower_cancel").click(function(){
	j("#popup_window").popup();	
	j("#manpower_cancel_box,._manpower_cancel_content").show();
	j("#manpower_suc_box,._manpower_cancel_tip,._manpower_suc_content,._manpower_suc__tip").hide();
})

j("._manpower_cancel_sure").click(function(){
	j("._manpower_cancel_content").hide();
	j("._manpower_cancel_tip").show();
})

//====================客服事件 end============<<


/*============================================================ >>

	全局的ＪＳ公共调用的方法

--------------------------------------------------------------*/


//通过keyCode判断当前输入的字符类型
function getKeyType(e){
	if(!e)e=this;//this refer to event
	if(e.ctrlKey){return 0;}
	var keyCode=e.keyCode;
	if (keyCode>=65&&keyCode<=90){return 1;};//返回值为1，输入为字母
	if (keyCode>=96&&keyCode<=105){return 2;};//返回值为2，输入为数字
	if (keyCode>=48&&keyCode<=57&&!e.shiftKey){return 2;};//返回值为2，输入为数字
	if (keyCode>=48&&keyCode<=57&&e.shiftKey){return 3;};//返回值为3，输入为其它符号
	var otherCodes=[192,189,187,219,221,220,186,222,191,190,188,111,106,109,107,110];
	for(var k in otherCodes){
		if(keyCode==otherCodes[k]){return 3;}//返回值为3，输入为其它符号
	}
	return 0;//不是符号
}


function getPos(elem){
	if(elem.selectionStart){
		return elem.selectionStart;
	}
	if(document.selection){
		var range=document.selection.createRange();
		range.moveStart("character",-elem.value.length);
		return range.text.length;
	}
	return 0;
};
(function($){//对jQuery扩展的一些公用的方法

	//只允许输入数字，扩展到jquery。（此方法只屏蔽输入，不能屏蔽复制，拖动到输入框的内容）
	$.fn.inputNumber=function(){
		return this.each(function(){
			$(this).keydown(function(e){
				var kc=getKeyType(e);
				if(kc!=2&&kc!=0){
					return false;
				}
			}).css("ime-mode","disabled");
			
		});
	};

	//允许输入带小数点的值
	$.fn.inputMoney=function(){
		
		return this.each(function(){
			$(this).keydown(function(e){
	
				var kc=getKeyType(e);
				if(kc!=0){
					if((e.keyCode==190&&!e.shiftKey)||(e.keyCode==110)){
						return true;
					}
					if(kc!=2){
						return false;
					}
				}
				
			}).css("ime-mode","disabled");
			
		});
	};

	
	//允许输入小数点后几位
	$.fn.allowpoint=function(){
		
		return this.each(function(){
			$(this).keydown(function(e){
				var num=this.getAttribute("allowpoint");
				if(num!==null&&isNaN(num))num=3;
				var kc=getKeyType(e);
				if(kc!=0){
					var index=this.value.indexOf(".");
					if(index>-1){
						if(getPos(this)>index&&this.value.length-index>num){//有小数点，已经有三位小数
							return false;
						}
					}
					//小数点
					else if((e.keyCode==190&&!e.shiftKey)||(e.keyCode==110)){
						return true;
					}
					if(kc!=2){
						return false;
					}
				}
				
			}).css("ime-mode","disabled");
			
		});
	};



	//弹出层的弹出方法
	$.fn.popup=function(){
		return this.show().children(".popup_container").css({top:j(window).scrollTop()+120}).end();//调整弹出层在页面中的位置
	};

	//获得select选中文本
	$.fn.selectedText=function(){return this.children("option:selected").text();}

	/*
		表单元素显示验证提示
		参数：
			str -- 提示内容，内容为空则表示输入正确
	*/
	$.fn.showTip=function(str){return this.siblings("._tip").text(str).removeClass("tip_error").removeClass("tip_suc").addClass(str?"tip_error":"tip_suc");};

	/*
		重写jquery val方法，使其触发 onValueChange 事件

	*/
	if(typeof(__tmpVal)=="undefined"){
		var __tmpVal=$.fn.val;
		$.fn.val=function(){var ret= __tmpVal.apply(this,arguments);if(arguments[0]){this.trigger("onValueChange");}return ret;};
	}
})(jQuery);


//关闭所有弹出层
function closeAllPopup(){
	j(".popup").hide();
};



/*===============================================================================>>>

	表单无素输入验证
-------------------------------------------------------------------------------------*/


/*//方法返回值: true - 通过验证;false - 未通过验证
	this指向当前验证的DOM
*/
ValidateMethods={
	emptykey:function(){//空值
		return /\S/.test(this.value);
	},
	shortkey:function(){//输入长度不够，配合minlength属性使用
		return this.value.length>=this.getAttribute("minlength");
	},
	longkey:function(){//输入长度不够，配合minlength属性使用
		return this.value.length<=this.getAttribute("maxlength");
	}
	,numberonly:function(){//只允许数字
		return !(/\D/.test(this.value));
	}
	,wordonly:function(){//只允许字母和数字
		return /^\w*$/.test(this.value);
	},
	email:function(){//验证email
		return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(this.value);
	},
	telephone:function(){//验证电话号码
		return /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/.test(this.value);
	},
	moneyonly:function(){//浮点型数字验证
		return /^\d+(\.\d+)?$/.test(this.value);
	},
	minkey:function(){//字符太小
		return this.value>=this.getAttribute("min");
	},
	maxkey:function(){//字符太小
		return this.value<=this.getAttribute("max");
	}

};
//表单元素验证
j("input:text,input:password,textarea").live("blur",function(e){
	
	var invalid_msg="",
		need_validate=false;//表示此表单是否需要验证
	for(var k in ValidateMethods){

		if(this.getAttribute(k)){
			need_validate=true;
			if(!ValidateMethods[k].call(this)){
				invalid_msg=this.getAttribute(k);break;
			}
		}

	}
	if(need_validate)j(this).showTip(invalid_msg);
});


j(document).ready(function(){
	j("input:text[numberonly]").inputNumber();
	j("input:text[allowpoint]").allowpoint();
	j("input:text[wordonly]").css("ime-mode","disabled");
	j("input:text[moneyonly]").inputMoney();
	//单独验证输入值要一致的输入框
	var sameobj=j("input:text[samekey],input:password[samekey]").blur(function(){
		var val1=sameobj.eq(0).val(),
			val2=sameobj.eq(1).val();
		if(val1&&val2){
			if(val1!==val2){
				sameobj.eq(1).showTip(sameobj.eq(1).attr("samekey"));
			}else if(!sameobj.eq(0).siblings(".tip_error").length){
				sameobj.eq(1).showTip("");
			}
		}
		
	});
	//调整日期控件样式
	j(".Wdate").after("<span class='Wdate2'></span>");


	//待处理事件－事件详情
	j("._choose_card_toggle").click(function(){
		if(this.checked){
			j(this.parentNode).next().show();
		}else{
			j(this.parentNode).next().hide();
		}
	}).attr("checked",false);
})






//表单sumbit验证 obj是原生dom元素
function chickForm(obj){
	validate_status=true;
	j.each(obj,function(i,n){
		var invalid_msg="",
		need_validate=false;//表示此表单是否需要验证
		for(var k in ValidateMethods){
			if(n.getAttribute(k)){
				need_validate=true;
				if(!ValidateMethods[k].call(n)){
					validate_status=false;
					invalid_msg=n.getAttribute(k);
					break;
				}
			}
		}
		if(need_validate){
			j(n).showTip(invalid_msg);
		}

	})
	return validate_status;
}


//验证表单方法
function autoCheckForm(){
	var returnVal=true;
	j("input:text,input:password,textarea").each(function(){
		var invalid_msg="",
		need_validate=false;//表示此表单是否需要验证
		for(var k in ValidateMethods){

			if(this.getAttribute(k)){
				need_validate=true;
				if(!ValidateMethods[k].call(this)){
					returnVal=false;
					invalid_msg=this.getAttribute(k);break;
				}
			}

		}
		if(need_validate)j(this).showTip(invalid_msg);
	});
	return returnVal;
}



/**=============================================
	by wur
*/
//fix bug
L=(typeof L==="undefined")?{}:L;

function popdiv(type,name1,zone1,name2,zone2,desZone){
	var html="<div style='padding-top:10px;line-height:1.8;'>";
	switch(parseInt(type)){
		case 1:
		html+="由于 <b>"+zone1+"</b> 区域不在 <b>"+name2+"</b> 的区域范围内，故不能进行此次操作。<br/><br/>建议：<br/>1. 在客户管理中为 <b>"+name2+"</b> 增加 <b>"+desZone+"</b> 区域<br/>2. 更改上下级关系操作";
		break;
		case 2:
		html+="由于 <b>"+zone1+"</b> 区域不在 <b>"+name2+"</b> 的区域范围内，故不能进行此次操作。<br/><br/>建议：<br/>1. 在客户区域管理中新增一个区域，对应的标准区域选为 <b>"+desZone+"</b> <br/>2. 更改 <b>"+name2+"</b> 的客户区域为新增的客户区域<br/>3. 更改上下级关系操作";
		break;
		case 3:
		html+="由于撤销客户 <b>"+name1+"</b> 的区域大于接管客户 <b>"+name2+"</b> 的区域范围，故不能进行此次操作。<br/><br/>建议：<br/>1. 在客户管理中为 <b>"+name2+"</b> 增加 <b>"+desZone+"</b> 区域<br/>2. 进行过户操作";
		break;
		case 4:
		html+="由于撤销客户 <b>"+name1+"</b> 的区域大于接管客户 <b>"+name2+"</b> 的区域范围，故不能进行此次操作。<br/><br/>建议：<br/>1. 在客户区域管理中新增一个区域，对应的标准区域选为 <b>"+desZone+"</b> <br/>2. 更改 <b>"+name2+"</b> 的客户区域为新增的客户区域<br/>3. 进行过户操作";
		break;
		case 5:
		html+="此次修改超出了系统级别体系，造成经销层级过多，影响分销体系中客户的收益，无法完成此次操作。";
		break;
	}
	html+="</div>";
	j("#operate_result").popup().find(".popup_content").html(html);
}

//-------------------------------------------------------//


//用户列表ajax
j("._ajax_usr_form").live("submit",function(e){
	e.preventDefault();
	frm = D.getElementsByClassName('_ajax_usr_form')[0];
	YAHOO.util.Connect.setForm(frm);
	YAHOO.util.Connect.asyncRequest('POST', j(frm).attr('action')+"?t="+new Date().getTime(),{
		success : function(req){
			j("#card_client_list").html(req.responseText );
		}
		,
		failure : function(req){

		}
		,
		timeout:20000
	});
	return false;
	//E.stopEvent(ev);
});

j("._ajax_goods_form").live("submit",function(e){
	e.preventDefault();
	frm = D.getElementsByClassName('_ajax_goods_form')[0];
	YAHOO.util.Connect.setForm(frm);
	YAHOO.util.Connect.asyncRequest('POST', j(frm).attr('action')+"?t="+new Date().getTime(),{
		success : function(req){
			j("#card_goods_list").html(req.responseText );
		}
		,
		failure : function(req){

		}
		,
		timeout:20000
	});
	//return false;
	//E.stopEvent(ev);
});




// 分页
function inputPage(formName,obj){
	pageNum1 = obj.value;
	var   pattern   =   /^([0-9])+$/;
	var flag = pattern.test(pageNum1);
	if(flag){
		pageNum = pageNum1;
	}else{
		pageNum = 1;
	}
	var pageInputName = "currentPage";
	var pageInput = null;
	var form = document.getElementsByName(formName)[0];

	if(document.getElementsByName(pageInputName).length != 0){
		pageInput = document.getElementsByName(pageInputName)[0];
		pageInput.value = pageNum;
	}else{
		pageInput = document.createElement("input");
		pageInput.type = "hidden";
		pageInput.name = "currentPage";
		pageInput.value = pageNum;
		form.appendChild(pageInput);
	}
}

function ajaxPage(formName, pageNum1){
	var   pattern   =   /^([0-9])+$/;     
    var flag = pattern.test(pageNum1); 
	if(flag){
		pageNum = pageNum1;
	}else{
		pageNum = 1;
	}
	var pageInputName = "currentPage";
	var pageInput = null;
	var form = document.getElementsByName(formName)[0];
	
	if(document.getElementsByName(pageInputName).length != 0){
		pageInput = document.getElementsByName(pageInputName)[0];
		pageInput.value = pageNum;
	}else{
		pageInput = document.createElement("input");
		pageInput.type = "hidden";
	    pageInput.name = "currentPage";
	    pageInput.value = pageNum;
	    
	    form.appendChild(pageInput);
	}
	j(form).submit();;
}
//yui添加类库
L.parseFloat = function(obj,def){
	r = parseFloat(obj);
	if(L.isNumber(r)){
		return r;
	}
	else{
		if(def){
			return def;
		}
		else{
			return 0;
		}
	}
}
L.parseInt = function(obj,def){
	parseInt(L.parseFloat(obj,def));
}

//员工角色管理--通过传ID使checkbox选中
function selectCheckBox(ids){
	j("input:checkbox[id^='ck_']").attr("checked",false);
	j("#ck_"+ids.join(",#ck_")).attr("checked",true);	
}


/**
//example
用户区域 数据格式


*/

function buildUserArea(ids,txts,name){
	var html="";
	if(ids.length){
		var arr=[];
		for(var i=0;i<ids.length;i++){
			arr.push('<input type="radio" class="duiqi" value="'+ids[i]+'" name="'+name+'" />'+txts[i]);
		}
		html=arr.join("<br/><br/>");

	}
	j("._cancel_clientele").html(html);
}




/*
	录入密保卡信息
*/
