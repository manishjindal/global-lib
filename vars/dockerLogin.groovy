package com.mjindal.devops
import NonCPS

def call(String username){
    return getUsername(username);
}
@NonCPS
String getUsername(username){
    return username;
}
