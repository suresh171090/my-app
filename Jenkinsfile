@Library('shared') _

pipeline 
{
    agent any
    stages
    {
        stage('checkout')
        {
          steps
            {
               SCM("https://github.com/suresh171090/my-app.git") 
            }
        }
         stage ('mavenbuilt')
         {
            steps
            {
              built()
            }
         }
         stage ('dockerbuild')
         {
            steps
            {
              dockerbuilt("span","suresh171090")
            }
         }
         stage ('dockerrun')
         {
            steps
            {
               dockerrun("span","suresh171090","task") 
            }
         }
         stage ('dockerpush')
         {
            steps
            {
               dockerpush("span","suresh171090") 
            }
         }
    }
    post {
         success {
         emailext body: 'A Test EMail', 
         recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], 
         subject: 'success'
          }
         failure {
         emailext body: 'failed', 
         recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], 
         subject: 'failed'
          }
        }   
}
