/*library('chaos-framework-library').constants.APIGroovy
library('chaos-framework-library').constants.Credentials
library('chaos-framework-library').utility.APIReqBuilder
library('chaos-framework-library').utility.ChaosUtil
library('chaos-framework-library').utility.VMWareMangle.ReqMapper.CPURequestObj
library('chaos-framework-library').utility.VMWareMangle.ReqMapper.DiskIORequestObj
library('chaos-framework-library').utility.VMWareMangle.ReqMapper.MemoryRequestObj*/

/**
 * CustomOrchestrator
 *
 * @param gameplay
 * @return
 */
def call() {
    node {
        /*stage('Clean Workspace') {
            cleanWs()
        }
        stage('Checkout') {
            checkout scm
        }*/

        stage('Inject JBoss Server in Group A with 25% CPU and 25% RAM for 10 seconds') {
            try {
                echo "loading chaos-framework-library utility.ChaosUtil"
                def chaosUtil = library('chaos-framework-library').utility.ChaosUtil
                echo "loading chaos-framework-library utility.VMWareMangle.ReqMapper.CPURequestObj"

                def reqMapper = library('chaos-framework-library').utility.VMWareMangle.ReqMapper
                def cpuRequestObj = reqMapper.CPURequestObj.new("remote-tomcat", null, "remote-tomcat", null, "cpu")
                echo "cpuReq: ${cpuRequestObj}"
//                def cpuRequestObj = library('chaos-framework-library').utility.VMWareMangle.ReqMapper.CPURequestObj.new("remote-tomcat", null, "remote-tomcat", null, "cpu")

                //        super(endpointName, timeoutInMilliseconds, id, injectionHomeDir, taskName)
                echo "Injecting Cpu fault"
                echo "cpuRequestObj : ${cpuRequestObj}"
                echo "executing ${chaosUtil.injectCPUFault(this, cpuRequestObj)}"

            } catch (Exception e) {
                println e.getMessage()
            }

            /*try {
                ChaosUtil.MemoryFault("groupA", 25, 10)
            } catch (Exception e) {
                println e.getMessage()
            }*/
        }
    }
}

return this

