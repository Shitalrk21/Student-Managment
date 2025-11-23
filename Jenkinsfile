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
                git branch: 'dev', url: 'https://github.com/Shitalrk21/Student-Managment.git'
            }
        }

        stage('Build') {
            steps {
                echo "🔧 Building..."
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Deploying JAR...'

                // Kill old Java process (ignore error)
                bat 'taskkill /F /IM java.exe || exit 0'

                // Run JAR in background so Jenkins doesn't hang
                bat '''
                cd target
                start /B java -jar StudentManagment-0.0.1-SNAPSHOT.jar
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Build & Deployment Successful!'
        }
        failure {
            echo '❌ Build Failed. Check logs!'
        }
    }
}
