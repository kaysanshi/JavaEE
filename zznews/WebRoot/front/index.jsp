<%@ page language="java" import="java.util.*,com.category.dao.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<style type="text/css">
</style>
<script>
	window.onload = function() {
		var main = document.getElementById('main');
		pic = document.getElementById('pic').getElementsByTagName("li");
		list = document.getElementById('list').getElementsByTagName('li');
		index = 0,
			timer = null;
		// 定义并调用自动播放函数
		timer = setInterval(autoPlay, 2000);
		// 鼠标划过整个容器时停止自动播放
		main.onmouseover = function() {
			clearInterval(timer);
		}

		// 鼠标离开整个容器时继续播放至下一张
		main.onmouseout = function() {
			timer = setInterval(autoPlay, 2000);
		}
		// 遍历所有数字导航实现划过切换至对应的图片
		for(var i = 0; i < list.length; i++) {
			list[i].onmouseover = function() {
				clearInterval(timer);
				index = this.innerText - 1;
				changePic(index);
			}
		}

		function autoPlay() {
			if(++index >= pic.length) index = 0;
			changePic(index);
		}

		// 定义图片切换函数
		function changePic(curIndex) {
			for(var i = 0; i < pic.length; i++) {
				pic[i].style.display = "none";
				list[i].className = "";
			}
			pic[curIndex].style.display = "block";
			list[curIndex].className = "on";
		}
	}
	</script>

<%

   //调用DAO
   CategoryDAO categoryDAO=new CategoryDAO();
   //查询所有的分类
   List<Map<String,Object>> categroies=categoryDAO.list();
   
   request.setAttribute("categroies",categroies);

 %>
