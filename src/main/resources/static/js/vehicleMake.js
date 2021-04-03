
//this one also works
/*$('doucument').ready(function(){
	$('.btn-primary').on('click', function(event){// .editButton is the id for the edit button the vehicle page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/

/*$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){// .editButton is the id for the edit button the vehicle page
		event.preventDefault();//prevent the it from opening the json page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/
//for edit button in vehicle page
$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){
		event.preventDefault();
		
		/**
		 * populate the popup modal with value when the edit button is click
		 * /countries/findById/?id=1 is a url and the id will change depending on
		 * the edit button that will be click
		 * 
		 * (this).attr('href') represent the entire url vehicled above
		 */
		
		
		var href = $(this).attr('href');
		//make a request from the url
		//vehicle is a variable and it stores the url request values
		$.get(href, function(vehicle, status){
			$('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
			$('#nameAEdit').val(vehicle.name);
			$('#vehicleNumberEdit').val(vehicle.vehicleNumber);
			$('#registrationDateEdit').val(vehicle.website);
			$('#descriptionEdit').val(vehicle.description);
			$('#acquisitionDate').val(vehicle.acquisitionDate);
			$('#ddlvehiclemakeEdit').val(vehicle.vehiclemakeid);
			$('#ddlvehiclemodelEdit').val(vehicle.vehiclemodelid);
			$('#ddlLocationlEdit').val(vehicle.locationid);
			$('#powerEdit').val(vehicle.power);
			$('#fuelCapacityEdit').val(vehicle.fuelCapacity);
			$('#netWeightEdit').val(vehicle.netWeight);
			$('#remarksEdit').val(vehicle.remarks);
			$('#ddlEmployeeslEdit').val(vehicle.vehiclestatusid);
			$('#ddlCurrentStatuslEdit').val(vehicle.vehiclestatusid);
			$('#fupImageEdit').val(vehicle.photo);
		});
		$('#editModal').modal(); 
	});
	
	//for details
	$('table #detailsButton').on('click', function(event){
		
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicle, status){
			$('#idDetails').val(vehicle.id);
			$('#descriptionDetails').val(vehicle.description);
			$('#detailsDetails').val(vehicle.details);
			
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