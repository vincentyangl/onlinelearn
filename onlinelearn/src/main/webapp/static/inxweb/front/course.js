/**
 * 不同条件查询课程 
 * @param type 1班类型（专业） 2讲师 3排序条件
 * @param keyWord type==1(专业ID) type==2(老师ID) type=3(排序条件)
 */
function submitForm(type,keyWord){
	if(type==1){
		$("input[name='subjectId']").val(keyWord);
	}else if(type==2){
		$("input[name='teacherId']").val(keyWord);
	}else if(type==3){
		$("input[name='pageViewCount']").val(keyWord);
	}else if(type==4){
		if(keyWord=='ONE'||keyWord=='NEW'||keyWord=='FOLLOW'){
			$("input[name='currentPrice']").val('DESCENDING');
		}else if(keyWord=='DESCENDING'){
			$("input[name='currentPrice']").val('ASCENDING');
		}else if(keyWord=='ASCENDING'){
			$("input[name='currentPrice']").val('DESCENDING');
		}
	}else if(type==5){
		$("input[name='addTime']").val(keyWord);
	}
	$("input[name='queryCourse.courseName']").val('');
	$("#searchForm").submit();
}