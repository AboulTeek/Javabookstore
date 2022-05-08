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
            }
            stage ('Deploy') {
                steps {
                    script {
                        deploy adapters: [tomcat8(credentialsId: 'tomcat_deployer', path: '', url: 'http://54.227.56.71:8080/')], contextPath: '/OnlineBookStore', war: '**/*.war' 
                    }
                }
            }
            stage ('Publish') {
                steps {
                    script {
                        publishArtifacts(artifacts: '**/target/surefire-reports/*.xml')
                    }
                }
            }
    }
}