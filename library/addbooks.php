<?php

include("db.php");
session_start();

if(!isset($_SESSION['username'])){
  header("location: index.php");
}
$good="";

if(isset($_POST['submit'])){
  $bookname=$_POST['bookname'];
  $category=$_POST['category'];
  $filename=$_FILES['filee']['name'];
  $filetmp=$_FILES['filee']['tmp_name'];
  $dir="books/";

  move_uploaded_file($filetmp, $dir.$filename);

  $sql="insert into books (bookname,file,category) values ('$bookname', '$filename','$category')";
  $res=mysqli_query($conn,$sql);
  if($res){
    $good="<div class='btn btn-primary'> Uploaded </div>";
  }
  else{
      $good="<div class='btn btn-primary'> Not Uploaded </div>";
  }
}














?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="viho admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, viho admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="pixelstrap">
    <link rel="icon" href="logo.png" type="image/x-icon">
    <link rel="shortcut icon" href="logo.png" type="image/x-icon">
    <title>-Cive Library</title>
    <!-- Google font-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&amp;display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap" rel="stylesheet">
    <!-- Font Awesome-->
    <link rel="stylesheet" type="text/css" href="assets/css/fontawesome.css">
    <link rel="stylesheet" type="text/css" href="assets/css/icofont.css">
    <link rel="stylesheet" type="text/css" href="assets/css/themify.css">
    <link rel="stylesheet" type="text/css" href="assets/css/flag-icon.css">
    <link rel="stylesheet" type="text/css" href="assets/css/feather-icon.css">
    <link rel="stylesheet" type="text/css" href="assets/css/prism.css">
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link id="color" rel="stylesheet" href="assets/css/color-1.css" media="screen">
    <link rel="stylesheet" type="text/css" href="assets/css/responsive.css">
  </head>
  <body>
    <!-- Loader starts-->
    <div class="loader-wrapper">
      <div class="theme-loader">
        <div class="loader-p"></div>
      </div>
    </div>
    <!-- Loader ends-->
    <!-- page-wrapper Start-->
    <div class="page-wrapper" id="pageWrapper">
      <!-- Page Header Start-->
      <div class="page-main-header">
        <div class="main-header-right row m-0">
          <div class="main-header-left">
            <div class="logo-wrapper"><a href="index.html"><img class="img-fluid" src="../assets/images/logo/logo.png" alt=""></a></div>
            <div class="dark-logo-wrapper"><a href="index.html"><img class="img-fluid" src="../assets/images/logo/dark-logo.png" alt=""></a></div>
            <div class="toggle-sidebar"><i class="status_toggle middle" data-feather="align-center" id="sidebar-toggle"></i></div>
          </div>
          <div class="left-menu-header col">
            <ul>
              <li>
                <form class="form-inline search-form">
                  <div class="search-bg"><i class="fa fa-search"></i>
                    <input class="form-control-plaintext" placeholder="Search here.....">
                  </div>
                </form><span class="d-sm-none mobile-search search-bg"><i class="fa fa-search"></i></span>
              </li>
            </ul>
          </div>
          <div class="nav-right col pull-right right-menu p-0">
            <ul class="nav-menus">
              <li><a class="text-dark" href="#!" onclick="javascript:toggleFullScreen()"><i data-feather="maximize"></i></a></li>
              <li class="onhover-dropdown">
                <div class="bookmark-box"><i data-feather="star"></i></div>
              </li>



                <div class="mode"><i class="fa fa-moon-o"></i></div>
              </li>

              <li class="onhover-dropdown p-0">
                <button class="btn btn-primary-light" type="button"><a href="logout.php"><i data-feather="log-out"></i>Log out</a></button>
              </li>
            </ul>
          </div>
          <div class="d-lg-none mobile-toggle pull-right w-auto"><i data-feather="more-horizontal"></i></div>
        </div>
      </div>
      <!-- Page Header Ends                              -->
      <!-- Page Body Start-->
      <div class="page-body-wrapper horizontal-menu">
        <!-- Page Sidebar Start-->
        <header class="main-nav">
          <nav>
            <div class="main-navbar">
              <div id="mainnav">
                <ul class="nav-menu custom-scrollbar">
                  <li class="back-btn">
                    <div class="mobile-back text-end"><span>Back</span><i class="fa fa-angle-right ps-2" aria-hidden="true"></i></div>
                  </li>
                  <li class="dropdown"><a class="nav-link menu-title" href="dashboard.php" ><i data-feather="home"></i><span>Dashboard</span></a></li>
                  <li class="dropdown"><a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="anchor"></i><span>Activities</span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a class="submenu-title" href="viewstudents.php">View Students<span class="sub-arrow"><i class="fa fa-chevron-right"></i></span></a>

                      </li>
                      <li>     <a class="submenu-title" href="addbooks.php">Add Book<span class="sub-arrow"><i class="fa fa-chevron-right"></i></span></a>

                      </li>
                      <li>     <a class="submenu-title" href="viewbooks.php">View Books<span class="sub-arrow"><i class="fa fa-chevron-right"></i></span></a>

                      </li>
                    </ul>
                  </li>
                  
                </ul>
              </div>
            </div>
          </nav>
        </header>
        <!-- Page Sidebar Ends-->
        <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>Cive Library</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="dashboard.php">Home</a></li>

                  </ol>
                </div>

              </div>
            </div>
          </div>
          <!-- Container-fluid starts-->
          <div class="container-fluid">
            <div class="row starter-main">
              <div class="col-sm-12">
                <div class="card">
                  <div class="card-header pb-0">
                    <h5>Add Books</h5>

                  </div>

                </div>

                <div class="col-md-6">
                  <div class="card">
                    <div class="card-body">
                      <?php echo $good ?>
                      <form class="needs-validation" novalidate="" action="" method="post" enctype="multipart/form-data">
                    <div class="row g-3">

                      <div class="col-md-6 ">
                        <label class="form-label" for="validationCustomUsername">Book Name</label>
                        <div class="input-group">
                          <input class="form-control" id="validationCustomUsername" name="bookname" type="text" placeholder="Book Name" aria-describedby="inputGroupPrepend" required="">
                          <div class="invalid-feedback">Please choose a Book Name.</div>
                        </div>
                      </div>
                      <div class="col-md-6 ">
                        <label class="form-label" for="validationCustomUsername">Category</label>
                        <div class="input-group">
                              <select  name="category" class="form-control">
                                <option value="Programming language">Programming language</option>
                                <option value="Networking">Networking</option>
                                <option value="Programming language">CN121</option>
                                <option value="Networking">CP123</option>
                                <option value="Networking">LG</option>
                                <option value="Programming language">DS</option>
                                <option value="Networking">MT1201</option>
                              </select>
                        </div>
                      </div>
                    </div>
                    <div class="row g-3">
                      <div class="col-md-6">
                        <label class="form-label" for="validationCustom03">File</label>
                        <input class="form-control" type="file" name="filee"  required="">

                      </div>


                    <button class="btn btn-primary" name="submit" type="submit">Add Book</button>
                  </form>

                    </div>

                  </div>

                </div>
              </div>




            </div>
          </div>
          <!-- Container-fluid Ends-->
        </div>
        <!-- footer start-->
        <footer class="footer">
          <div class="container-fluid">
            <div class="row">
              <div class="col-md-6 footer-copyright">
                <p class="mb-0">Copyright 2022-23 ©  All rights reserved.</p>
              </div>
              <div class="col-md-6">
                <p class="pull-right mb-0"> & made with <i class="fa fa-heart font-secondary"></i></p>
              </div>
            </div>
          </div>
        </footer>
      </div>
    </div>
    <!-- latest jquery-->
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <!-- feather icon js-->
    <script src="assets/js/icons/feather-icon/feather.min.js"></script>
    <script src="assets/js/icons/feather-icon/feather-icon.js"></script>
    <!-- Sidebar jquery-->
    <script src="assets/js/sidebar-menu.js"></script>
    <script src="assets/js/config.js"></script>
    <!-- Bootstrap js-->
    <script src="assets/js/bootstrap/popper.min.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>
    <!-- Plugins JS start-->
    <script src="assets/js/prism/prism.min.js"></script>
    <script src="assets/js/clipboard/clipboard.min.js"></script>
    <script src="assets/js/custom-card/custom-card.js"></script>
    <script src="assets/js/tooltip-init.js"></script>
    <script src="assets/js/script.js"></script>
    <script src="assets/js/theme-customizer/customizer.js"></script>
    <!-- login js-->
    <!-- Plugin used-->
  </body>
</html>
