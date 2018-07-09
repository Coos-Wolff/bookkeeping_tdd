pipeline {
	agent any
	
    stages {
        stage('Build') {
            steps {
                sh '''#!/bin/bash -l
				mvn clean javadoc:jar source:jar deploy -DskipITs=false -U
                '''
            }
        }
		
		stage('SonarQube analysis') {
            sh 'mvn sonar:sonar'
        }
    }
}