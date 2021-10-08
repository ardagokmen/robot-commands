function getInputValue(){
  const Http = new XMLHttpRequest();
  const url='http://localhost:8080/robot';

  var script = document.getElementById("myInput").value;
  Http.open("POST", url);
  Http.setRequestHeader('Content-Type','text/plain');
  Http.send(script);

  Http.onreadystatechange = (e) => {
    if(Http.readyState === XMLHttpRequest.DONE) {
      var status = Http.status;
      if (status === 0 || (status >= 200 && status < 400)) {
        var jsonResponse = JSON.parse(Http.responseText);
        document.getElementById("xrobot").innerHTML = "<b>X:</b> " + jsonResponse.positionX;
        document.getElementById("yrobot").innerHTML = "<b>Y:</b> " + jsonResponse.positionY;
        document.getElementById("direction").innerHTML = "<b>FACING:</b> " + jsonResponse.direction;
        makeTableHTML(jsonResponse.positionX,jsonResponse.positionY);

      } else {
        alert(Http.responseText);
      }
    }
  }

}

function makeTableHTML(x, y) {

  var result = "<table border=1>";
  for(var i=0; i<5; i++) {
    result += "<tr>";
    for(var j=0; j<5; j++){
      if(i === y && j === x){
        result += "<td bgcolor=red> </td>";
      } else {
        result += "<td> </td>";
      }

    }
    result += "</tr>";
  }
  result += "</table>";
  document.getElementById('table').innerHTML = result;
}

function getPosition(){
  const Http = new XMLHttpRequest();
  const url='http://localhost:8080/robot';

  Http.open("POST", url);
  Http.setRequestHeader('Content-Type','text/plain');
  Http.send("WAIT");

  Http.onreadystatechange = (e) => {
    if(Http.readyState === XMLHttpRequest.DONE) {
      var status = Http.status;
      if (status === 0 || (status >= 200 && status < 400)) {
        var jsonResponse = JSON.parse(Http.responseText);
        document.getElementById("xrobot").innerHTML = "<b>X:</b> " + jsonResponse.positionX;
        document.getElementById("yrobot").innerHTML = "<b>Y:</b> " + jsonResponse.positionY;
        document.getElementById("direction").innerHTML = "<b>FACING:</b> " + jsonResponse.direction;
        makeTableHTML(jsonResponse.positionX,jsonResponse.positionY);

      } else {
        alert(Http.responseText);
      }
    }
  }

}

