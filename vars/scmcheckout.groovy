def call(String URL)
node{
   stage('SCM Checkout'){
     git 'URL'
   }
