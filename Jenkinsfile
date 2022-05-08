pipeline {
    agent { 
        dockerfile { 
            label "docker-build"
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