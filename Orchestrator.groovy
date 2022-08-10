/*library('chaos-framework-library').constants.APIGroovy
library('chaos-framework-library').constants.Credentials
library('chaos-framework-library').utility.APIReqBuilder
library('chaos-framework-library').utility.ChaosUtil
library('chaos-framework-library').utility.VMWareMangle.ReqMapper.CPURequestObj
library('chaos-framework-library').utility.VMWareMangle.ReqMapper.DiskIORequestObj
library('chaos-framework-library').utility.VMWareMangle.ReqMapper.MemoryRequestObj*/

/**
 * Orchestrator
 *
 * @param gameplay
 * @return
 */
def call(gameplay) {
    node {
        stage('Clean Workspace') {
            cleanWs()
        }
        stage('Checkout') {
            checkout scm
            echo "Executing ${gameplay}"
        }

        stage('Inject JBoss Server in Group A with 25% CPU and 25% RAM for 10 seconds') {
            try {
                def chaosUtil = library('chaos-framework-library').utility.ChaosUtil
                def cpuRequestObj = library('chaos-framework-library').utility.VMWareMangle.ReqMapper.CPURequestObj.new("remote-tomcat", null, "remote-tomcat", null, "cpu")
                //        super(endpointName, timeoutInMilliseconds, id, injectionHomeDir, taskName)
                chaosUtil.injectCPUFault("groupA", 25, 10)
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

