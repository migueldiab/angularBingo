/**
 * User: migueldiab
 * Date: 30/05/12
 * Time: 11:59 AM
 *
 */

{
    
  var xmlHttp;
  
  function processReqChange()
  {
    if(xmlHttp.readyState==4) {
      
      if (xmlHttp.status == 200) {
        var res;
        if (xmlHttp.responseBody != undefined)
        {
          res = "";
          var a = BinaryToArray(xmlHttp.responseBody).toArray();
          for (var i = 0; i < a.length; i++)
          {
            res += String.fromCharCode(a[i]);
          }
        }
        else
        {
          res = xmlHttp.responseText;
        }
        var amf3msg = decodeAMF(res);
        var o = amf3msg.messages[0].body;
        var bytes = new a3d.ByteArray(res, a3d.Endian.BIG);
        //var jsonO = JSON.stringify(o);
        var bytesO = dumpHex(bytes);
        GLOBAL_SCOPE.next_round = o.name;
        if (console != undefined) {
          console.log(o.newPrizes[0]);
        }
        document.getElementById("response").innerHTML = "<pre>" + bytesO + "</pre>";
        GLOBAL_SCOPE.$apply();
        
      } else {
        alert('error' + xmlHttp.statusText);
      }
    }
  }
  
  function onFormSubmit()
  {
    var url = "/Tango/amfServlet";
    var params = "method=getResults&parm=TestFabian&parm=Test2";
    try  {
      // Firefox, Opera 8.0+, Safari
      xmlHttp=new XMLHttpRequest();
      xmlHttp.overrideMimeType('text/plain; charset=x-user-defined');
    }
    catch (e) {  // Internet Explorer
      try {
        xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      }
      catch (e) {
        try {
          xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch (e) {
          alert("Your browser does not support AJAX!" + e);
        }
      }
    }    
    xmlHttp.onreadystatechange = processReqChange;
    xmlHttp.open("POST", url, true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
  }

  
}