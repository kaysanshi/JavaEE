<%@ page language="java" import="java.util.*,com.comment.dao.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
   CommentDAO commentDAO=new CommentDAO();
   
   Map<String,Object> record=(Map<String,Object>)request.getAttribute("record");
   int newsid=Integer.parseInt(record.get("newsid").toString());
   //评论列表
   List<Map<String,Object>> comments=commentDAO.getCommentsByProductid(newsid);
   request.setAttribute("comments",comments);

%>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script src="js/slardar.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/detail.css">
</head>

<body>
	<div>
		<div class="toutiao-header">
			<div class="topbar">

				<div class="bui-right">
					<ul class="user-nav-list clearfix">
						<!---->
						<!---->
						<!---->
						<c:if test="${user==null}">
							<li class="nav-login"><a ga_event="nav_login"
								class="tb-link" href="front/login.jsp">登录</a></li>
						</c:if>
						<c:if test="${user!=null}">
							<li class="nav-login1"><a>欢迎你：${user.username}</a></li>
						</c:if>

					</ul>
				</div>
			</div>
			<div class="middlebar">
				<div class="middlebar-inner clearfix" style="width: 1170px;">
					<!--
					     	作者：kaysanshi@163.com
					     	时间：2019-04-12
					     	描述：logo
					     -->
					<div class="bui-left logo-box">
						<a href="/" ga_event="go_home" class="logo-link"><img
							src="image/bb.jpg" class="logo"></a>
					</div>
					<!--
					      	作者：kaysanshi@163.com
					      	时间：2019-04-12
					      	描述：search
					      -->
					<div ga_event="middlebar_search" class="bui-right">
						<form action="newsServlet?action=search" method="post">
							<div class="search-wrap">
								<div class="tt-autocomplete">
									<div class="tt-input tt-input-group tt-input-group--append">
										<!---->
										<!---->
										<input type="text" placeholder="请输入要搜索的内容" autocomplete="off"
											class="tt-input__inner" key="keyword">
										<!---->
										<div class="tt-input-group__append">
											<button type="button" class="tt-button tt-button--default"
												onclick="form.submit();">
												<span></span>搜索
											</button>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<script type="text/javascript">
						function searchnews(){
							
						}
					</script>
				<div class="bui-box container">
					<div class="bui-left index-left">
						<div class="share-box">
							<a href="newsServlet?action=displayNews"
								ga_event="click_comment_anchor" class="share-count"><i
								class="bui-icon "
								style="font-size: 30px; color: rgb(248, 89, 89);"></i> <span>返回</span></a>
						</div>
						<div class="share-box">
							<a href="#comment_area" ga_event="click_comment_anchor"
								class="share-count"><i class="bui-icon icon-comments_anchor"
								style="font-size: 30px; color: rgb(248, 89, 89);"></i> <span>30</span></a>
						</div>
					</div>
					<div class="bui-left index-middle">
						<div class="article-box">
							<h1 class="article-title">${record.title}</h1>
							<div class="article-sub">
								<span class="original">原创</span> <span>${record.addtime}</span>
								<span></span>
							</div>
							<!--
                                	作者：kaysanshi@163.com
                                	时间：2019-04-12
                                	描述：內容
                                -->
							<div class="article-content">${record.content}</div>

						</div>

						<div class="detail-comment">
							<a id="comment_area" href="#"></a>
							<div id="comment">
								<div class="c-header">
									<em>30&nbsp;</em>条评论
								</div>

								<div data-v-7f58aa2c="" class="inputBox">
									<div data-v-7f58aa2c="" class="bui-box">
										<div data-v-7f58aa2c="" class="avatar-wrap avatar-wrap-center">
											<!---->
										</div>
										<form action="newsServlet?action=addcomment" method="post">
											<input type="hidden" name="newsid" value=${record.newsid}>
											<div data-v-7f58aa2c="" class="input-wrap">
												<div data-v-7f58aa2c="" ga_event="click_input_comment"
													class="c-textarea">
													<textarea data-v-7f58aa2c="" placeholder="写下您的评论..."
														name="content"></textarea>
												</div>
												<!-- 如果登录则可以评论 -->
												<c:if test="${user!=null}">
													<div data-v-7f58aa2c="" ga_event="click_publish_comment"
														class="c-action">
														<input type="button" data-v-7f58aa2c="" class="c-submit"
															value="评论" onclick="form.submit();">
													</div>
												</c:if>
											</div>
										</form>
									</div>

								</div>

								<script>
										
									</script>
								<ul>
									<c:forEach items="${comments}" var="record">
										<li class="c-item">
											<div class="c-content">
												<input type="hidden" value="${record.userid}" name="userid">
												<div class="c-user-info">
													<a href="/c/user/71870131792/" target="_blank"
														class="c-user-name">${record.username} </a> <span
														class="c-create-time">${record.addtime}</span>
												</div>
												<p>${record.content}</p>
												<div class="c-footer-action">
													<span ga_event="click_reply_comment" class="c-reply"
														onclick="showinput('${record.username}')">回复</span>
												</div>
												
												<div id="show${record.username}" style="display: none">
													<div data-v-7f58aa2c="" class="inputBox">
														<div data-v-7f58aa2c="" class="bui-box">
															<div data-v-7f58aa2c=""
																class="avatar-wrap avatar-wrap-center">
																<!---->
															</div>
															<!-- 这里换成具体的人物的id 请求的url-->
															<form action="servcie.action" method="post">
																<input type="hidden" name="newsid"
																	value="${record.newsid}"> <input type="hidden"
																	name="userid" value="${user.id}">
																<div data-v-7f58aa2c="" class="input-wrap">
																	<div data-v-7f58aa2c="" ga_event="click_input_comment"
																		class="c-textarea">
																		<textarea data-v-7f58aa2c="" placeholder="写下您的评论..."
																			name="content"></textarea>
																	</div>
																	<!-- 如果登录则可以评论 -->
																	<c:if test="${user!=null}">
																		<div data-v-7f58aa2c=""
																			ga_event="click_publish_comment" class="c-action">
																			<input type="button" data-v-7f58aa2c=""
																				class="c-submit" value="回复" onclick="form.submit();">
																		</div>
																	</c:if>
																</div>
															</form>
														</div>
													</div>
												</div>
												<!---->
											</div>
										</li>
									</c:forEach>
								</ul>
								<script>
										function showinput(param){
											var id="show"+param;
											console.log(id);
											document.getElementById(id).style.display="block";
										}
									</script>
								<!---->
								<!---->

							</div>
						</div>
					</div>
					<!--  <div class="bui-right index-right">
							<div class="pane-module">
								<!--右側頭部
								<div class="user-card">
									<div class="user-card-head">
										
									</div>
									<!--
                                    	作者：kaysanshi@163.com
                                    	时间：2019-04-12
                                    	描述：內容
                                    
									<ul class="user-card-article-list">
										<li class="user-card-article-item">
											<a href="#" target="_blank"></a>
										</li>
									</ul>
									<div class="pane-module">
							
								</div>
							</div>
						-->
</body>

</html>