@Library('chaos-framework-library') _
def orchestrator

node {
    cleanWs()
    checkout scm
    orchestrator = load 'CustomOrchestrator.groovy'
    orchestrator.call()
}