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
                            <h1 class="page-header">SISTEMA DE PR&Eacute;STAMO</h1>
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
                            Auxiliar
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
                                                <h3>Escuela/Programa
                                                    <small> Ciencia Exactas e Ingenier&iacute;a</small>
                                                </h3>
                                            </th>
                                            <td></td>
                                            <th colspan="2">
                                                <div class="form-group">
                                                    <h3>Cargo
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

                      <c:choose>
                       <c:when test="${not empty requestScope.busqueda}">
                            <div class="alert alert-danger">
                                 El usuario solicitado no existe.  
                            </div>
                       </c:when>
                      </c:choose>
                            
                   <div class="panel panel-primary">
                        <div class="panel-heading">
                            Usuario
                        </div>

                    <form action="ServletPrestamo" method="POST">
                        <div class="input-group custom-search-form">
                            <input type="hidden" name="usuarioSearch"/>
                            <input type="text" name="cedula" class="form-control" placeholder="Search...">
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
                                   
                                   
                                   <c:choose>
                                       <c:when test="${not empty requestScope.usuario}">
                            
                                           <tr>
                                            <th colspan="2">
                                                <div class="form-group">
                                                    <h3>Nombre:
                                                        <small> ${requestScope.usuario.nombre}</small>
                                                    </h3>

                                                </div>
                                            </th>
                                            <td></td>
                                            <th colspan="2">
                                                <div class="form-group">
                                                    <h3>Identificaci&oacute;n:
                                                        <small> ${requestScope.usuario.cedula}</small>
                                                    </h3>
                                                </div></th>
                                            <td></td>
                                            <th colspan="2">
                                                <h3>Escuela/Programa
                                                    <small> ${requestScope.usuario.programa.nombre}</small>
                                                </h3>
                                            </th>
                                            <td></td>
                                            <th colspan="2">
                                                <div class="form-group">
                                                    <h3>Cargo
                                                        <small> Estudiante</small>
                                                    </h3>
                                                </div>
                                            </th>
                                        </tr>

                                        
                                        </c:when>
                                        <c:when test="${not empty requestScope.docente}">
                            
                                            <tr>
                                            <th colspan="2">
                                                <div class="form-group">
                                                    <h3>Nombre:
                                                        <small> ${requestScope.docente.nombre}</small>
                                                    </h3>

                                                </div>
                                            </th>
                                            <td></td>
                                            <th colspan="2">
                                                <div class="form-group">
                                                    <h3>Identificaci&oacute;n:
                                                        <small> ${requestScope.docente.nombre}</small>
                                                    </h3>
                                                </div></th>
                                            <td></td>
                                            <th colspan="2">
                                                <h3>Escuela/Programa
                                                    <small> ${docente.dependencia.nombre}</small>
                                                </h3>
                                            </th>
                                            <td></td>
                                            <th colspan="2">
                                                <div class="form-group">
                                                    <h3>Cargo
                                                        <small> Docente</small>
                                                    </h3>
                                                </div>
                                            </th>
                                        </tr>

                                        
                                        </c:when>
                                    </c:choose>
                               
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                 
                 <div class="panel panel-primary" id="tips">
                        <div class="panel-heading">
                            Activos a Prestar:
                        </div>
                        <div class="panel-body">
                        <form action="ServletPrestamo" method="POST">
                            <div class="input-group custom-search-form">
                                <input type="text" name="activo" class="form-control" placeholder="Search...">
                                <input type="hidden" name="activoSearch"/>
                                
                            <c:choose>
                             <c:when test="${not empty requestScope.docente}">
                                 <input type="hidden" name="docente" value="${requestScope.docente.cedula}"/>
                                 
                             </c:when>
                             <c:when test="${not empty usuario}">
                                    <input type="hidden" name="usuario" value="${requestScope.usuario.cedula}"/>
                              </c:when>
                            </c:choose>
                                
                                
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                        </form>    
                            <!-- /input-group -->

                        <form action="ServletPrestamo" method="POST">
                           <c:choose>
                             <c:when test="${not empty requestScope.docente}">
                                <input type="hidden" name="docente" value="${requestScope.docente.cedula}"/>
                             </c:when>
                             <c:when test="${not empty usuario}">
                                    <input type="hidden" name="usuario" value="${requestScope.usuario.cedula}"/>
                              </c:when>
                          </c:choose>
                          
                                    
                            
                            <!-- /.row -->
                            <div class="row" >
                                <div class="col-lg-12">
                                    <div class="panel panel-default">
                                        <div class="panel-body">

                                            <div class="panel panel-default">
                                                <div class="panel-heading">
                                                    Lista de Activos registrados hasta el momento para el pr&eacute;stamo
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body">
                                                    <div class="table-responsive">
                                                        <table class="table table-striped table-bordered table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>#</th>
                                                                    <th>Activo.</th>
                                                                    <th>C&oacute;digo de barras.</th>
                                                                    <th>Estado.</th>
                                                                     <th>Observaci&oacute;n.</th>
                                                                    <th></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                              <c:forEach items="${sessionScope.cart.cartItems}" var="item" varStatus="status">
                                                                <tr>
                                                                    <td>${status.count}</td>
                                                                    <td>${item.value.nombreEquipo}</td>
                                                                    <td>${item.value.codigo}</td>
                                                                    <input type="hidden" name="activo${status.count}" value="${item.value.codigo}"/>
                                                                    <th>
                                                                       <div class="form-group">
                                                                        <h3> Estado</h3>
                                                                     <textarea name= "status${status.count}" class="form-control" rows="3"></textarea>
                                                                        </div> 
                                                                        
                                                                    </th>
                                                                    <th>
                                                                         <h3> Observacion</h3>
                                                                         <textarea name= "observacion${status.count}" class="form-control" rows="3"></textarea>
                                                                        </div> 
                                                                        
                                                                    </th>
                                                                     
                                                                    <td> 
                                                                        <button type="button" class="btn btn-warning btn-circle">
                                                                            <i class="fa fa-times"></i>
                                                                        </button>
                                                                    </td>
                                                                </tr>
                                                      
                                                            </c:forEach> 
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <!-- /.table-responsive -->
                                                </div>

                                                <div class="panel-footer">
                                                    <h3>N&uacute;mero de Activos: ${sessionScope.cart.cartItems.size()}</h3> 
                                                </div>

                                                <!-- /.panel-body -->
                                            </div>
                                            <!-- /.panel -->
                                        </div>
                                    </div>


                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <tbody>
                                                <tr>
                                                    <th colspan="3">
                                                        <div class="form-group">
                                                            <h3> Fecha de Solicitud: ${requestScope.fecha}</h3>
                                                            <input name="fecha" type="hidden" value="${requestScope.fecha}"> 
                                                        </div>
                                                        <label>Semestre</label>
                                                        <select name="semestre" class="form-control">
                                                            <option>1</option>
                                                            <option>2</option>
                                                        </select>
                                                    </th>
                                                    <td></td>
                                                    <th colspan="3">
                                                        <div class="form-group">
                                                            <h3> Fecha Devoluci&oacute;n</h3>
                                                            <input id="meeting" name="devolucion" type="date"/>
                                                        </div>
                                                    </th>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                   
                                    
                                <div class="table-responsive">
                                        <table class="table table-striped">
                                            <tbody>
                                                <tr>
                                                    <th colspan="3">
                                                        <div class="form-group">
                                                            <h3> Tipo de Pr&aacute;ctica</h3>
                                                            
                                                            <div class="radio">
                                                                <label>
                                                                    <input type="radio" name="tipoPractica" value="L" checked>Libre                                                              </label>
                                                            </div>
                                                                
                                                            <div class="radio">
                                                                <label>
                                                                    <input type="radio" name="tipoPractica" value="D">Dirigida
                                                                </label>
                                                            </div>
                                                            
                                                            

                                                        </div>

                                                    </th>
                                                    <td></td>
                                                    <th colspan="3">

                                                    </th>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>

                                                        
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <tbody>
                                                <tr>
                                                    <th colspan="3">
                                                        <div class="form-group">
                                                            <h3> Lugar Salida</h3>
                                                            <input class="form-control" name="lugarSalida" placeholder="Enter text" required>
                                                            
                                                            <div class="checkbox">
                                                                <label>
                                                                    <input type="checkbox" name="salida" value="si">El activo sale de la Universidad
                                                                </label>
                                                            </div>
                                                                
                                                            <div class="checkbox">
                                                                <label>
                                                                    <input type="checkbox" name="aprobado" value="si">Aprobado por el Coordinador del laboratorio
                                                                </label>
                                                            </div>
                                                            
                                                            

                                                        </div>

                                                    </th>
                                                    <td></td>
                                                    <th colspan="3">

                                                    </th>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>



                                    <div align="center">
                                        <button type="submit" class="btn btn-default">Confirmar Pr&eacute;stamo</button>
                                    </div>



                                </div>
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
