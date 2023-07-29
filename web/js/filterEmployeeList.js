/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#searchUserID").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#example tbody tr").filter(function () {
            $(this).toggle($(this).find('td:eq(0)').text().toLowerCase().indexOf(value) > -1)
        });
    });
    $("#searchUserName").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#example tbody tr").filter(function () {
            $(this).toggle($(this).find('td:eq(1)').text().toLowerCase().indexOf(value) > -1)
        });
    });
    $("#searchFullName").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#example tbody tr").filter(function () {
            $(this).toggle($(this).find('td:eq(2)').text().toLowerCase().indexOf(value) > -1)
        });
    });
    $("#searchAddress").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#example tbody tr").filter(function () {
            $(this).toggle($(this).find('td:eq(4)').text().toLowerCase().indexOf(value) > -1)
        });
    });
    $("#searchPhone").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#example tbody tr").filter(function () {
            $(this).toggle($(this).find('td:eq(5)').text().toLowerCase().indexOf(value) > -1)
        });
    });
    $("#searchEmail").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#example tbody tr").filter(function () {
            $(this).toggle($(this).find('td:eq(6)').text().toLowerCase().indexOf(value) > -1)
        });
    });
    $("#searchRole").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#example tbody tr").filter(function () {
            $(this).toggle($(this).find('td:eq(7)').text().toLowerCase().indexOf(value) > -1)
        });
    });
    $("#searchStatus").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#example tbody tr").filter(function () {
            $(this).toggle($(this).find('td:eq(8)').text().toLowerCase().indexOf(value) > -1)
        });
    });
});