<div class="ui segment">
	<h3>List of Accepted</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">

		<tr>
			<th>AM</th>
			<th>Score</th>
		
		</tr>

		<!-- loop over and print our accepted students -->
		<tr>
			<c:forEach var="tempAccepted" items="${accepted}">


				<td>${tempAccepted.am}</td>
				<td>${tempAccepted.score}</td>
				<td><button type="submit" id="${tempAccepted.am}"
					name="deleteAccepted"><i class="remove user icon"></i>
					 Delete</button>
		</tr>
		</c:forEach>

	</table>
	
	<script type="text/javascript">
	$("[name='deleteAccepted']").click(
			function() {
				var urlCall = "<c:url value="/api/accepted/delete/"></c:url>";
				$.ajax({
					url : urlCall + $(this).attr('id'),
					type : 'DELETE',
					success : function(result) {
						console.log(result);
						$(location).attr("href",
								"<c:url value="/accepted/list"></c:url>");
					},
					error : function(result) {
						console.log(result);
					},
				});
			});
</script>