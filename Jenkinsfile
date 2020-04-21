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
        
        stage('Remove Unused docker image') {
          steps{
            sh "docker rmi " + params.DOCKER_REPO + "/runhtml:latest"
          }
        } 

        stage('Deploy to OKE') {
          steps{
            sh "mkdir -p $HOME/.kube
            sh "oci ce cluster create-kubeconfig --cluster-id ocid1.cluster.oc1.iad.aaaaaaaaaezdonldgvtgiojrgq2gim3bgnrwcyjsgezdcnjzgc2tkm3egjrw --file $HOME/.kube/config --region us-ashburn-1 --token-version 2.0.0"
            sh "export KUBECONFIG=\$HOME/.kube/config"
            sh "kubectl config view"
            sh "kubectl get nodes"
            sh "kubectl replace -f kubernetes.yaml --force"
            sh "sleep 120"
            sh "kubectl get services runhtml-service"
            sh "kubectl get pods"
            sh "kubectl describe pods"
          }
        } 
        
    }
}
