
//this one also works
/*$('doucument').ready(function(){
	$('.btn-primary').on('click', function(event){// .editButton is the id for the edit button the vehicleHire page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/

/*$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){// .editButton is the id for the edit button the vehicleHire page
		event.preventDefault();//prevent the it from opening the json page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/
//for edit button in vehicleHire page
$('doucument').ready(function(){
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		
		/**
		 * populate the popup modal with value when the edit button is click
		 * /countries/findById/?id=1 is a url and the id will change depending on
		 * the edit button that will be click
		 * 
		 * (this).attr('href') represent the entire url vehicleHired above
		 */
		
		
		var href = $(this).attr('href');
		//make a request from the url
		//vehicleHire is a variable and it stores the url request values
		$.get(href, function(vehicleHire, status){
			$('#idEdit').val(vehicleHire.id);
			$('#ddlVehicleEdit').val(vehicleHire.vehicle.name);
			$('#ddlClientEdit').val(vehicleHire.client.name);
			$('#dateOutEdit').val(vehicleHire.dateOut);
			$('#timeOutEdit').val(vehicleHire.timeOut);
			$('#ddlLocationEdit').val(vehicleHire.location.descrption);
			$('#dateInEdit').val(vehicleHire.dateIn);
			$('#timeInEdit').val(vehicleHire.timeIn);
			$('#priceEdit').val(vehicleHire.price);
			$('#remarksEdit').val(vehicleHire.remarks);
		});
		$('#editModal').modal(); 
	});
	
	//for details
	$('table #detailsButton').on('click', function(event){
		
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleHire, status){
			$('#idEdit ').val(vehicleHire.id);
			$('#ddlVehicleEdit').val(vehicleHire.vehicle.name);
			$('#ddlClientEdit').val(vehicleHire.client.name);
			$('#dateOutEdit').val(vehicleHire.dateOut);
			$('#timeOutEdit').val(vehicleHire.timeOut);
			$('#ddlLocationEdit').val(vehicleHire.location.descrption);
			$('#dateInEdit').val(vehicleHire.dateIn);
			$('#timeInEdit').val(vehicleHire.timeIn);
			$('#priceEdit').val(vehicleHire.price);
			$('#remarksEdit').val(vehicleHire.remarks);
			
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