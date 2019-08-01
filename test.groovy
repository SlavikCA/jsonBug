@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.1')

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.JSON

def jsonSlurper = new JsonSlurper()

// if you replace `function` on next line to any other word - it will work correctly
String baseContextJSON = '{ "afterResponse": "function (getParam, setParam, genInfo) { }" }'

def baseContext = jsonSlurper.parseText(baseContextJSON)

println JsonOutput.prettyPrint(JsonOutput.toJson(baseContext))

RESTClient http = new RESTClient('https://requestinspector.com')
http.post(
        path: "/inspect/01dh7rs82be884ke89jcny061e",
        body: baseContext,
        query: null,
        requestContentType: JSON
)

/*

results in POST request with invalid JSON:

{"afterResponse":function(getParam,setParam,genInfo){}}

Note missing quote around function.

see actual received payloads here:
https://requestinspector.com/p/01dh7rs82be884ke89jcny061e 

*/
