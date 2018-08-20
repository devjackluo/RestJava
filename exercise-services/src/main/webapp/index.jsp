<!-- <html> -->
<!-- <body> -->
<!--     <h2>Jersey RESTful Web Application!</h2> -->
<!--     <p><a href="webapi/myresource">Jersey resource</a> -->
<!--     <p>Visit <a href="http://jersey.java.net">Project Jersey website</a> -->
<!--     for more information on Jersey! -->
    
<!--     <a href="http://jackluo.online">My Website</a> -->
<!-- </body> -->
<!-- </html> -->


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Jack Luo</title>


    <link rel="stylesheet" href="./lib/bootstrap/dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="./css/site.css"/>


</head>


<body>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="" class="navbar-brand"><img class="myLogo" src="./images/logo.png"/></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="https://jackluo.herokuapp.com/">Ruby</a></li>
                <li><a href="https://jackluo.azurewebsites.net/">.Net</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="parallax-window" data-parallax="scroll" data-image-src="./images/wallone.jpg">

    <div class="innerDiv">
        <h1 class="nameHeader">Jack Luo</h1>
        <h4>Software Developer</h4>
    </div>

</div>


<div class="gapSection" id="about">

    <section class="col-xs-12 col-lg-6" style="background-color:black">
        <div class="frame">
            <span class="helper"></span>
            <img class="myImage" src="./images/me.JPG"/>
        </div>

    </section>
    <section class="col-xs-12 col-lg-6" style="background-color:royalblue">
        <div class="col-xs-8" id="aboutText">
            <h2>Jack</h2>
            <p>
                Zhaowen (Jack) Luo was born in Taishan China.
                He moved to Spokane Washington at the age of seven.
                He went to Spokane Community College for higher education.
                There he received his degree in Software Development.
                He is eager to learn new technology to fuel his passion for developing software.
                In his spare time, you can find him learning more.
            </p>
        </div>
    </section>
    <section class="col-xs-12 col-lg-6" style="background-color:darkslateblue">
        <div class="col-xs-8" id="educationText">
            <h2>Education</h2>
            <br/>
            <h4>Spokane Community College</h4>
            <h5>Associates of Applied Science</h5>
            <h5>Software Development</h5>
            
            <p>Counting to three:</p>
			<% for (int i=1; i<4; i++) { %>
			    <p>This number is <%= i %>.</p>
			<% } %>
			<p>OK.</p>
            
        </div>
    </section>
    <section class="col-xs-12 col-lg-6" style="background-color:darkcyan">
        <div class="col-xs-8" id="educationText">
            <h2>Skills</h2>
            <ul>
                <li>Multiple programming languages: Java, C#, Python, etc.</li>
                <li>Build native Android and iOS Apps</li>
                <li>Create websites on multiple frameswork.</li>
                <li>Quick to learn new technologies</li>
                <li>Practicing and improving algorithms and data structures everyday</li>
                <li>Constantly learning and working on projects</li>
                <li>Much more!</li>

            </ul>
        </div>
    </section>


</div>

<div class="parallax-window2" data-parallax="scroll" data-image-src="./images/walltwo.jpg">


</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="./lib/parallax.js-1.5.0/parallax.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/bootstrap/3.3.7/bootstrap.min.js"></script>


</body>
</html>
