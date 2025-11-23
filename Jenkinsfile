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
        echo '🚀 Deploying new JAR... (killing old one first)'

        // Kill old java process if running
        bat 'taskkill /F /IM java.exe || exit 0'

        // Wait 2 seconds
        bat 'timeout /t 2'

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
