pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Build') {
            steps {
                echo '🔧 Building project...'
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Package') {
            steps {
                echo '📦 Packaging JAR...'
                bat 'mvn package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Deploying JAR...'
                bat """
                    cd target
                    java -jar StudentMgmtPSQL-0.0.1-SNAPSHOT.jar
                """
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
