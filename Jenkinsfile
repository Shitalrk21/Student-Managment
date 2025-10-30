pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                echo ' Checking out code from GitHub...'
                git branch: 'main', url: 'https://github.com/Shitalrk21/Student-Managment.git'
            }
        }

        stage('Build') {
            steps {
                echo ' Building the project...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo ' Deploying Spring Boot application...'
                // Automatically pick the JAR file from target/
                bat '''
                for /f %%i in ('dir /b target\\*.jar') do (
                    echo Running JAR: target\\%%i
                    java -jar target\\%%i
                )
                '''
            }
        }
    }

    post {
        success {
            echo ' Build and Deployment Successful!'
        }
        failure {
            echo ' Build Failed. Check logs for details.'
        }
    }
}
