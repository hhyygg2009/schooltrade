function reloadCode() {
    $("#code").attr("src", `${webroot}/passport/code?rnd=${Math.random()}`);
}