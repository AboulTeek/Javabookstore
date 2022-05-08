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
    }
}