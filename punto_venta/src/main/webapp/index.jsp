<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript">
	function registerUser() {
		var uname = $("#uname").val();
		var udeg = $("#udeg").val();
		var uemail = $("#uemail").val();
		var upass = $("#upass").val();
		$.ajax({
			type : "POST",
			url : "registeruser.action",
			data : "uname=" + uname + "&udeg=" + udeg + "&uemail=" + uemail	+ "&upass=" + upass,
			success : function(data) {
				var ht = data.msg;
				$("#resp").html(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	}
</script>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">CRUD</a>
			</div>
			<ul class="nav navbar-nav">
				<li>
					<a href="#">Register</a>
				</li>
				<li>
					<a href="report.jsp">Report</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="col-lg-5">
			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="text" name="uname" id="uname" class="form-control input-sm" placeholder="Full Name">
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="text" name="udeg" id="udeg" class="form-control input-sm" placeholder="Designation">
					</div>
				</div>
			</div>
			<div class="form-group">
				<input type="text" name="uemail" id="uemail" class="form-control input-sm" placeholder="Email">
			</div>
			<div class="form-group">
				<input type="password" name="upass" id="upass" class="form-control input-sm" placeholder="Password">
			</div>
			<button onclick="registerUser();" type="button" class="btn btn-success btn-block">Register</button>
			<div class="text-center" id="resp" style="margin-top: 14px;"></div>
		</div>
	</div>
</body>
</html>