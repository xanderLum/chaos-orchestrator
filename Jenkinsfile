@Library('chaos-framework-library') _
def orchestrator

node {
    orchestrator = load '@script/*/CustomOrchestrator.groovy'
    orchestrator.call()
}