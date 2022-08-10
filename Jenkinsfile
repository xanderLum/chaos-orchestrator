@Library('chaos-framework-library') _
def orchestrator

node {
    cleanWs()
    checkout scm
    orchestrator = load '@script/*/CustomOrchestrator.groovy'
    orchestrator.call()
}