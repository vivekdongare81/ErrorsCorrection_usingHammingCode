
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Raleway"
    />

    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>


<title>Home Page</title>
</head>
<body>

	<div class="afterstats">
		<div class="container-fluid " id="contact"
			style="filter: drop-shadow(1px 1px 4px grey);">
			<div class="row justify-content-evenly" id="contact">
				<div class="col-12  md-5" id="abjustablediv"></div>
				<div class="col-12  md-5"></div>
				<div class="col-sm-4  ">
					<form action="homeServelet" method="post">
						<div class="p-1">
							<div class="mb-3  ">
								<h3>#Error Detection and Correction</h3>
								  <button class="w3-black" disabled>Hamming Code</button>
								 <div
          class=""
          
          style="font-size: 15px"
        >
          <p class="mt-4">
            <h5>* Select Version </h5>
            <select
              name="version"
              size="3"
              multiple="multiple"
              tabindex="1"
              class="selectpicker"
              data-live-search="true"
            >
              <option value="3,1">(3,1)</option>
              <option value="7,4">(7,4)</option>
              <option value="15,11">(15,11)</option>
              <option value="31,26">(31,26)</option>
              <option value="63,57">(63,57)</option>
              <option value="127,120">(127,120)</option>
              <option value="255,247">(255,247)</option>
              <option value="511,502">(511,502)</option>
            
            </select>
          </p>
          
        </div>
        
        
							<div class="mb-3 ">
		
									<br/>
									<h5>* Encoding </h5>
								<textarea name="input" class="form-control"
									placeholder="Input here " id="exampleFormControlTextarea1"
									rows="3"></textarea>
								<br/>
									<button type="submit" name="submit"  value="encode"class="btn btn-secondary">Encode</button>
									<br/><br/>
									<h5>* Decoding </h5>
									<textarea name="errorStr" class="form-control"
									placeholder="Errored Stream here " id="exampleFormControlTextarea2"
									rows="3"></textarea>
									<br/>
									<button type="submit"name="submit" value="decode" class="btn btn-secondary">Decode</button>
							</div>
						
							
						</div>

					</form>
				</div>

			</div>
		</div>
	
</body>
</html>