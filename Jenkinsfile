pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials'
        DOCKER_IMAGE = 'your-dockerhub-username/maven-webapp'
        DOCKER_HUB_USERNAME = 'devbams'
        GIT_CREDENTIALS_ID = 'GitHub-PAT' 
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Checkout the code using GitHub credentials (PAT)
                git credentialsId: GIT_CREDENTIALS_ID, url: 'https://github.com/khaleedcodes/devops.git'
            }
        }

        stage('Build Maven Project') {
            steps {
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
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                sh 'docker push $DOCKER_IMAGE'
            }
        }
    }
}
