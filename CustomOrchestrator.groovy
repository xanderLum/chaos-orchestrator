def call() {
    final chaosFramework = library('chaos-framework-library')

    stage('cleanWs') {
        cleanWs()
    }
    stage('checkout') {
        checkout scm
    }
    stage('Inject JBoss Server in Group A with 25% CPU and 25% RAM for 10 seconds') {
        try {
            echo "loading chaos-framework-library utility.ChaosUtil"
            def chaosUtil = chaosFramework.utility.ChaosUtil
            echo "loading chaos-framework-library utility.VMWareMangle.ReqMapper.CPURequestObj"
            def reqMapper = chaosFramework.utility.VMWareMangle.ReqMapper.CPURequestObj.new("remote-tomcat", null, "remote-tomcat", null, "cpu")
            echo "cpuReq: ${reqMapper}"

            echo "Injecting Cpu fault"
            echo "cpuRequestObj : ${cpuRequestObj}"
            echo "executing ${chaosFramework.utility.ChaosUtil.injectCPUFault(this, cpuRequestObj)}"

        } catch (Exception e) {
            println e.getMessage()
        }
    }

    /*stage('Inject JBoss Server in Group A with 25% CPU and 25% RAM for 10 seconds') {
        steps{
            script{
                def ochestrator = load 'CustomOrchestrator.groovy'
                ochestrator.call()
            }
        }
    }*/
}
/*  cleanWs()
 checkout scm
 orchestrator = load 'CustomOrchestrator.groovy'
 orchestrator.call() */

/*stage('Inject JBoss Server in Group A with 25% CPU and 25% RAM for 10 seconds') {
    try {
        echo "loading chaos-framework-library utility.ChaosUtil"
        def chaosUtil = chaosFramework.utility.ChaosUtil
        echo "loading chaos-framework-library utility.VMWareMangle.ReqMapper.CPURequestObj"
        def reqMapper = chaosFramework.utility.VMWareMangle.ReqMapper.CPURequestObj.new("remote-tomcat", null, "remote-tomcat", null, "cpu")
        echo "cpuReq: ${reqMapper}"

        echo "Injecting Cpu fault"
        echo "cpuRequestObj : ${cpuRequestObj}"
        echo "executing ${chaosFramework.utility.ChaosUtil.injectCPUFault(this, cpuRequestObj)}"

    } catch (Exception e) {
        println e.getMessage()
    }
}*/
return this

