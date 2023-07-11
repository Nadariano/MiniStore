/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function changeSearchType() {
    var searchType = document.getElementById("searchType").value;
    if (searchType === "date") {
        document.getElementById("dateInputs").style.display = "block";
        document.getElementById("nameInputs").style.display = "none";
    } else {
        document.getElementById("dateInputs").style.display = "none";
        document.getElementById("nameInputs").style.display = "block";
    }
}