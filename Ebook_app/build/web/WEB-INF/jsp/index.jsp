<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, com.DB.DBConnect" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>E-book: Index</title>
        <%@include file="allCss.jsp"%>

        <style type="text/css">
            .back-img{
                background: url("img/book.jpeg");
                height: 50vh;
                width: 100%;
                background-repeat: no-repeat;
                background-size: cover;
            }
            
            .crd-ho:hover{
                background-color: #fcf7f7;
            }
        </style>
    </head>

    <body  style="background-color: #f7f7f7;">
        <%@include file="navbar.jsp"%>
        <div class="container-fluid back-img">
            <h2 class="text-center text-danger">E-Book Management System</h2>
        </div>
              
        <!-- Recent Book -->
        <div class="container">
            <h3 class="text-center">Recent Book</h3>
            <div class="row">
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/java.jpeg" alt="JAVA BOOK"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>JAVA Programming</p>
                            <p>Sharanam Shah</p>
                            <p>Categories: New</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">299</a>
                            </div>   
                        </div>
                    </div>
                </div>
                
                
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/linux.jpeg" alt="LINUX BOOK"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>LINUX Programming</p>
                            <p>Jason Cannon</p>
                            <p>Categories: Old</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">469</a>
                            </div>   
                        </div>
                    </div>
                </div>
                
                
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/python.jpeg" alt="PYTHON BOOK"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>Python Programming</p>
                            <p>Alexander</p>
                            <p>Categories: New</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">142</a>
                            </div>   
                        </div>
                    </div>
                </div>
                
                
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/sql.jpeg" alt="SQL BOOK"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>The Art of SQL</p>
                            <p>Stephanie</p>
                            <p>Categories: New</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">399</a>
                            </div>   
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="text-center ml-1">
                <a href="" class="btn btn-danger btn-sm text-white">View All</a>
            </div>
        </div>
        <!-- Close Recent Book -->
        <hr>
        <!-- New Book -->
        <div class="container">
            <h3 class="text-center">New Book</h3>
            <div class="row">
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/C%23.jpeg" alt="C# BOOK"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>C# Programming</p>
                            <p>Rob Miles</p>
                            <p>Categories: New</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">372</a>
                            </div>   
                        </div>
                    </div>
                </div>
                
                
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/C.png" alt="C BOOK"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>C Programming</p>
                            <p>Brian & Dennis </p>
                            <p>Categories: New</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">175</a>
                            </div>   
                        </div>
                    </div>
                </div>
                
                
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/C++.jpg" alt="C++ BOOK"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>C++ Programming</p>
                            <p>- - -</p>
                            <p>Categories: New</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">142</a>
                            </div>   
                        </div>
                    </div>
                </div>
                
                
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/assembly.jpg" alt="Assembly BOOK"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>Assembly Langauge</p>
                            <p>Richard Blum</p>
                            <p>Categories: New</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">522</a>
                            </div>   
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="text-center ml-1">
                <a href="" class="btn btn-danger btn-sm text-white">View All</a>
            </div>
        </div>
        <!-- Close New Book -->
        <hr>
        <!-- Old Book -->
        <div class="container">
            <h3 class="text-center">Old Book</h3>
            <div class="row">
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/GO.jpg" alt="GO Lang"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>GoLang Programming</p>
                            <p>Alan & Brian</p>
                            <p>Categories: Old</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">888</a>
                            </div>   
                        </div>
                    </div>
                </div>
                
                
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/PHP.jpeg" alt="PHP"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>PHP & MySQL</p>
                            <p>W.Jason Gilmore</p>
                            <p>Categories: Old</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">758</a>
                            </div>   
                        </div>
                    </div>
                </div>
                
                
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/react.jpeg" alt="REACT"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>REACT Programming</p>
                            <p>Cory</p>
                            <p>Categories: Old</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">239</a>
                            </div>   
                        </div>
                    </div>
                </div>
                
                
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/vue.jpg" alt="VUE"  style="width: 150px; height: 200px" 
                                 class="img-thumblin"/>
                            <p>VUE.js 3</p>
                            <p>John Au-Yeung</p>
                            <p>Categories: Old</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">666</a>
                            </div>   
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="text-center ml-1">
                <a href="" class="btn btn-danger btn-sm text-white">View All</a>
            </div>
        </div>
        <!-- Close Old Book -->
        
        
        <%@include file="footer.jsp" %>
    </body>
</html>
