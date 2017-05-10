<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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
            <form action="PersonaServlet" method="POST">
                <div id="page-wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Gestionar Estudiantes</h1>
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
                 
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Docente
                        </div>
                        <div class="panel-body">

                            <!-- /.row -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="panel panel-default">
                                        <div class="panel-body">

                                            <div class="table-responsive">
                                                <table class="table table-striped">

                                                    <tbody>
                                                        <tr>
                                                            <th colspan="3">
                                                                <div class="form-group has-error">
                                                                    <label class="control-label" for="inputError">Cedula</label>
                                                                    <input class="form-control" name="cedula" placeholder="Enter text" value="${requestScope.estudiante.cedula}" required>
                                                                </div>
                                                                
                                                                
                                                            <c:if test="${not empty requestScope.estudiante}">
                                                                <input type="hidden" name="id" value="${requestScope.estudiante.id}"/>
                                                            </c:if>
                                                              

                                                            </th>
                                                            <td></td>
                                                            <td></td>
                                                             <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> Email</label>
                                                                    <input class="form-control"  name="email" placeholder="Enter text" value="${requestScope.estudiante.email}" required>
                                                                </div>
                                                            </th>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> Nombre</label>
                                                                    <input class="form-control"  name="nombre" value="${requestScope.estudiante.nombre}" placeholder="Enter text"required>
                                                                </div>


                                                            </th>
                                                            <td></td>
                                                            <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> Apellido</label>
                                                                    <input class="form-control"  name="apellido" value="${requestScope.estudiante.apellido}" placeholder="Enter text" required>
                                                                </div>
                                                            </th>
                                                            <td></td>
                                                            <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> Telefono</label>
                                                                    <input class="form-control"  name="telefono" value="${requestScope.estudiante.telefono}" placeholder="Enter text" required>
                                                                </div>


                                                            </th>
                                                        </tr>
                                                        
                                                        <tr>
                                                            <th colspan="4">
                                                                <div class="form-group">
                                                                    <label> Programa</label>
                                                                    <select name="programa" class="form-control">
                                                                    <c:forEach items="${requestScope.programas}" var="programa" varStatus="status">
                                                                        
                                                                        <c:choose>
                                                                        <c:when test="${requestScope.estudiante.programa.id == programa.id}">
                                                                            <option value="${programa.id}" selected="true">${programa.nombre}</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                           <option value="${programa.id}">${programa.nombre}</option>  
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                        
                                                                   </select>     
                                                                        
                                                                         
                                                                    </c:forEach>    
                                                                </div>
                                                            </th>
                                                            
                                                            <th colspan="4">
                                                               

                                                            </th>
                                                        </tr>

                                                    </tbody>
                                                </table>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <!-- /.col-lg-12 -->
                            </div>
                            <!-- /.row -->
                        </div>
                        
                        
                        <div align="center" class="panel-footer">
                             <c:choose>
                                <c:when test="${not empty requestScope.estudiante}">
                                 <button type="submit" name="estudiante" class="btn btn-default">Actualizar Estudiante</button> 
                               </c:when>
                               <c:otherwise >
                                  <button type="submit" name="estudiante" class="btn btn-default">Ingresar Estudiante</button> 
                               </c:otherwise>
                            </c:choose>
                        </div>
    
                                 
                    </div>
                                 
                      <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">

                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            Lista de Estudiantes 
                                        </div>
                                        <!-- /.panel-heading -->
                                        <div class="panel-body">
                                            <div class="table-responsive">
                                                <table id= "table" class="table table-striped table-bordered table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Nombre</th>
                                                            <th>Apellido</th>
                                                            <th>Telefono</th>
                                                            <th></th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${requestScope.estudiantes}" var="estudiante" varStatus="status">
                                                           
                                                            <tr>
                                                            <td>${status.count}</td>
                                                            <td>${estudiante.nombre}</td>
                                                            <td>${estudiante.apellido}</td>
                                                            <td>${estudiante.telefono}</td>
                                                            <td> 
                                                                 <a href="PersonaServlet?action=edit&estudiante=${estudiante.id}" class="btn btn-info" role="button">Editar</a>
                                                            </td>
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

                               <a href="#" data-href="PersonaServlet?action=delete&estudiante=${estudiante.id}" data-toggle="modal" data-target="#confirm-delete" class="btn btn-info" role="button">Borrar</a>

                                </td>
                                                                                                               
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

        
         <script>
              $('#confirm-delete').on('show.bs.modal', function(e) {
                  $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
                $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
              });
        </script>
    </body>

</html>
