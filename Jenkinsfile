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

        // Kill old app running on 8081
        bat 'for /f "tokens=5" %a in (\'netstat -aon ^| find "8081"\') do taskkill /F /PID %a || exit 0'

        // Short delay
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
