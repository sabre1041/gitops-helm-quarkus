# gitops-helm-quarkus GitOps Assets

This branch contains the associated tooling for demonstrating how to use ArgoCD and Helm to deploy and manage an application using GitOps principles. 

## Bootstrapping an Environment

Execute the following steps to bootstrap your environment.

1. Install and deploy the ArgoCD Operator

```
oc apply -k argocd-operator/base
```

2. Wait for the ArgoCD custom resource to become established

```
until oc wait --for condition=established --timeout=60s crd/argocds.argoproj.io; do sleep 2; done
```

3. Deploy ArgoCD with Bootstrap application

```
oc apply -k argocd/base/
```

At this point, three (3) ArgoCD applications will be deployed:

1. An app of apps that containers the two applications to deploy Helm Charts
2. Application to deploy Helm Chart to a project called `gitops-helm-quarkus`
3. Application to deploy Helm Chart to a project called `gitops-helm-quarkus-prod`
