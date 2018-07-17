pipeline {
    agent any
    tools {
        maven 'Maven_3.5.4'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean verify'
            }
        }
    }
}