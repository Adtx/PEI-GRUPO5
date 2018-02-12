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

    <script src="Chart.min.js"></script>

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
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="/Anansi/writing">
              <!--
              <i class="fa fa-pencil"></i> AVALIAR</a>
              -->
              <i class="fa fa-pencil"></i> EVALUATE</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="navbar " >
        <ul class="navbar-nav ml-auto">
          <a class=" nav-link" t>Olá, ${user.name}</a>
        </ul>
      </div>
    </nav>

    <div id="results" style="visibility: hidden; display: none">
      <c:forEach  items="${sessionScope.results}" var="a">
        <div class="results">
          <div class="result">${a.result}</div>
          <div class="date">${a.day}/${a.month}/${a.year}</div>
        </div>
      </c:forEach>
    </div>
  <!-- Contact Section -->
    <section id="test" style="background-color:#18bc9c; margin-top:25px;">
      <div class="container" >
        <br><br>

        <!--
        <h6 class="text-center" style="color:black">Histórico de avaliações</h6>
        <p class="text-center" style="color:black">Pode visualizar, no gráfico seguinte, a sua evolução global.</p>
        -->
        <h6 class="text-center" style="color:black">Evaluation history</h6>
        <p class="text-center" style="color:black">The following chart presents your global evolution progress.</p>

        <hr class="star-primary" style="background-color:#18bc9c;">
        <br>
        <div class="row">
          <div class="container" style="width:66%; text-align:center">
              <canvas id="myChart" width="400" height="200"></canvas>
          </div>
          <script>
          var ctx = document.getElementById("myChart").getContext('2d');

          var check = function(value, index, values) {
                          var level = ''
                          switch(value) {
                              case "1":
                                  level = 'A1'
                                  break;
                              case "2":
                                  level = 'A2'
                                  break;
                              case "3":
                                  level = 'B1'
                                  break;
                              case "4":
                                  level = 'B2'
                                  break;
                              case "5":
                                  level = 'C1'
                                  break;
                              case 6:
                                  level = 'C2'
                                  break;
                              default:
                                  break;
                          }
                          return level;
                      }

          var check1 = function(value) {
              var level = ""
              switch(value) {
                  case "1":
                      level = "CEFR level: A1"
                      break;
                  case "2":
                      level = "CEFR level: A2"
                      break;
                  case "3":
                      level = "CEFR level: B1"
                      break;
                  case "4":
                      level = "CEFR level: B2"
                      break;
                  case "5":
                      level = "CEFR level: C1"
                      break;
                  case "6":
                      level = "CEFR level: C2"
                      break;
                  default:
                      break;
              }
              return level;
          }
          var levelColor = function(value) {
                          var color = ''
                          switch(value) {
                              case "1":
                                  color = 'rgba(0, 0, 255, 0.1)'
                                  break;
                              case "2":
                                  color = 'rgba(0, 0, 255, 0.3)'
                                  break;
                              case "3":
                                  color = 'rgba(0, 0, 255, 0.5)'
                                  break;
                              case "4":
                                  color = 'rgba(0, 0, 255, 0.7)'
                                  break;
                              case "5":
                                  color = 'rgba(0, 0, 255, 0.8)'
                                  break;
                              case "6":
                                  color = 'rgba(0, 0, 255, 0.9)'
                                  break;
                              default:
                                  break;
                          }
                          return color;
                      }
          var elements = document.getElementsByClassName("result");
          var dates = document.getElementsByClassName("date");
          var dataset = Array.from(Array.prototype.slice.call(elements),x => x.innerHTML);
          var temp = ["0","0","0","0","0","0"];
          if(dataset.length<6){
              for (i = 0; i < dataset.length; i++) {
                  temp[i] = dataset[i];
              }
              dataset=temp;
          }
          if(dataset.length>6){
              for (i = 0; i < 6; i++) {
                  temp[i] = dataset[i];
              }
              dataset=temp;
          }
          temp = ["","","","","",""];
          var labels = Array.from(Array.prototype.slice.call(dates),x => x.innerHTML);
          if(labels.length<6){
              for (i = 0; i < labels.length; i++) {
                  temp[i] = labels[i];
              }
              labels=temp;
          }
          if(labels.length>6){
              for (i = 0; i < 6; i++) {
                  temp[i] = labels[i];
              }
              labels=temp;
          }
          var colors = Array.from(dataset, x => levelColor(x));
          var myChart = new Chart(ctx, {
              type: 'bar',
              data: {
                  labels: labels,
                  datasets: [{
                      data: dataset,
                      label: "CEFR level",
                      backgroundColor: colors,
                      borderColor: colors,
                      borderWidth: 1
                  }]
              },
              options: {
                  tooltips:{
                      callbacks:{
                          label:function(tooltipItems,data){
                                  return check1(data.datasets[0].data[tooltipItems.index]);}
                      }
                  },
                  scales: {
                      yAxes: [{
                          ticks: {
                              min: 0,
                              max: 6,
                              stepSize: 1,
                              beginAtZero: true,
                              callback: check
                          },
                          position: 'left'
                      }]
                  }
              }
          });
          </script>
        </div>

      </div>
    </section>


    <section id="test2" style="background-color:#18bc9c;">
      <div class="container" >

        <!--
        <h6 class="text-center" style="color:black">Estatísticas detalhadas</h6>
        <p class="text-center" style="color:black">Pode visualizar, na tabela seguinte, estatísticas detalhadas sobre as avaliações realizadas.</p>
        -->
        <h6 class="text-center" style="color:black">Detailed statistics</h6>
        <p class="text-center" style="color:black">The following table presents detailed statistics regarding the performed evaluations.</p>

        <hr class="star-primary" style="background-color:#18bc9c;">
        <br>

        <div class="table-responsive  table-hover">
          <table class="table">
            <thead class="thead-dark">
              <tr>
                <th>Date</th>
                <th>CEFR level</th>
                <th>Errors</th>
                <th>Readability</th>
                <th>Lexical Density</th>
                <th>Lexical Richness</th>
                <th>Perplexity</th>
                <th>Text</th>
              </tr>
            </thead>

            <tbody>
            <c:forEach items="${sessionScope.results}" var="a">

              <tr>
                <td>${a.day}/${a.month}/${a.year}</td>
                <td>${a.designation}</td>
                <td>${a.metric2}/${a.metric1}</td>
                <td>${a.metric3}</td>
                <td>${a.metric5}</td>
                <td>${a.metric6}</td>
                <td>${a.metric4}</td>
                <th style="text-align:center" data-toggle="modal" data-target="#${a.responseID}">
                  <i class="fa fa-file" style="cursor:pointer"></i>
                </th>
              </tr>
            </c:forEach>

            </tbody>
          </table>
        </div>

      </div>
    </section>


    <!-- Modals -->

    <div class="container">

    <c:forEach items="${sessionScope.results}" var="a">
      <div class="modal fade" id="${a.responseID}" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <h6 class="modal-title">${a.day}/${a.month}/${a.year}</h6>
              <span>&nbsp;&nbsp;(CEFR level: ${a.designation})</span>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
              <p>${a.response}</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div>

        </div>
      </div>
    </c:forEach>
    </div>


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
