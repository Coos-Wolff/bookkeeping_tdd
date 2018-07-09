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
			steps {
				sh '''#!/bin/bash -l
				mvn sonar:sonar
				'''
			}
        }
    }
}