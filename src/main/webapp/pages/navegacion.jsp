<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html">Sistema de Gestión de Laboratorio</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">


        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-comment fa-fw"></i> ALERTAS
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>


                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                            <span class="pull-right text-muted small">12 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="div


                    ider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-envelope fa-fw"></i> Message Sent
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-tasks fa-fw"></i> New Task
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-upload fa-fw"></i> Server Rebooted
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>See All Alerts</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
            <!-- /.dropdown-alerts -->
        </li>
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                </li>
                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                </li>
                <li class="divider"></li>
                <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">

                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i> Gesti&oacute;n<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                         <li>
                            <a href="CategoriaServlet?index">Gestionar Categor&iacute;a</a>
                        </li>
                        <li>
                            <a href="DependenciaServlet?index">Gestionar Dependencia</a>
                        </li>
                        <li>
                            <a href="ProgramaServlet?index">Gestionar Programa</a>
                        </li>

                        <li>
                            <a href="PersonaServlet?indexAuxiliar">Registrar Auxiliar</a>
                        </li>

                        <li>
                            <a href="PersonaServlet?indexDocente">Registrar Docente</a>
                        </li>
                        
                        <li>
                            <a href="PersonaServlet?indexEstudiante">Registrar Estudiante</a>
                        </li>

                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                
                
                <li>
                    <a href="buscador.jsp"><i class="fa fa-dashboard fa-fw"></i> Buscador</a>
                </li>
                
               
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i> Movimientos<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="ActivoServlet?index">Ingreso de Activos</a>
                        </li>
                        <li>
                            <a href="busqueda.jsp">B&uacute;squeda de Activos</a>
                        </li>

                        <li>
                            <a href="prestamo.jsp">Pr&eacute;stamo de Activos</a>
                        </li>

                        <li>
                            <a href="devolucion.jsp">Devoluci&oacute;n de Activos</a>
                        </li>
                        
                        <li>
                            <a href="inventario.jsp">Inventario</a>
                        </li>

                    </ul>
                    <!-- /.nav-second-level -->
                </li>


                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i> Mantenimiento<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="preventivo.jsp">Preventivo</a>
                        </li>

                        <li>
                            <a href="correctivo.jsp">Correctivo</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>

                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i> Reportes<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="dashboard.jsp">Inventario</a>
                        </li>

                        <li>
                            <a href="dashboard.jsp">Movimiento de Activos</a>
                        </li>

                        <li>
                            <a href="flot.jsp">Estad&iacute;sticas de Uso</a>
                        </li>

                        <li>
                            <a href="pazysalvo.jsp">Paz y Salvo</a>
                        </li>


                    </ul>
                    <!-- /.nav-second-level -->
                </li>

                 <li>
                    <a href="dashboard.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                </li>
                
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>