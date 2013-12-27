<html>
<head>
<title>I18N Bug Detail</title>
</head>
<body>
	${bug.bugNum} 
	${bug.title}
	<form name="deleteBug" action="${bug.bugNum}?method=delete" method="post">
		<input type="submit" value="Delete" />
	</form>
</body>
</html>