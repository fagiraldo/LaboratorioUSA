<%@page import="udu.usa.laboratorio.modelo.MantenimientoPreventivo"%>
<%@page import="udu.usa.laboratorio.modelo.Activo"%>
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
                        <h1 class="page-header">FO-08 HOJA DE VIDA MAQUINARIA Y EQUIPOS</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <c:if test="${empty requestScope.busqueda == false}">
                    <div class="alert alert-danger">
                        Activo solicitado no registrado. 
                    </div>
                </c:if>    
                    
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        Activo a buscar
                    </div>
                    <div class="panel-body">

                        <form action="SearchServlet" method="POST">
                            <div class="input-group custom-search-form">
                                <input type="text" name="activo" class="form-control" placeholder="Search..." required>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit" >
                                        <i class="fa fa-search"></i>
                                    </button>
                            </div>

                        </form>

                        <br/> 
                        <div class="col-lg-12">

                        </div>

                        <!-- /.row -->
                        <form action="UpdateServlet" method="POST">
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
                                                                    <label class="control-label" for="disabledSelect">Nombre Equipo o M&aacute;quina</label>
                                                                    <input class="form-control"value="${requestScope.Activo.nombreEquipo}">
                                                                </div>


                                                            </th>
                                                            <td></td>
                                                            <td></td>
                                                            <th colspan="3">
                                                                <div class="form-group">
                                                                    <label> Fecha de Adquisici&oacute;n</label>
                                                                    <input id="meeting" type="date" name="fechaAdquisicion" value="${requestScope.Activo.fechaAdquisicion}"/>
                                                                </div>



                                                            </th>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> C&oacute;digo</label>
                                                                    <input class="form-control"   id="disabledInput" type="text" placeholder="Disabled input"  disabled  name="codigo"  placeholder="Enter text" value="${requestScope.Activo.codigo}"/>
                                                                </div>


                                                            </th>
                                                            <td></td>
                                                            <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> Marca</label>
                                                                    <input class="form-control"  name="marca" placeholder="Enter text" value="${requestScope.Activo.marca}"/>
                                                                </div>
                                                            
                                                            </th>
                                                            <td></td>
                                                            <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> Modelo</label>
                                                                    <input class="form-control"  name="modelo" placeholder="Enter text" value="${requestScope.Activo.modelo}"/> 
                                                                </div>


                                                            </th>
                                                        </tr>


                                                        <tr>
                                                            <th colspan="5">

                                                                <div class="form-group">
                                                                    <label> Ubicaci&oacute;n</label>
                                                                    <input class="form-control"  name="ubicacion" placeholder="Enter text" value="${requestScope.Activo.ubicacion}"/>
                                                                </div>
                                                            </th>
                                                            <td></td>
                                                            <th colspan="2">

                                                                <div class="form-group">
                                                                    <label> N&uacute;mero de Serie</label>
                                                                    <input class="form-control"  name="numeroSerie" placeholder="Enter text" value="${requestScope.Activo.numeroSerie}"/>
                                                                </div>
                                                            </th>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> Funcionamiento</label>
                                                                    <div class="form-group">
                                                                        <label class="radio-inline">
                                                                            <input type="radio" name="funcionamiento" id="optionsRadiosInline2" value="si" checked>Si
                                                                        </label>
                                                                        <label class="radio-inline">
                                                                            <input type="radio" name="funcionamiento" id="optionsRadiosInline3" value="no" >No
                                                                        </label>
                                                                    </div> 
                                                                </div>
                                                            </th>
                                                            <td></td>
                                                            <th colspan="3">
                                                                <div class="form-group">
                                                                    <label> Referencia</label>
                                                                    <input class="form-control" name="referencia" placeholder="Enter text" value="${requestScope.Activo.referencia}">
                                                                </div>

                                                            </th>

                                                            <td></td>
                                                            <td></td>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="2">
                                                                <label>Cuenta con Manual</label> 
                                                            </th>


                                                            <th colspan="6">
                                                                <div class="form-group">
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="manual" id="optionsRadiosInline2" value="si">Si
                                                                    </label>
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="manual" id="optionsRadiosInline3" value="no" checked>No
                                                                    </label>
                                                                </div> 

                                                                
                                                            </th>

                                                        </tr>


                                                        <tr>
                                                            <th colspan="8">

                                                            </th>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="2">
                                                                <label>Categor&iacute;a</label> 
                                                            </th>


                                                            <th colspan="6">
                                                                <div class="form-group">
                                                                    <select name="categoria" class="form-control">
                                                                     <c:forEach items="${requestScope.categorias}" var="categoria" varStatus="status">
                                                                        <c:choose>
                                                                            <c:when test="${requestScope.Activo.categoria.id == categoria.id}">
                                                                                <option value="${categoria.id}" selected="true">${categoria.nombre}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                               <option value="${categoria.id}">${categoria.nombre}</option>  
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>  
                                                                    </select>
                                                                </div> 

                                                                 <button type="submit" name="update" class="btn btn-default">Actualizar</button>  
                                                                <button type="delete" name="update" class="btn btn-default">Borrar</button>       
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
                        </form>




                    </div>

                </div>

                <div class="panel panel-success">
                    <div class="panel-heading">
                        Mantenimiento Preventivo
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Periodicidad</th>
                                        <th>Actividad</th>
                                        <th>Materiales</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.Activo.mantenimientoPreventivo}" var="preventivo">
                                        <tr>
                                        <td>1</td>
                                        <td>${preventivo.numMeses}</td>
                                        <td>${preventivo.actividad}</td>
                                        <td>${preventivo.materiales}</td>
                                        
                                    </tr>
                                    </c:forEach>
                                                                       
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->

                    </div>

                </div>


                <div class="panel panel-success">
                    <div class="panel-heading">
                        Mantenimiento Correctivo
                    </div>
                    <div class="panel-body">

                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Fecha</th>
                                        <th>Da&ntilde;o Encontrado</th>
                                        <th>Descripci&oacute;n del Mantenimiento</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>10/12/2016</td>
                                        <td>Fusible</td>
                                        <td>Cambio de fusible</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>10/12/2016</td>
                                        <td>Fusible</td>
                                        <td>Cambio de fusible</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>10/12/2016</td>
                                        <td>Fusible</td>
                                        <td>Cambio de fusible</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->


                    </div>

                </div>







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
