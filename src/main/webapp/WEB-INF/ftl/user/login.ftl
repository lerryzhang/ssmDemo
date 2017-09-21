<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>登录页面 - Bootstrap后台管理系统模版Ace下载</title>
		<meta name="keywords"
			content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
		<meta name="description"
			content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />


		<script src="${base}/assets/js/jquery-2.0.3.min.js"></script>

		<!-- basic styles -->

		<link href="${base}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${base}/assets/css/font-awesome.min.css" />

		<script src="${base}/assets/js/layer/layer.js"></script>
		<script src="${base}/assets/js/MD5.js"></script>


		<!--[if IE 7]>
		  <link rel="stylesheet" href="${base}/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<!-- fonts -->

		<link rel="stylesheet"
			href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->

		<link rel="stylesheet" href="${base}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${base}/assets/css/ace-rtl.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${base}/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${base}/assets/js/html5shiv.js"></script>
		<script src="${base}/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">Ace</span>
									<span class="white">Application</span>
								</h1>
								<h4 class="blue">
									&copy; 合肥德远通信科技有限公司
								</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box"
									class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i> Please Enter Your
												Information
											</h4>

											<div class="space-6"></div>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right"> <input
																type="text" class="form-control" id="username"
																placeholder="Username" /> <i class="icon-user"></i> </span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right"> <input
																type="password" class="form-control" id="password"
																placeholder="Password" /> <i class="icon-lock"></i> </span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" id="rememberMe" class="ace" />
															<span class="lbl"> Remember Me</span>
														</label>

														<button type="button" id="login"
															class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i> Login
														</button>
													</div>

													<div class="error">
														<span>+</span>
													</div>
												</fieldset>
											</form>

											<div class="social-or-login center">
												<span class="bigger-110">Or Login Using</span>
											</div>

											<div class="social-login center">
												<a class="btn btn-primary"> <i class="icon-facebook"></i>
												</a>

												<a class="btn btn-info"> <i class="icon-twitter"></i> </a>

												<a class="btn btn-danger"> <i class="icon-google-plus"></i>
												</a>
											</div>
										</div>
										<!-- /widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="#" onclick="show_box('forgot-box'); return false;"
													class="forgot-password-link"> <i
													class="icon-arrow-left"></i> I forgot my password </a>
											</div>

											<div>
												<a href="#" onclick="show_box('signup-box'); return false;"
													class="user-signup-link"> I want to register <i
													class="icon-arrow-right"></i> </a>
											</div>
										</div>
									</div>
									<!-- /widget-body -->
								</div>
								<!-- /login-box -->

								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="icon-key"></i> Retrieve Password
											</h4>

											<div class="space-6"></div>
											<p>
												Enter your email and to receive instructions
											</p>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right"> <input
																type="email" class="form-control" placeholder="Email" />
															<i class="icon-envelope"></i> </span>
													</label>

													<div class="clearfix">
														<button type="button"
															class="width-35 pull-right btn btn-sm btn-danger">
															<i class="icon-lightbulb"></i> Send Me!
														</button>
													</div>
												</fieldset>
											</form>
										</div>
										<!-- /widget-main -->

										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;"
												class="back-to-login-link"> Back to login <i
												class="icon-arrow-right"></i> </a>
										</div>
									</div>
									<!-- /widget-body -->
								</div>
								<!-- /forgot-box -->

								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="icon-group blue"></i> New User Registration
											</h4>

											<div class="space-6"></div>
											<p>
												Enter your details to begin:
											</p>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right"> <input
																type="email" id="email" class="form-control"
																placeholder="Email" /> <i class="icon-envelope"></i> </span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right"> <input
																type="text" id="Username" class="form-control"
																placeholder="Username" /> <i class="icon-user"></i> </span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right"> <input
																type="passwd" class="form-control" id="passwd"
																placeholder="Password" /> <i class="icon-lock"></i> </span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right"> <input
																id="repasswd" type="password" class="form-control"
																placeholder="Repeat password" /> <i
															class="icon-retweet"></i> </span>
													</label>

													<label class="block">
														<input type="checkbox" class="ace" />
														<span class="lbl"> I accept the <a href="#">User
																Agreement</a> </span>
													</label>

													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="icon-refresh"></i> Reset
														</button>

														<button type="button" id="register"
															class="width-65 pull-right btn btn-sm btn-success">
															Register
															<i class="icon-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" onclick=show_box( 'login-box');
	return
												false;;
