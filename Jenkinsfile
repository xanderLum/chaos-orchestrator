@Library('chaos-framework-library') _

pipeline {
    agent any
    stages{
        stage('cleanWs'){
            steps{
                script{
                 cleanWs()
                }
            }
        }
        stage('checkout'){
                steps{
                        script{
                          checkout scm
                        }
                 }
        }
        stage('Inject JBoss Server in Group A with 25% CPU and 25% RAM for 10 seconds') {
            steps{
                script{
                    def ochestrator = load 'CustomOrchestrator.groovy'
                    ochestrator.call()
                    }
            }
    }
   /*  cleanWs()
    checkout scm
    orchestrator = load 'CustomOrchestrator.groovy'
    orchestrator.call() */
}
