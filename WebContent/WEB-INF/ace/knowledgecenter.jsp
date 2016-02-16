<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/css/zTreeStyle.css" type="text/css">
<title>Insert title here</title>
<jsp:include page="common/js_init.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/top_navbar.jsp"></jsp:include>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<jsp:include page="common/left_sidebar.jsp"></jsp:include>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">Home</a>
						</li>

						<li><a href="#">UI Elements</a></li>
						<li class="active">Treeview</li>
					</ul>
					<!-- .breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="icon-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- #nav-search -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							Treeview <small> <i class="icon-double-angle-right"></i>
								with selectable items(single &amp; multiple) and custom icons
							</small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<input id="cid" type="hidden" value="${cId}" />
							<input id="cname" type="hidden" value="${cName}" />
							<input id="parentId" type="hidden" value="0" />
							<input id="itemId" type="hidden" value="0" />
							<div class="row">
								<div class="col-sm-6">
									<div class="widget-box">
										<div class="widget-header header-color-blue2">
											<h4 class="lighter smaller">${cName}</h4>
										</div>

										<div class="widget-body">
											<div class="widget-main padding-8">
												<ul id="tree" class="ztree"></ul>
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-6" style="display: none;" id="info">
										<div class="widget-header header-color-green2">
											<h4 class="lighter smaller" id="fileTitle">File Content</h4>
										</div>

										<div class="widget-body">
											<div class="form-group">
												<div class="widget-main padding-8">
													<div>
														<label>File Name</label>
														<input type="text" id="filename" placeholder="filename"/>
													</div>
													<div>
														<label>Type</label>

														<select id="type">
															<option value="">&nbsp;</option>
															<option value="folder">Floder</option>
															<option value="item">File</option>
														</select>
													</div>
														
													<div>
														<textarea id="content" rows="30" cols="50" name="editor01">请输入.</textarea>
													</div>
													<input id="add" type="button" onclick="addNode();" value="Add"/>
													<input id="update" type="button" onclick="updateNode();" value="Update"/>
												</div>
											</div>
										</div>
								</div>
							</div>

							<script type="text/javascript">
								var $assets = "assets";//this will be used in fuelux.tree-sampledata.js
							</script>

							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->

			<jsp:include page="common/container_setting.jsp"></jsp:include>
		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->

	<!--<script src="assets/js/jquery-2.0.3.min.js"></script>-->
	<script src="assets/js/jquery-2.0.3.min.js"></script>
	<script src="assets/js/bootstrap-treeview.js"></script>
	<script src="assets/js/jquery.ztree.core-3.5.js"></script>
	<script src="assets/js/jquery.ztree.excheck-3.5.js"></script>
	<script src="assets/js/jquery.ztree.exedit-3.5.js"></script>
	<script src="plugin/ckeditor/ckeditor.js"></script>
	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets\js\jquery-1.10.2.min.js"></script>
