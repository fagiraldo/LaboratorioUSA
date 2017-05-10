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
            <form action="ActivoServlet" method="POST">


                <div id="page-wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Inventario Periodo</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <div class="alert alert-success">
                        Activo registrado en el inventario del periodo.
                    </div>

                    <div class="alert alert-danger">
                        Problemas al registrar el activo en el inventario del periodo. Consultar con el coordinador de laboratorio.
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

                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->


                            <!-- /.row -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="panel panel-default">
                                        <div class="panel-body">

                                            <div class="panel panel-default">
                                                <div class="panel-heading">
                                                    Activo Le&iacute;do:
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
                                                                                <small> 18-09-2016</small>
                                                                            </h3>

                                                                        </div>
                                                                    </th>
                                                                    <td></td>
                                                                    <th colspan="2">
                                                                        <div class="form-group">
                                                                            <h3>Activo:
                                                                                <small> Osciloscipio</small>
                                                                            </h3>
                                                                        </div></th>
                                                                    <td></td>
                                                                    <th colspan="2">
                                                                        <h3>C&oacute;digo de Barras:
                                                                            <small> 00001112345</small>
                                                                        </h3>
                                                                    </th>
                                                                    <td></td>
                                                                    <th colspan="2">
                                                                        <div class="form-group">
                                                                            <h3>Ubicaci&oacute;n:
                                                                                <small> Estante 2</small>
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
                                            <!-- /.panel -->
                                        </div>
                                    </div>

                                </div>
                            </div>


                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped">

                                        <tbody>
                                            <tr>
                                                <th colspan="2">
                                                    <div class="form-group">
                                                        <h3>Estado:                     
                                                        </h3>

                                                        <div class="form-group">

                                                            <textarea class="form-control" rows="3"></textarea>
                                                        </div>

                                                    </div>
                                                </th>
                                                <td></td>
                                                <th colspan="7">
                                                    <div class="form-group">
                                                        <h3>Observaci&oacute;n:

                                                        </h3>

                                                        <div class="form-group">

                                                            <textarea class="form-control" rows="3"></textarea>
                                                        </div>



                                                    </div></th>

                                                <td></td>

                                            </tr>


                                        </tbody>
                                    </table>
                                </div>

                                <!-- /.table-responsive -->
                            </div>

                            <div align="center">
                                <button type="submit" class="btn btn-default">Incluir activo en el Inventario</button>
                            </div>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->



                </div>
                <!-- /#page-wrapper -->
            </form>
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
