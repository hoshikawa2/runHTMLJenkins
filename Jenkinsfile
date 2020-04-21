pipeline {
    agent any
    tools {
      maven 'Maven'
      'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }   
    environment {
        registry = "iad.ocir.io/idavixsf5sbx/cristianohoshikawa"
        registryCredential = 'docker-credential'
        app = ''
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
                    /* app = docker.build(registry + "/runhtml:latest")  */
                    sh 'docker build -t ' + params.DOCKER_REPO + '/runhtml:latest .'
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
    /*
                            docker.withRegistry('https://iad.ocir.io', 'docker-credential') {
                            app.push(registry + "/runhtml")
                        }               
    */
                    sh 'docker login https://iad.ocir.io -u ' + params.REGISTRY_USERNAME + ' -p "' + params.REGISTRY_TOKEN + '"'
                    sh 'docker push ' + params.DOCKER_REPO + '/runhtml:latest'
                }                       
            }
        }
    }
}
