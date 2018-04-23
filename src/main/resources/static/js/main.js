$(function() {
    $("#logout").on("click",function(e) {
        e.preventDefault(); // cancel the link itself
        $.post(this.href,function(data) {
            $("@{/logout}").html(data);
        });
    });
});



