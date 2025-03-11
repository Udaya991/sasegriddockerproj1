pipeline {
    agent any

    stages {
        stage('Clean Workspace') {
            steps {
                bat 'rmdir /s /q sasegriddockerproj1 || exit 0'
            }
        }

        stage('Clone Repository') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'github-credentials', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_PASS')]) {
                    bat 'git clone https://%GIT_USER%:%GIT_PASS%@github.com/Udaya991/sasegriddockerproj1.git'
                }
            }
        }

        stage('Start Selenium Grid') {
            steps {
                bat 'docker-compose up -d'
            }
        }

        stage('Run Maven Tests') {
            steps {
                bat 'mvn clean test -DsuiteXmlFile=testng.xml'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                step([$class: 'Publisher', reportFilenamePattern: '**/target/surefire-reports/testng-results.xml'])
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                bat 'docker-compose down'
            }
        }
    }
}
