pipeline {
    agent { 
        dockerfile { 
        }
    }
        stages {
            stage('Build') {
                steps {
                    sh 'mvn --version'
                    sh 'mvn clean install'
                }
            }
            stage('Test') {
                steps {
                    sh 'mvn test lint:check'
                }
                post {
                    always {
                        junit '**/surefire-reports/*.xml'
                        archiveArtifacts artifacts: '**/target/*.war'
                    }
                }
            }
            stage ('Integration Test') {
                steps {
                    sh 'mvn verify'
                }
            }
            stage ('Deploy') {
                steps {
                    script {
                        deploy adapters: [tomcat8(credentialsId: 'tomcat_deployer', path: '', url: 'http://54.227.56.71:8081/')], contextPath: '/OnlineBookStore', war: '**/*.war' 
                    }
                }
            }
        }   
    }