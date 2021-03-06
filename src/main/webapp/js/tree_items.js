var TREE_ITEMS = [
	[' Sistema de Multas', 0,				
		[' Registro',0,
		     [' Resoluciones', '../pages/registros/cargarPagResolucion.htm'],
			 [' Notificaciones', '../pages/registros/cargarPagNotificaciones.htm'],
			 [' Pagos',   0,
  			   [' Manual',   '../pages/registros/cargarPagPagos.htm'],
  			   [' Importar Pagos',   '../pages/registros/cargarPagImpPagos.htm'],
			   [' Exportar Multas',   '../pages/registros/cargarPagExpPagos.htm'],
			 ],

			// [' Nulidad',  '../pages/registros/cargarPagAnulacion.htm'],
			// [' Suspension',  '../pages/registros/cargarPagSuspension.htm'],
			 [' Recursos impugnativos', '../pages/registros/_RecursoImpugnativo.htm'],
			 [' Ejecutoria coactiva',  '../pages/registros/_EjecucionCoactivo.htm'],
		],
		
		[' Procesos',0,
			 [' Generación del Asiento de Orden', '../pages/procesos/cargarPagCtaOrden.htm'],
			 [' Generación del Asiento de Pago',   '../pages/procesos/cargarPagAsientoPagos.htm'],
			 [' Generación del Asiento de Nulidad',  '../pages/procesos/cargarAsientoNulidad.htm'],
			 [' Generación del Asiento de Suspension',  '../pages/procesos/cargarAsientoSuspension.htm'],
			 [' Generación del Asiento de Modificacion',  '../pages/procesos/CargarAsientoModificacion.htm'],
			 [' Enviar a Cobranza Dudosa', '../pages/registros/_RegCobranzaDudosa.htm'],
		],		
		
		[' Consulta',0,
		    [' Por empresa', 'http://www.softcomplex.com/services.html'],
			[' Por modalidad', 'http://www.softcomplex.com/download.html'],		
		    [' Por área', 'http://www.softcomplex.com/services.html'],
			[' De los pagos', '../pages/consultas/cargarPagos.htm'],
			[' De las resoluciones emitidas', 'http://www.softcomplex.com/services.html'],
			[' Del estado de los recursos impugnativos', 'http://www.softcomplex.com/services.html'],
			[' De notificación', 'http://www.softcomplex.com/services.html'],
			[' Ejecutoria coactiva', 'http://www.softcomplex.com/services.html'],
			[' Interfaz con SFH',  '../pages/consultas/cargar_Intf_SFH.htm'],
		],
		[' Reporte',0,
		     [' Diario de niveles de cobranza', 'http://www.softcomplex.com/services.html'],
			 [' Resumen de resoluciones de multa mensuales', 'http://www.softcomplex.com/download.html'],
			 [' De resoluciones de multa',    'http://www.softcomplex.com/order.html'],
			 [' Histórico de las resoluciones de multa',  'http://www.softcomplex.com/support.html'],
   			 [' De notificación de resoluciones', 'http://www.softcomplex.com/services.html'],
 			 [' De expediente de cobranza coactiva', 'http://www.softcomplex.com/services.html'],
			 [' De multas de cobranzas coactiva', 'http://www.softcomplex.com/services.html'],
			 [' De multas por cobrar', 'http://www.softcomplex.com/services.html'],
			 [' Resumen situación de multas', 'http://www.softcomplex.com/services.html'],
			 [' De recursos impugnativos', 'http://www.softcomplex.com/services.html'],
			 [' De multas por administrado o concesionario', 'http://www.softcomplex.com/services.html'],
		],
			
		[' Administración',0,
		    [' Empresas', '../pages/admin/cargarPagEmpresas.htm'],
			[' Bancos', '../pages/admin/cargarPagBancos.htm'],
			[' Calendario', '../pages/admin/cargarPagCalendario.htm'],
			[' Parámetros del sistema', '../pages/admin/cargarParametros.htm'],
			[' Configuracion de Asientos', '../pages/admin/cargarCfgAsientos.htm'],
			[' Parámetros de Asientos', '../pages/admin/cargarPagParamAsientos.htm'],

		],
	]
];