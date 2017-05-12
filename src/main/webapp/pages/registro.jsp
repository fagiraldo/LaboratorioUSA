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
            <form action="ActivoServlet" method="POST">
                <div id="page-wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">FO-08 HOJA DE VIDA MAQUINARIA Y EQUIPOS</h1>
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
                            Activo a ingresar en inventario
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
                                                                    <label class="control-label" for="inputError">Nombre Equipo o M&aacute;quina</label>
                                                                    <input class="form-control" name="nombreEquipo" placeholder="Enter text" required>
                                                                </div>


                                                            </th>
                                                            <td></td>
                                                            <td></td>
                                                            <th colspan="3">
                                                                <div class="form-group">
                                                                    <label> Fecha de Adquisici&oacute;n</label>
                                                                    <input id="meeting" type="date" name="fechaAdquisicion" required/>
                                                                </div>



                                                            </th>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> C&oacute;digo</label>
                                                                    <input class="form-control"  name="codigo" placeholder="Enter text"required>
                                                                </div>


                                                            </th>
                                                            <td></td>
                                                            <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> Marca</label>
                                                                    <input class="form-control"  name="marca" placeholder="Enter text" required>
                                                                </div></th>
                                                            <td></td>
                                                            <th colspan="2">
                                                                <div class="form-group">
                                                                    <label> Modelo</label>
                                                                    <input class="form-control"  name="modelo" placeholder="Enter text" required>
                                                                </div>


                                                            </th>
                                                        </tr>


                                                        <tr>
                                                            <th colspan="5">

                                                                <div class="form-group">
                                                                    <label> Ubicaci&oacute;n</label>
                                                                    <input class="form-control"  name="ubicacion" placeholder="Enter text" required>
                                                                </div>
                                                            </th>
                                                            <td></td>
                                                            <th colspan="2">

                                                                <div class="form-group">
                                                                    <label> N&uacute;mero de Serie</label>
                                                                    <input class="form-control"  name="numeroSerie" placeholder="Enter text" required>
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
                                                                    <input class="form-control" name="referencia" placeholder="Enter text" required>
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
                                                            <th colspan="2">
                                                                <label>Categor&iacute;a</label> 
                                                            </th>


                                                            <th colspan="6">
                                                                <div class="form-group">
                                                                    <select name="categoria" class="form-control">
                                                                       <c:forEach items="${requestScope.categorias}" var="categoria" varStatus="status">
                                                                           <option value="${categoria[0]}">${categoria[1]}</option>  
                                                                         
                                                                        </c:forEach>    
                                                                        
                                                                    </select>
                                                                </div> 


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
                            <button type="submit" class="btn btn-default">Ingresar Activo</button> 
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
