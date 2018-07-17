pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean verify' 
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
            }
        }
    }
}