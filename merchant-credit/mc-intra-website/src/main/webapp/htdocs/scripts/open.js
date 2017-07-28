var j=window.j||window.jQuery;

j(document).ready(function(){

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

//弹出层中供选择的列表
    j(".dialog_select_table>tbody>tr").live('click',function(){
        j(this).siblings("tr.tr_style_selected").removeClass("tr_style_selected").end().addClass("tr_style_selected");
    });

     j("#table_date tbody tr").hover(function() {
        j(this).addClass("tr_style_over");
    }, function() {
        j(this).removeClass("tr_style_over");
    }).filter(":odd").addClass("tr_style_odd");



     function tableTrOver(){
         j(".table_date tbody tr").hover(function() {
            j(this).addClass("tr_style_over");
        }, function() {
            j(this).removeClass("tr_style_over");
        });
        j(".table_date tbody").each(function(){
            j(this).children("tr:odd").addClass("tr_style_odd");
         });
     }

    tableTrOver();

        //返回按钮
        j(".back_2_list").click(function(){
            if(toggled)toggled.toggle();
            toggled=null;
        });
})

if(typeof ajaxPage==="undefined"){
ajaxPage=function (formName, pageNum1){
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
    j(form).submit();
}
}
var ajaxUsrform=j("._ajax_usr_form").unbind("submit").bind("submit",function(e){
    e.preventDefault();
    var params=ajaxUsrform.serializeArray();
    var data={};
    for(var i=0;i<params.length;i++){
        data[params[i]["name"]]=params[i]["value"];
    }
    j.ajax({
        url:ajaxUsrform.attr('action')+"?t="+new Date().getTime(),
        type:"POST",
        data:data,
        success:function(res){j("#card_client_list").html(res);}
    });
    return false;
});
// 分页
function inputPage(formName,obj,totalPage){

    pageNum1 = obj.value;
    if(/\D/.test(pageNum1)){
        alert("页码输入有误");
        return false;
    }else if(pageNum1-totalPage>0||pageNum1-0<=0){
         alert("总页数是"+totalPage+"，请输入合适的页码");
         return false;
    }
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