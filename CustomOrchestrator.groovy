def call() {
    final chaosFramework = library('chaos-framework-library')

    stage('cleanWs') {
        cleanWs()
    }
    stage('checkout') {
        checkout scm
    }
    stage('Inject JBoss Server in Group A with 100% CPU and 90% RAM for 10 seconds') {
        echo "loading chaos-framework-library utility.ChaosUtil"
        def chaosUtil = chaosFramework.utility.ChaosUtil

        try {
            echo "Injecting Cpu fault"
            //params:
            //this exec, "endpointname", timeout in ms, id, injectionHomeDir, taskname, cpuLoad
            echo "executing ${chaosUtil.injectCPUFault(this, "remote-tomcat", 10, "remote-tomcat", null, "cpu", 100)}"
        } catch (Exception e) {
            println e.getMessage()
        }

        try {
            echo "Injecting Memory fault"
            //params:
            //this exec, "endpointname", timeout in ms, id, injectionHomeDir, taskname, memoryLoad
            echo "executing ${chaosUtil.injectMemoryFault(this, "remote-tomcat", 10, "remote-tomcat", null, "memory", 90)}"

        } catch (Exception e) {
            println e.getMessage()
        }
    }
}

return this

