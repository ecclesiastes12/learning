
//this one also works
/*$('doucument').ready(function(){
	$('.btn-primary').on('click', function(event){// .editButton is the id for the edit button the vehicleMovemenet page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/

/*$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){// .editButton is the id for the edit button the vehicleMovemenet page
		event.preventDefault();//prevent the it from opening the json page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/
//for edit button in vehicleMovemenet page
$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){
		event.preventDefault();
		
		/**
		 * populate the popup modal with value when the edit button is click
		 * /countries/findById/?id=1 is a url and the id will change depending on
		 * the edit button that will be click
		 * 
		 * (this).attr('href') represent the entire url vehicleMovemenetd above
		 */
		
		
		var href = $(this).attr('href');
		//make a request from the url
		//vehicleMovemenet is a variable and it stores the url request values
		$.get(href, function(vehicleMovemenet, status){
			$('#idEdit').val(vehicleMovemenet.id);
			$('#ddlVehicleEdit').val(vehicleMovemenet.description);
			$('#ddlLocationEdit1').val(vehicleMovemenet.city);
			$('#ddlLocationEdit2').val(vehicleMovemenet.city);
			$('#editDate1').val(vehicleMovemenet.date1);
			$('#editDate2').val(vehicleMovemenet.date2);
			$('#editRemarks').val(vehicleMovemenet.remarks);
		});
		$('#editModal').modal(); 
	});
	
	//for details
	$('table #detailsButton').on('click', function(event){
		
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleMovemenet, status){
			$('#idEdit').val(vehicleMovemenet.id);
			$('#ddlVehicleEdit').val(vehicleMovemenet.description);
			$('#ddlLocationEdit1').val(vehicleMovemenet.city);
			$('#ddlLocationEdit2').val(vehicleMovemenet.city);
			$('#editDate1').val(vehicleMovemenet.date1);
			$('#editDate2').val(vehicleMovemenet.date2);
			$('#editRemarks').val(vehicleMovemenet.remarks);
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