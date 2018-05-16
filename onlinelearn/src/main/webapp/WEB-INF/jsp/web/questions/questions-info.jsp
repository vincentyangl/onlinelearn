<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>问题详情</title>
</head>
<body>
	<div class="bg-fa of">
		<section class="container">
			<section class="i-question">
				<div class="fl col-7">
					<section class="mr30 pt10">
						<section class="path-wrap txtOf hLh30">
							<a href="${ctx }" title="" class="c-999 fsize14">首页</a>
							\
							<a href="${ctx }/questions/list" title="" class="c-999 fsize14">全部问答</a>
							\ <span class="c-333 fsize14">${questions.title }</span>
						</section>
						<!-- /问题详情 开始 -->
						<div>
							<section class="q-infor-box">
								<div class="pr">
									<aside class="q-head-pic">
										<c:choose>
											<c:when test="${not empty questions.edu_User.picImg }">
												<img src="<%=staticImage %>${questions.edu_User.picImg }" alt="">
											</c:when>
											<c:otherwise>
												<img src="${ctx }/static/inxweb/img/avatar-boy.gif" alt="">
											</c:otherwise>
										</c:choose>
										<p class="hLh30 txtOf"></p>
									</aside>
									<section class="q-txt-box">
										<aside class="q-share">
											<span class="fl" title="分享到："><em class="icon14 q-share-icon mt5">&nbsp;</em></span>
											<div class="fl ml10" style="width: 95px;">
												<div class="bdsharebuttonbox bdshare-button-style0-16" id="bdshare" data-bd-bind="1443601302583" style="right: -160px;">
													<a title="分享到新浪微博" href="#" class="bds_tsina" data-cmd="tsina"></a>
													<a title="分享到微信" href="#" class="bds_weixin" data-cmd="weixin"></a>
													<a title="分享到QQ空间" href="#" class="bds_qzone" data-cmd="qzone"></a>
													<a title="分享到腾讯微博" href="#" class="bds_tqq" data-cmd="tqq"></a>
												</div>
												<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
											</div>
											<div class="clear"></div>
										</aside>
										<h3 class="hLh30 txtOf">
											<em class="icon16 q-tw">&nbsp;</em> <span class="c-blue fsize14"> <c:if test="${empty questions.edu_User.showName }">${questions.edu_User.email }</c:if> <c:if test="${not empty questions.edu_User.showName }">${questions.edu_User.showName }</c:if>
											</span> <span class="c-999 fsize14"> <c:if test="${questions.type==1 }">课程提问</c:if> <c:if test="${questions.type==2 }">学习分享</c:if>
											</span>
										</h3>
									</section>
									<section class="ml50 pl10">
										<div class="mt20">
											<h3 class="hLh30 txtOf">
												<span class="fsize18 c-333 vam">${questions.title }</span>
											</h3>
										</div>
										<div class="i-q-txt mt15">
											
												<span class="c-999 f-fA"><c:out value="${questions.content}"></c:out></span>
											
										</div>
										<div class="mt20 pr10">
											<section class="fr">
												<span> <a href="#" title="评论" class="noter-dy vam">
														<em class="icon18">&nbsp;</em>(<span id="questionsReplyCount">${questions.replyCount }</span>)
													</a> <tt class="noter-zan vam ml10 f-fM" title="赞一下" onclick="addPraise(${questions.id },1,this)">
														<em class="icon18">&nbsp;</em>(<span>${questions.praiseCount }</span>)
													</tt>
												</span>
											</section>
											<span class="c-ccc fl vam">${questions.addTime }</span>
											<section class="fl ml20 pt10">
												<div class="taglist clearfix">
													<c:forEach items="${list.questionsTagRelationList }" var="questionsTag">
														<a title="${questionsTag.tagName }" data-id="${questionsTag.questionsTagId }" onclick="submitForm('${questionsTag.questionsTagId }','questionsTagId')" class="list-tag" href="javascript:;">${questionsTag.tagName }</a>
													</c:forEach>
												</div>
											</section>
											<div class="clear"></div>
										</div>
									</section>
								</div>
								<span id="questionsCommentSpan">
								
								
								<c:if test="${not empty questionsCommentRepList}">
	<!-- /最佳答案 开始-->
	<div class="good-anwer-box">
		<h4 class="g-a-title">
			<span class="bg-green vam"><em class="icon24 mr5">&nbsp;</em>最佳答案</span>
		</h4>
		<section class="good-answer mt10">
			<section class="question-list lh-bj-list pr">
				<ul class="pr10">
					<c:forEach items="${questionsCommentRepList}" var="questionsComment">
						<li>
							<aside class="noter-pic">
								<c:choose>
									<c:when test="${not empty questionsComment.edu_User.picImg}">
										<img src="<%=staticImage %>${questionsComment.edu_User.picImg}" alt="" width="50" height="50">
									</c:when>
									<c:otherwise>
										<img src="${ctx }/static/inxweb/img/avatar-boy.gif" alt="" width="50" height="50">
									</c:otherwise>
								</c:choose>
							</aside>
							<div class="of hLh20">
								<span class="fl"> <font class="fsize12 c-blue"> <c:if test="${not empty questionsComment.edu_User.showName}">${questionsComment.edu_User.showName}</c:if> <c:if test="${empty questionsComment.edu_User.showName }">${questionsComment.edu_User.email }</c:if>
								</font> <font class="fsize12 c-999 ml5">回复：</font></span>
							</div>
							<div class="noter-txt mt5">
								<p><c:out value="${questionsComment.content }"></c:out></p>
							</div>
							<div class="of mt5">
								<span class="fr"><font class="fsize12 c-999 ml5"><fmt:formatDate type="both" value="${questionsComment.addTime }" pattern="yyyy-MM-dd HH:mm" /></font></span> <span class="fl"> <a href="javascript: void(0)" title="回答" class="noter-dy vam"
										onclick="getCommentById(this,${questionsComment.id })">
										<em class="icon18">&nbsp;</em>全部评论(<span>${questionsComment.replyCount }</span>)
									</a> <tt class="noter-zan vam ml10 f-fM" title="赞一下" onclick="addPraise(${questionsComment.id },2,this)">
										<em class="icon18">&nbsp;</em>点赞(<span>${questionsComment.praiseCount }</span>)
									</tt>
								</span>
							</div>
							<div class="n-reply">
								<section class="n-reply-wrap mt10">
									<fieldset>
										<textarea name="" placeholder="输入您要评论的文字" id="commentContent"></textarea>
									</fieldset>
									<p class="of mt5 tar pl10 pr10">
										<span class="fl "><tt class="c-red commentContentmeg" style="display: none;"></tt></span>
										<a href="javascript:addComment();" title="回复" class="lh-reply-btn">回复</a>
									</p>
								</section>
								<input type="hidden" id="" name="" value="${questionsComment.id}" />
								<div class="mt10 pl10 pr10">
									<dl class="n-reply-list">
										<!-- 最佳答案的评论在这里 -->
									</dl>
								</div>
							</div> <!-- /回复盒子 -->
						</li>
					</c:forEach>
				</ul>
			</section>
		</section>
	</div>
	<!-- /最佳答案 结束-->
