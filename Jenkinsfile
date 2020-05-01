pipeline {
    agent any

    tools {
        maven "Maven"
    }

    triggers {
            pollSCM "* * * * *"
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'cp target/test-0.0.1-SNAPSHOT.jar /var/jenkins_home/release'
            }
        }
    }
    
    post {
        always {
            echo 'One way or another, I have finished'
            deleteDir() /* clean up our workspace */
        }
        success {
            echo 'I succeeeded!'
            sh 'curl -d "status:success" https://webhook.site/1fb03a0d-18ae-4fca-9fef-4b6b0464a49c'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
        changed {
            echo 'Things were different before...'
        }
    }
}
