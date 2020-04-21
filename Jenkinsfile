pipeline {
    agent any
    tools {
      maven 'Maven'
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
                    /* sh "docker build -f Dockerfile -t runhtml:${scmVars.GIT_COMMIT} ." */
                    sh "sudo apt-get install -y docker-client"
                    app = docker.build("runhtml:${scmVars.GIT_COMMIT}")
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
                /* #sh "docker login -u ${params.REGISTRY_USERNAME} -p ${params.REGISTRY_TOKEN} iad.ocir.io"
                #sh "docker tag runhtml:${scmVars.GIT_COMMIT} ${params.DOCKER_REPO}:${scmVars.GIT_COMMIT} -v /var/run/docker.sock:/var/run/docker.sock"
                #sh "docker push ${params.DOCKER_REPO}:${scmVars.GIT_COMMIT}" 
                */
                docker.withRegistry('iad.ocir.io', '-u ${params.REGISTRY_USERNAME} -p ${params.REGISTRY_TOKEN}') {
                    app.push("${params.DOCKER_REPO}:${scmVars.GIT_COMMIT}")
                    app.push("${scmVars.GIT_COMMIT}")
                }
                env.GIT_COMMIT = scmVars.GIT_COMMIT
                sh "export GIT_COMMIT=${env.GIT_COMMIT}"
                }
               }
            }
        }
}
