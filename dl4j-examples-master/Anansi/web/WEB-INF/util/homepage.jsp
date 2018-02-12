<%--
  Created by IntelliJ IDEA.
  User: andrepinto
  Date: 14/11/17
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<html lang="en">

<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Freelancer - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="static/css/freelancer.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="/Anansi">Anansi</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fa fa-bars"></i>
        </button>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="/Anansi/companies">For Companies</a>

            </li>
        </ul>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#registar">Register</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Header -->
<header class="masthead">
    <div class="container">
        <img class="img-fluid" src="static/img/logo.png" style="max-height: 200px" alt="">
        <div class="intro-text">
            <span class="name">Welcome!</span>
            <hr class="star-light">
            <span class="skills">Ready for evaluating your CEFR writing level?</span>
        </div>
    </div>
</header>

<!-- Contact Section -->
<section id="login">
    <div class="container">
        <h2 class="text-center">Login</h2>
        <hr class="star-primary">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                <span>${login_fail}</span>
                <form name="sentMessage" id="contactForm1"  accept-charset="ISO-8859-1" action="login" method="post">



                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls">
                            <label>Email</label>
                            <input class="form-control" id="email1" type="email" name="email" placeholder="Email" required data-validation-required-message="Please insert your email.">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls">
                            <label>Password</label>
                            <input class="form-control" id="password1" type="password" name="password" placeholder="Password" required data-validation-required-message="Please inser your password.">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div id="success1"></div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-success btn-lg" id="sendMessageButton1" form="contactForm1" value="Login">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>



<!-- Register Section -->
<section id="registar">
    <div class="container">
        <h2 class="text-center">Register</h2>
        <hr class="star-primary">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                <span>${register_failed}</span>
                <form name="sentMessage" id="contactForm2"  accept-charset="ISO-8859-1" method="post" action="/Anansi/home">
                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls">
                            <label>Nome completo</label>
                            <input class="form-control" id="name" type="text" name="nome" placeholder="Full name" required data-validation-required-message="Please insert your full name.">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls">
                            <label>Email</label>
                            <input class="form-control" id="email" type="email" name="email" placeholder="Email" required data-validation-required-message="Please insert your email.">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls">
                            <label>Número de telemóvel</label>
                            <input class="form-control" id="phone" type="tel" name="telefone" placeholder="Phone number" required data-validation-required-message="Please insert your phone number.">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls">
                            <div class="form-group floating-label-form-group controls">
                                <label>Password</label>
                                <input class="form-control" id="password" type="password" name="pass" placeholder="Password" required data-validation-required-message="Please insert your password.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <br>
                        <div id="success"></div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-success btn-lg" id="sendMessageButton" form="contactForm2" value="Submit"></input>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="text-center">

    <div class="footer-below">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    Copyright &copy; Your Website 2017
                </div>
            </div>
        </div>
    </div>
</footer>

<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
<div class="scroll-top d-lg-none">
    <a class="btn btn-primary js-scroll-trigger" href="/Anansi">
        <i class="fa fa-chevron-up"></i>
    </a>
</div>


<!-- Bootstrap core JavaScript -->
<script src="static/vendor/jquery/jquery.min.js"></script>
<script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="static/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="static/js/jqBootstrapValidation.js"></script>
<script src="static/js/contact_me.js"></script>

<!-- Custom scripts for this template -->
<script src="static/js/freelancer.min.js"></script>

</body>

</html>
