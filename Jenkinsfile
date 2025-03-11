pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/your-username/amazon-automation.git'
            }
        }

        stage('Start Docker Selenium Grid') {
            steps {
                sh 'docker-compose up -d'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Print Test Results') {
            steps {
                sh 'cat target/surefire-reports/*.txt'
            }
        }

        stage('Stop Docker Grid') {
            steps {
                sh 'docker-compose down'
            }
        }
    }
}
