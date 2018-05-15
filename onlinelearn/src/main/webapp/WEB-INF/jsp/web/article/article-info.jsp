<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>文章详情</title>
<script src="${ctx }/static/inxweb/acticle/acticle.js"
	type="text/javascript"></script>
<script src="${ctx }/static/inxweb/comment/comment.js"
	type="text/javascript"></script>
<script type="text/javascript">
	//全局变量 
	var otherId = '${article.articleId}';
	var articleId = '${article.articleId}';
	var type = 1;
	$(function() {
		//添加浏览量
		updateArticleClickNum();
		//好文推荐
		articleRecommend();
		queryComment();
	});
</script>
</head>
<body>
	<div class="bg-fa of">
		<section class="container">
			<section class="i-article">
				<div class="fl col-7">
					<section class="mr30">
						<section class="path-wrap txtOf hLh30">
							<a href="${ctx }" title="首页" class="c-999 fsize14">首页</a> \ <a
								href="/front/articlelist/ealist" title="" class="c-999 fsize14">文章列表</a>
							\ <span class="c-333 fsize14">${edu_Article.title }</span>
						</section>
						<article class="article-infor-box pr20">
							<h3 class="hLh30 txtOf">
								<span class="i-art-title">${edu_Article.title }</span>
							</h3>
							<section class="hLh30 txtOf mt5 pb20 mreadnum">
								<div class="fr">
									<span> <a class="noter-dy vam" title="评论"
										href="#i-art-comment"> <em class="icon18">&nbsp;</em>(<span
											class="totalResultComment">0</span>)
									</a> <tt title="赞一下"
											onclick="addPraise('${edu_Article.articleId}',3)"
											class="noter-zan vam ml5 f-fM">
											<em class="icon18">&nbsp;</em>(<span
												class="addPraise${edu_Article.articleId}_3 praiseCount">0</span>)
										</tt>
									</span>
								</div>
								<div class="fl pt3">
									<%--  <tt class="c-999 f-fM">来源：${article.source }</tt>  --%>
									<tt class="c-999 f-fM">
										<!-- 1小时前发布 -->
										<fmt:formatDate value="${edu_Article.publishTime }"
											pattern="yyyy-MM-dd HH:mm" />
									</tt>
								</div>
							</section>
							<div id="art-infor-body">${edu_Article.edu_Article_Content.content  }
								<div>
									<tt class="c-999 f-fM">
										评论：<span class="totalResultComment">0</span>
									</tt>
									<tt class="c-999 f-fM ml20">
										点赞：<span
											class="addPraise${edu_Article.articleId}_3 praiseCount">0</span>
									</tt>
									<tt class="c-999 f-fM ml20">
										阅读：<span class="clickNum"></span>
									</tt>
								</div>
							</div>


							<section class="mt20 tac" id="sharebutton">
								<div class="bdsharebuttonbox clearfix disIb">
									<div class="pr disIb fl of">
										<a href="javascript:void(0)"
											onclick="addActiclePraise('${edu_Article.articleId}',3)"
											title="" class="zan-icon dz-btn pr"></a>
										<div class="dz-num">
											<span class="c-red fsize16">+1</span>
										</div>
									</div>
									<a title="分享到微信" href="#" class="bds_weixin fl"
										data-cmd="weixin"> <em class="share-fir-icon icon30"></em>
									</a> <a title="分享到新浪微博" href="#" class="bds_tsina fl"
										data-cmd="tsina"></a>
								</div>
								<script>
									window._bd_share_config = {
										"common" : {
											"bdSnsKey" : {},
											"bdText" : "",
											"bdMini" : "2",
											"bdMiniList" : false,
											"bdPic" : "",
											"bdStyle" : "0",
											"bdSize" : "32"
										},
										"share" : {}
									};
									with (document)
										0[(getElementsByTagName('head')[0] || body)
												.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
												+ ~(-new Date() / 36e5)];
								</script>
							</section>
						</article>
						<!-- 文章评论 开始 -->
						<div class="mt30 pr20 mb50 commentHtml">
							<div>

								<h6 class="c-c-content c-infor-title" id="i-art-comment">
									<span class="commentTitle">评论</span>
								</h6>
								<section class="lh-bj-list pr mt20 replyhtml">
									<form action="">
										<ul>
											<li class="unBr">
												<aside class="noter-pic">
													<c:if test="${empty user.picImg }">
														<img width="50" height="50" class="picImg"
															src="${ctx }/static/inxweb/img/avatar-boy.gif">
													</c:if>
													<c:if test="${!empty user.picImg }">
														<img width="50" height="50" class="picImg"
															src="<%=staticImage%>${user.picImg }">
													</c:if>
												</aside>
												<input type="hidden" name="user" value="${user.userId }">
												<div class="of">
													<section class="n-reply-wrap">
														<fieldset>
															<textarea name="" placeholder="输入您要评论的文字"
																id="content"></textarea>
														</fieldset>
														<p class="of mt5 tar pl10 pr10">
															<span class="fl "><tt
																	class="c-red commentContentmeg" style="display: none;"></tt></span>
															<a href="javascript:addComment();" title="回复"
																class="lh-reply-btn">回复</a>
														</p>
													</section>
												</div>
											</li>
										</ul>
									</form>
								</section>
								<c:if test="${empty commentList }">
									<!-- /无数据提示 开始-->
									<section class="no-data-wrap">
										<em class="icon30 no-data-ico">&nbsp;</em> <span
											class="c-666 fsize14 ml10 vam">还没有评论，快来抢沙发吧...</span>
									</section>
									<!-- /无数据提示 结束-->
								</c:if>
								<c:if test="${!empty commentList }">
									<section class="">
										<section class="question-list lh-bj-list pr">
											<ul class="pr10">
												<c:forEach items="${commentList }" var="ac">
													<li>
														<aside class="noter-pic">
															<c:if test="${empty ac.picImg }">
																<img width="50" height="50" class="picImg"
																	src="${ctx }/static/inxweb/img/avatar-boy.gif">
															</c:if>
															<c:if test="${!empty ac.picImg }">
																<img width="50" height="50" class="picImg"
																	src="<%=staticImage%>${ac.picImg }">
															</c:if>
														</aside>
														<div class="of">
															<span class="fl"> <font class="fsize12 c-blue">
																	<c:if test="${empty ac.userName }">
										${ac.email}
									</c:if> <c:if test="${!empty ac.userName }">
										${ac.userName}
									</c:if>
															</font> <font class="fsize12 c-999 ml5">评论：</font></span>
														</div>
														<div class="noter-txt mt5">
															<p>
																<c:out value="${ac.content}"></c:out>
															</p>
														</div>
														<div class="of mt5">
															<span class="fr"><font class="fsize12 c-999 ml5"><fmt:formatDate
																		value="${ac.addTime}" pattern="yyyy/MM/dd HH:mm" /></font></span> <span
																class="fl"> <a class="noter-dy vam" title="回复"
																href="javascript: void(0)"
																onclick="queryCommentReply('${ac.commentId}')"> <em
																	class="icon18">&nbsp;</em>(<span
																	class="replyCount${ac.commentId}">${ac.replyCount}</span>)
															</a> <tt title="赞一下" class="noter-zan vam ml10"
																	onclick="addPraise('${ac.commentId}',4)">
																	<em class="icon18">&nbsp;</em>(<span
																		class="addPraise${ac.commentId}_4 praiseCount">${ac.praiseCount }</span>)
																</tt>
															</span>
														</div>
														<div class="n-reply">
															<section class="n-reply-wrap">
																<fieldset>
																	<textarea name=""
																		class="commentReplyMsgContent${ac.commentId}"></textarea>
																</fieldset>
																<p class="of mt5 tar pl10 pr10">
																	<span class="fl"><tt
																			class="c-red commentReplyMsg${ac.commentId}"></tt></span> <a
																		onclick="addCommentReply('${ac.commentId}')"
																		class="lh-reply-btn" title="回复"
																		href="javascript: void(0)">回复</a>
																</p>
															</section>
															<div
																class="mt10 pl10 pr10 pb10 commentReply${ac.commentId}"></div>
														</div> <!-- /回复盒子 -->
													</li>
												</c:forEach>
											</ul>
										</section>
									</section>
								</c:if>
								<!-- 公共分页 开始 -->
								<jsp:include page="/WEB-INF/jsp/common/ajaxpage.jsp"></jsp:include>
								<!-- 公共分页 结束 -->
							</div>
						</div>
					</section>
				</div>
				<aside class="fl col-3 articleRecommend"></aside>
				<div class="clear"></div>
			</section>
		</section>
		<!-- /文章列表 结束 -->
	</div>
</body>
</html>