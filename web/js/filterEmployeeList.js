/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addSearchFunctionality(tableID, columnIndexes) {
    columnIndexes.forEach(function (columnIndex) {
        var inputID = "#search" + columnIndex;
        $(inputID).on("input", function () {
            var value = $(this).val().toString().toLowerCase();
            var inputType = $(this).attr('type');
            if (inputType === 'date' && value === '') {
                // Reset table list when date input field is empty
                $(tableID + " tbody tr").show();
            } else {
                $(tableID + " tbody tr").filter(function () {
                    if (inputType === 'date') {
                        $(this).toggle($(this).find('td:eq(' + columnIndex + ')').text().toLowerCase() === value);
                    } else {
                        $(this).toggle($(this).find('td:eq(' + columnIndex + ')').text().toLowerCase().indexOf(value) > -1);
                    }
                });
            }
        });
    });
}



$(document).ready(function () {
    // Add search functionality to user table
    addSearchFunctionality("#userTable", [0, 1, 2, 4, 5, 6, 7, 8]);

    // Add search functionality to report table
    addSearchFunctionality("#reportTable", [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
    addSearchFunctionality("#attendanceTable", [0, 1, 2, 3, 4,10,12]);
});
