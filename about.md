---
layout: page
title: About
permalink: /about/
---
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Build Status](https://travis-ci.com/brad-tech/mpesa-api-java.svg?branch=master)](https://travis-ci.com/brad-tech/daraja-api-client)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/brad-tech/mpesa-api-java.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/brad-tech/daraja-api-client/alerts/)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/brad-tech/mpesa-api-java.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/brad-tech/daraja-api-client/context:java)

# Daraja API Client
The Java implementation of [Safaricom](https://www.safaricom.co.ke)'s [M-Pesa](https://www.safaricom.co.ke/personal/m-pesa) [Daraja APIs](https://developer.safaricom.co.ke/). The library uses apache http client, jackson json library and 
junit for unit testing. Documentation for the API can be found at https://developer.safaricom.co.ke/docs.

## Downloading and Installing
[![GitHub issues](https://img.shields.io/github/release/brad-tech/mpesa-api-java.svg)](https://github.com/brad-tech/daraja-api-client/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/brad.tech/mpesa-api-java.svg)](http://mvnrepository.com/artifact/brad.tech/daraja-api-client)
1. Get the latest source files by:
   - Downloading from [Github](https://github.com/brad-tech/daraja-api-client) as a [zip file](https://github.com/brad-tech/daraja-api-client/archive/master.zip).
   - Cloning the project with git over 
     * https: `git clone https://github.com/brad-tech/daraja-api-client.git`
     * ssh: `git clone git@github.com:brad-tech/daraja-api-client.git`.
  
2. Navigate to the source directory `cd daraja-api-client`
3. Install it to your local maven repository: `mvn install`.

You can also add the latest compiled jar file located under [releases](https://github.com/brad-tech/mpesa-api-java/releases/download/v1.0/daraja-api-client-1.0-SNAPSHOT.jar).
Just remember to include Jackson and Apache-HttpClient to your classpath.

Having trouble with your build or found a bug? [Create an issue!](https://github.com/brad-tech/daraja-api-client/issues)