</c:if>
<!-- /回答列表 开始 -->
<div class="q-i-noter-box">
	<section class="q-i-reply">
		<h6 class="c-c-content c-infor-title">
			<span>问答列表</span>
		</h6>
		<c:if test="${questions.status==0 }">
			<section class="lh-bj-list pr mt20">
				<ul>
					<li class="unBr">
						<aside class="noter-pic">
							<c:choose>
								<c:when test="${not empty user.picImg }">
									<img src="<%=staticImage %>${user.picImg }" alt="" width="50" height="50">
								</c:when>
								<c:otherwise>
									<img src="${ctx }/static/inxweb/img/avatar-boy.gif" alt="" width="50" height="50">
								</c:otherwise>
							</c:choose>
						</aside>
						<div class="of">
							<section class="n-reply-wrap">
								<fieldset>
									<textarea placeholder="输入您要回复的文字" name="questionsComment.content" onkeyup="$(this).parent().next().find('tt').html('');"></textarea>
								</fieldset>
								<p class="of mt5 tar pl10 pr10">
									<span class="fl"><tt class="c-red"></tt></span> <u class="hand mr10 qxBtn c-999" style="display: none;">取消</u>
									<a class="lh-reply-btn" title="回复" href="javascript: void(0)" onclick="addComment(this)">回复</a>
								</p>
							</section>
						</div>
					</li>
				</ul>
			</section>
		</c:if>
	</section>
	<c:if test="${empty questionsCommentList  }">
		<!-- /无数据提示 开始-->
		<section class="no-data-wrap">
			<em class="icon30 no-data-ico">&nbsp;</em> <span class="c-666 fsize14 ml10 vam">还没有人回答，提问者喊你去回答...</span>
		</section>
		<!-- /无数据提示 结束-->
	</c:if>
	<c:if test="${not empty questionsCommentList  }">
		<div class="q-n-r-box">
			<section class="question-list lh-bj-list pr">
				<ul class="pr10">
					<c:forEach items="${questionsCommentList}" var="questionsComment" varStatus="index">
						<li>
							<aside class="noter-pic">
								<c:choose>
									<c:when test="${not empty questionsComment.picImg }">
										<img src="<%=staticImage %>${questionsComment.picImg }" alt="" width="50" height="50">
									</c:when>
									<c:otherwise>
										<img src="${ctx }/static/inxweb/img/avatar-boy.gif" alt="" width="50" height="50">
									</c:otherwise>
								</c:choose>
							</aside>
							<div class="of hLh20">
								<c:if test="${questions.status==0 and  questions.cusId==user.userId and questionsComment.cusId != questions.cusId}">
									<span class="fr"><a href="javascript:void(0)" onclick="acceptComment(${questionsComment.id})" title="" class="comm-btn c-btn-6">采纳为最佳答案</a></span>
								</c:if>
								<span class="fl"> <font class="fsize12 c-blue"> <c:if test="${not empty questionsComment.showName}">${questionsComment.showName}</c:if> <c:if test="${empty questionsComment.showName}">${questionsComment.email}</c:if>
								</font> <font class="fsize12 c-999 ml5">回复：</font></span>
							</div>
							<div class="noter-txt mt5">
								<p><c:out value="${questionsComment.content }"></c:out></p>
							</div>
							<div class="of mt5">
								<span class="fr"><font class="fsize12 c-999 ml5"> <!-- <a href="" class="c-blue mr10">删除</a> --> <fmt:formatDate type="both" value="${questionsComment.addTime}" pattern="yyyy-MM-dd HH:mm" />
								</font></span> <span class="fl"> <a href="javascript: void(0)" title="回答" class="noter-dy vam" onclick="getCommentById(this,${questionsComment.id})">
										<em class="icon18">&nbsp;</em>(<span>${questionsComment.replyCount }</span>)
									</a> <tt class="noter-zan vam ml10" title="赞一下" onclick="addPraise(${questionsComment.id },2,this)">
										<em class="icon18">&nbsp;</em>(<span>${questionsComment.praiseCount }</span>)
									</tt>
								</span>
							</div>

							<div class="n-reply" style="display: none;padding-left: 0;">
								<div>
									<section class="n-reply-wrap mt10">
										<fieldset>
											<textarea name="" onkeyup="$(this).parent().next().find('tt').html('');"></textarea>
										</fieldset>
										<p class="of mt5 tar pl10 pr10">
											<span class="fl"><tt class="c-red"></tt></span><u class="hand mr10 qxBtn c-999" >取消</u>
											<a href="javascript: void(0)" title="回复" class="lh-reply-btn" onclick="addReply(this)">回复</a>
										</p>
									</section>
									<input type="hidden" id="" name="" value="${questionsComment.id}" />
								</div>
								<div class="mt10 pl10 pr10">
									<dl class="n-reply-list">
										<!-- 当前问答回复的所有评论在这里 -->
									</dl>
								</div>
							</div> <!-- /回复盒子 -->
						</li>
					</c:forEach>
				</ul>
			</section>
		</div>
		<!-- 公共分页 开始 -->
