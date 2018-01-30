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
        <a class="navbar-brand js-scroll-trigger" href="index.html">Anansi</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="writing.html">
              <!--
              <i class="fa fa-pencil"></i> AVALIAR</a>
              -->
              <i class="fa fa-pencil"></i> EVALUATE</a>
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
                              case 1:
                                  level = 'A1'
                                  break;
                              case 2:
                                  level = 'A2'
                                  break;
                              case 3:
                                  level = 'B1'
                                  break;
                              case 4:
                                  level = 'B2'
                                  break;
                              case 5:
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

          var levelColor = function(value) {
                          var color = ''
                          switch(value) {
                              case 1:
                                  color = 'rgba(0, 0, 255, 0.1)'
                                  break;
                              case 2:
                                  color = 'rgba(0, 0, 255, 0.3)'
                                  break;
                              case 3:
                                  color = 'rgba(0, 0, 255, 0.5)'
                                  break;
                              case 4:
                                  color = 'rgba(0, 0, 255, 0.7)'
                                  break;
                              case 5:
                                  color = 'rgba(0, 0, 255, 0.8)'
                                  break;
                              case 6:
                                  color = 'rgba(0, 0, 255, 0.9)'
                                  break;
                              default:
                                  break;
                          }
                          return color;
                      }

          var data = [1,3,2,2,4,6];
          var labels = ["January", "February", "April", "July", "September", "December"];
          var colors = Array.from(data, x => levelColor(x));

          var myChart = new Chart(ctx, {
              type: 'bar',
              data: {
                  labels: labels,
                  datasets: [{
                      data: data,
                      label: "CEFR level",
                      backgroundColor: colors,
                      borderColor: colors,
                      borderWidth: 1
                  }]
              },
              options: {
                  scales: {
                      yAxes: [{
                          ticks: {
                              beginAtZero: true,
                              callback: check   
                          },
                          position: 'left'
                      }]
                  },
                  legend: {
                      display: true,
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
              <tr>
                <td>22 Dec (2017)</td>
                <td>A2</td>
                <td>5/126</td>
                <td>0.31</td>
                <td>0.42</td>
                <td>0.37</td>
                <td>0.60</td>
                <th style="text-align:center" data-toggle="modal" data-target="#modal1">
                  <i class="fa fa-file" style="cursor:pointer"></i>
                </th>
              </tr>
              <tr>
                <td>04 Jan (2018)</td>
                <td>B1</td>
                <td>7/245</td>
                <td>0.46</td>
                <td>0.51</td>
                <td>0.34</td>
                <td>0.71</td>
                <th style="text-align:center" data-toggle="modal" data-target="#modal2">
                  <i class="fa fa-file" style="cursor:pointer"></i>
                </th>
              </tr>
              <tr>
                <td>16 Jan (2018)</td>
                <td>B1</td>
                <td>9/220</td>
                <td>0.53</td>
                <td>0.54</td>
                <td>0.40</td>
                <td>0.68</td>
                <th style="text-align:center" data-toggle="modal" data-target="#modal3">
                  <i class="fa fa-file" style="cursor:pointer"></i>
                </th>
              </tr>
            </tbody>
          </table>
        </div>

      </div>
    </section>


    <!-- Modals -->

    <div class="container">
      <div class="modal fade" id="modal1" role="dialog">
        <div class="modal-dialog">
        
          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <h6 class="modal-title">22 Dec (2017)</h6> 
              <span>&nbsp;&nbsp;(CEFR level: A2)</span>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
              <p>This is supposed to be a text submitted on 22 Dec (2017). It is a free topic text with a minimum of 30 words. However, bigger texts are expected for higher levels. Additionally, two topic suggestions are made to the candidate, including: his latest holidays and his hobbies.</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div>
          
        </div>
      </div>   
      <div class="modal fade" id="modal2" role="dialog">
        <div class="modal-dialog">
        
          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <h6 class="modal-title">04 Jan (2018)</h6> 
              <span>&nbsp;&nbsp;(CEFR level: B1)</span>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
              <p>This is supposed to a text submitted on 04 Jan (2018). It is a free topic text with a minimum of 30 words. However, bigger texts are expected for higher levels. Additionally, two topic suggestions are made to the candidate, including: his latest holidays and his hobbies.</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div>
          
        </div>
      </div>   
      <div class="modal fade" id="modal3" role="dialog">
        <div class="modal-dialog">
        
          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <h6 class="modal-title">16 Jan (2018)</h6> 
              <span>&nbsp;&nbsp;(CEFR level: B1)</span>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
              <p>This is supposed to a text submitted on 16 Jan (2018). It is a free topic text with a minimum of 30 words. However, bigger texts are expected for higher levels. Additionally, two topic suggestions are made to the candidate, including: his latest holidays and his hobbies.</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div>
          
        </div>
      </div>      
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