<body>
	<div class="bui-box container">
		<div ga_event="channel_click" class="bui-left index-channel">
			<div>
				<div ga_event="left-channel-click" class="channel">
					<a href="#" class="logo"><img src="images/logo.201f80d.png"
						alt="新闻列表" style="width: 108px; height: 27px;"></a>
					<!---->

					<ul>
						<li><a href="#" target="_self"
							ga_event="channel_recommand_click" class="channel-item active"><span>推荐</span></a>
						</li>
						<c:forEach items="${categroies}" var="record">
							<li><a
								href="newsServlet?action=displayNews&categoryid=${record.categoryid}"
								class="channel-item"><span>${record.name}</span></a></li>
						</c:forEach>

					</ul>
				</div>
			</div>
		</div>
		<div class="bui-left index-content">
			<!--
                	作者：kaysanshi@163.com
                	时间：2019-04-11
                	描述：轮播
                -->
			<div id="main" class="all">
				<ul id="pic">
					<li><a href="#"><img src="fornt/image/bb.jpg" alt=""
							width="660px" height="400px"></a></li>
					<li style="display: none;"><a href="#"><img
							src="front/image/1.jpg" alt="" width="660px" height="400px"></a>
					</li>
					<li style="display: none;"><a href="#"><img
							src="front/image/th.jpg" alt="" width="660px" height="400px"></a>
					</li>
					<li style="display: none;"><a href="#"><img
							src="front/image/1.jpg" alt="" width="660px" height="400px"></a>
					</li>
					<li style="display: none;"><a href="#"><img
							src="front/image/1.jpg" alt="" width="660px" height="400px"></a>
					</li>
				</ul>
				<ul id="list">
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
				</ul>
			</div>

			<!---->
			<div class="center">

				<ul>
					<c:forEach items="${records}" var="record" varStatus="status">
						<c:if test="${status.index%4==0}">
							<tr>
						</c:if>
						<li class="">

							<div ga_event="article_item_click" class="bui-box single-mode">
								<!--
                                	作者：kaysanshi@163.com
                                	时间：2019-04-11
                                	描述：左图片
                                -->
								<div ga_event="article_img_click"
									class="bui-left single-mode-lbox">
									<a href="../Demo_tj_qt/ch/ALL.html" target="_blank"
										class="img-wrap"><img class="lazy-load-img"
										src="${record.picture}" lazy="loaded"> </a>
								</div>
								<!--
                                	作者：kaysanshi@163.com
                                	时间：2019-04-11
                                	描述：右侧内容
                                -->
								<div class="single-mode-rbox">
									<div class="single-mode-rbox-inner">
										<!-- - -->
										<div ga_event="article_title_click" class="title-box">
											<a
												href="newsServlet?action=showDetail&newsid=${record.newsid}"
												target="_blank" class="link">${record.title}</a>
										</div>
										<div class="bui-box footer-bar">
											<div class="bui-left footer-bar-left">
												<span class="footer-bar-action">&nbsp;${record.addtime}</span>
											</div>
											<div class="bui-right">
												<div ga_event="dislike_click" class="action-dislike"
													dislikeurl="/api/dislike/">
													<i class="bui-icon icon-close_small"
														style="font-size: 16px; color: rgb(221, 221, 221);"></i>
													不感兴趣
												</div>
											</div>
										</div>
										<c:if test="${status.index%4==3}">
											<tr></tr>
										</c:if>
					</c:forEach>
					<c:if test="${totalCount%4!=0 && currentPage==totalPage}">
						<tr></tr>
					</c:if>
			</div>
		</div>
	</div>
	</li>
	<li class="">
		<div ga_event="refresh_item_click" class="refresh-mode">
			共找到${totalCount}条记录，当前第${currentPage}页， <a
				href="newsServlet?action=displayNews&currentPage=1&orderfield=${orderfield}&ordervalue=${ordervalue}&categoryid=${categoryid}">首页</a>
			<c:if test="${currentPage==1}">上一页</c:if>
			<c:if test="${currentPage!=1}">
				<a
					href="newsServlet?action=displayNews&currentPage=${currentPage-1}&orderfield=${orderfield}&ordervalue=${ordervalue}&categoryid=${categoryid}">上一页</a>
			</c:if>
			<c:if test="${currentPage==totalPage}">下一页</c:if>
			<c:if test="${currentPage!=totalPage}">
				<a
					href="newsServlet?action=displayNews&currentPage=${currentPage+1}&orderfield=${orderfield}&ordervalue=${ordervalue}&categoryid=${categoryid}">下一页</a>
			</c:if>
			<a
				href="newsServlet?action=displayNews&currentPage=${totalPage}&orderfield=${orderfield}&ordervalue=${ordervalue}&categoryid=${categoryid}">尾页</a>
		</div>
	</li>

	</ul>
	</div>
	</div>
	<!--
        	作者：kaysanshi@163.com
        	时间：2019-04-11
        	描述：右侧
        	-->
	<div id="rightModule" class="bui-right index-right-bar">
		<div ga_event="index_search_click" class="search-wrapper">
			<div class="search-wrap">
				<form action="newsServlet?action=search" method="post">
					<div class="tt-autocomplete">
						<div class="tt-input tt-input-group tt-input-group--append">
							<!---->
							<!---->
							<input type="text" placeholder="请输入要搜索的内容" autocomplete="off"
								class="tt-input__inner" name="keyword" value="${keyword}">
							<!---->
							<div class="tt-input-group__append">
								<button type="button" class="tt-button tt-button--default"
									onclick="form.submit();">
									<span>搜索</span>
								</button>
							</div>
						</div>

					</div>
				</form>
			</div>
		</div>
		<div>
			<div data-v-73e9c86a="" class="outer">
				<c:if test="${user==null}">
					<div class="login inner">
						<p class="login-msg">登录后可以保存您的浏览喜好、评论、收藏，并与APP同步更可以发布微头条</p>
						<a href="front/login.jsp"><button data-v-4a7e2734=""
								class="login-button">登录</button></a>
						<ul data-v-4a7e2734="" class="third-login">
							<li data-v-4a7e2734="" data-pid="qzone_sns" class="sns qq"><span
								data-v-4a7e2734="">QQ</span></li>
							<li data-v-4a7e2734="" data-pid="weixin" class="sns weixin"><span
								data-v-4a7e2734="">微信</span></li>
						</ul>
					</div>
				</c:if>
				<c:if test="${user !=null}">
					<div class="login inner">
						<div height="50px"></div>
						<h2 class="">欢迎你！${user.username}</h2>
						<a href="front/mine.jsp"><button data-v-4a7e2734=""
								class="login-button">个人中心</button></a> <a
							href="userServlet?action=logout"><button data-v-4a7e2734=""
								class="login-button">退出登录</button></a>
					</div>
				</c:if>
			</div>

		</div>
		<!---->
		<div class="pane-module">
			<div class="module-head">24小时热闻</div>
			<ul ga_event="click_hot_news" class="module-content article-list">
				<c:forEach items="${records}" var="record" varStatus="status">
					<c:if test="${status.index%4==0}">
						<tr>
					</c:if>
					<li class="article-item"><a
						href="newsServlet?action=showDetail&newsid=${record.newsid}"
						target="_blank" class="news-link">
							<div class="module-pic news-pic">
								<img src="${record.picture}" lazy="loaded">
							</div>
							<div class="news-inner">
								<p class="module-title">${record.title}</p>
							</div>
					</a></li>
				</c:forEach>
			</ul>
		</div>

		<div class="pane-module">
			<div class="module-head">友情链接</div>
			<ul class="friend-links-content">
				<li class="item"><a target="_blank" href="http://39.105.4.254/">网站</a>
				</li>
				<li class="item"><a target="_blank"
					href="http://39.105.4.254:81/front/index.html">berry</a></li>
			</ul>
		</div>
		<div class="company">
			<p class="J-company-name">©kay三石</p>
		</div>
</body>

</html>