<%-- 		<jsp:include page="/WEB-INF/view/common/ajaxpage.jsp"></jsp:include> --%>
		<!-- 公共分页 结束 -->
</div>
<!-- /回答列表 结束 -->
</c:if>
								
								
								</span>
							</section>
						</div>
						/问题列表 结束
					</section>
				</div>
				<aside class="fl col-3">
					<div class="mt30 pl10">
						<section class="pt10">
							<a href="javascript:void(0)" onclick="toAddQuestions()" title="我要提问" class="comm-btn c-btn-5">我要提问</a>
						</section>
						 <section class="pt20">
							<div class="taglist clearfix">
							 	<%-- <form action="${ctx}/questions/list" id="searchForm" method="post">
									<input type="hidden" id="pageCurrentPage" name="page.currentPage" value="1" />
									<input type="hidden" name="questions.orderFalg" value="${questions.orderFalg}" />
									<input type="hidden" name="questions.type" value="${questions.type}" />
									<input type="hidden" name="questions.status" value="${questions.status}" />
									<input type="hidden" name="questions.questionsTagId" value="${questions.questionsTagId}" />
								</form>  --%>
								<c:forEach items="${list }" var="questionsTag">
									<a title="${questionsTag.questionsTagName }" data-id="${questionsTag.questionsTagId }" class="list-tag" href="javascript:;" onclick="submitForm('${questionsTag.questionsTagId }','questionsTagId')">${questionsTag.questionsTagName }</a>
								</c:forEach>
							</div>
						</section> 
						/标签云
						<section class="mt30">
							<section class="c-infor-tabTitle c-tab-title">
								<a href="javascript: void(0)" title="热门问答推荐">热门问答推荐</a>
							</section>
							<div class="q-r-rank-list">
								<ul id="hotQuestions">
									<section class="no-data-wrap">
										<em class="icon30 no-data-ico">&nbsp;</em> <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span>
									</section>
								</ul>
							</div>
						</section>
						/热门问答排行
					</div>
				</aside>
				<div class="clear"></div>
			</section>
		</section>
		/提问题 结束
	</div>
 	<script> 
	var questionsId="${questions.id}"; 
 	</script> 
	<script type="text/javascript" src="${ctx}/static/inxweb/questions/questions_info.js"></script>
	<script type="text/javascript" src="${ctx}/static/inxweb/questions/questions.js"></script>
</body>
</html>