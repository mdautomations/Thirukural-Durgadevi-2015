
$(document).ready(function()
{
	
	$('#priority-low').click(function()
	{
		$('#query').attr("placeholder","For Eg : 1-20");	
		$('#query').css('background-color','rgb(255, 255, 255)');
	});
	$('#priority-normal').click(function()
	{
		$('#query').attr("placeholder","For Eg : அடக்கமுடைமை");	
		$('#query').css('background-color','rgb(255, 255, 255)');
	});
	$('#priority-high').click(function()
	{
		$('#query').attr("placeholder","For Eg : அடக்கம்");	
		$('#query').css('background-color','rgb(255, 255, 255)');
	});
	
	$("#query").click(function() 
	{
		$('#query').css('background-color','rgb(255, 255, 255)');
	});
	 $("#process").click(function() 
		{
		 $('#hello').html(" ");
		 	var inputgiven 	= 	$('#query').val();
		 	if(inputgiven.length!=0)
		 	{
		 		if(document.getElementById('priority-low').checked) 
			 	{
			 		var inputgiven 	= 	$('#query').val();
					inputgiven 		= 	inputgiven.split("-");
					$('#hello').html();
					for(var id=inputgiven[0]; id<=inputgiven[1];id++)
					{
						 console.log('#id :: '+id);
						 var htmltoappend=$('#'+id).text();
						 if(htmltoappend.length!=0 && htmltoappend!=undefined && htmltoappend!="" )
						 {
						    	 var kuralhtml = $('#'+id).html();
						    	 $('#containers').hide();
						    	  $('#hello').append(kuralhtml);
						    	  $('#hello').append('<br/>');
						    	  $('#hello').append('<br/>');
						  }
					}
				}
			 	else if(document.getElementById('priority-normal').checked) 
			 	{
					 		$('#hello').html(" ");
					 		var inputgiven 	= 	$('#query').val();
					 		$('#containers').hide();
					 		var kuralhtml = $('#'+inputgiven).html();
					 		$('#hello').append(kuralhtml);
				}
			 	else if(document.getElementById('priority-high').checked) 
			 	{
			 		$('#hello').html(" ");
			 		$('#containers').hide();
			 		var inputgiven 	= 	$('#query').val();
			 		var character=inputgiven.trim().substring(0,3);
			 		for(var kural=1; kural<=1330;kural++)
			 		{
//			 			console.log($('#'+kural).text());
			 			console.log("comes ::"+character);
			 			var kuraltoCheck = $('#'+kural).html();
			 			console.log(kuraltoCheck);
			 			if(kuraltoCheck!=undefined && kuraltoCheck!="")
			 			{
			 				if (kuraltoCheck.indexOf(character) != -1) 
							{
				 				console.log("comes in");
				 				$('#hello').append(kuraltoCheck);
				 				$('#hello').append('<br/>');
				 				$('#hello').append('<br/>');
							}
			 			}
			 			}
				}
		 	}
		 	else
		 	{
		 		$('#query').css('background-color','rgb(212, 190, 190)');
		 	}
		 	
				 
		});
	 	
	 
});
		