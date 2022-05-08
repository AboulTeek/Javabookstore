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
                    }
                }
            }
            stage ('Integration Test') {
                steps {
                    sh 'mvn verify -Pfailsafe'
                }
            }
            stage ('Deploy') {
                steps {
                    script {
                        deploy adapters: [tomcat8(credentialsId: 'tomcat_deployer', path: '', url: 'http://54.227.56.71:8080/')], contextPath: '/OnlineBookStore', war: '**/*.war' 
                    }
                }
            }
        }   
    }