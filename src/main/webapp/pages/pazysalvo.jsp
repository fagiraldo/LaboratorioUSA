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
                            <h1 class="page-header">Paz y Salvo</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>


                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Usuario
                        </div>

                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>

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

                        </div>
                    </div>
                    <!-- /.row -->
                    <div class="alert alert-success">
                        El usuario est&aacute; a paz y salvo con el laboratorio. 
                    </div>

                    <div class="alert alert-danger">
                       El usuario tiene una deuda con el laboratorio.  
                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">

                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            Deudas 
                                        </div>
                                        <!-- /.panel-heading -->
                                        <div class="panel-body">
                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Activo</th>
                                                            <th>Fecha</th>
                                                            <th>Observaci&oacute;n</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>1</td>
                                                            <td>Osciloscipio</td>
                                                            <td>12/12/2016</td>
                                                            <td>Entrego producto sin funcionar.</td>
                                                            
                                                            <td> 
                                                                <button type="button" class="btn btn-warning btn-circle">
                                                                    <i class="fa fa-times"></i>
                                                                </button>
                                                            </td>
                                                        </tr>
                                                        
                                                        <tr>
                                                            <td>2</td>
                                                            <td>Osciloscipio</td>
                                                            <td>12/12/2016</td>
                                                            <td>Entrego producto sin funcionar.</td>
                                                            
                                                            <td> 
                                                                <button type="button" class="btn btn-warning btn-circle">
                                                                    <i class="fa fa-times"></i>
                                                                </button>
                                                            </td>
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
