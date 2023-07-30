/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function updateFileName() {
    const fileInput = document.getElementById('fileName');
    const selectedFile = fileInput.files[0];
    console.log(selectedFile);
    document.getElementById('inputBox').value = selectedFile.name;
}
