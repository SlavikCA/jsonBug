@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.1')

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.JSON

def jsonSlurper = new JsonSlurper()

String baseContextJSON = new File('defaultContextV2.json').text
def baseContext = jsonSlurper.parseText(baseContextJSON)

println JsonOutput.prettyPrint(JsonOutput.toJson(baseContext))

RESTClient http = new RESTClient('https://requestinspector.com')
http.post(
        path: "/inspect/01dh7rs82be884ke89jcny061e",
        body: baseContext,
        query: null,
        requestContentType: JSON
)
