pipeline{
    agent any
    stages{
        stage('Git'){
            steps{
                git 'https://github.com/m0levich/cucumberLesson28'
            }
        }
        stage('Test'){
            steps{
                withMaven(maven : 'Maven'){
                sh 'mvn clean test'
                }
            }
        }
    }
    post{
        always{
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}