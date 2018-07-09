pipeline {
	agent any
	tools {
		maven: 'Maven 3.5.0'
		jdk: 'jdk8'
	}
	
    stages {
        stage('Build') {
            steps {
                sh '''#!/bin/bash -l
				mvn clean javadoc:jar source:jar deploy -DskipITs=false -U
                '''
            }
        }
		
		stage('Test') {
            steps {
				sh 'mvn clean verify'
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