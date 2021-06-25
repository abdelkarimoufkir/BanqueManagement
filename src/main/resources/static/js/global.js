function ShowHide() {
		var cp2 = document.getElementById("codeCompte2");
		var montant = document.getElementById("montant");
        var operation = document.getElementById("operationTypeCode");
        var op = document.forms["form1"]["operationTypeCode"].value;
        	
        cp2.style.display = (op == "Virement" ) ?  "block" :  "none";
        cp2 = (op == "Virement") ?  $(".codecompte2").prop('required',true) :  $(".codecompte2").prop('required',false);
   }
  
