pipeline {
    agent any
    tools {
      maven 'Maven'
      'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }   
    environment {
        registry = "iad.ocir.io/idavixsf5sbx/cristianohoshikawa"
        registryCredential = 'docker-credential'
    }
    stages {
        
        stage('Build') { 
            steps {
                sh "mvn -f pom.xml package" 
            }
        }
        stage('Create docker image') { 
            steps {
                script {
                    def scmVars = checkout([
                        $class: 'GitSCM',
                        doGenerateSubmoduleConfigurations: false,
                        userRemoteConfigs: [[
                            url: 'https://github.com/hoshikawa2/runHTMLJenkins.git'
                          ]],
                        branches: [ [name: '*/master'] ]
                      ])
                    /*sh "docker build -f Dockerfile -t " + registry + "/runhtml:latest ."*/
                    app = docker.build(registry + "/runhtml:latest") 
                }
            }
        }
        stage('Push image to OCIR') { 
            steps {
                script {
                    def scmVars = checkout([
                        $class: 'GitSCM',
                        doGenerateSubmoduleConfigurations: false,
                        userRemoteConfigs: [[
                            url: 'https://github.com/hoshikawa2/runHTMLJenkins.git'
                          ]],
                        branches: [ [name: '*/master'] ]
                      ])
    sh "id"
    sh "echo $PATH"
    sh "docker images"
    sh "docker push " + registry + "/runhtml:latest"
                    /*sh "docker login iad.ocir.io -u ${params.REGISTRY_USERNAME} -p ${params.REGISTRY_TOKEN}"
                        sh "docker tag runhtml:${scmVars.GIT_COMMIT} ${params.DOCKER_REPO}:${scmVars.GIT_COMMIT}"
                        sh "docker push ${params.DOCKER_REPO}:${scmVars.GIT_COMMIT}" */
/*
                        docker.withRegistry('https://iad.ocir.io', 'docker-credential') {
                            app.push(registry + "/runhtml")
                        }               
                */
                }                       
            }
        }
    }
}
