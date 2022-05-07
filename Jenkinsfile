pipeline {
    agent { docker { image 'maven:3.3.3' } }
        stages {
            stage('log version info') 
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