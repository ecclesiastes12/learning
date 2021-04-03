
//this one also works
/*$('doucument').ready(function(){
	$('.btn-primary').on('click', function(event){// .editButton is the id for the edit button the location page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/

/*$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){// .editButton is the id for the edit button the location page
		event.preventDefault();//prevent the it from opening the json page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/
//for edit button in location page
$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){
		event.preventDefault();
		
		/**
		 * populate the popup modal with value when the edit button is click
		 * /countries/findById/?id=1 is a url and the id will change depending on
		 * the edit button that will be click
		 * 
		 * (this).attr('href') represent the entire url locationd above
		 */
		
		
		var href = $(this).attr('href');
		//make a request from the url
		//location is a variable and it stores the url request values
		$.get(href, function(location, status){
			$('#idEdit').val(location.id);
			$('#editDescription').val(location.description);
			$('#editCity').val(location.city);
			$('#editAddress').val(location.address);		
			$('#ddlCountryEdit').val(location.countryid);
			$('#ddlStateEdit').val(location.stateid);
			$('#editDetails').val(location.details);
			
			
		});
		$('#editModal').modal(); 
	});
	
	//for details
	$('table #detailsButton').on('click', function(event){
		
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(location, status){
			$('#idDetails').val(location.id);
			$('#ddlCountryDetails').val(location.countryid);
			$('#nameDetails').val(location.name);
			$('#capitalDetails').val(location.capital);
			$('#codeDetails').val(location.code);
			$('#lastModifiedbyDetails').val(location.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T",""));
			
		});
		$('#detailsModal').modal();
	});
	
	
	//for delete button
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		
		var href1 = $(this).attr('href');
		
		//parameter 1 href references  href in confirmDeleteButton
		//parameter 2 href1 references the href variable declared above
		$('#confirmDeleteButton').attr('href', href1);
		
		$('#deleteModal').modal();// select the delete modal
	});
});