pipeline {
    agent any
    
    tools {
        maven 'Maven 386'
    }
    
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
                archiveArtifacts 'target/*.war'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
    post {
        always {
            echo 'Je passe toujours par là'
            //deleteDir()
        }
    }
}