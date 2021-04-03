
//this one also works
/*$('doucument').ready(function(){
	$('.btn-primary').on('click', function(event){// .editButton is the id for the edit button the employee page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/

/*$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){// .editButton is the id for the edit button the employee page
		event.preventDefault();//prevent the it from opening the json page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/
//for edit button in employee page
$('doucument').ready(function(){
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		
		/**
		 * populate the popup modal with value when the edit button is click
		 * /countries/findById/?id=1 is a url and the id will change depending on
		 * the edit button that will be click
		 * 
		 * (this).attr('href') represent the entire url employeed above
		 */
		
		
		var href = $(this).attr('href');
		//make a request from the url
		//employee is a variable and it stores the url request values
		$.get(href, function(employee, status){

			$('#txtIdEdit').val(employee.id);
			$('#ddlTitleEdit').val(employee.title);
			$('#txtInitialsEdit').val(employee.initials);
			$('#txtSSNEdit').val(employee.socialSecurityNumber);
			$('#txtFirstnameEdit').val(employee.firstname);
			$('#txtLastnameEdit').val(employee.lastname);
			$('#txtOthernameEdit').val(employee.othername);
			$('#ddlGenderEdit').val(employee.gender);
			$('#ddlNationalityEdit').val(employee.countryid);
			$('#txtAddressEdit').val(employee.address);
			
		
			$('#ddlStateEdit').val(employee.stateid);
			$('#txtCityEdit').val(employee.city);
			$('#txtPhoneEdit').val(employee.phone);
			$('#txtMobileEdit').val(employee.mobile);
			$('#ddlMaritalStatusEdit').val(employee.maritalStatus);
			$('#txtEmailEdit').val(employee.email);
			$('#ddlJobTitleEdit').val(employee.jobtitleid);
			$('#ddlEmployeeTypeEdit').val(employee.employeetypeid);
			$('#fupImageEdit').val(employee.photo);
			
			var dob = employee.dateOfBirth.substr(0,10)
			$('#txtDateOfBirthEdit').val(dob);
			$('#txtHireDateEdit').val(employee.hireDate.substr(0,10));
			
		});
		$('#editModal').modal(); 
	});
	
	//for details
	$('table #detailsButton').on('click', function(event){
		
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(employee, status){
			$('#idDetails').val(employee.id);
			$('#descriptionDetails').val(employee.description);
			$('#detailsDetails').val(employee.details);
			$('#lastModifiedByDetails').val(employee.lastModified);
			$('#lastModifiedDateDetails').val(employee.lastModifiedDate.substr(0,19).replace("T"," "));
			
		});
		$('#detailsModal').modal();
	});
	
	
	//for delete button
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		
		var href1 = $(this).attr('href');
		
		//parameter 1 href references  href in confirmDeleteButton
		//parameter 2 href1 references the href1 variable declared above
		$('#confirmDeleteButton').attr('href', href1);
		
		$('#deleteModal').modal();// select the delete modal
	});
	
	//for photo modal
	$('table #photoButton').on('click',function(event){
		event.preventDefault();
		
		var hrefphoto = $(this).attr('href');
		
		//parameter 1 src references  src in photo popup modal
		//parameter 2 hrefphoto references the hrefphoto variable declared above
		
		$('#photoModal #employeePhoto').attr('src',hrefphoto);
		$('#photoModal').modal();
		
	});
});