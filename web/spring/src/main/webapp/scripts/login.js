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
            alert("<fmt:message key="errors.required"><fmt:param><fmt:message key="label.username"/></fmt:param></fmt:message>");
            $("#username").focus();
        } else {
            location.href="<c:url value="/passwordHint"/>?username=" + $("#username").val();
        }
    }
    
    function requestRecoveryToken() {
        if ($("#username").val().length == 0) {
            alert("<fmt:message key="errors.required"><fmt:param><fmt:message key="label.username"/></fmt:param></fmt:message>");
            $("#username").focus();
        } else {
            location.href="<c:url value="/requestRecoveryToken"/>?username=" + $("#username").val();
        }
    }    
    
    function required () { 
        this.aa = new Array("username", "<fmt:message key="errors.required"><fmt:param><fmt:message key="label.username"/></fmt:param></fmt:message>", new Function ("varName", " return this[varName];"));
        this.ab = new Array("password", "<fmt:message key="errors.required"><fmt:param><fmt:message key="label.password"/></fmt:param></fmt:message>", new Function ("varName", " return this[varName];"));
    } 
</script>
