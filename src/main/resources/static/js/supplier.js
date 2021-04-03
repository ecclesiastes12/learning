
//this one also works
/*$('doucument').ready(function(){
	$('.btn-primary').on('click', function(event){// .editButton is the id for the edit button the supplier page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/

/*$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){// .editButton is the id for the edit button the supplier page
		event.preventDefault();//prevent the it from opening the json page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/
//for edit button in supplier page
$('doucument').ready(function(){
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		
		/**
		 * populate the popup modal with value when the edit button is click
		 * /countries/findById/?id=1 is a url and the id will change depending on
		 * the edit button that will be click
		 * 
		 * (this).attr('href') represent the entire url supplierd above
		 */
		
		
		var href = $(this).attr('href');
		//make a request from the url
		//supplier is a variable and it stores the url request values
		$.get(href, function(supplier, status){
			$('#idEdit').val(supplier.id);
			$('#nameEdit').val(supplier.name);
			$('#detailsEdit').val(supplier.details);
			$('#websiteEdit').val(supplier.website);
			$('#addressEdit').val(supplier.address);
			$('#ddlStateEdit').val(supplier.stateid);
			$('#ddlCountryEdit').val(supplier.countryid);
			$('#cityEdit').val(supplier.city);
			$('#phoneEdit').val(supplier.phone);
			$('#mobileEdit').val(supplier.mobile);
			$('#emailEdit').val(supplier.email);
			
		});
		$('#editModal').modal(); 
	});
	
	//for details
	$('table #detialsButton').on('click', function(event){
		
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(supplier, status){
			$('#idDetails').val(supplier.id);
			$('#nameDetails').val(supplier.name);
			$('#detailsDetails').val(supplier.details);
			$('#websiteDetails').val(supplier.website);
			$('#addressDetails').val(supplier.address);
			$('#ddlStateDetails').val(supplier.stateid);
			$('#ddlCountryDetails').val(supplier.countryid);
			$('#cityDetails').val(supplier.city);
			$('#phoneDetails').val(supplier.phone);
			$('#mobileDetails').val(supplier.mobile);
			$('#emailDetails').val(supplier.email);
			
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