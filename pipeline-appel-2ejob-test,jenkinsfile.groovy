pipeline {
    agent any
    
    tools {
        maven 'Maven 386'
    }
    
    stages {
        stage('Build') {
            steps {
                dir('exemplev11') {
                    bat 'mvn clean package'
                    archiveArtifacts 'target/*.war'
                }
            }
        }
        stage('Test') {
            steps {
                dir('exemplev11') {
                    bat 'mvn test'
                }
            }
        }
    }
    post {
        always {
            echo 'Je passe toujours par là'
            deleteDir()
        }
    }
}