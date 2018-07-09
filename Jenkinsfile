pipeline {
	agent any
	
    stages {
        stage('Build') {
            steps {
                sh 'make' 
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
            }
        }
		
		stage('Test') {
            steps {
                /* `make check` returns non-zero on test failures,
                * using `true` to allow the Pipeline to continue nonetheless
                */
                sh 'make check || true' 
                junit '**/target/*.xml' 
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