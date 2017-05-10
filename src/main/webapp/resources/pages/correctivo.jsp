<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Sistema de Gestion de Laboratorio</title>


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
                            <h1 class="page-header">Mantenimiento Correctivo</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                                        
                    <c:choose>
                        <c:when test="${OK == true}">
                            <div class="alert alert-success">
                             Se ha realizado satisfactoriamente la operaci&oacute;n.
                            </div>
                            
                        </c:when>
                        <c:when test="${OK == false}">
                            <div class="alert alert-danger">
                                 Problemas al realizar la operaci&oacute;n solicitada.  
                            </div>
                        </c:when>
                    </c:choose>


                    <c:if test="${busqueda == false}">
                      <div class="alert alert-danger">
                          Activo no existe.  
                      </div>
                    </c:if>
                    
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Activo
                        </div>

                        <form action="SearchServlet" method="POST">
                        <div class="input-group custom-search-form">
                            <input type="text" name="correctivo" class="form-control" placeholder="Search..." required>
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        </form>
                        
                        <div class="panel-body">

                            <div class="table-responsive">
                                <table class="table table-striped">

                                    <tbody>
                                        <tr>
                                            <th colspan="2">
                                                <div class="form-group">
                                                    <h3>Codigo
                                                        <small> ${activo.codigo}</small>
                                                    </h3>

                                                </div>
                                            </th>
                                            <td></td>
                                            <th colspan="2">
                                                <div class="form-group">
                                                    <h3>Nombre:
                                                        <small>${activo.nombreEquipo}</small>
                                                    </h3>
                                                </div></th>
                                            <td></td>
                                            <th colspan="2">
                                                <h3>Ubicaci&oacute;n:
                                                    <small> ${activo.ubicacion}</small>
                                                </h3>
                                            </th>
                                            <td></td>
                                            <th colspan="2">
                                                <div class="form-group">
                                                    <h3>Categor&iacute;a
                                                        <small> ${activo.categoria.nombre}</small>
                                                    </h3>
                                                </div>
                                            </th>
                                        </tr>


                                    </tbody>
                                </table>
                            </div>


                                                    
                            <div class="panel-heading">
                                Lista de Mantenimientos Correctivos
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Fecha</th>
                                                <th>Descripcion del Mantenimiento</th>
                                                <th>Averia Encontrada</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${activo.mantenimiento}" var="mantenimiento" varStatus="varStatus">
                                            <tr>
                                                <td>${varStatus.count}</td>
                                                <td>${mantenimiento.fecha.getTime().toString()}</td>
                                                <td>${mantenimiento.descripcion}</td>
                                                <td>${mantenimiento.averiaEncontrada}</td>
                                                <td> 
                                                    <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">

                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Confirmaci&oacute;n de Eliminaci&oacute;n</h4>
                                        </div>

                                        <div class="modal-body">
                                            <p>Esta seguro del proceso de eliminaci&oacute;n, este proceso es irreversible.</p>
                                            <p>Desea Proceder?</p>
                                        </div>

                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                            <a class="btn btn-danger btn-ok">Eliminar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                               <a href="#" data-href="MantenimientoServlet?correctivo=${mantenimiento.id}" data-toggle="modal" data-target="#confirm-delete" class="btn btn-info" role="button">Borrar</a>

                               
                                                </td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
                            </div>
                           
                        </div>
                    </div>


                   <form action="MantenimientoServlet" method="POST">    
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Descripción Mantenimiento:
                        </div>
                        <div class="panel-body">

                            <!-- /.panel-heading -->
                           <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped">

                                        <tbody>
                                            <tr>
                                                <th colspan="2">
                                                    <div class="form-group">
                                                        <h3>Fecha:                     
                                                        </h3>
                                                        <input id="meeting" type="date" name="fechaAdquisicion"/>  



                                                    </div>
                                                </th>
                                                <td></td>
                                                <th colspan="3">
                                                    <div class="form-group">
                                                        <h3>Da&ntilde;o encontrado:

                                                        </h3>

                                                        <div class="form-group">

                                                            <textarea name="dannio" class="form-control" rows="3"></textarea>
                                                            <input type="hidden" name="activo" value="${activo.codigo}" />
                                                        </div>



                                                    </div>
                                                </th>

                                                <th colspan="3">
                                                    <div class="form-group">
                                                        <h3>Repuestos:

                                                        </h3>

                                                        <div class="form-group">

                                                            <textarea name="repuesto" class="form-control" rows="3"></textarea>
                                                        </div>



                                                    </div>
                                                </th>

                                                <th colspan="2">
                                                    <div class="form-group">
                                                        <h3>Descripci&oacute;n del Mantenimiento

                                                        </h3>

                                                        <div class="form-group">

                                                            <textarea name="descripcion" class="form-control" rows="3"></textarea>
                                                        </div>



                                                    </div>
                                                </th>

                                            </tr>


                                        </tbody>
                                    </table>
                                </div>

                                <!-- /.table-responsive -->
                            </div>

                            <div align="center">
                                <button type="submit" name="correctivo" class="btn btn-default">Adicionar Mantenimientos</button>
                            </div>

                        </div>
                        <!-- /#page-wrapper -->
                    </div>
                   </form>
                    <!-- /#wrapper -->

                    <!-- jQuery -->
                    <script src="../vendor/jquery/jquery.min.js"></script>

                    <!-- Bootstrap Core JavaScript -->

                    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

                    <!-- Metis Menu Plugin JavaScript -->
                    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

                    <!-- Custom Theme JavaScript -->
                    <script src="../dist/js/sb-admin-2.js"></script>

                    <script>
              $('#confirm-delete').on('show.bs.modal', function(e) {
                  $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
                $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
              });
        </script>
                    </body>

                    </html>
