<%--
  Created by IntelliJ IDEA.
  User: andrepinto
  Date: 14/11/17
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">


<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Anansi</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/freelancer.min.css" rel="stylesheet">

    <style>
      hr.star-primary:after {
          background-color: #18bc9c;
      }
    </style>

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
              <a class="nav-link js-scroll-trigger" href="/Anansi/profile">
              <i class="fa fa-bar-chart"></i> STATISTICS</a>
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
        <h6 class="text-center" style="color:black">Escreva um texto sobre as suas atividades extra-curriculares</h6>
        <p class="text-center" style="color:black">É necessário escrever, no mínimo, 30 palavras. Contudo, são esperados textos maiores para níveis superiores.</p>
        -->
        <h6 class="text-center" style="color:black">Write a free text</h6>
        
        
        <!--
        <p class="text-center" style="color:black; font-size:16px;margin-bottom:0px;">(Suggestion 1:<b> Your last holidays</b>)</p>
        <p class="text-center" style="color:black; font-size:16px;">(Suggestion 2:<b> Your hobbies</b>)</p>
        -->

        <p class="text-center" style="color:black"><icon class="fa fa-exclamation-circle" style=""></icon> Your text must contain a minimum of 30 words. However, bigger texts are expected for higher levels.</p>
        <!--
        <h5 class="text-center" style="color:black">Write a free text</h5>
        <h6 class="text-center" style="color:black">(Suggestion: Your last holidays)</h6>
        <p class="text-center" style="color:black">Your text must contain a minimum of 30 words. However, bigger texts are expected on higher levels.</p>
        -->
        

        <div class="row">
          <div class="col-sm-6">
            <p class="text-right" style="color:black; font-size:18px;"><icon class="fa fa-lightbulb-o" style="color:#2c3e50;"></icon> Suggestion 1:<b> Your last holidays</b></p>
          </div>
          <div class="col-sm-6">
            <p class="text-left" style="color:black; font-size:18px;"><icon class="fa fa-lightbulb-o" style="color:#2c3e50;"></icon> Suggestion 2:<b> Your hobbies</b></p>
          </div>
        </div>

        <hr class="star-primary" style="background-color:#18bc9c;">
        
        

        <br>
        
        <form action="/Anansi/corrector" method="post">
          <div class="row">

            <!--input rows="8" onkeyup="verify(this)" type="text" name="texto"/-->

            <textarea onkeyup="verify(this)" class="form-control" type="text" name="texto" rows="8" id="text"></textarea>
            <!--<textarea onkeyup="verify(this)" class="form-control" rows="8" id="text" onpaste="return false;"></textarea>-->
          </div>
          <!--<div style="text-align:center" >
            <br>
            <button type="button" id="submit" class="btn btn-primary">Submeter</button>
          </div>-->
          <br>
          <div class="row">
            <div class="col-sm-3" style="text-align:center" >
              <p id="words" style="color:#c82333;"><i class="fa fa-exclamation-triangle" style="color:#c82333;"></i>&nbsp; 0 words</p>
            </div>
            <div class="col-sm-6" style="text-align:center" >
              <input type="submit" id="submit" value="Submit" class="btn btn-primary" style="cursor:pointer;">
              <!--button type="submit" id="submit" class="btn btn-primary" style="cursor:pointer;" > &nbsp; Submit &nbsp;</button>
                <!--<i class="fa fa-file-word-o"></i>-->
            </div>
            <div class="col-sm-3">
            </div>
          </div>
        </form>
        
      </div>
    </section>


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
    </footer>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top d-lg-none">
      <a class="btn btn-primary js-scroll-trigger" href="#page-top">
        <i class="fa fa-chevron-up"></i>
      </a>
    </div>

    

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

    <script>
      function verify(textarea){
        var text = textarea.value.trim();
        var number_of_words = text.split(" ").length;  
        if (text == '') number_of_words = 0;

        /*alert(
          '|' + textarea.value.trim() + '|\n' 
          + '|' + textarea.value.trim() + '|\n' 
          + '|' + textarea.value.trim().split(" ") + '|\n' 
          + '|' + textarea.value.trim().split(" ").length
        );*/

        var submit = document.getElementById("submit");
        var words = document.getElementById("words");
        
        if (number_of_words<30){
          submit.disabled = true;
          //words.className="btn btn-danger";

          words.innerHTML = '<i class="fa fa-exclamation-triangle" style="color:#c82333;"></i> &nbsp;' 
                + number_of_words 
                + ' words';
          words.style.color="#c82333";
        }
        else {
          submit.disabled = false;
          //words.className="btn btn-success";
          words.innerHTML = '<i class="fa fa-tachometer" style="color:green"></i> &nbsp;' 
                + number_of_words 
                + ' words';
          words.style.color="white";
        }
      }
    </script>

  </body>

</html>
