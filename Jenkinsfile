pipeline {
    agent any
    tools {
        maven 'maven 3'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/khaleedcodes/devops.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'No tests implemented'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying artifact...'
            }
        }
    }
}
