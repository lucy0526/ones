	jQuery(document).ready(function() {
		jQuery("#verifyCode").blur(function() {
			jQuery.ajax({
	            url: "http://bbs.51testing.com/static/js/msg_verify/verify.php",
	            data: "msg="+jQuery("#verifyCode").val()+"&uid="+jQuery("#hiddenuid").val()+"&mobile="+jQuery("#mobile").val(),
	            success: function(data){
	            	jQuery("#hiddenCode").val(jQuery.trim(data));
	            }
	        });
		});
		jQuery("#profilesubmitbtn").click(function() {
			if((jQuery("#hiddenCode").val()!="yes" && jQuery("#hiddenvid").val()=="2") || (jQuery("#verifyCode").val()=='' && jQuery("#hiddenvid").val()=="2")){
				alert("�ֻ���֤�����!");
				return false;
			}
		});
				
		
		if(jQuery("#td_residesuite").children("span").html()=="�����û�"){
			jQuery("#company").val("������֤");
			jQuery("#field8").val("������֤");
			jQuery("#tr_affectivestatus").hide();
			jQuery("#tr_company").hide();
			jQuery("#tr_height").hide();
			jQuery("#tr_field2").hide();
			jQuery("#tr_field4").hide();
			jQuery("#tr_field8").hide();
			jQuery("#tr_field6").hide();
			jQuery("#personalEmail").show();
		}
		if(jQuery("input:radio[name=residesuite]").filter(':checked').val()=="�����û�"){
			jQuery("#company").val("������֤");
			jQuery("#field8").val("������֤");
			jQuery("#tr_affectivestatus").hide();
			jQuery("#tr_company").hide();
			jQuery("#tr_height").hide();
			jQuery("#tr_field2").hide();
			jQuery("#tr_field4").hide();
			jQuery("#tr_field8").hide();
			jQuery("#tr_field6").hide();
			jQuery("#personalEmail").show();
		}
		var tdHtml = jQuery("#td_field1").html();
		var children = jQuery("#td_field1").find('input').length;
		if (children){jQuery("#td_field1").html(tdHtml+"<nn style='color:gray;'>����дӪҵִ�պ�</nn>");}	
		jQuery("#showerror_weight").html("<nn style='color:gray;'>ֻ���ϴ���С������1MB����ʽΪgif��jpg��png��bmp֮һ��ͼƬ��</nn>");
		jQuery("input:radio[name=residesuite]").change(function() {
			var rrr = jQuery("input:radio[name=residesuite]").filter(':checked').val();
				if(jQuery("input:radio[name=residesuite]").filter(':checked').val()=="��ҵ�û�"){
					jQuery("#company").val("");
					jQuery("#field8").val("");
					jQuery("#tr_affectivestatus").show();
					jQuery("#tr_company").show();
					jQuery("#tr_height").show();
					jQuery("#tr_field2").show();
					jQuery("#tr_field4").show();
					jQuery("#tr_field8").show();
					jQuery("#tr_field6").show();
					jQuery("#personalEmail").hide();
					jQuery("#td_field1").html(tdHtml+"<nn style='color:gray;'>����дӪҵִ�պ�</nn>");
				}
				else{
					jQuery("#company").val("������֤");
					jQuery("#field8").val("������֤");
					jQuery("#tr_affectivestatus").hide();
					jQuery("#tr_company").hide();
					jQuery("#tr_height").hide();
					jQuery("#tr_field2").hide();
					jQuery("#tr_field4").hide();
					jQuery("#tr_field8").hide();
					jQuery("#tr_field6").hide();
					jQuery("#personalEmail").show();
					jQuery("#td_field1").html(tdHtml+"<nn style='color:gray;'>����д���֤��</nn>");
				}
		});	
	});