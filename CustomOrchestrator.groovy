def call() {
    echo "loading chaos-framework-library"
    final chaosFramework = library('chaos-framework-library')
    def chaosUtil = chaosFramework.utility.ChaosUtil

    stage('cleanWs') {
        cleanWs()
    }
    stage('checkout') {
        checkout scm
    }
    /*stage('Inject JBoss Server in endpoint LSTSCINFJB0AV25 with 100% CPU and 3GB DiskIO parallel for 35 minutes') {
        try {
            echo "Injecting CPU fault"
            echo "executing ${chaosUtil.injectCPUFault(this, "LSTSCINFJB0AV25", 2.1e+6, "LSTSCINFJB0AV25", null, "iteration3-cpu", 100)}"

        } catch (Exception e) {
            println e.getMessage()
        }

        try {
            echo "Injecting DiskIO fault"
            echo "executing ${chaosUtil.injectDiskIOFault(this, "LSTSCINFJB0AV25", 2.1e+6, "LSTSCINFJB0AV25", null, "iteration3-diskIO", 3e+6, "/home/trps.mas.gov.sg/a_jbs")}"

        } catch (Exception e) {
            println e.getMessage()
        }
    }*/

    stage('Inject MySQL DB Server Primary RW node in endpoint LSTSCINFDB0EV04 with 100% CPU and 3GB DiskIO parallel for 35 minutes') {
        try {
            echo "Injecting CPU fault"
            echo "executing ${chaosUtil.injectCPUFault(this, "LSTSCINFJB0AV25", 2.1e+6, "LSTSCINFJB0AV25", null, "iteration3-cpu", 100, false, "", 1, "schedId-1", "schedulingTest")}"

        } catch (Exception e) {
            println e.getMessage()
        }

        try {
            echo "Injecting DiskIO fault"
            echo "executing ${chaosUtil.injectDiskIOFault(this, "LSTSCINFJB0AV25", 2.1e+6, "LSTSCINFJB0AV25", null, "iteration3-diskIO", 3e+6, "/home/trps.mas.gov.sg/a_jbs", false, "", 1, "schedId-1", "schedulingTest")}"

        } catch (Exception e) {
            println e.getMessage()
        }
    }
}

return this

