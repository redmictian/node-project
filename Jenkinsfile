pipeline {
    agent any
    stages {
        stage("Managing depencies") {
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
                echo "Building the app"
                sh 'docker build -t redmictian/node-project:1.1 .'
<<<<<<< HEAD
            }
=======
>>>>>>> 51483ae132c10086503c4cad1aee282cd73018fa
        }
    }
}