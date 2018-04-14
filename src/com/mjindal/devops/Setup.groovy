package com.mjindal.devops

class Setup implements Serializable {

    def steps;
    Setup(steps){
        this.steps = steps;
    }

    def loginToDockerHub(){
        withCredentials([usernameColonPassword(credentialsId: '8d3f3ee8-05dd-49f3-9cdd-f21d3119784d', variable: 'TOKEN')]) {
            // some block
        }
    }
}
