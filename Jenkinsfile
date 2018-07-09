node{
  stage ('Build') {
 
    git url: 'https://github.com/Coos-Wolff/bookkeeping_tdd.git'
 
    withMaven(
        // Maven installation declared in the Jenkins "Global Tool Configuration"
        maven: '3.5.0',
        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
        // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
        mavenSettingsConfig: 'my-maven-settings',
        mavenLocalRepo: '.repository') {
 
      // Run the maven build
      sh "mvn clean install"
 
    } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...
  }
}