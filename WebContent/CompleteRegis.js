function master()
{
			var p=document.updatereg.idproof.value;
		var addp=document.updatereg.AddressProof.value;
		var img=document.updatereg.image.value;
		var addimg=document.updatereg.AddressImage.value;
		var ipos=img.lastIndexOf(".");
		var apos=addimg.lastIndexOf(".");
		var i=ipos+1;
		var j=ipos+2;
		var k=ipos+3;
		var l=ipos+4;
		var a=img.charAt(i);
		var b=img.charAt(j);
		var c=img.charAt(k);
		var d=img.charAt(l);
		var format1=a+b+c+d;
		alert(format1);
		
		var ii=apos+1;
		var jj=apos+2;
		var kk=apos+3;
		var ll=apos+4;
		var aa=addimg.charAt(ii);
		var bb=addimg.charAt(jj);
		var cc=addimg.charAt(kk);
		var dd=addimg.charAt(ll);
		var format=aa+bb+cc+dd;
		alert(format);
		
		
		if((p.length!=0)&&(p=="Id Skip"))
		{
			alert("Please select an id proof for completing the registration")
			return false;
		}
		
		else if((p.length!=0)&&(p!="Id Skip")&&(img.length==0))
		{
			alert("Please upload the image for the id proof");
			return false;
		}
		
		else if((img.length!=0)&&(format1!="jpeg")&&(format1!="jpg")&&(format1!="bmp")&&(format1!="png"))
		{
			alert("Please upload the ID PROOF image with format like .jpeg,.jpg,.bmp,or .png only ");
			return false;
		}
		if((addp.length!=0)&&(addp=="Address Skip"))
		{
			alert("Please select an address proof  for completing the registration")
			return false;
		}
		
		else if((addp.length!=0)&&(addp!="Address Skip")&&(addimg.length==0))
		{
			alert("Please upload the image for the address proof");
			return false;
		}
		else if((addimg.length!=0)&&(format!="jpeg")&&(format!="jpg")&&(format!="bmp")&&(format!="png"))
		{
			alert("Please upload the ADDRESS PROOF image with format like .jpeg,.jpg,.bmp,or .png only ");
			return false;
		}
		else if((p.length!=0)&&(p=="Id Skip")&&(img.length!=0))
				{
			alert("Please select an idproof for the idproof image");
			return false;
				}
		else if((addp.length!=0)&&(addp=="Address Skip")&&(addimg.length!=0))
		{
	alert("Please select an address proof for the address proof image");
	return false;
		}
		else if((p.length!=0)&&(p=="Id Skip")&&(addp!="Address Skip"))
		{
			alert("Please fill both the proofs together.");
			return false;
		}
		
		else if((addp.length!=0)&&(p!="Id Skip")&&(addp=="Address Skip"))
		{
			alert("Please fill both the proofs together.");
			return false;
		}
		
		else
		{
			return true;
		}
	}

