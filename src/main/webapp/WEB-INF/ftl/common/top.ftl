<#macro top index>
<#assign base=request.contextPath />


        <script src="${base}/assets/js/jquery-2.0.3.min.js"></script>
        <script src="${base}/assets/js/layer/layer.js"></script>
		<link href="${base}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${base}/assets/css/font-awesome.min.css" />
		
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
		<link rel="stylesheet" href="${base}/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${base}/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="${base}/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${base}/assets/js/html5shiv.js"></script>
		<script src="${base}/assets/js/respond.min.js"></script>
		<![endif]-->
	
	<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							后台管理系统(lerry.zhang)
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${base}/assets/avatars/user.jpg"/>
								<span class="user-info">
									<small>欢迎光临,</small>
									<#if Session.username?exists> 
                                      ${Session.username}
                                    </#if>
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-user"></i>
										个人资料
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#"  id="logout" >
										<i class="icon-off" ></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>
		
		
		
<script type="text/javascript">


$(document)
			.ready(
			
			function() {
		
			
			$('#logout')
								.click(
										function() {
										
										
										$
													.ajax( {
														url : "${base}/user/logout.shtml",
													
														type : "get",
														dataType : "json",
														
														success : function(
																result) {
																
												
															
															if (result
																	&& result.status != 200) {
																
																return;
															} else {
															  
				    			
																setTimeout(
																		function() {
																			//登录返回
																			window.location.href= "${base}/user/indexs.shtml";
																		}, 1000)
															}
														},
														error : function(e) {
															console.log(e,
																	e.message);
															
														}
													});
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										})
			
			
			
			
			}
			)



	
</script>

</#macro>


		