/**
 * 
 */

function addTable() {
     
    var myTableDiv = document.getElementById("myDynamicTable");
     
    var table = document.createElement('TABLE');
    table.border='0';
   
    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);
     
    for (var i=0; i<3; i++){
       var tr = document.createElement('TR');
       tableBody.appendChild(tr);
      
       for (var j=0; j<4; j++){
           var td = document.createElement('TD');
           //td.width='75';
           td.appendChild(document.createTextNode("The United States has a much more advanced health care system than Africa."));
           tr.appendChild(td);
       }
    }
    myTableDiv.appendChild(table);
   
}