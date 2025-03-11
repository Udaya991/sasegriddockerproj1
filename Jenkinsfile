pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'github-credentials', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_PASS')]) {
                    sh 'git clone https://$GIT_USER:$GIT_PASS@github.com/Udaya991/sasegriddockerproj1.git'
                }
            }
        }

        stage('Start Selenium Grid') {
            steps {
                sh 'docker-compose up -d'
            }
        }

        stage('Run Maven Tests') {
            steps {
                sh 'mvn clean test -DsuiteXmlFile=testng.xml'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                publishTestNGResults testResultsPattern: '**/target/surefire-reports/testng-results.xml'
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                sh 'docker-compose down'
            }
        }
    }
}
