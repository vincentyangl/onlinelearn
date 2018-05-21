<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>讲师列表</title>
</head>
<body>
	<div id="aCoursesList" class="bg-fa of">
		<!-- /课程列表 开始 -->
		<section class="container"> <header
			class="comm-title all-teacher-title">
		<h2 class="fl tac">
			<span class="c-333">全部讲师</span>
		</h2>
		<section class="c-tab-title"> <a id="subjectAll" title="全部"
			href="${ctx }/front/teacher">全部</a> <c:forEach items="${lists }"
			var="s">
			<a title="${s.subjectName }"
				href="/front/teacher/getBySid/${s.subjectId}">${s.subjectName }</a>
		</c:forEach> </section> </header> <section class="c-sort-box unBr">
		<div>
			<!-- /无数据提示 开始 -->
			<c:if test="${empty list }">
				<section class="no-data-wrap"> <em
					class="icon30 no-data-ico">&nbsp;</em> <span
					class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span> </section>
			</c:if>
			<!-- /无数据提示 结束 -->
			<article class="i-teacher-list">
			<ul class="of">
				<c:if test="${not empty list }">
					<c:forEach var="teacher" items="${list }">
						<li><section class="i-teach-wrap">
							<div class="i-teach-pic">
								<a href="/front/teacher/getById/${teacher.id}"
									title="${teacher.name }"> <c:choose>
										<c:when test="${not empty teacher.picPath }">
											<img src="${teacher.picPath}" alt="">
										</c:when>
										<c:otherwise>
											<img src="/static/inxweb/img/default-tea-img.gif" alt="">
										</c:otherwise>
									</c:choose>
								</a>
							</div>
							<div class="mt10 hLh30 txtOf tac">
								<a href="/front/teacher/getById/${teacher.id}"
									title="${teacher.name }" class="fsize18 c-666">${teacher.name }</a>
							</div>
							<div class="hLh30 txtOf tac">
								<span class="fsize14 c-999">${teacher.career }</span>
							</div>
							<div class="mt15 i-q-txt">
								<p class="c-999 f-fA">${teacher.education}</p>
							</div>
							</section></li>
					</c:forEach>
				</c:if>
			</ul>
			<table width="100%" border="0">
				<tr>
					<td align="center">一共${page.pages }页 <a
						href="/front/teacher${l.id }?page=${page.firstPage}">首页</a>
						<a href="/front/teacher${l.id }?page=${page.prePage}">上一页</a>
						<a
						href="/front/teacher${l.id }?page=${page.nextPage}">下一页</a>
						<a
						href="/front/teacher${l.id }?page=${page.lastPage}">尾页</a></td>
				</tr>
			</table>
			<div class="clear"></div>
			</article>
		</div>
		<!-- 				公共分页 开始 --> <!-- 				<div> --> <%-- 					<form action="${ctx }/front/teacherlist" method="post" id="searchForm"> --%>
		<!-- 						<input type="hidden" name="page.currentPage" id="pageCurrentPage" value="1"> -->
		<%-- 						<input type="hidden" name="queryTeacher.subjectId" id="" value="${subjectId }"> --%>
		<!-- 					</form> --> <%-- 					<jsp:include page="/WEB-INF/jsp/common/front_page.jsp"></jsp:include> --%>
		<!-- 				</div> --> <!-- 				公共分页 结束 --> </section> </section>
		<!-- /课程列表 结束 -->
	</div>

</body>
</html>