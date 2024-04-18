/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// A $( document ).ready() block.
$(document).ready(function () {
    $("#bo-submit").click(() => {
        var age = $("#age").val(),
                oxlvl = $("#oxygenLevel").val(),
                gender = $("#gender").val();
        console.log("age : " + age + " fgender" + gender + " oxlvl : " + oxlvl);
        $.ajax({
            url: 'BloodOxygenLevelTestServlet',
            type: 'POST', // or 'GET', 'PUT', 'DELETE'
            data: {age: age, oxygenLevel: oxlvl, gender: gender}, // Optional data to send to the server
            success: function (data) {
                // Handle the response from the server on success
                $("#result").empty().append(data);
                console.log(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                // Handle errors that occur during the AJAX request
            }
        });
    });

    $("#c-submit").click(() => {
        var age = $("#age").val(),
                hdl = $("#hdl").val(),
                total = $("#total").val();
        console.log("age : " + age + " hdl: " + hdl + " total : " + total);

        $.ajax({
            url: 'CholesterolTestCalculatorServlet',
            type: 'POST', // or 'GET', 'PUT', 'DELETE'
            data: {age: age, total: total, hld: hdl}, // Optional data to send to the server
            success: function (data) {
                // Handle the response from the server on success
                $("#result").empty().append(data);
                console.log("result " + data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                // Handle errors that occur during the AJAX request
            }
        });
    });

    $("#d-button").click(() => {
        var age = $("#age").val(),
                bs = $("#bloodSugar").val();
        console.log("age : " + age + " bs: " + bs);
        $.ajax({
            url: 'FastBloodTestCalculatorServlet',
            type: 'POST', // or 'GET', 'PUT', 'DELETE'
            data: {age: age, bloodSugar: bs}, // Optional data to send to the server
            success: function (data) {
                // Handle the response from the server on success
                $("#result").empty().append(data);
                console.log("result " + data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                // Handle errors that occur during the AJAX request
            }
        });
    });
    $("#bp-button").click(() => {
        var age = $("#age").val(),
                d = $("#diastolic").val(),
                s = $("#systolic").val(),
                g = $("#gender").val();
        console.log("age : " + age + " d: " + d + " s " + s + " g : " + g);
        $.ajax({
            url: 'BloodPressureCalculatorServlet',
            type: 'POST', // or 'GET', 'PUT', 'DELETE'
            data: {age: age, diastolic: d, systolic: s, gender: g}, // Optional data to send to the server
            success: function (data) {
                // Handle the response from the server on success
                $("#result").empty().append(data);
                console.log("result " + data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                // Handle errors that occur during the AJAX request
            }
        });
    });

    $("#login").click(() => {
        var name = $("#uname").val(),
                pass = $("#upass").val();
        console.log("name : " + name + " pass : " + pass);
        $.ajax({
            url: 'login',
            type: 'POST', // or 'GET', 'PUT', 'DELETE'
            data: {us: name, pwd: pass}, // Optional data to send to the server
            success: function (data) {
                // Handle the response from the server on success
                console.log(data);
                if (data.indexOf("user not found") > -1) {
                    console.log("not f");
                    $(".error-box").text("User not found");
                }
                if (data.indexOf("logged in") > -1) {
                    console.log("logged in");
                    $(".error-box").text("");
                    location.href = "index.html";
                }
                if (data.indexOf("invalid password") > -1) {
                    console.log("invalid pass");
                    $(".error-box").text("Invalid password!!!");
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                // Handle errors that occur during the AJAX request
            }
        });
    });

});
