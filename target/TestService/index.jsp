<html>
<head>
<script type="text/javascript" src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
  function submitForm() {
	  var name = $("#symbol").val();
	  $.get("http://localhost:8080/TestService/hello?symbol=" + name, function(data, status) {
		  $("#result").text(data);
	  });
  }
</script>
</head>
<body>
<h2>Hello World!</h2>
<input type="text" id="symbol">
<input type="button" id="submit" onclick="submitForm()" value="Submit">
<p id="result"></p>
</body>
</html>
