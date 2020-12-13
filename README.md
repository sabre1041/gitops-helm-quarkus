# gitops-helm-quarkus

This project uses a simple [Quarkus](https://quarkus.io) based application to demonstrate how to enable GitOps principles with [ArgoCD](https://argoproj.github.io/argo-cd/) and [Helm](https://helm.sh/).

# Quarkus Basics

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

### Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `gitops-helm-quarkus-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/gitops-helm-quarkus-1.0.0-SNAPSHOT-runner.jar`.

### Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/gitops-helm-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

# Application Configuration

The application can be used to illustrate operating in different environments of the Software Development Lifecycle (SDLC) which are driven by declaring environment variables.

By default, a blue background will be displayed when navigating to the application. To simulate the application being deployed to a production environment, set the following environment variable:

```
ENVIRONMENT=prod
```

With the above variable set, the background of the application will turn red.

In addition, an optional customized message can be displayed by setting the `message` environment variable as shown below:

```
MESSAGE="this is a customized message"
```

## GitOps

To demonstrate how GitOps and in particular, ArgoCD can be used to deploy this application to a Kubernetes and OpenShift environment, refer to the `gitops` branch for more information.