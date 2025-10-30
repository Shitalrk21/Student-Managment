pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '📥 Checking out code...'
                git branch: 'main', url: 'https://github.com/Shitalrk21/Student-Managment.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Deploying JAR...'
                bat 'java -jar target\\StudentMgmtPSQL-0.0.1-SNAPSHOT.jar'
            }
        }
    }

    post {
        success {
            echo '✅ Build and Deployment Successful!'
        }
        failure {
            echo '❌ Build Failed. Check logs for details.'
        }
    }
}
