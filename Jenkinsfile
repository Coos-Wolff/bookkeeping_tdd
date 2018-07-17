pipeline {
    agent any
    tools {
        maven 'Maven_3.5.4'
    }
    stages {
        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
		}
		stage('Compile') {
			steps {
				sh 'mvn compile
			}
		}
		stage('Install') {
			steps {
				sh 'mvn install'
			}
		}
	}
}