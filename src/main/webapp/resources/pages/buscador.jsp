<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Sistema de Gesti&oacute;n de Laboratorio</title>


        <!-- Bootstrap Core CSS -->
        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <jsp:include page="navegacion.jsp" flush="true" />
           


                <div id="page-wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Buscador de Activos</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                   

                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Activos:
                        </div>
                        <div class="panel-body">
                            <form action="SearchServlet" method="POST"> 
                            <div class="input-group custom-search-form">
                                <input type="text" name="nombreActivo" class="form-control" placeholder="Busqueda por nombre...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                             </form>    
                            <!-- /input-group -->


                            <!-- /.row -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="panel panel-default">
                                        <div class="panel-body">

                                            <div class="panel panel-default">
                                                <div class="panel-heading">
                                                    Activos
                                                </div>
                                                <!-- /.panel-heading -->
                                                
                                                 <div class="panel-body">

                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>C&oacute;digo de barras</th>
                                                        <th>Activo</th>
                                                        <th>Estado</th>
                                                        <th>Ubicacion</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${requestScope.activos}" var="activo"> 
                                                    <tr>
                                                        <td>${activo.codigo}</td>
                                                        <td>${activo.nombreEquipo}</td>
                                                        <td>
                                                            <c:choose>
                                                                <c:when test="${not empty activo.detalleprestamo}">
                                                                    <c:out value="Prestado"/>
                                                                </c:when>
                                                                <c:when test="${empty activo.detalleprestamo}">
                                                                    <c:out value="Disponible"/>
                                                                </c:when>
                                                                 
                                                            </c:choose>
                                                            
                                                            
                                                        </td>
                                                        <td>${activo.ubicacion}</td>
                                                    </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.table-responsive -->


                    </div>
                                                
                                                
                                                <!-- /.panel-body -->
                                            </div>
                                            <!-- /.panel -->
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->



                </div>
                <!-- /#page-wrapper -->
          
        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="../vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="../vendor/metisMenu/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="../dist/js/sb-admin-2.js"></script>

    </body>

</html>
