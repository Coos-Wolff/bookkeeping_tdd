pipeline {
	agent any
	
    stages {
        stage('Build') {
            steps {
                sh 'make' 
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
            }
        }
		
		stage('SonarQube analysis') {
			steps {
				sh '''#!/bin/bash -l
				mvn sonar:sonar
				'''
			}
        }
    }
}