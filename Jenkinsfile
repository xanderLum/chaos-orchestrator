@Library('chaos-framework-library') _

pipeline {
    agent any
    stages{
        stage('ready'){
            steps{
                script{
                    /* cleanWs()
                    checkout scm */
                    orchestrator = load 'CustomOrchestrator.groovy'
                    orchestrator.call()
                }
            }
        }
    }
}
