properties([
    parameters ([
        string(name: 'BUILD_NODE', defaultValue: 'ossim-test-build', description: 'The build node to run on'),
        string(name: 'TARGET_DEPLOYMENT', defaultValue: 'dev', description: 'The deployment to run the tests against'),
        booleanParam(name: 'CLEAN_WORKSPACE', defaultValue: true, description: 'Clean the workspace at the end of the run')
    ]),
    pipelineTriggers([
            [$class: "GitHubPushTrigger"]
    ]),
    disableConcurrentBuilds()
])

node ("${BUILD_NODE}"){

    stage("Checkout branch $BRANCH_NAME")
    {
        checkout(scm)
    }

    stage("Load Variables")
    {
        step ([$class: "CopyArtifact",
        projectName: "ossim-ci",
           filter: "common-variables.groovy",
           flatten: true])

        load "common-variables.groovy"
    }

    stage("Pull Artifacts")
    {
        step ([$class: "CopyArtifact",
            projectName: "ossim-ci",
            filter: "cucumber-configs/cucumber-config-frontend.groovy",
            flatten: true])
    }
    try {
        stage("Run Test") {
            sh """
                echo "TARGET_DEPLOYMENT = ${TARGET_DEPLOYMENT}"
                export CUCUMBER_CONFIG_LOCATION="cucumber-config-frontend.groovy"
                export DISPLAY=":1"
                gradle frontend
                echo ""
            """
        }
    } finally {
        stage("Archive"){
            sh "cp build/frontend.json ."
            archiveArtifacts "frontend.json"
        }

        stage("Publish Report"){
            step([$class: 'CucumberReportPublisher',
                fileExcludePattern: '',
                fileIncludePattern: '',
                ignoreFailedTests: false,
                jenkinsBasePath: '',
                jsonReportDirectory: "build",
                parallelTesting: false,
                pendingFails: false,
                skippedFails: false,
                undefinedFails: false])
           cucumberSlackSend channel: '#ossimlabs_jenkins', json: "build/frontend.json"
        }

        stage("Clean Workspace")
        {
            if ("${CLEAN_WORKSPACE}" == "true"){
                archiveArtifacts '**/*.flv,**/*.mp4'
                step([$class: 'WsCleanup'])
            }
        }
    }
}
