<div class="ui segment">
	<h3>List of Forms</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">

		<tr>
			<th>AM</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Income</th>
			<th>Family income</th>
			<th>Studying</th>
			<th>Studying city</th>
			<th>City</th>
		</tr>

		<!-- loop over and print our forms -->
		<tr>
			<c:forEach var="tempForms" items="${forms}">


				<td>${tempForms.am}</td>
				<td>${tempForms.first_name}</td>
				<td>${tempForms.last_name}</td>
				<td>${tempForms.income}</td>
				<td>${tempForms.fincome}</td>
				<td>${tempForms.bstudying}</td>
				<td>${tempForms.scity}</td>
				<td>${tempForms.city}</td>
				<td><a class="ui button"
					href="<c:url value="/forms/${tempForms.am}"></c:url>"><i
						class="unhide icon"></i> Edit Form</a><a class="ui button"
					href="<c:url value="/forms/accept/${tempForms.am}"></c:url>"><i
						class="add circle icon"></i>Accept</a>
						<button type="submit" id="${tempForms.am}"
					name="deleteForms"><i class="remove user icon"></i>
					 Decline</button>
		</tr>
		</c:forEach>

	</table>

	<a class="ui button"
		href="${pageContext.request.contextPath}/forms/showAddForm"
		class="item"><i class="add circle icon"></i>Add Form</a>

</div>
<!--${price}  -->

<script type="text/javascript">
	$("[name='deleteForms']").click(
			function() {
				var urlCall = "<c:url value="/api/forms/delete/"></c:url>";
				$.ajax({
					url : urlCall + $(this).attr('id'),
					type : 'DELETE',
					success : function(result) {
						console.log(result);
						$(location).attr("href",
								"<c:url value="/forms/list"></c:url>");
					},
					error : function(result) {
						console.log(result);
					},
				});
			});
</script>