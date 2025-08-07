pipeline {
    agent any

    environment {
        IMAGE_NAME = "badrinadh1104/customer-service"
        CONTAINER_NAME = "customer-service-app-container"
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials'
        DOCKER_HOST = 'tcp://host.docker.internal:2375'  // Add this line
    }

    stages {
        stage('Clone from GitHub') {
            steps {
                git 'https://github.com/badrinadh1104/CustomerService.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh 'mvn test -Dspring.profiles.active=test'
            }
        }
        stage('Verify Docker Setup') {
            steps {
                sh 'docker version'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t $IMAGE_NAME:latest ."
                }
            }
        }

        stage('Push Docker Image to DockerHub') {
            steps {
                script {
                    withCredentials([usernamePassword(
                        credentialsId: "${DOCKER_CREDENTIALS_ID}",
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                    )]) {
                        sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
                        sh "docker push $IMAGE_NAME:latest"
                    }
                }
            }
        }

//         stage('Run Docker Container') {
//             steps {
//                 script {
//                     sh "docker rm -f $CONTAINER_NAME || true"
//                     sh "docker run -d --name $CONTAINER_NAME -p 8080:8080 $IMAGE_NAME:latest"
//                 }
//             }
//         }
    }

    post {
        always {
            echo "Pipeline finished."
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}