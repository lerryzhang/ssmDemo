<#macro user>
<#assign base=request.contextPath />
	
	
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
	
	
	
	<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#"> <span
					class="menu-text"></span> </a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
	try {
		ace.settings.check('sidebar', 'fixed')
	} catch (e) {
	}
</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div>
					<!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
						<li class="active">
							<a href="${base}/user/index.shtml"> <i class="icon-dashboard"></i> <span
								class="menu-text"> 控制台 </span> </a>
						</li>

					
						

						<li>
							<a href="#" class="dropdown-toggle"> <i class="icon-list"></i>
								<span class="menu-text"> 表格 </span> <b
								class="arrow icon-angle-down"></b> </a>

							<ul class="submenu">
								<li>
									<a href="${base}/user/list.shtml"> <i
										class="icon-double-angle-right"></i>用户列表</a>
								</li>

								<li>
									<a href="${base}/permission/index.shtml"> <i class="icon-double-angle-right"></i>
										权限列表</a>
								</li>
								
								<li>
									<a href="${base}/role/index.shtml"> <i class="icon-double-angle-right"></i>
										角色列表</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#" class="dropdown-toggle"> <i class="icon-edit"></i>
								<span class="menu-text"> 表单 </span> <b
								class="arrow icon-angle-down"></b> </a>

							<ul class="submenu">
								<li>
									<a href="form-elements.html"> <i
										class="icon-double-angle-right"></i> 表单组件 </a>
								</li>

								<li>
									<a href="form-wizard.html"> <i
										class="icon-double-angle-right"></i> 向导提示 &amp; 验证 </a>
								</li>

								<li>
									<a href="wysiwyg.html"> <i class="icon-double-angle-right"></i>
										编辑器 </a>
								</li>

								<li>
									<a href="dropzone.html"> <i class="icon-double-angle-right"></i>
										文件上传 </a>
								</li>
							</ul>
						</li>

						<li>
							<a href="widgets.html"> <i class="icon-list-alt"></i> <span
								class="menu-text"> 插件 </span> </a>
						</li>

						<li>
							<a href="calendar.html"> <i class="icon-calendar"></i> <span
								class="menu-text"> 日历 <span
									class="badge badge-transparent tooltip-error"
									title="2&nbsp;Important&nbsp;Events"> <i
										class="icon-warning-sign red bigger-130"></i> </span> </span> </a>
						</li>

						<li>
							<a href="gallery.html"> <i class="icon-picture"></i> <span
								class="menu-text"> 相册 </span> </a>
						</li>

						<li>
							<a href="#" class="dropdown-toggle"> <i class="icon-tag"></i>
								<span class="menu-text"> 更多页面 </span> <b
								class="arrow icon-angle-down"></b> </a>

							<ul class="submenu">
								<li>
									<a href="profile.html"> <i class="icon-double-angle-right"></i>
										用户信息 </a>
								</li>

								<li>
									<a href="inbox.html"> <i class="icon-double-angle-right"></i>
										收件箱 </a>
								</li>

								<li>
									<a href="pricing.html"> <i class="icon-double-angle-right"></i>
										售价单 </a>
								</li>

								<li>
									<a href="invoice.html"> <i class="icon-double-angle-right"></i>
										购物车 </a>
								</li>

								<li>
									<a href="timeline.html"> <i class="icon-double-angle-right"></i>
										时间轴 </a>
								</li>

								<li>
									<a href="login.html"> <i class="icon-double-angle-right"></i>
										登录 &amp; 注册 </a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#" class="dropdown-toggle"> <i class="icon-file-alt"></i>

								<span class="menu-text"> 其他页面 <span
									class="badge badge-primary ">5</span> </span> <b
								class="arrow icon-angle-down"></b> </a>

							<ul class="submenu">
								<li>
									<a href="faq.html"> <i class="icon-double-angle-right"></i>
										帮助 </a>
								</li>

								<li>
									<a href="error-404.html"> <i
										class="icon-double-angle-right"></i> 404错误页面 </a>
								</li>

								<li>
									<a href="error-500.html"> <i
										class="icon-double-angle-right"></i> 500错误页面 </a>
								</li>

								<li>
									<a href="grid.html"> <i class="icon-double-angle-right"></i>
										网格 </a>
								</li>

								<li>
									<a href="blank.html"> <i class="icon-double-angle-right"></i>
										空白页面 </a>
								</li>
							</ul>
						</li>
					</ul>
					<!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left"
							data-icon1="icon-double-angle-left"
							data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
	try {
		ace.settings.check('sidebar', 'collapsed')
	} catch (e) {
	}
</script>
				</div>
				</#macro>