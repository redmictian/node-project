pipeline {
    agent any
    stages {
        stage("Managing depencies") {
            steps {
                sh 'cd app'
                sh 'npm install'
            }
        }
        stage("testing") {
            steps {
                echo "Testing the app"
                sh 'npm test'
                echo "Executing pipeline for branch $BRANCH_NAME"
                
            }
        }
    }
}