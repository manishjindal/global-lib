package com.mjindal.devops
import com.cloudbees.groovy.cps.NonCPS

def call(String username){
    return getUsername(username);
}
@NonCPS
String getUsername(username){
    return username;
}
