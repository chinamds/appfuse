<script type="text/javascript">
    if ($.cookie("username") != null && $.cookie("username") != "") {
        $("#username").val($.cookie("username"));
        $("#password").focus();
    } else {
        $("#username").focus();
    }
    
    function saveUsername(theForm) {
        $.cookie("username",theForm.username.value, { expires: 30, path: "<c:url value="/"/>"});
    }
    
    function validateForm(form) {                                                               
        var valid = validateRequired(form);
        if (valid == false) {
            $(".form-group").addClass('error');
        }
        return valid;
    }

    function passwordHint() {
        if ($("#username").val().length == 0) {
            alert("<s:text name="errors.requiredField"><s:param><s:text name="label.username"/></s:param></s:text>");
            $("#username").focus();
        } else {
            location.href="<c:url value="/passwordHint"/>?username=" + $("#username").val();
        }
    }
    
    function required () { 
        this.aa = new Array("username", "<s:text name="errors.requiredField"><s:param><s:text name="label.username"/></s:param></s:text>", new Function ("varName", " return this[varName];"));
        this.ab = new Array("password", "<s:text name="errors.requiredField"><s:param><s:text name="label.password"/></s:param></s:text>", new Function ("varName", " return this[varName];"));
    }
</script>
