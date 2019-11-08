[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Build Status](https://travis-ci.com/brad-tech/mpesa-api-java.svg?branch=master)](https://travis-ci.com/brad-tech/mpesa-api-java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/brad-tech/mpesa-api-java.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/brad-tech/mpesa-api-java/alerts/)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/brad-tech/mpesa-api-java.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/brad-tech/mpesa-api-java/context:java)

# M-Pesa API Java
The Java implementation of [Safaricom](https://www.safaricom.co.ke)'s [M-Pesa](https://www.safaricom.co.ke/personal/m-pesa) [Daraja APIs](https://developer.safaricom.co.ke/). The library uses apache http client, jackson json library and 
junit for unit testing. Documentation for the API can be found at https://developer.safaricom.co.ke/docs.

## Downloading and Installing
[![GitHub issues](https://img.shields.io/github/release/brad-tech/mpesa-api-java.svg)](https://github.com/brad-tech/mpesa-api-java/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/brad.tech/mpesa-api-java.svg)](http://mvnrepository.com/artifact/brad.tech/mpesa-api-java)
1. Get the latest source files by:
   - Downloading from [Github](https://github.com/brad-tech/mpesa-api-java) as a [zip file](https://github.com/brad-tech/mpesa-api-java/archive/master.zip).
   - Cloning the project with git over 
     * https: `git clone https://github.com/brad-tech/mpesa-api-java.git`
     * ssh: `git clone git@github.com:brad-tech/mpesa-api-java.git`.
  
2. Navigate to the source directory `cd mpesa-api-java`
3. Install it to your local maven repository: `mvn install`.

You can also add the latest compiled jar file located under [releases](https://github.com/brad-tech/mpesa-api-java/releases/download/v1.0/mpesa-api-java-1.0-SNAPSHOT.jar).
Just remember to include Jackson and Apache-HttpClient to your classpath.

## Examples
:warning: All examples use Java-8

### Authentication
```java
import brad.tech.web.safaricom.daraja.MPesaException;
import brad.tech.web.safaricom.daraja.SandboxURLs;

import brad.tech.web.safaricom.daraja.v1.auth.OAuthAPI;
import brad.tech.web.safaricom.daraja.v1.auth.OAuthResponse;

public class OAuthDemo {

    private final String url;
    
    public OAuthDemo(String url) {
        this.url = url;
    }

    public OAuthResponse getAccessToken(String appKey, String appSecret) throws MPesaException {
        return new OAuthAPI(this.url, appKey, appSecret).authenticate();
    }

    public static void main(String[] args) {
        // supply the url, you can also use the SandboxURLs constants
        final String url = SandboxURLs.OAUTH;
        // supply the app key and app secret
        final String appKey = "<APP_KEY>";
        final String appSecret = "<APP_SECRET>";
        
        // authenticate!  
        try {
            // get the access token object
            final OAuthResponse authResponse = new OAuthDemo(url).getAccessToken(appKey, appSecret);
            // you'll have to check for null scenarios
            if (authResponse != null) {
                final String accessToken = authResponse.getAccessToken();
                final Long expiresIn = authResponse.getExpiresIn();

                // print out the values
                System.out.printf("AccessToken: %s, ExpiresIn: %d%n", accessToken, expiresIn);
    
                // print out the json value
                System.out.println(authResponse.toJson());
            }
        } catch (MPesaException ex) {
            System.err.println("Error authenticating with M-Pesa. Details: " + ex.getMessage());
        }
    }
}

```

### C2B API
```java
import brad.tech.web.safaricom.daraja.MPesaException;
import brad.tech.web.safaricom.daraja.SandboxURLs;

import brad.tech.web.safaricom.daraja.v1.c2b.C2BAPIBase;

public class C2BDemo implements SandboxURLs {

    private void registerURLs(String confirmURL, String verifyURL) {
        
    }
 
    public static void main(String[] args) {
        // register urls api
        final C2BRegisterURLsAPI registerURLsAPI = new C2BAPIBase(SandboxURLs.C2B_REGISTER_URL_API);
        registerURLsAPI.setVerifyURL("https://verify.example.com");
        registerURLsAPI.setConfirmURL("https://confirm.example.com");
        
        // simulate transactions api
        final C2BSimulateTransactionAPI transactionAPI = 
                        new C2BSimulateTransactionAPI(SandboxURLs.C2B_SIMULATE_TRANSACTION);
        
        try {
        // authentication is required
        final OAuthResponse authResponse = new OAuthAPI(OAUTH).authenticate();
        if (authResponse != null) {
            String accessToken = authResponse.getAccessToken();
            
            C2BRequest c2bRequest = new C2BRequest();
        }
            
        } catch (MPesaException ex) {
            System.err.println("Error connecting to C2B API Service. Details: " + ex.getMessage());
        }
    }
    
}

```


Having trouble with your build or found a bug? [Create an issue!](https://github.com/brad-tech/mpesa-api-java/issues)
