package com.mjindal.devops



class Setup implements Serializable {

    def steps;
    def static appVersion;
    Setup(steps){
        this.steps = steps;
    }

    def loginToDockerHub(){
        steps.withCredentials([steps.usernameColonPassword(credentialsId: '8d3f3ee8-05dd-49f3-9cdd-f21d3119784d', variable: 'TOKEN')]) {
            println "Credential " + steps.TOKEN;
        }
    }

    static String getAppVersion(def versionFileContent){
        appVersion =  versionFileContent.split("\n");
        println "Version = " + appVersion[0];
        return appVersion[0];
    }
    
    def ArrayList<Map<String, String>> readClusterInfo(def clusterInfoContent, def versionFileContent) {

        println "Cluster Info = " + clusterInfoContent
        println "Version File Content =  " + versionFileContent
        def cluster = new ArrayList<Map<String, String>>();
    
        print "----1--------------" + Setup.getAppVersion(versionFileContent);
        
        def lines= clusterInfoContent.split("\n");

        //print lines.toString();

        for (int i=0;i<lines.size();i++) {
            println "Line = " + lines[i];
            def clusterDetails = lines[i].toString().split(",");
            print "Cluster Detail = " + clusterDetails
            def clusterMap = new HashMap<String, String>();
            for (int j = 0; j < clusterDetails.size(); j++) {
                def clusterElements = (clusterDetails[j]).toString().split(":");
                clusterMap.put(clusterElements[0], clusterElements[1]);
            }
            cluster.add(clusterMap);
        }
        cluster
    }

}

