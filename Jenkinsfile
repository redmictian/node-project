pipeline {
    agent any
    stages {
        stage("depencies") {
            steps {
                echo 'Managing depencies'
                sh 'npm --prefix ./app install'
            }
        }
        stage("testing") {
            steps {
                echo "Testing the app"
                sh 'npm --prefix ./app test'
            }
        }
        stage("Docker build") {
            steps {
                echo "building the app"
                sh 'docker build -t redmictian/node-project:1.1 .'
            }
        }
    }
}
