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
                            <h1 class="page-header">Devoluci&oacute;n de Activos</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <div class="alert alert-success">
                        Devoluci&oacute;n efectada correctamente.
                    </div>

                    <div class="alert alert-danger">
                        Problema para efectuar el proceso de devoluci&oacute;n. Contactar al coordinador de Laboratorio.
                    </div>


                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Auxiliar
                        </div>

                        <div class="panel-body">

                            <div class="panel panel-default">

                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped">

                                            <tbody>
                                                <tr>
                                                    <th colspan="2">
                                                        <div class="form-group">
                                                            <h3>Nombre:
                                                                <small> Fabian Andres Giraldo Giraldo</small>
                                                            </h3>

                                                        </div>
                                                    </th>
                                                    <td></td>
                                                    <th colspan="2">
                                                        <div class="form-group">
                                                            <h3>Identificaci&oacute;n:
                                                                <small> 8070062</small>
                                                            </h3>
                                                        </div></th>
                                                    <td></td>
                                                    <th colspan="2">
                                                        <h3>Escuela/Programa:
                                                            <small> Ciencia Exactas e Ingenier&iacute;a</small>
                                                        </h3>
                                                    </th>
                                                    <td></td>
                                                    <th colspan="2">
                                                        <div class="form-group">
                                                            <h3>Cargo:
                                                                <small> Docente</small>
                                                            </h3>
                                                        </div>
                                                    </th>
                                                </tr>



                                            </tbody>
                                        </table>
                                    </div>

                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                    </div>


                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Activos:
                        </div>
                        <div class="panel-body">
                            <form action="ServletPrestamo" method="POST">
                            <div class="input-group custom-search-form">
                                <input type="text" name="devolucionSearch" class="form-control" placeholder="Search...">
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
                                                    Activo Le&iacute;do
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body">
                                                    <div class="table-responsive">
                                                        <table class="table table-striped">

                                                            <tbody>
                                                                <tr>
                                                                    <th colspan="2">
                                                                        <div class="form-group">
                                                                            <h3>Fecha:
                                                                                <small>${requestScope.prestamo.fechaSolicitud.getTime()}</small>
                                                                            </h3>

                                                                        </div>
                                                                    </th>
                                                                    <td></td>
                                                                    <th colspan="2">
                                                                        <div class="form-group">
                                                                            <h3>Activo:
                                                                                <small> ${requestScope.activo.nombreEquipo}</small>
                                                                            </h3>
                                                                        </div></th>
                                                                    <td></td>
                                                                    <th colspan="2">
                                                                        <h3>C&oacute;digo de Barras:
                                                                            <small> ${requestScope.activo.codigo}</small>
                                                                        </h3>
                                                                    </th>
                                                                    <td></td>
                                                                    <th colspan="2">
                                                                        <div class="form-group">
                                                                            <h3>Usuario:
                                                                                
                                                                        <c:choose>
                                                                            <c:when test="${not empty requestScope.prestamo.estudiante}">
                                                                                ${requestScope.prestamo.estudiante.nombre}  ${requestScope.prestamo.estudiante.apellido}

                                                                            </c:when>
                                                                            <c:when test="${not empty requestScope.prestamo.docente}">
                                                                                ${requestScope.prestamo.docente.nombre}  ${requestScope.prestamo.docente.apellido}
                                                                             </c:when>
                                                                       </c:choose>

                                                                                <small>
                                                                            </h3>
                                                                        </div>
                                                                    </th>
                                                                </tr>

                                                                <tr>
                                                                    <th colspan="2">
                                                                        <div class="form-group">
                                                                            <h3>Estado:

                                                                            </h3>

                                                                            <div class="form-group">
                                                                                <textarea class="form-control"  disabled   rows="3">
                                                                                   ${detalle.estado}    
                                                                                
                                                                                </textarea>
                                                                            </div>

                                                                        </div>
                                                                    </th>
                                                                    <td></td>
                                                                    <th colspan="4">
                                                                        <div class="form-group">
                                                                            <h3>Observaci&oacute;n:

                                                                            </h3>

                                                                            <div class="form-group">

                                                                                <textarea class="form-control" disabled rows="3">
                                                                                    ${detalle.observacion}

                                                                                </textarea>
                                                                            </div>
                                                                        </div></th>
                                                                        <td colspan="3">
                                                                            <h3>Registro de Danos:

                                                                            </h3>
                                                                              <div class="form-group">

                                                                                <textarea class="form-control" rows="3"></textarea>
                                                                            </div>
                                                                            
                                                                            
                                                                        </td>
                                                                    <td></td>

                                                                </tr>

                                                            </tbody>
                                                        </table>

                                                        <div align="center">
                                                            <button type="submit" class="btn btn-default">Confirmar Devoluci&oacute;n</button>
                                                        </div>
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
