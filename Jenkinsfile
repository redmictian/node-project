pipeline {
    agent any
    stages {
        stage("Managing depencies") {
            steps {
                echo 'Initially Im at '
                sh 'pwd'
                sh 'cd app'
                echo 'But the path is '
                sh 'pwd
                echo 'npm install'
            }
        }
        stage("testing") {
            steps {
                echo "Testing the app"
                echo 'npm test'
                echo "Executing pipeline for branch $BRANCH_NAME"
                
            }
        }
    }
}