<![endif]-->

	<!--[if !IE]> -->

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
	<script src="assets/js/fuelux/fuelux.tree.min.js"></script>

	<!-- ace scripts -->

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->

	<script type="text/javascript">
		CKEDITOR.replaceAll();
		var pid = 0;
		var cname = $("#cname").val();
		var cid = $("#cid").val();
	
		var setting = {
			view: {
				selectedMulti: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			async: {
				enable: true,
				url:"/generaldms/initTree",
				autoParam:["id=pid"],
				otherParam:{"cname":cname,"cid":cid},
				dataFilter: filter
			},
			callback: {
				beforeClick: beforeClick,
				onRemove: onRemove,
				beforeRemove: beforeRemove,
				onClick: onClick
			},
			edit: {
				enable: true,
				editNameSelectAll: true,
				showRemoveBtn: showRemoveBtn,
				showRenameBtn: false
			}
		};
		
		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		};

		function showRemoveBtn(treeId, treeNode) {
			return (!treeNode.isParent&&!treeNode.isFirstNode);
		};

		function onRemove(e, treeId, treeNode) {
			deleteNode(treeNode.id);
		};

		function beforeRemove(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			zTree.selectNode(treeNode);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		};
		
		function beforeClick(treeId, treeNode, clickFlag) {
			//alert("[ "+treeId+" beforeClick ]&nbsp;&nbsp;" + treeNode.name );
			return (treeNode.click != false);
		};

		function onClick(event, treeId, treeNode, clickFlag) {
			//alert($("#parentId").val());
			alert(treeNode.id+" isParent:"+treeNode.isParent);
			var nid = treeNode.id;
			if(treeNode.isParent==true){
				$("#parentId").val(nid);
				$("#filename").val("");
				$("#type").val("");
				CKEDITOR.instances.content.setData("");
				$("#info").css('display','block');
				$("#update").css('display','none');
				$("#add").css('display','block');
			}else{
				$("#info").css('display','block');
				$("#add").css('display','none');
				$("#update").css('display','block');
				$("#itemId").val(nid);
				getNodeInfo(nid);
			}
		};
		
		function initTree(cid,cname,pid) {
			$.ajax({
				type : "post",
				contentType : "application/text;charset=utf-8",
				cache : false,
				url : "/generaldms/initTree?pid=" + pid + "&cid=" + cid + "&cname=" + cname,
				success : function(data) {
					alert(data);
					$("#tdata").val(data);
					var zNodes =    [  { "id":"1","pId":"null","name":"test","isParent":"true" } , { "id":"2","pId":"null","name":"test1" } , { "id":"3","pId":"null","name":"item2","isParent":"true" }  ];
					$.fn.zTree.init($("#tree2"), setting , data);
				}
			});
		};
		
		function getNodeInfo(id){
			$.ajax({
				type:"post",
				dataType:"json",
				contentType:"application/json;charset=utf-8",
				url:"/generaldms/getKmItem?id="+id,
				success:function(data){
					$("#filename").val(data.filename);
					$("#fileTitle").html(data.filename)
					$("#type").val(data.type);
					CKEDITOR.instances.content.setData(data.content);
				}
			});
		}
		
		function updateNode(){
			var itemId = $("#itemId").val();
			var filename = $("#filename").val();
			var content = CKEDITOR.instances.content.getData();
			var kmitem = {
					 	id:itemId,
					 	filename:filename,
					 	content:content
			        };
			var jsonString = JSON.stringify(kmitem);
			$.ajax({
				type:"post",
				dataType:"json",
				url:"/generaldms/updateKm",
				data: jsonString,
				contentType:"application/json;charset=utf-8",
				success:function(resultData){
					if(resultData.isUpate==true){
						alert("成功!");
					}else{
						alert("失败!");
					}
				}
			});
		}
		
		function deleteNode(id){
			$.ajax({
				type:"post",
				dataType:"json",
				contentType:"application/json;charset=utf-8",
				url:"/generaldms/deleteKm?id="+id,
				success : function(data) {
					if(data.isDelete==true){
						alert("删除成功!");
					}else{
						alert("删除失败!");
					}
				}
			});
		}
		
		function addNode(){
			var cid = $("#cid").val();
			var parentId = $("#parentId").val();
			var filename = $("#filename").val();
			var type = $("#type").val();
			var pid = 0;
			var cname = $("#cname").val();
			var content = CKEDITOR.instances.content.getData();
			$.ajax({
				type:"post",
				dataType:"json",
				contentType:"application/json;charset=utf-8",
				url:"/generaldms/addKm?cid="+cid+"&parentid="+parentId+"&filename="+filename+"&content="+content+"&type="+type,
				success : function(data) {
					if(data.isInsert==true){
						$("#filename").val("");
						$("#type").val("");
						CKEDITOR.instances.content.setData("");
						$("#info").css('display','none'); 
						$.fn.zTree.init($("#tree"), setting);
						alert("增加成功!");
					}else{
						alert("增加失败!");
					}
				}
			});
		}
		
		jQuery(function($) {
			$.fn.zTree.init($("#tree"), setting);
		});
	</script>

</body>
</html>
<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?a43c39da34531f4da694d4499c5614d4";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>