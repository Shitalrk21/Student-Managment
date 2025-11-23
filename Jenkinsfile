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

        stage('Deploy') {
            steps {
                echo '🚀 Deploying JAR...'

                // Kill old running app
                bat 'taskkill /F /IM java.exe || exit 0'

                // Start new jar
                bat """
                    cd target
                    java -jar StudentManagment-0.0.1-SNAPSHOT.jar
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
