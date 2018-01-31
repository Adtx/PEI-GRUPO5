<%--
  Created by IntelliJ IDEA.
  User: andrepinto
  Date: 14/11/17
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    hr.star-primary:after {
        background-color: #18bc9c;
    }
</style>

<script src="Chart.min.js"></script>

</head>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="/Anansi/">Anansi</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="/Anansi/writing">
                        <i class="fa fa-pencil"></i> EVALUATE
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="/Anansi/profile">
                        <i class="fa fa-bar-chart"></i> STATISTICS
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<!-- Contact Section -->
<section id="test" style="background-color:#18bc9c; margin-top:25px;">
    <div class="container" >
        <br><br>
        <!--
        <h6 class="text-center" style="color:black">Histórico de avaliações</h6>
        <p class="text-center" style="color:black">Pode visualizar, no gráfico seguinte, a sua evolução global.</p>
        -->
        <h6 class="text-center" style="color:black">Evaluation result</h6>
        <p class="text-center" style="color:black">The following statistics present the results of your last evaluation</p>

        <hr class="star-primary" style="background-color:#18bc9c;">
        <br>
        <div class="row">
            <div class="container" style="width:66%; text-align:center">
                <h1 style="text-transform:capitalize">CEFR level:</h1>
                <h1 style="font-size:6rem">${info}</h1>
            </div>
        </div>
    </div>
</section>

<div class="well"></div>



<!-- Footer -->
<footer class="text-center">
    <!--
    <div class="footer-above">
      <div class="container">
        <div class="row">
          <div class="footer-col col-md-4">
            <h3>Location</h3>
            <p>3481 Melrose Place
              <br>Beverly Hills, CA 90210</p>
          </div>
          <div class="footer-col col-md-4">
            <h3>Around the Web</h3>
            <ul class="list-inline">
              <li class="list-inline-item">
                <a class="btn-social btn-outline" href="#">
                  <i class="fa fa-fw fa-facebook"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn-social btn-outline" href="#">
                  <i class="fa fa-fw fa-google-plus"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn-social btn-outline" href="#">
                  <i class="fa fa-fw fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn-social btn-outline" href="#">
                  <i class="fa fa-fw fa-linkedin"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn-social btn-outline" href="#">
                  <i class="fa fa-fw fa-dribbble"></i>
                </a>
              </li>
            </ul>
          </div>
          <div class="footer-col col-md-4">
            <h3>About Freelancer</h3>
            <p>Freelance is a free to use, open source Bootstrap theme created by
              <a href="http://startbootstrap.com">Start Bootstrap</a>.</p>
          </div>
        </div>
      </div>
    </div>
    -->
    <div class="footer-below">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    Copyright &copy; Anansi 2018
                </div>
            </div>
        </div>
    </div>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top d-lg-none">
        <a class="btn btn-primary js-scroll-trigger" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>
</footer>



    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/freelancer.min.js"></script>

</body>

</html>