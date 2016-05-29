<%-- 
    Document   : footer
    Created on : Apr 30, 2016, 9:45:26 PM
    Author     : marcio.soares <marcio@mail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</div>
            </div>
            <footer id="footer">
              <div class="container">
                <p class="text-muted"><i class="glyphicon glyphicon-registration-mark"></i> IMEG Cosm&eacute;ticos</p>
              </div>
            </footer>
            <script src="<c:url value='/resources/js/vendor/jquery-1.12.4.min.js'></c:url>" type="text/javascript"></script>
            <script src="<c:url value='/resources/js/vendor/bootstrap.min.js'></c:url>" type="text/javascript"></script>
            <script src="<c:url value="/resources/js/vendor/jquery.maskMoney.min.js"/>" type="text/javascript"></script>
            <script src="<c:url value='/resources/js/vendor/tinymce/tinymce.min.js'></c:url>" type="text/javascript"></script>            
            <script src="<c:url value='/resources/js/main.js'></c:url>" type="text/javascript"></script>
            <script type="text/javascript">
                tinymce.init({ selector:'textarea' });
            </script>            
        </body>
    </html>