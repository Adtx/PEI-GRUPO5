<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
        <a class="navbar-brand js-scroll-trigger" href="/Anansi/home">Anansi</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">

        </div>
      </div>
    </nav>


    <section id="test1" style="background-color:#18bc9c; margin-top:25px;">
      <div class="container" >
        <br><br>
        <!--
        <h6 class="text-center" style="color:black">Histórico de avaliações</h6>
        <p class="text-center" style="color:black">Pode visualizar, no gráfico seguinte, a sua evolução global.</p>
        -->
        <h6 class="text-center" style="color:black">Evaluation contexts</h6>

        <p class="text-center" style="color:black">The following table presents all your evaluation contexts.</p>
        <hr class="star-primary" style="background-color:#18bc9c;">
        <div class="table-responsive  table-hover">
          <table class="table">
            <thead class="thead-dark">
              <tr>
                <th>Context name</th>
                <th>Code</th>
                <th>Password</th>
                <th>Submissions</th>
                <th>Statistics</th>
              </tr>
            </thead>

            <tbody>


            <c:forEach items = "${sessionScope.contexts}" var="a">
                <form action="contextStats" method="post">
                    <input type="hidden" name="id" value="${a.ID}">
                    <tr>
                        <td>${a.name}</td>
                        <td>${a.code}</td>
                        <td>${a.password}</td>
                        <td style="text-align:center">${a.stats}</td>
                        <th style="text-align:center">
                            <button  type="submit" class="fa fa-bar-chart" style="background: transparent; border: hidden; cursor:pointer"></button>
                        </th>
                    </tr>
                </form>
            </c:forEach>

            </tbody>
          </table>
        </div>


        <br><br>


        <h6 class="text-center" style="color:black">Create new evaluation context</h6>

        <p class="text-center" style="color:black">The following form allows you to create a new evaluation context.</p>
        <hr class="star-primary" style="background-color:#18bc9c;">
        <!--<hr class="star-primary" style="background-color:#18bc9c;">-->

        <div style="border: 2px solid #212529; border-radius:10px; padding:20px;">
          <form class="form-inline"  accept-charset="ISO-8859-1" action="companyProfile" method="post">
            <div class="form-group col-sm-4" style="text-align:center">
              <input type="text" class="form-control" id="name" name="name" placeholder="Enter context name" required data-validation-required-message="Please insert context code.">
            </div>
            <div class="form-group col-sm-4" style="text-align:center">
              <input type="text" class="form-control" id="pwd" name="pass" placeholder="Enter context password" required data-validation-required-message="Please insert context password.">
            </div>
            <div class="form-group col-sm-4" style="text-align:center">
              <button type="submit" id="create_context" class="btn btn-primary" style="cursor:pointer;"> &nbsp; Create new evaluation context &nbsp; <i class="fa fa-plus-square"></i></button>
            </div>
          </form>
        </div>

      </div>
    </section>






    <!-- Footer -->
    <footer class="text-center">
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
    <script src="static/vendor/jquery/jquery.min.js"></script>
    <script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="static/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="static/js/jqBootstrapValidation.js"></script>
    <script src="static/js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="static/js/freelancer.min.js"></script>

    <script>
      function verify(textarea){
        var number_of_words = textarea.value.trim().split(" ").length;

        /*alert(
          '|' + textarea.value.trim() + '|\n'
          + '|' + textarea.value.trim() + '|\n'
          + '|' + textarea.value.trim().split(" ") + '|\n'
          + '|' + textarea.value.trim().split(" ").length
        );*/

        var submit = document.getElementById("submit");
        var words = document.getElementById("words");
        words.innerHTML = 'Palavras: ' + number_of_words;

        if (number_of_words<30){
          submit.disabled = true;
          words.className="btn btn-danger";
        }
        else {
          submit.disabled = false;
          words.className="btn btn-default";
        }
      }
    </script>

  </body>

</html>
