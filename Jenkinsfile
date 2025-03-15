pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials'
        DOCKER_IMAGE = 'devbams/maven-webapp'  // Adjust Docker image name
        DOCKER_HUB_USERNAME = 'devbams'
        GIT_CREDENTIALS_ID = 'GitHub-PAT'  // Use the correct GitHub PAT ID
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Checkout code using GitHub Personal Access Token
                git credentialsId: GIT_CREDENTIALS_ID, url: 'https://github.com/khaleedcodes/devops.git', branch: 'main'
            }
        }

        stage('Build Maven Project') {
            steps {
                // Run Maven clean and package
                sh 'mvn clean package'
            }
        }

        stage('Login to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: DOCKER_CREDENTIALS_ID, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build Docker image
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                // Push the Docker image to Docker Hub
                sh 'docker push $DOCKER_IMAGE'
            }
        }
    }
}
