pipeline {
   agent any

   stages {
      stage('Employee Pipeline') {
         steps {
            echo 'Employee Pipeline started'
         }
      }

      stage('Checkout') {
          steps {

            git branch:'master', credentialsId: 'GIT_HUB_CREDENTIALS', url: 'https://github.com/mcool8180/JDBCemployee.git'


        echo 'Checkout Done'
        }
      }

      stage('Compile') {
         steps {
           sh 'mvn clean compile'
            echo 'Compilation done'

         }
      }
     stage('Build') {
         steps {

         sh 'mvn clean package'
//             sh './service.sh'
// to do
// build service jar
// 1. docker image build from jar
//3 docker image run
            echo 'Build Done'

         }
      }




//      stage('Checkout Test') {
//           steps {
//
//               git branch:'master', credentialsId: 'GIT_HUB_CREDENTIALS', url: 'https://github.com/mcool8180/employee-restAssured.git'
//
//         echo 'Checkout Test Done'
//         }
//       }
//
//       stage('Compile Test') {
//          steps {
//             sh 'mvn clean compile'
//             echo 'Compilation of Test is done'
//
//          }
//       }
//      stage('Test') {
//          steps {
//             sh 'mvn clean test -Dgroups=addEmployee'
//             echo 'Test case passed successfully'
//
//          }
//       }



   }
}