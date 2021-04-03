
//this one also works
/*$('doucument').ready(function(){
	$('.btn-primary').on('click', function(event){// .editButton is the id for the edit button the state page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/

/*$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){// .editButton is the id for the edit button the state page
		event.preventDefault();//prevent the it from opening the json page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/
//for edit button in state page
$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){
		event.preventDefault();
		
		/**
		 * populate the popup modal with value when the edit button is click
		 * /countries/findById/?id=1 is a url and the id will change depending on
		 * the edit button that will be click
		 * 
		 * (this).attr('href') represent the entire url stated above
		 */
		
		
		var href = $(this).attr('href');
		//make a request from the url
		//state is a variable and it stores the url request values
		$.get(href, function(state, status){
			$('#idEdit').val(state.id);
			$('#ddlCountryEdit').val(state.countryid);
			$('#capitalEdit').val(state.capital);
			$('#codeEdit').val(state.code);		
			$('#nameEdit').val(state.name);
			$('#detailsEdit').val(state.details);
			
			
		});
		$('#editModal').modal(); 
	});
	
	//for details
	$('table #detailsButton').on('click', function(event){
		
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(state, status){
			$('#idEdit').val(state.id);
			$('#ddlCountryDetails').val(state.countryid);
			$('#nameDetails').val(state.name);
			$('#capitalDetails').val(state.capital);
			$('#codeDetails').val(state.code);
			$('#lastModifiedbyDetails').val(state.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T",""));
			
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