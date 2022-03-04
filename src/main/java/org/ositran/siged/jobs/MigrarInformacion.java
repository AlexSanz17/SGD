package org.ositran.siged.jobs;

public class MigrarInformacion {

	private RecepcionPideDaoForJob recepcionPideDaoForJob;

	public MigrarInformacion() {
		super();
	}

	public MigrarInformacion(RecepcionPideDaoForJob recepcionPideDaoForJob) {
		setRecepcionPideDaoForJob(recepcionPideDaoForJob);
	}

	

	public void migrar() {
		System.out.println("============================");
		System.out.println("Job migracion");
		System.out.println("============================");

		// obtener informacion de db origen

		// SELECT SIDRECEXT, BCARSTD, CCODUNIORGSTD, CFLGENVCAR, CFLGEST, CFLGESTOBS,
		// CTIPDOCIDEREM, DFECMOD, DFECREG, DFECREGSTD, VANIOREGSTD, VCUO, VCUOREF,
		// VDESANXSTD, VNUMDOCIDEREM, VNUMREGSTD, VOBS, VRUCENTREM, VUNIORGREM,
		// VUNIORGSTD, VUSUMOD, VUSUREGSTD
		// FROM [BD_PCM_INTEROPERABILIDAD].[IDOSGD].[IOTDTC_RECEPCION]
		// WHERE SIDRECEXT IN (5)

		// insertar informaciuon en db destino

		// INSERT INTO IOTDTC_RECEPCION (SIDRECEXT , BCARSTD , CCODUNIORGSTD ,
		// CFLGENVCAR , CFLGEST , CFLGESTOBS , CTIPDOCIDEREM , DFECMOD , DFECREG ,
		// DFECREGSTD , VANIOREGSTD , VCUO , VCUOREF , VDESANXSTD , VNUMDOCIDEREM ,
		// VNUMREGSTD , VOBS, VRUCENTREM , VUNIORGREM , VUNIORGSTD , VUSUMOD ,
		// VUSUREGSTD )
		// VALUES (5 , NULL , NULL , 'N' , 'P' , NULL , 1 , NULL , '2021-12-06
		// 13:31:33.357' , NULL , NULL , '0000008684', '' , NULL , 12345678 , NULL ,
		// NULL, 20168999926 , 'Help Desk' , NULL , NULL , NULL )

		System.out.println("leer datos de schema normal");
		recepcionPideDaoForJob.getAllt();
		
		System.out.println("leer datos de schema getAllSchemaIdosgd");
		recepcionPideDaoForJob.getAllSchemaIdosgd();

		

	}

	public RecepcionPideDaoForJob getRecepcionPideDaoForJob() {
		return recepcionPideDaoForJob;
	}

	public void setRecepcionPideDaoForJob(RecepcionPideDaoForJob recepcionPideDaoForJob) {
		this.recepcionPideDaoForJob = recepcionPideDaoForJob;
	}

	
	
	
}
