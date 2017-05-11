node {
deleteDir()
stage('Build'){
    checkout scm
    sh './gradlew assemble --info'
}
  stage('Test'){
    sh './gradlew check --info'
    junit '**/test-results/**/*.xml'
  }

  stage('DockerImage'){
    def newApp = docker.build "gifster:${env.BUILD_TAG}"
  }


}
