# Basic set up

```
oc new-project demo

oc adm policy add-role-to-user admin system:serviceaccount:openshift-gitops:openshift-gitops-argocd-application-controller -n demo

oc apply -f gitops/configure.yaml

oc patch configs.imageregistry.operator.openshift.io/cluster --patch '{"spec":{"defaultRoute":true}}' --type=merge

HOST=$(oc get route default-route -n openshift-image-registry --template='{{ .spec.host }}')

podman login --tls-verify=false -u kubeadmin -p $(oc whoami -t) $HOST

podman login -u='<USRN>' -p=<PSWD> registry.redhat.io
```

# Build & Push each component

## Service 1

```
cd services/service1

buildah build -t $HOST/demo/service1:latest .

buildah push --tls-verify=false $HOST/demo/service1:latest
```

## Service 2

```
cd services/service2

buildah build -t $HOST/demo/service2:latest .

buildah push --tls-verify=false $HOST/demo/service2:latest
```

## API entrypoint

```
cd services/api

buildah build -t $HOST/demo/api:latest .

buildah push --tls-verify=false $HOST/demo/api:latest
```

# Test

```
curl -H 'Content-Type: application/json' -v http://demo-api-525eca1d5089dbdc-istio-system.apps.ocp.sandbox150.opentlc.com/api/
```
