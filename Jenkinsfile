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


}
