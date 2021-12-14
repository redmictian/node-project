pipeline {
    agent any
    stages {
        stage("dependencies") {
            steps {
                echo 'Managing dependencies'
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
                    script {
                        echo "Incrementing the app version"
                        env.VERSION = sh( returnStdout: true, script: 'npm --prefix ./app version patch | sed s/v//').trim()
                    }
            }
        }
        stage("docker build") {
            steps {
                script {
                    echo "building the the docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t redmictian/node-project:$VERSION ."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push redmictian/node-project:$VERSION"
                    }
                }
            }
        }
        stage('commit version update') {
			steps {
				script {
                    echo "Commiting the new version $VERSION to the repository"
					withCredentials([usernamePassword(credentialsId: 'github-personal-token', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
						sh 'git config --global user.email "jenkins@example.com"'					
						sh 'git config --global user.name "jenkins"'	
						sh "git remote set-url origin https://${USER}:${PASS}@github.com/redmictian/node-project.git"
						sh 'git commit -am "ci: version $VERSION bump"'
						sh 'git push origin HEAD:main'
					}
				}
			}
		}
    }
}