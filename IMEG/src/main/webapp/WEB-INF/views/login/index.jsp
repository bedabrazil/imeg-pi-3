<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="header.jsp" />
    <%-- CONTEÚDO DE PRODUTOS/ --%>
    <form action="<c:url value="/login"/>" method="post">
        <div class="col-lg-12 pager">
            <h1>Seja Bem Vindo(a)</h1>
        </div>
        <div class="col-lg-12 pager">
            <h4>Faça seu login para acessar as funcionalidades</h4>
        </div>
        <div class="col-lg-12 form-space">
            <div class="col-lg-4"></div>
            <div class="col-lg-4 form-space">
                <label for="email_funcionario">Email</label>
                <input name="email_funcionario" id="email_funcionario" type="text" class="form-control">
            </div>
            <div class="col-lg-4"></div>
        </div>    
        <div class="col-lg-12 form-space">
            <div class="col-lg-4"></div>
            <div class="col-lg-4 form-space">
                <label for="senha_funcionario">Senha</label>
                <input name="senha_funcionario" id="senha_funcionario" type="password" class="form-control">
            </div>
            <div class="col-lg-4"></div>        
        </div>
        <div class="col-lg-12 form-space pager">
            <div class="col-lg-3"></div>
            <div class="col-lg-4 col-lg-offset-1 form-space">
                <input name="commit" id="commit" type="submit" class="btn btn-default" value="Logon">
            </div>
            <div class="col-lg-3"></div>        
        </div>
    </form>
    
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />