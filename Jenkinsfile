pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying JAR file to Tomcat...'
                bat 'copy target\\*.jar C:\\apache-tomcat-9.0.91\\webapps\\'
            }
        }
    }

    post {
        success {
            echo '✅ Build and Deployment Successful!'
        }
        failure {
            echo '❌ Build Failed!'
        }
    }
}
