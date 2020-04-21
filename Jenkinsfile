pipeline {
    agent any
    tools {
      maven 'Maven'
      'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
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
                    /*sh "docker build -f Dockerfile -t runhtml:${scmVars.GIT_COMMIT} ."*/
                    app = docker.build("${scmVars.DOCKER_REPO}/runhtml")
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
                        /*sh "docker login iad.ocir.io -u ${params.REGISTRY_USERNAME} -p ${params.REGISTRY_TOKEN}"
                        sh "docker tag runhtml:${scmVars.GIT_COMMIT} ${params.DOCKER_REPO}:${scmVars.GIT_COMMIT}"
                        sh "docker push ${params.DOCKER_REPO}:${scmVars.GIT_COMMIT}" */

                        docker.withRegistry('https://iad.ocir.io', 'docker-credential') {
                            app.push("${scmVars.DOCKER_REPO}/runhtml")
                            app.push("latest")
                        }                        
                }                       
            }
        }
    }
}
