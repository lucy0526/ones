$(function () {
    $.get("header.html",function (data) {
        $("#header").html(data);
    });

    $.get("common.html",function (data) {
        $("#common").html(data);
    });
    $.get("footer.html",function (data) {
        $("#footer").html(data);
    });
});