class="back-to-login-link"> <i
												class="icon-arrow-left"></i> Back to login </a>
										</div>
									</div>
									<!-- /widget-body -->
								</div>
								<!-- /signup-box -->
							</div>
							<!-- /position-relative -->
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
		</div>


		<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#login')
								.click(
										function() {
											var username = $('#username').val();
											var password = $('#password').val();

											if (username == '') {
												$('#error').fadeOut(
														'fast',
														function() {
															$('#error').css(
																	'top',
																	'27px')
																	.show();
														});
												$('#error').fadeIn(
														'fast',
														function() {
															$('#username')
																	.focus();
														});
												return false;
											}
											if (password == '') {
												$('#error').fadeOut(
														'fast',
														function() {
															$('#error').css(
																	'top',
																	'96px')
																	.show();
														});
												$(this).find('#error').fadeIn(
														'fast',
														function() {
															$('#password')
																	.focus();
														});
												return false;
											}

											data = {
												password : MD5(password),
												username : username,
												rememberMe : $("#rememberMe")
														.is(':checked')
											};
                                           var load = layer.load();
											$
													.ajax( {
														url : "${base}/user/login.shtml",
														data : data,
														type : "post",
														dataType : "json",
														beforeSend : function() {
															layer.msg('开始登录，请注意后台控制台。');
														},
														success : function(
																result) {
																
												layer.close(load);
															
															if (result
																	&& result.status != 200) {
																layer.msg(result.msg,function(){});
																$("#password")
																		.val('');
																return;
															} else {
															   layer.msg('登录成功！');
				    			
																setTimeout(
																		function() {
																			//登录返回
																			window.location.href= "${base}/user/index.shtml";
																		}, 1000)
															}
														},
														error : function(e) {
															console.log(e,
																	e.message);
															
														}
													});

										});
										
										
										$('#register')
								.click(
										function() {
											var username = $('#Username').val();
											var email = $('#email').val();
											passwd=$('#passwd').val();
											repasswd=$('#repasswd').val();
											
                                            if(passwd!=repasswd){
                                               return layer.msg('2次密码输出不一样！',function(){}),!1;
                                            }
											data = {
												username : username,
												password : passwd,
												email : email
											};
                                           var load = layer.load();
											$
													.ajax( {
														url : "${base}/user/register",
														data : data,
														type : "post",
														dataType : "json",
														beforeSend : function() {
															layer.msg('开始注册，请注意后台控制台。');
														},
														success : function(
																result) {
																
												layer.close(load);
															
															if (result
																	&& result.status != 200) {
																return layer.msg(result.message,function(){}),!1;
															} else {
															   layer.msg('注册成功！');
				    			
																setTimeout(
																		function() {
																			//登录返回
																			window.location.href= "${base}/user/index.shtml";
																		}, 1000)
															}
														},
														error : function(e) {
															console.log(e,
																	e.message);
															
														}
													});

										});
										
										
										
										
										
										
										
										
										
										
										
										

					})
</script>













		<!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
	window.jQuery || document.write("__tag_373$36_" + "__tag_373$83_");
</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${base}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
	if ("ontouchend" in document)
		document.write("__tag_385$48_" + "__tag_385$103_");
</script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
	function show_box(id) {
		jQuery('.widget-box.visible').removeClass('visible');
		jQuery('#' + id).addClass('visible');
	}
</script>
		<div style="display: none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
				language='JavaScript' charset='gb2312'></script>
		</div>
	</body>
</html>
