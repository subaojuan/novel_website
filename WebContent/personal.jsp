<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%--引入JSTL--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		
		<!--引入核心bootstrap样式-->
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/comm.css" />
		<style type="text/css">
			.container{margin-top: 60px;}
			.out_media{padding-left: 3%;padding-right: 3%;padding-top: 20px;padding-bottom: 20px;}
		</style>
		
		
<title>personal.jsp</title>
</head>
<body>
		<!-- 顶部导航栏 -->
	<div class="nav_head"></div>
		<!-- 个人中心 -->
		<div class="container">
			<!-- 面板 -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">个人中心&nbsp;&nbsp;&nbsp;
					<c:choose>
						<c:when test="${authorMap.get('name')!=null }">
						笔名：<a href="authorDetail.action?authorName=${authorMap.get('name')}">${authorMap.get('name')}&nbsp;&nbsp;</a>
						</c:when>
						<c:otherwise>
							&nbsp;<a href="isActivated.action?mainId=${sessionScope.detailMap.get('user_main_id') }">成为作者</a>
						</c:otherwise>
					</c:choose>
					</h3>
				</div>
				
				<div class="out_media">
					<div class="media">
						<div class="media-body">
							<div class="panel-group" id="accordion">
							<!-- 头像 -->
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseZero">
							               	头像
							                </a>
							            </h4>
							        </div>
							        <div id="collapseZero" class="panel-collapse collapse in">
							            <div class="panel-body">
							            <img src="${sessionScope.detailMap.get('display') == null ? 
							'img/displays/default.png':sessionScope.detailMap.get('display')} " 
							class="media-object img-circle img-responsive center-block " data-toggle="modal" data-target="#myModal" style="width:100px" title="头像">
							            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								            <div class="modal-dialog">
										        <div class="modal-content">
										            <div class="modal-header">
										                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										                <h4 class="modal-title" id="myModalLabel">头像编辑</h4>
										            </div>
										            <form action="displaying.action" method="post" enctype="multipart/form-data" class="form-inline">
										            <div class="modal-body">
														<div class="form-group">						
															<input value="${sessionScope.detailMap.get('user_main_id') }" name="user_main_id" hidden="true">
															<input id="inputFile" class="form-control" type="file" name="display" style="border: none">
														</div>
										            </div>
										            <div class="modal-footer">
										                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
										                <button type="submit" class="btn btn-primary">提交更改</button>
										            </div>
										            </form>
										        </div><!-- /.modal-content -->
    										</div><!-- /.modal -->
										</div>
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseOne">
							               	我的昵称
							                </a>
							            </h4>
							        </div>
							        <div id="collapseOne" class="panel-collapse collapse in">
							            <div class="panel-body">
							            	<span data-toggle="modal" data-target="#nameModal" title="点击编辑昵称">${sessionScope.detailMap.get('username') }</span>
							            	<div class="modal fade" id="nameModal" tabindex="-1" role="dialog" aria-labelledby="nameModalLabel" aria-hidden="true">
							            		<div class="modal-dialog">
										        <div class="modal-content">
										            <div class="modal-header">
										                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										                <h4 class="modal-title" id="nameModalLabel">更新昵称</h4>
										            </div>
										            <form action="updateName.action" method="post">
										            <div class="modal-body">
														<div class="form-group">						
															<input value="${sessionScope.detailMap.get('user_main_id') }" name="user_main_id" hidden="true">
															<input class="form-control" type="text" name="name">
														</div>
										            </div>
										            <div class="modal-footer">
										                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
										                <button type="submit" class="btn btn-primary">提交更改</button>
										            </div>
										            </form>
										        </div><!-- /.modal-content -->
    										</div><!-- /.modal-dialog -->
							            	</div>
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseTwo">
							               	钱包
							                </a>
							            </h4>
							        </div>
							        <div id="collapseTwo" class="panel-collapse collapse in">
							            <div class="panel-body">
							               <span data-toggle="modal" data-target="#moneyModal" title="点击充值">${sessionScope.detailMap.get('money') }</span>
							               <div class="modal fade" id="moneyModal" tabindex="-1" role="dialog" aria-labelledby="nameModalLabel" aria-hidden="true">
							            		<div class="modal-dialog">
										        <div class="modal-content">
										            <div class="modal-header">
										                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										                <h4 class="modal-title" id="moneyModalLabel">充值</h4>
										            </div>
										            <form action="updateMoney.action" method="post">
										            <div class="modal-body">
														<div class="form-group">						
															<input value="${sessionScope.detailMap.get('user_main_id') }" name="user_main_id" hidden="true">
															<input class="form-control" type="text" name="money">
														</div>
										            </div>
										            <div class="modal-footer">
										                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
										                <button type="submit" class="btn btn-primary">提交更改</button>
										            </div>
										            </form>
										        </div><!-- /.modal-content -->
    										</div><!-- /.modal-dialog -->
							            	</div>
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseThree" title="激活操作是在绑定的邮箱中点击注册时的链接">
							               	状态
							                </a>
							            </h4>
							        </div>
							        <div id="collapseThree" class="panel-collapse collapse in">
							            <div class="panel-body">
							               ${sessionScope.detailMap.get('live') == 1 ? '已激活' :'未激活'}
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseFour">
							               	邮箱
							                </a>
							            </h4>
							        </div>
							        <div id="collapseFour" class="panel-collapse collapse in">
							            <div class="panel-body">
							              ${sessionScope.detailMap.get('email') }
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseFive">
							               	电话
							                </a>
							            </h4>
							        </div>
							        <div id="collapseFive" class="panel-collapse collapse in">
							            <div class="panel-body">
							             ${sessionScope.detailMap.get('telephone')}
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseSix">
							               	个人描述
							                </a>
							            </h4>
							        </div>
							        <div id="collapseSix" class="panel-collapse collapse in">
							            <div class="panel-body">
							             <span data-toggle="modal" data-target="#infoModal" title="点击编辑">${sessionScope.detailMap.get('info')}</span>
							            	<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="infoModalLabel" aria-hidden="true">
							            		<div class="modal-dialog">
										        <div class="modal-content">
										            <div class="modal-header">
										                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										                <h4 class="modal-title" id="infoModalLabel">更新个人描述</h4>
										            </div>
										            <form action="updateInfo.action" method="post">
										            <div class="modal-body">
														<div class="form-group">						
															<input value="${sessionScope.detailMap.get('user_main_id') }" name="user_main_id" hidden="true">
															<textarea name="info" class="form-control" rows="5"></textarea>
														</div>
										            </div>
										            <div class="modal-footer">
										                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
										                <button type="submit" class="btn btn-primary">提交更改</button>
										            </div>
										            </form>
										        </div><!-- /.modal-content -->
    										</div><!-- /.modal-dialog -->
							            	</div>
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseSeven">
							               	故乡
							                </a>
							            </h4>
							        </div>
							        <div id="collapseSeven" class="panel-collapse collapse in">
							            <div class="panel-body">
							              <span data-toggle="modal" data-target="#cityModal" title="点击编辑">${sessionScope.detailMap.get('city')==null ? '点击编辑' : sessionScope.detailMap.get('city')}</span>
							            	<div class="modal fade" id="cityModal" tabindex="-1" role="dialog" aria-labelledby="cityModalLabel" aria-hidden="true">
							            		<div class="modal-dialog">
										        <div class="modal-content">
										            <div class="modal-header">
										                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										                <h4 class="modal-title" id="cityModalLabel">更新故乡</h4>
										            </div>
										            <form action="updateCity.action" method="post">
										            <div class="modal-body">
														<div class="form-group">						
															<input value="${sessionScope.detailMap.get('user_main_id') }" name="user_main_id" hidden="true">
															所在地区：<select class="form-control" name="province" id="param_province" onchange="provincechange(this.selectedIndex)"><option>请选择省份</option></select><br/>
  																城市：<select class="form-control" name="city" id="param_city"><option>请选择城市</option></select>
														</div>
										            </div>
										            <div class="modal-footer">
										                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
										                <button type="submit" class="btn btn-primary">提交更改</button>
										            </div>
										            </form>
										        </div><!-- /.modal-content -->
    										</div><!-- /.modal-dialog -->
							            	</div>
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseEight">
							               	最近看的书
							                </a>
							            </h4>
							        </div>
							        <div id="collapseEight" class="panel-collapse collapse in">
							            <div class="panel-body">
							             ${sessionScope.detailMap.get('book')}
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseNine">
							               	职业
							                </a>
							            </h4>
							        </div>
							        <div id="collapseNine" class="panel-collapse collapse in">
							            <div class="panel-body">
							             ${sessionScope.detailMap.get('job')}
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseTen">
							               	注册日期
							                </a>
							            </h4>
							        </div>
							        <div id="collapseTen" class="panel-collapse collapse in">
							            <div class="panel-body">
							             ${sessionScope.detailMap.get('register_date')}
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseEle">
							               	用户生日
							                </a>
							            </h4>
							        </div>
							        <div id="collapseEle" class="panel-collapse collapse in">
							            <div class="panel-body">
							             ${sessionScope.detailMap.get('birthday')== null 
							             ? '' : sessionScope.detailMap.get('birthday')}
							            </div>
							        </div>
	    						</div>
								<div class="panel panel-default">
							        <div class="panel-heading">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" 
							                href="#collapseTwl">
							               	最新修改日期
							                </a>
							            </h4>
							        </div>
							        <div id="collapseTwl" class="panel-collapse collapse in">
							            <div class="panel-body">
							             ${sessionScope.detailMap.get('last_modified_date')}
							            </div>
							        </div>
	    						</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	
	
	
	
	<!-- 底部信息 -->
	<div class="footer"></div>
</body>
	<!--核心js插件：jquery-->
	<script type="text/javascript" src="js/jquery-2.1.0.min.js" ></script>
	<!--引入核心bootstrap 核心js文件,必须在引入js文件之后引入-->
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<!-- 自定义js -->
	<script type="text/javascript" src="js/index/index.js"></script>
	<script type="text/javascript" src="js/personal.js"></script>
	<script type="text/javascript">
		//window.onload = function() {
		//	var fileValue = document.getElementById("inputFile");
		//	alert(fileValue);
		//}
		// 初始化数据。为省市级连做准备。
		$(document).ready(function(){
			init();
		});
		
	</script>
</html>