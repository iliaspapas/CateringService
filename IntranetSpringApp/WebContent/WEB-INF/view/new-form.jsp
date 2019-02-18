<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add Form</h3>

	<form:form action="saveForm" modelAttribute="forms" method="POST" class="ui form">
		<div class="field">
			<label>AM</label> 
			<form:input path="Am"/>
		</div>
		<div class="field">
			<label>First name</label>
			<form:input path="First_name"/>
		</div>
		<div class="field">
			<label>Last name</label> 
			<form:input path="Last_name"/>
		</div>
		<div class="field">
			<label>Income</label> 
			<form:input path="Income"/>
		</div>
		<div class="field">
			<label>Family Income</label> 
			<form:input path="Fincome"/>
		</div>
		<div class="field">
			<label>Brothers Studying</label> 
			<form:input path="Bstudying"/>
		</div>
		
		<div class="field">
			<label>Studying City</label> 
			<form:input path="Scity"/>
		</div>
		
		<div class="field">
			<label>City</label> 
			<form:input path="City"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>