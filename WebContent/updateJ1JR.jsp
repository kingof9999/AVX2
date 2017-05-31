<!-- 
	* updateJ1JR.jsp
	*
	* version 4.0
	*
	* Date: 18/05/2017
 	*
 	* Copyright
 	* 
 	* Modification Logs:
 	* DATE				AUTHOR			DECRIPTION
 	* -------------------------------------------
 	* 23/05/2017		TinLQ			Create
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ｊ１／ＪＲ情報簡易修正</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link
	href="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">
<link
	href="http://cdn.datatables.net/responsive/1.0.1/css/dataTables.responsive.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/quanlynhanvien.css" />
<script src="js/jquery.min.js"></script>
<!-- script export to excel -->
<script type="text/javascript">  
	function exportF() {
		var table = document.getElementById("table");
		var html = table.outerHTML;

		var url = 'data:application/vnd.ms-excel,' + encodeURI(html); // Set your html table into url 
		var link = document.getElementById("downloadLink");
		link.setAttribute("href", url);
		link.setAttribute("download", "export.xls"); // Choose the file name
		link.click(); // Download excel file   
		return false;
	}
</script>
</head>
<body>
	<div class="container" style="margin-top: 10px;">
		<div class="body">
			<div class="main-form col-sm-12">
				<div class="top-text col-sm-12">
					<div class="col-sm-5" style="float: left;">
						<label for="message" class="my-label">AUTA321</label>
					</div>
					<div class="col-sm-4" style="float: left;">
						<label for="message" class="my-label">Ｊ１／ＪＲ情報簡易修正</label>
					</div>
					<div class="col-sm-3" style="float: left;">
						<label for="message" id="clock" style="padding-left: 60%;" class="my-label"></label>
						<script type="text/javascript"> function refrClock() {
								var d=new Date();
								var s=d.getSeconds();
								var m=d.getMinutes();
								var h=d.getHours();
								var day=d.getDay();
								var date=d.getDate();
								var month=d.getMonth();
								var year=d.getFullYear();
								var days=new Array("Sunday,","Monday,","Tuesday,","Wednesday,","Thursday,","Friday,","Saturday,");
								var months=new Array("01","02","03","04","05","06","07","08","09","10","11","12"); var am_pm;
									if (s<10) {s="0" + s}
									if (m<10) {m="0" + m}
									if (h>12){
											h-=12;AM_PM = "PM"
									}
									else {AM_PM="AM"}
									if (h<10) {
										h="0" + h
									}
								   document.getElementById("clock").innerHTML= year + "年" +months[month] + "月" + date + "日"; 
								   setTimeout("refrClock()",1000); } refrClock();
						</script>
					</div>
				</div>
				<html:form action="/search-J1JR" styleClass="form-group" method="post">
				<div class="top-message col-sm-12">
					<label for="message" id="message"><html:errors property="nullStokError"/></label>
					<label for="message">
						<html:errors property="reloadPageError"/>
						<html:errors property="updateSuccess"/>
						<html:errors property="updateHalfSizeError"/>
						<html:errors property="specialCharError"/>
					</label>
					<label for="message" id="message2"><html:errors property="nullUpdateError"/><html:errors property="existError"/></label>
				</div>
				<div class="body-filter col-sm-12" style="height: 80px;">
					<div style="margin: 24px 0 0 50px;">
						<table>
							<tr>
								<td>
									<div class="body-main-label-text"><label for="message" class="my-label2">ストック・ナンバー</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text tabindex="1" styleId="iTEMMSTOKtextbox" property="iTEMMSTOK" styleClass="form-control" style="width: 37%;" maxlength="13"></html:text>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="body-button col-sm-12">
					<div style="margin: 10px 0 0 76%;">
						<html:submit tabindex="2" styleId="submitSearch" styleClass="m-btn m-btn-success my-btn" style="width: 120px;height: 34px;margin-left: 10px;">検索(S)</html:submit>
						<input tabindex="3" type="reset" class="m-btn m-btn-success my-btn" style="width: 120px;height: 34px;margin-left: 10px;" onclick="location.href='/AVX2/search-J1JR.do';" value="キャンセル(C)"/>
					</div>
				</div>
				<div class="body-main-top col-sm-12">
					<div style="margin-left: 15px;">
						<label for="message" class="my-label2"><span id="setpageid"></span>/<span id="setallpage"></span>べ ー ジ </label>
						<button id="back" class="m-btn m-btn-success my-btn" style="margin-left: 5px;">
							<i class="glyphicon glyphicon-arrow-left"></i>
						</button>
						<button id="next" class="m-btn m-btn-success my-btn" style="margin: 0 10px 0 10px;">
							<i class="glyphicon glyphicon-arrow-right"></i>
						</button>
						<label for="message" class="my-label2">べ ー ジ</label> 
						<html:text styleId="pageid" property="pagenum" style="margin: 0 10px 0 10px; width: 50px;"></html:text>
						<button id="searchPagebtn" class="m-btn m-btn-success my-btn">表示</button>
					</div>
				</div>
				</html:form>
				<logic:iterate id="st" name="stokForm" property="listStok">
					<span id="allpage" hidden><bean:write name="st" property="allpage"/></span>
					<div>
						<html:form styleId="infoForm" action="/update-J1JR" styleClass="form-group" method="post">
							<div class="body-main col-sm-12">
								<div class="col-sm-12">
										<table id="table" style="margin-top: 15px;">
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2"> ストック・ナンバー</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text name="st" property="iTEMMSTOK" styleClass="form-control" style="width: 20%;" readonly="true" maxlength="14"></html:text>
													</td>
												</tr>
												<tr id="errorLine">
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">主保管地コード</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text tabindex="4" styleId="iTEMMSKCD" name="st" property="iTEMMSKCD" styleClass="form-control" style="width: 5%;" maxlength="2"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">担当者コード</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text name="st" property="iTEMMTNTO" styleClass="form-control" style="width: 5%;" readonly="true" maxlength="2"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">氏名・通名</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text name="st" property="eMPFLEMPNM" styleClass="form-control" style="width: 8%;" readonly="true"  maxlength="5"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">ＤＣＣ名称</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text name="st" property="dCCFLNAME" styleClass="form-control" style="width: 37%;" readonly="true" maxlength="25"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">修正前・品名</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text name="st" property="iTEMMHNME" styleClass="form-control" style="width: 37%;" readonly="true" maxlength="25"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">修正後・品名</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text name="st" property="iTEMMHNME" styleClass="form-control" style="width: 37%;" readonly="true" maxlength="25"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">修正前メーカー名</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text property="mAKERDATA" styleClass="form-control" style="width: 10%;" readonly="true" maxlength="6"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">修正後ﾒｰｶｰ・コード</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text name="st" property="iTEMMMKCD" styleClass="form-control" style="width: 5%;" readonly="true" maxlength="2"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">修正前・車種名</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text property="cARNMNAME" styleClass="form-control" style="width: 15%;" readonly="true" maxlength="10"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">修正後車種コード</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text name="st" property="iTEMMSYCD" styleClass="form-control" style="width: 4%;" readonly="true" maxlength="1"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">ﾛｯﾄ別単価適用ﾏｰｸ</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text name="st" property="iTEMMTNKMK" styleClass="form-control" style="width: 4%;" readonly="true" maxlength="1"></html:text>
													</td>
												</tr>
												<tr>
													<td class="body-main-label">
														<div class="body-main-label-text"><label for="message" class="my-label2">ﾊﾟｰﾂ化年度（ﾗｲﾝ=0）</label></div>
													</td>
													<td style="padding-left: 20px;width: 87%;">
														<html:text name="st" property="iTEMMPART" styleClass="form-control" style="width: 7%;text-align-last: end;" readonly="true" maxlength="4"></html:text>
													</td>
												</tr>
										</table>
									<br>
								</div>
							</div>
							<div class="body-button col-sm-12">
								<div style="margin: 10px 0 0 64%;">
									<button tabindex="5" class="m-btn m-btn-success my-btn" style="width: 120px;height: 34px;margin-left: 10px;">更新(U)</button>
									<input tabindex="6" type="reset" class="m-btn m-btn-success my-btn" style="width: 120px;height: 34px;margin-left: 10px;" value="クリアー(R)"/>
									<a tabindex="7" onclick="exportF()" class="m-btn m-btn-success my-btn" style="width: 120px;height: 34px;margin-left: 10px;text-decoration: none;">エクスポート(E)</a>
									<a style="display: none" id="downloadLink"></a>
								</div>
							</div>
						</html:form>
					</div>
				</logic:iterate>
			</div>
		<div class="footer">
		</div>
		</div>
	</div>
