# Spring Cloud Kubernetes with ConfigMapd and Secrets Example #

This project born with the aim to show how deploy a service using Spring Cloud Kubernetes with ConfigMap,

This is a simple application thas uses  a mongodb and a secret object from kubernetes. This service
is going to show us some properties from ConfigMap.


You can find this article on :
*  [Spanish]: https://refactorizando.com/externalizar-configuracion-spring-boot-kubernetes-configmap/
*  [English]: https://refactorizando.com/en/externalize-spring-boot-config-to-configmap/
## How can I run it?

First off is necesary a distribution of kubernetes such as minikube, google cloud kubernetes ... and have installed
docker, then with kubernetes running in our local machine we can start to deploy our services: 

### Step 1
`eval $(minikube docker-env)
`
### Step 2
`mvn clean install
`
### Step 2
`docker build -t order-service .
`

`cd kubernetes`


### Step 3
`kubectl create -f configmap.yml
`
### Step 4
`kubectl create -f secret.yaml
`
### Step 5
`kubectl create -f service-account.yml
`
### Step 6

`kubectl create -f mongo-deployment.yaml
`
###Step 7
`kubectl create -f deployment.yaml
`
and it's ready.

If you are using minikube don't forget run the next command to open a browser with the application:
` minikube service order-service
`
