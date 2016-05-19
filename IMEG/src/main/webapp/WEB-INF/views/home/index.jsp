<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
            <%-- CONTEÚDO DE HOME/INDEX --%>
<div id="carousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
<!--   <ol class="carousel-indicators">
    <li data-target="#carousel" data-slide-to="0" class="active"></li>
  </ol>
 -->
  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item">
      <img src="resources/img/imeg-carousel.png" alt="">
      <div class="carousel-caption">
      </div>
    </div>
    <div class="item">
      <img src="resources/img/imeg-carousel-III.jpg" alt="">
      <div class="carousel-caption">
      </div>
    </div>      
    <div class="item active">
      <img src="resources/img/imeg-carousel-IV.jpg" alt="">
      <div class="carousel-caption">
      </div>
    </div>  
    <div class="item">
      <img src="resources/img/imeg-carousel-V.jpg" alt="">
      <div class="carousel-caption">
      </div>
    </div>        
  </div>
 <!-- Controls -->
  <a class="left carousel-control" href="#carousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<div class="col-lg-4">
    <header>
        <h4>Saúde</h4>
    </header>
	<p>Suspendisse potenti. Maecenas sollicitudin enim at viverra posuere. Phasellus erat augue, imperdiet ac facilisis eget, convallis eu libero. Morbi in sapien sed arcu semper laoreet. In nec sapien nec nisl pretium aliquet eget vel sem. Sed pulvinar faucibus dui. Aliquam mattis ex commodo, ornare nulla ut, pulvinar sem. Phasellus quam felis, pharetra eget mi ac, mollis tristique turpis. Proin iaculis quis mi in laoreet. Sed a neque ornare, pellentesque risus id, mattis libero. Suspendisse vehicula, erat dignissim lobortis pharetra, odio felis bibendum lectus, eu consectetur lectus tortor sit amet dui. Donec pretium eros vitae libero pretium, et ullamcorper justo dapibus. Vestibulum vestibulum sagittis lorem quis vestibulum. Nunc pharetra, turpis vitae pharetra finibus, arcu metus bibendum risus, non rutrum ante erat id risus. Nullam mattis metus vitae quam ullamcorper tempor. Nam condimentum odio convallis, blandit purus ac, lacinia quam.
	<div class="col-lg-12">
		<a href="#">Veja Mais...<i class="glyphicon glyphicon-zoom-in"></i></a>
	</div>
	</p>
</div>
<div class="col-lg-4">
    <header>
        <h4>Beleza</h4>
    </header>
	<p>Phasellus placerat eget ante vel suscipit. Suspendisse quis lacinia velit, scelerisque condimentum est. Maecenas vulputate consequat orci, quis lobortis dui condimentum a. Aliquam sollicitudin suscipit vestibulum. Donec tincidunt quis tellus sed fermentum. Phasellus eu massa facilisis, interdum augue sit amet, posuere sapien. Fusce eleifend consectetur ultricies. Duis mi mi, convallis fermentum egestas eu, fermentum et nunc. Nullam ac euismod tortor, vitae pharetra orci. Vivamus aliquet ex enim. Cras turpis ex, porttitor sit amet justo ac, vehicula semper metus. Fusce id ornare elit, sed molestie odio. In hac habitasse platea dictumst. Cras malesuada lacus blandit, vulputate nulla posuere, mattis lectus. Nullam eu varius magna. Aenean suscipit felis tristique metus aliquet, in pellentesque mi sodales.
	<div class="col-lg-12">
		<a href="#">Veja Mais...<i class="glyphicon glyphicon-zoom-in"></i></a>
	</div>
	</p>
</div>
<div class="col-lg-4">
    <header>
        <h4>Bem Estar</h4>
    </header>
	<p>Suspendisse potenti. Maecenas sollicitudin enim at viverra posuere. Phasellus erat augue, imperdiet ac facilisis eget, convallis eu libero. Morbi in sapien sed arcu semper laoreet. In nec sapien nec nisl pretium aliquet eget vel sem. Sed pulvinar faucibus dui. Aliquam mattis ex commodo, ornare nulla ut, pulvinar sem. Phasellus quam felis, pharetra eget mi ac, mollis tristique turpis. Proin iaculis quis mi in laoreet. Sed a neque ornare, pellentesque risus id, mattis libero. Suspendisse vehicula, erat dignissim lobortis pharetra, odio felis bibendum lectus, eu consectetur lectus tortor sit amet dui. Donec pretium eros vitae libero pretium, et ullamcorper justo dapibus. Vestibulum vestibulum sagittis lorem quis vestibulum. Nunc pharetra, turpis vitae pharetra finibus, arcu metus bibendum risus, non rutrum ante erat id risus. Nullam mattis metus vitae quam ullamcorper tempor. Nam condimentum odio convallis, blandit purus ac, lacinia quam.
	<div class="col-lg-12">
		<a href="#">Veja Mais...<i class="glyphicon glyphicon-zoom-in"></i></a>
	</div>

	</p>
        <br></br>
</div>
            
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />