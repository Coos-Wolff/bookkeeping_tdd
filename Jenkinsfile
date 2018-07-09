pipeline {
	agent any
	tools {
		maven 'Maven'
		jdk 'jdk8'
	}
	
    stages {
		stage ('Initialize') {
				steps {
					sh '''
						echo "PATH = ${PATH}"
						echo "M2_HOME = ${M2_HOME}"
					''' 
				}
			}
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