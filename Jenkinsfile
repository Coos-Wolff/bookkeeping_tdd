pipeline {
    agent checkout scm

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean verify' 
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
            }
        }
    }
}