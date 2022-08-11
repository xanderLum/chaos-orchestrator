/**
 * CustomOrchestrator
 *
 * @param gameplay
 * @return
 */
def call() {
//    node {
    def final chaosFramework = library 'chaos-framework-library'
    
    stage('Inject JBoss Server in Group A with 25% CPU and 25% RAM for 10 seconds') {
        try {
            echo "loading chaos-framework-library utility.ChaosUtil"
            def chaosUtil = chaosFramework.utility.ChaosUtil
            echo "loading chaos-framework-library utility.VMWareMangle.ReqMapper.CPURequestObj"
            def reqMapper = chaosFramework.utility.VMWareMangle.ReqMapper.CPURequestObj.new("remote-tomcat", null, "remote-tomcat", null, "cpu")
//                def cpuRequestObj = reqMapper.CPURequestObj.new("remote-tomcat", null, "remote-tomcat", null, "cpu")
            echo "cpuReq: ${reqMapper}"
//                def cpuRequestObj = library('chaos-framework-library').utility.VMWareMangle.ReqMapper.CPURequestObj.new("remote-tomcat", null, "remote-tomcat", null, "cpu")

            //        super(endpointName, timeoutInMilliseconds, id, injectionHomeDir, taskName)
            echo "Injecting Cpu fault"
            echo "cpuRequestObj : ${cpuRequestObj}"
            echo "executing ${chaosFramework.utility.ChaosUtil.injectCPUFault(this, cpuRequestObj)}"

        } catch (Exception e) {
            println e.getMessage()
        }
    }
}
//}

return this

