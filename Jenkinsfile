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
        stage("incrementing") {
            steps {
                echo "Incrementing the app version"
                    script {
                        env.VERSION = sh returnStdout: true, script: 'npm --prefix ./app version patch | sed s/v//'
                        println VERSION
                    /*  def version = readJSON: 'app/package.json'
                        echo "version is $version" */
                    }
                
            }
        }
        stage("docker build") {
            steps {
                    script {
                        echo "building the the docker image"
                        withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                            echo 'docker build -t redmictian/node-project:$VERSION .'
                            sh "echo $PASS | docker login -u $USER --password-stdin"
                       //     sh "docker push redmictian/node-project:$VERSION"
                        }
                    }
                
            }
        }
    }
}