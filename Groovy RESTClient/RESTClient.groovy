@Grapes([
        @Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7'),
        @Grab(group='com.jameskleeh', module='excel-builder', version='0.4.2')
])

import static groovyx.net.http.ContentType.*
import groovyx.net.http.RESTClient

def copy=new RESTClient("http://httpbin.org/get")
       // copy.headers['Authorization'] = authentication
def result=copy.get(contentType: JSON).data.collect{
    println it
}

null