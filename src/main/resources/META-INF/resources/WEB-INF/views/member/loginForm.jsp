<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
	
		// 회원가입 서브밋
		$("form").on("submit", function(){
			this.action="login";  
			this.method="post";
		});
		
		$("form").on("reset", function(){
			alert("로그인 하지 않기");
			this.action="login";  
		});
		
	});// ready()

</script>

<div class="container">
    <form class="row g-3 m-4">
          <div class="row mb-3">
		      <div>${errorMessage}</div>
		  </div>  
		  <div class="row mb-3">
		    <label for="member_id" class="col-sm-2 col-form-label">아이디</label>
		    <div class="col-auto">
		      <input type="text" class="form-control" id="member_id" name="member_id">
		    </div>
		  </div>
		 <div class="row mb-3">
		    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
		    <div class="col-auto">
		      <input type="password" class="form-control" name="passwd" id="passwd">
		    </div>
		  </div>
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">로그인</button>
		    <button type="reset" class="btn btn-primary">취소</button>
		  </div>
 </form>
</div> 
