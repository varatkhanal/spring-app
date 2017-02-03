<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#container{
	    margin: 30px 50px 30px 50px;
	    border: 2px solid #00A;
	    background-color:#FFF;
	}
</style>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
$().ready(function() {
	$('#getZones').on('click',function (e){   
	 
	   $.ajax({
		   type:'GET',
		   url :"/spring-app/zone",
		   dataType: 'json',
		   contentType: "application/json",
		   error: function (msg)
		    { alert(msg.responseText); },
		    success: function (data) {	
		    	$('#row').append(data);
		    	$('#zones').empty();
		    	$.each(data, function () {
		    		   $.each(this, function (name, value) {
		    		      console.log(name + '=' + value);
		    		      var div_data="<option value="+value+">"+value+"</option>";
				            $(div_data).appendTo('#zones'); 
				            
		    		   });
		    	}); 
	            
	         },	   		
	   		error:function(exception){alert('Exception:'+exception);}
		});
	   e.preventDefault();
	});
	$('#getDistricts').click(function (e){          
		   $.ajax({
			   type:'GET',
			   url :"/spring-app/districts",
			   dataType: 'json',
			   contentType: "application/json",
			   error: function (msg)
			    { alert(msg.responseText); },
			    success: function (data) {			    	
			    	$('#districts').empty();
			    	$.each(data, function () {
				    	$.each(data, function () {
				    		   $.each(this, function (name, value) {
				    		      console.log(name + '=' + value);
				    		      var div_data="<option value="+value+">"+value+"</option>";
						            //alert(div_data);
						            $(div_data).appendTo('#districts');
				    		   });
				    	});
			    	});
		            
		         },	
			   error:function(exception){alert('Exeption:'+exception);}
			}); 
		 	e.preventDefault();
	});
	$('#getBoth').on('click',function (e){	
		    $.ajax({
			   type:'GET',
			   url :"/spring-app/Both",
			   dataType: 'json',
			   contentType: "application/json",
			   error: function (msg)
			    { alert(msg.responseText); },
			    success: function (data) {	
			    	/* $('#zones').empty();
			    	$.each(data[1], function () {
			    		   $.each(this, function (name, value) {
			    		      console.log(name + '=' + value);
			    		      var div_data="<option value="+value+">"+value+"</option>";
					            $(div_data).appendTo('#zones'); 
					            
			    		   });
			    	});
			    	$.each(data[2], function () {
			    		   $.each(this, function (name, value) {
			    		      console.log(name + '=' + value);
			    		      var div_data="<option value="+value+">"+value+"</option>";
					            //alert(div_data);
					            $(div_data).appendTo('#districts'); 
					            $('#row').append(name + '=' + value);
			    		   });
			    	});  */
		            
		         },
			   error:function(exception){alert('Exeption:'+exception);}
			}); 
		 	e.preventDefault();
		}); 
});
</script>
</head>
<body class="cointainer">
<div id="row"></div>
<div>
	<ul>
        <li><input type="submit" id="getZones" value="get Zones" name="getZones" /></li>
        <li><input type="submit" id="getDistricts" value="get Districts" name="getDistricts"/></li>
        <li><input type="submit" id="getBoth" value="get Both" name="GetBoth"/></li>
    </ul>
	<div>
		<ul>
			<li>
               <select name="dropdown" id="zones">
                   <option>Select Zones</option>
               </select>
            </li>
            <li>
               <select name="dropdown" id='districts'>
                   <option>Select Districts</option>
               </select>
            </li>          
        </ul>
	</div>	
</div>
</body>
</html>