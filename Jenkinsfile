@Library('chaos-framework-library') _

pipeline {
    agent any
    stages{
        stage('Load CustomOrchestratorGrp'){
            steps{
                script{
                    orchestrator = load 'CustomOrchestratorGrp.groovy'
                    orchestrator.call()
                }
            }
        }
    }
}