</body>
<script>	
	var iTEMMSTOKtextbox = $("#iTEMMSTOKtextbox").val();
	var allpage = parseInt($("#allpage").text());
	var pageid = parseInt($("#pageid").val());
	if (allpage.toString() == "NaN") {
		allpage = 0;
	}
	if (allpage.toString() == 0) {
		$("#setallpage").text(0);
	} else {
		$("#setallpage").text(allpage);
	}
	if (pageid == 1) {
		$("#back").attr('disabled', 'disabled');
		$("#back").attr('style', 'background-color:#8c320d');
	}
	if (allpage == pageid) {
		$("#next").attr('disabled', 'disabled');
		$("#next").attr('style', 'background-color:#8c320d');
	}
	$("#setpageid").text(pageid);
	$("#pageid").attr("type", "number");
	$("#pageid").attr("min", "0");
	$("#pageid").attr("max", "" + allpage + "");
	$(document).ready(function() {
		$("#next").click(function() {
			if (pageid > allpage) {
				$("#pageid").val(allpage);
			}
			if (pageid == 0) {
				$("#pageid").val(1);
			}
			var pageid = parseInt($('#pageid').val(), 10);
			$("#pageid").val(pageid + 1);
		});
		$("#back").click(function() {
			if (pageid > allpage) {
				$("#pageid").val(allpage);
			}
			if (pageid == 0) {
				$("#pageid").val(1);
			}
			var pageid = parseInt($('#pageid').val(), 10);
			$("#pageid").val(pageid - 1);
		});
		$("#pageid").keypress(function(e) {
			if (e.keyCode == 13) {
				var allpage = parseInt($("#allpage").text());
				var pageid = parseInt($("#pageid").val());
				if (pageid > allpage) {
					$("#pageid").val(allpage);
				}
				if (pageid == 0) {
					$("#pageid").val(1);
				}
				if (String(pageid) == 'NaN') {
					var setpageid = $("#setpageid").text();
					$("#pageid").val(setpageid);
				}
			}
		});
		$("#searchPagebtn,#next,#back").click(function() {
			var allpage = parseInt($("#allpage").text());
			var pageid = parseInt($("#pageid").val());
			if (pageid > allpage) {
				$("#pageid").val(allpage);
			}
			if (pageid == 0) {
				$("#pageid").val(1);
			}
			if (String(pageid) == 'NaN') {
				var setpageid = $("#setpageid").text();
				$("#pageid").val(setpageid);
			}
		});
		$("#submitSearch").click(function() {
			$("#pageid").val(1);
		});
	});
</script>
<script>
	$(document).ready(function() {
		var message = $("#message").text();
		var x = document.getElementById('infoForm');
		if (message.length == 0) {
			x.style.display = 'block';
		}
		if (message.length > 0) {
			x.style.display = 'none';
		}

		var message2 = $("#message2").text();
		if (message2.length > 0) {
			$("#iTEMMSKCD").focus();
			$("#errorLine").attr('style', 'background-color: red;');
		}else{
			$("#iTEMMSTOKtextbox").focus();
		}
	});
</script>
</html>