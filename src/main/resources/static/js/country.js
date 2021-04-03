
//this one also works
/*$('doucument').ready(function(){
	$('#editButton').on('click', function(event){//#editButton is the id for the edit button the country page
		$('#editModal').modal(); //#editModal is the id for the modal popup of the edit page
	});
});*/

/*$('doucument').ready(function(){
	$('table #editButton').on('click', function(event){//#editButton is the id for the edit button the country page
		event.preventDefault();//prevent the it from opening the json page
		$('#editModal').modal(); //#editModal is the id for the modal popup of the edit page
	});
});*/
//for edit button in country page
$('doucument').ready(function(){
	$('table #editButton').on('click', function(event){
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
		//country is a variable and it stores the url request values
		$.get(href, function(country, status){
			$('#idEdit').val(country.id);
			$('#descriptionEdit').val(country.description);
			$('#capitalEdit').val(country.capital);
			$('#codeEdit').val(country.code);
			$('#continentEdit').val(country.continent);
			$('#nationalityEdit').val(country.nationality);
			
		});
		$('#editModal').modal(); 
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