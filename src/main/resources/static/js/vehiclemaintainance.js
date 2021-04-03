
//this one also works
/*$('doucument').ready(function(){
	$('.btn-primary').on('click', function(event){// .editButton is the id for the edit button the vehicleMaintenace page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/

/*$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){// .editButton is the id for the edit button the vehicleMaintenace page
		event.preventDefault();//prevent the it from opening the json page
		$('#editModal').modal(); // .editModal is the id for the modal popup of the edit page
	});
});*/
//for edit button in vehicleMaintenace page
$('doucument').ready(function(){
	$('table .btn-primary').on('click', function(event){
		event.preventDefault();
		
		/**
		 * populate the popup modal with value when the edit button is click
		 * /countries/findById/?id=1 is a url and the id will change depending on
		 * the edit button that will be click
		 * 
		 * (this).attr('href') represent the entire url vehicleMaintenaced above
		 */
		
		
		var href = $(this).attr('href');
		//make a request from the url
		//vehicleMaintenace is a variable and it stores the url request values
		$.get(href, function(vehicleMaintenace, status){
			$('#idEdit').val(vehicleMaintenace.id);
			$('#ddlVehicleEdit').val(vehicleMaintenace.vehicle.name);
			
			$('#remarksEdit').val(vehicleMaintenace.remarks);
			
			$('#ddlSupplierEdit').val(vehicleMaintenace.supplierid);
			$('#priceEdit').val(vehicleMaintenace.price);
			
			var startDate = vehicleMaintenace.startDate.substr(0,10);
			var endDate = vehicleMaintenace.startDate.substr(0,10);
			
			$('#startDate').val(startDate);
			$('#endDate').val(endDate);
		});
		$('#editModal').modal(); 
	});
	
	//for details
	$('table #detailsButton').on('click', function(event){
		
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleMaintenace, status){
			$('#idDetails').val(vehicleMaintenace.id);
			$('#vehicleid').val(vehicleMaintenace.vehicle.name);
			
			$('#remarks').val(vehicleMaintenace.remarks);
			
			$('#supplierid').val(vehicleMaintenace.supplierid);
			$('#priceDetails').val(vehicleMaintenace.price);
			
			var startDate = vehicleMaintenace.startDate.substr(0,10);
			var endDate = vehicleMaintenace.startDate.substr(0,10);
			
			$('#startDate').val(startDate);
			$('#endDate').val(endDate);
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