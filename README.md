# Hello IBM Bluemix!

This is a sample application built on Spring Boot which is ready for
being deployed to *IBM Bluemix* or any other PaaS vendor running on top
of *Cloud Foundry*.

<br/>

## Requirements

* JDK 1.8
* Gradle 3.4.1
* IBM Bluemix Account
<br/>

## Build

This project relies on Gradle as build tool. For getting started, check
out the repository and launch Gradle inside the project's root directory:

```
$ git clone https://pk070@gitlab.mi.hdm-stuttgart.de/pk070/dev4cloud-hello-bluemix.git
$ cd dev4cloud-hello-bluemix/
$ gradle build
```

<br/>


## Local test

Before deploying the application via Cloud Foundry, make sure the build
succeeds and the app can be started locally. Inside the project root, perform
the following commands:

```
$ cd build/libs/
$ java -jar hello-bluemix-0.1.0.jar
```

Assumed that everything works fine, the Spring Boot sample starts 
listening for incoming connections at *localhost:8080*.

<br/>


## Deploy to IBM Bluemix

Before you can push your application to IBM Bluemix, make sure you
registered and set up your [account](https://www.ibm.com/cloud-computing/bluemix/).  
As the next step, download and install the 
latest version of the [Cloud Foundry CLI](https://github.com/cloudfoundry/cli/releases).
We need that to interact with Bluemix on the command line and deploy
our application.   
As soon as you're done with this, we can finally devote ourselves to get
up and running with Bluemix.

<br/>


### 1) Set Bluemix API endpoint
First, check the region (US South, Sydney, Germany or UK) you're working on in your profile
settings and make Cloud Foundry CLI point to the correct API endpoint:

```
$ cf api https://api.ng.bluemix.net # point CLI to US South
```

<br/>


### 2) Login to your Bluemix account
Now we need to use the previously installed Cloud Foundry CLI in order to login
to our Bluemix account. For that to work, make sure you created at least
one single personal organization as well as an area to place your application in. You can do
this by means of the Bluemix Dashboard.
Then, you can login to Bluemix with the Cloud Foundry CLI as follows:

```
$ cf login -u {username} -o {organization} -s {area}
```

<br/>


### 3) Deploy the Hello-Bluemix application

Enter the project's root directory and launch the following command to deploy the 
application to Bluemix:

```
$ cf push -m 1024M -n {hostname} -b https://github.com/cloudfoundry/java-buildpack.git 
```

<br/>

There's a couple of important points here. First, pay attention to provide sufficient memory
to your application. In this case, I chose 1GB, since the JVM allocated about 600MB on startup
whilst my local test scenario. If there's not enough memory available, the app won't start.  
Second, you have to pass a unique hostname to your application, which is used by Bluemix to
provide you with an endpoint where the app can be accessed after deployment.  
Last but not least, it's important to make your deployment use the latest version of the
Cloud Foundry *Java Buildpack*. This is necessary since *Spring Boot* currently does not work
with the Java Buildpack version applied by default and instead crashes with 
`java.lang.NoClassDefFoundError: org/springframework/context/ApplicationContextInitializer`.


