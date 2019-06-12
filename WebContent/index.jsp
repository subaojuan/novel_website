<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--引入JSTL--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
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
		<!-- 自定义样式 -->
		<link rel="stylesheet" href="css/add-fixed-nav.css" />
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/comm.css" />
		
		<style>
			.mytable{
				width: 300px;
			}
		</style>
	
<title>主页</title>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
	<!-- 顶部导航栏 -->
	<div class="nav_head"></div>
	
	<!-- 轮播图片 -->
	<div id="myCarousel" class="carousel slide">
	    	<!-- 轮播（Carousel）指标 -->
	    	<ol class="carousel-indicators">
		        <li data-target="#myCarousel" data-slide-to="0" 
		            class="active"></li>
		        <li data-target="#myCarousel" data-slide-to="1"></li>
		        <li data-target="#myCarousel" data-slide-to="2"></li>
	    	</ol>   
		    <!-- 轮播（Carousel）项目 -->
		    <div id="roll_pics_div" class="carousel-inner" >
		        <div class="item active" >
		            <img src="img/rool_pics/my_roll_pic1.png" alt="First slide">
		        </div>
		        <div class="item">
		            <img src="img/rool_pics/my_roll_pic2.png" alt="Second slide">
		        </div>
		        <div class="item">
		            <img src="img/rool_pics/my_roll_pic3.png" alt="Third slide">
		        </div>
		    </div>
	    	<!-- 轮播（Carousel）导航 -->
	        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	            <span class="sr-only">Previous</span>
	        </a>
	        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	            <span class="sr-only">Next</span>
	        </a>
		</div>
	
	
		<!-- 以上，轮播结束 -->
		<div class="container">
			<div class="title-div" style="height: 250px">
				<h1 class="col-md-8"><img src="img/title.png" /><label class="label label-warning">宝儿小说网</label></h1>
				<h4 title="当前时间"><label id="time" class="label label-warning"></label></h4>
				<!-- 榜单数据展示 -->
				<table class="table mytable">
					<thead>
						<tr style="font-family: '黑体';font-weight: 800"><td>排名</td><td>特色推荐</td><td>访问量</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sessionScope.tops }" var="top" varStatus="v">
								<c:choose>
									<c:when test="${v.count == 1 }">
										<tr>
											<td style="color: #f54545;">${v.count }</td>
											<td><a href="detail.action?name=${top.key }">${top.key }</a></td>
											<td>${top.value }</td>
										</tr>
									</c:when>
									<c:when test="${v.count == 2 }">
										<tr>
											<td style="color: #FF8547">${v.count }</td>
											<td><a href="detail.action?name=${top.key }">${top.key }</a></td>
											<td>${top.value }</td>
										</tr>
									</c:when>
									<c:when test="${v.count == 3 }">
										<tr>
											<td style="color: #ffac38">${v.count }</td>
											<td><a href="detail.action?name=${top.key }">${top.key }</a></td>
											<td>${top.value }</td>
										</tr>
									</c:when>
									<c:otherwise>
										<tr>
											<td style="color: #8EB9F5">${v.count }</td>
											<td><a href="detail.action?name=${top.key }">${top.key }</a></td>
											<td>${top.value }</td>
										</tr>
									</c:otherwise>
								</c:choose>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="row">
				<!-- 附加导航 -->
				<div class="col-md-3 col-xs-3" id="myScrollspy">
					<ul class="nav nav-tabs nav-stacked" id="myNav" data-spy="affix" data-offset-top="125">
						<c:forEach items="${sessionScope.types }" var="type" varStatus="v">
							<c:choose>
								<c:when test="${v.count == 1 }">
									<li class="active"><a href="#section-${v.count}">${type }</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="#section-${v.count }">${type }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<li><a href="#section-12">关于</a></li>
					</ul>
				</div>
				<!-- 核心内容部分 -->
		
				<!-- 核心 -->
				<div class="col-xs-9">
					<!-- 玄幻部分 -->
					<h2 id="section-1" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(0) }
						<a href="type.action?type=1"><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('1').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('1').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('1').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('1').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('1').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('1').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<c:forEach begin="1" end="9" step="1" var="num">
								<li><a href="detail.action?name=${sessionScope.typeXNovelsMap.get('1').get(num).get('name') }" title="内容简介 ：${sessionScope.typeXNovelsMap.get('1').get(num).get('info') }">
								${sessionScope.typeXNovelsMap.get('1').get(num).get('name') }
								</a></li>
							</c:forEach>
						</ul>
					</div>
					<hr class="alert-warning">
					
					<!-- 同人部分 -->
				 	<h2 id="section-2" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(1) }
						<a href="type.action?type=2"><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('2').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('2').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('2').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('2').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('2').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('2').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<!--  -->
						
						</ul>
					</div>
					<hr class="alert-warning">
		           
		           <!-- 爱情部分 -->
		           	<h2 id="section-3" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(2) }
						<a href="type.action?type=3"><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('3').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('3').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('3').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('3').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('3').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('3').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<!---->
							
						</ul>
					</div>
					<hr class="alert-warning">
		           
		           <!-- 武侠部分 -->
		           <h2 id="section-4" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(3) }
						<a href=""><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('4').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('4').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('4').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('4').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('4').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('4').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<!---->
						</ul>
					</div>
					<hr class="alert-warning">
		           
		           <!-- 推理部分 -->
		           <h2 id="section-5" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(4) }
						<a href=""><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('5').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('5').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('5').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('5').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('5').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('5').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<!---->
						</ul>
					</div>
					<hr class="alert-warning">
		           
		           <!-- 历史部分 -->
		           <h2 id="section-6" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(5) }
						<a href=""><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('6').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('6').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('6').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('6').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('6').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('6').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<!---->
						</ul>
					</div>
					<hr class="alert-warning">
		           
		           <!-- 文学部分 -->
		           <h2 id="section-7" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(6) }
						<a href=""><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('7').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('7').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('7').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('7').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('7').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('7').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<!---->
						</ul>
					</div>
					<hr class="alert-warning">
		           
		           
		           <!-- 恐怖部分 -->
		            <h2 id="section-8" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(7) }
						<a href=""><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('8').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('8').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('8').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('8').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('8').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('8').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<!---->
						</ul>
					</div>
					<hr class="alert-warning">
		           
		           
		           <!-- 网游部分 -->
		           	<h2 id="section-9" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(8) }
						<a href=""><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('9').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('9').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('9').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('9').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('9').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('9').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<!---->
						</ul>
					</div>
					<hr class="alert-warning">
		           
		           
		           <!-- 修真部分 -->
		           <h2 id="section-10" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(9) }
						<a href=""><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('10').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('10').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('10').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('10').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('10').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('10').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<!---->
						</ul>
					</div>
					<hr class="alert-warning">
		           
		           
		           
		           <!-- 军事部分 -->
		            <h2 id="section-11" class="media-heading">
						<img class="img-topbar" alt="..." src="img/topbar.png">${sessionScope.types.get(10) }
						<a href=""><img title="点击查看更多" align="right" style="margin-top: 12px;margin-right: 5px" height="32px" src="img/more.png"/></a>
					</h2>
					
					<div class="jumbotron content_media">
						<div class="media">
							<div id="media-left" class="media-left media-middle">
								<a href="detail.action?name=${sessionScope.typeXNovelsMap.get('11').get(0).get('name') }">
								    <img title="${sessionScope.typeXNovelsMap.get('11').get(0).get('name') }" class="media-object novel_title" src="${sessionScope.typeXNovelsMap.get('11').get(0).get('img') }" alt="...">
								</a>
								<p class="label-success"><label class="label label-success"><a href="#" title="作者">${sessionScope.typeXNovelsMap.get('11').get(0).get('author_name') }</a>•著</label></p>
							</div>
							<div class="media-body">
								<h4 class="media-heading"><label class="label bg-primary">《${sessionScope.typeXNovelsMap.get('11').get(0).get('name') }》简介：</label></h4>
								<span>${sessionScope.typeXNovelsMap.get('11').get(0).get('info') }</span>
							</div>
						</div>
						<hr class="bg-danger"/>
						<!-- 列表中的小说名字以及连接 -->
						<ul class="other_novel bg-primary">
							<!---->
						</ul>
					</div>
					<hr class="alert-warning">
		           
		           <!-- 关于 -->
			        <h2 id="section-12"><img class="img-topbar" alt="..." src="img/topbar.png">关于</h2>
		            	<div class="jumbotron">
		            		<!--
                            	作者：offline
                            	时间：2019-01-11
                            	描述：占位。。。暂时不写内容
                            -->
		            	</div>
		            	<hr class="alert-warning">
			</div>
			
		</div>
		</div>
		<!-- 
		取出第1种类型中的，第一本小说的作者名字
		${sessionScope.typeXNovelsMap.get("1").get(1).get("AUTHOR_NAME")} 
		-->
	<!-- 底部信息 -->
	<div class="footer"></div>
	
</body>

	<!--核心js插件：jquery-->
	<script type="text/javascript" src="js/jquery-2.1.0.min.js" ></script>
	<!--引入核心bootstrap 核心js文件,必须在引入js文件之后引入-->
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	<!-- 自定义js -->
	<script type="text/javascript" src="js/index/index.js"></script>
</html>


