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
    stage('Inject DB MySQL Server in endpoint javaapp with 100% CPU and 90% Memory parallel for 35 minutes') {
        try {
            echo "Injecting CPU fault"
            echo "executing ${chaosUtil.injectCPUFault(this, "javaapp", 2.1e+6, "javaapp", null, "dbgrp-iteration1-cpu", 100, false, "", 1, "schedId-1", "schedulingTest")}"

        } catch (Exception e) {
            println e.getMessage()
        }

        try {
            echo "Injecting Memory fault"
            echo "executing ${chaosUtil.injectMemoryFault(this, "javaapp", 2.1e+6, "javaapp", null, "dbgrp-iteration1-memory", 90, false, "", 1, "schedId-1", "schedulingTest")}"

        } catch (Exception e) {
            println e.getMessage()
        }
    }

    stage('Inject DB MySQL Server in endpoint javaapp with 3GB DiskIO and 90% DiskSpace parallel for 35minutes seconds') {

        try {
            echo "Injecting DiskIO fault"
            echo "executing ${chaosUtil.injectDiskIOFault(this, "javaapp", 2.1e+6, "javaapp", null, "dbgrp-iteration1-diskIO", 3e+6, "/home/trps.mas.gov.sg/a_osp_chaos", false, "", 1, "schedId-1", "schedulingTest")}"
        } catch (Exception e) {
            println e.getMessage()
        }

        try {
            echo "Injecting DiskSpace fault"
            echo "executing ${chaosUtil.injectDiskSpaceFault(this, "javaapp", 2.1e+6, "javaapp", null, "dbgrp-iteration1-diskSpace", "/home/trps.mas.gov.sg/a_osp_chaos", 90, false, "", 1, "schedId-1", "schedulingTest")}"

        } catch (Exception e) {
            println e.getMessage()
        }
    }
}

return this

